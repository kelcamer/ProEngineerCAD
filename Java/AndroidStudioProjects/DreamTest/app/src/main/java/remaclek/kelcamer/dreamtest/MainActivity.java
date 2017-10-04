package remaclek.kelcamer.dreamtest;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.database.DatabaseUtils;
import android.os.Bundle;
import android.os.Environment;
import android.provider.ContactsContract;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import java.io.BufferedOutputStream;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import java.io.FileInputStream;

import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.io.Writer;
import java.nio.channels.FileChannel;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

/*
 * Steps to using the DB:
 * 1. [DONE] Instantiate the DB Adapter
 * 2. [DONE] Open the DB
 * 3. [DONE] use get, insert, delete, .. to change data.
 * 4. [DONE]Close the DB
 */

/**
 * Demo application to show how to use the 
 * built-in SQL lite database.
 */

public class MainActivity extends Activity {
    public static Cursor main_cursor;
    public static String export_list = "";
    DBAdapter2 myDb;
    String date = new SimpleDateFormat("MMMMMMMMMMMMMM dd, yyyy").format(new Date());
    String time = new SimpleDateFormat("HH:mm").format(new Date());
    // public
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        openDB();

    }
    @Override
    protected void onDestroy() {
        super.onDestroy();
        closeDB();
    }


    private void openDB() {
        myDb = new DBAdapter2(this);

        myDb.open();
    }
    private void closeDB() {
        myDb.close();
    }

    private void displayText(String message) {
        TextView textView = (TextView) findViewById(R.id.textDisplay);
        textView.setText(message);
    }
    private String getData(int num){
        EditText box = (EditText)findViewById(num);
        String message = box.getText().toString();
        System.out.println("Box " + message);
        box.getText().clear();
        return message;
    }
    private void setData(String message, int id){
        TextView tv = (TextView)findViewById(id);
        tv.setText(message);
    }
    private void clear(int num){
        EditText box = (EditText)findViewById(num);
        box.getText().clear();
    }
    private String getStringFromDB(){
       String list = myDb.getAllRows().toString();

        return list;
    }
    public void onClick_AddRecord(View v) {
        displayText("Clicked add record!");

        dataItem cur = new dataItem(date, time, getData(R.id.dream));
        long newId = myDb.insertRow(date, time, cur.dream);



        // Query for the record we just added.
        // Use the ID:
        System.out.println("Successfully inserted row.");
        Cursor cursor = myDb.getRow(newId);

        // Display Record Set Closes the Cursor so DO NOT USE after this line.
       displayRecordSet(cursor);
        System.out.println("Successfully displayed.");
        clear(R.id.dream);
    }
    // TODO: allow user to import their own current database
    // TODO:  While importing, make sure user has a way of providing the file path or creating a set standard

    public void onClick_ClearAll(View v) {
        displayText("Clicked clear all!");
        myDb.deleteAll();
        export_list = "";

    }
    public void displayRecordSet(Cursor cursor) {
        String list = "";
        // populate the message from the cursor
        list = MainActivity.getStringFromCursor(cursor);
        // Close the cursor to avoid a resource leak.
        cursor.close();
        displayText(list);
    }
    public String strRecordSet(Cursor cursor) {
        String list = "";
        // populate the message from the cursor
        list = MainActivity.getStringFromCursor(cursor);
        // Close the cursor to avoid a resource leak.
        cursor.close();
        System.out.println("LIST " + list);
        return list;
    }
    public void onClick_Delete(View v){
        // get data from edittext
        // parse into int
        String data = getData(R.id.delete);
        if(data != null && data != "") {
            int data2 = Integer.parseInt(data);
            deleteSpecific(data2);
            displayText("Deleted.");
        }
    }
    public void deleteSpecific(int todelete){
       myDb.deleteDataMatch(todelete);

    }


    //TODO: make a toast that tells the user where the new file is located (main storage folder)
    public void onClick_Backup(View v){
        try{
            Cursor cursor = myDb.getAllRows();


            export_list = strRecordSet(cursor);
            System.out.println("EXPORT LIST " + export_list);
            if(export_list!= null && export_list != "") {
                System.out.println("Sending text file to " + Environment.getExternalStorageDirectory().getAbsolutePath() + "/database.txt");
                System.out.println("Export list: " + export_list);
               print_to_file(export_list, Environment.getExternalStorageDirectory().getAbsolutePath() + "/database.txt");

            }
        }
        catch(Exception e){

        }
        try {
            File sd = Environment.getExternalStorageDirectory();
            File data = Environment.getDataDirectory();

            if (sd.canWrite()) {
                String currentDBPath = "//data//remaclek.kelcamer.dreamtest//databases//mydb.db";
                String backupDBPath = "mydb.db";
                File currentDB = new File(data, currentDBPath);
                File backupDB = new File(sd, backupDBPath);


                if (currentDB.exists()) {

                    FileChannel src = new FileInputStream(currentDB).getChannel();

                    FileChannel dst = new FileOutputStream(backupDB).getChannel();
                    dst.transferFrom(src, 0, src.size());
                    System.out.println("File is copied.");
                    System.out.println("Size in destination file: " + dst.size());
                    src.close();
                    dst.close();
                }
            }
        } catch (Exception e) {
            System.out.println("Failure :(");
        }

    }

    public static void print_to_file(String enc, String filename) throws IOException{
        File fout = new File(filename);
        FileOutputStream fos = new FileOutputStream(fout);

        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(fos));
        bw.append(enc);

        bw.close();


    }

    // make a new activity here
    public void onClick_DisplayRecords(View v) {
        main_cursor = myDb.getAllRows();
        Intent intent = new Intent(this, DisplayNew.class);
        this.startActivity(intent);
        displayText("Clicked display record!");
    }
    public void onClick_search(View v){
        Cursor cursor = myDb.getAllRows();
        String key = getData(R.id.search_bar);

        displayCertain(cursor, key);

    }




    public static String getStringFromCursor(Cursor cursor){
        String message = "";
        // Reset cursor to start, checking to see if there's data:
        if (cursor.moveToFirst()) {
            do {
                // Process the data:
                int id = cursor.getInt(DBAdapter2.COL_ROWID);
                String date = cursor.getString(DBAdapter2.COL_EVENT);
                String time = cursor.getString(DBAdapter2.COL_TIME);
                String dream = cursor.getString(DBAdapter2.COL_DREAM);

                // Append data to the message:
                message += "Number: " + id +"\n"+"Date: " + date
                        +"\nTime: " + time
                        +"\n" + dream
                        +"\n";
            } while(cursor.moveToNext());
        }
        //export_list = message;
        System.out.println("Message: " + message);
        return message;
    }

    // Display an entire recordset to the screen.
    private void displayCertain(Cursor cursor, String keyword) {
        String message = "";
        // populate the message from the cursor

        // Reset cursor to start, checking to see if there's data:
        if (cursor.moveToFirst()) {
            do {
                // Process the data:
                int id = cursor.getInt(DBAdapter2.COL_ROWID);
                String date = cursor.getString(DBAdapter2.COL_EVENT);
                String time = cursor.getString(DBAdapter2.COL_TIME);
                //   int studentNumber = cursor.getInt(DBAdapter.COL_STUDENTNUM);
                String dream = cursor.getString(DBAdapter2.COL_DREAM);


                // Append data to the message, and filter out what should be displayed
                if(dream.toLowerCase().contains(keyword.toLowerCase()) ||
                        keyword.toLowerCase().contains(dream.toLowerCase())
                        || date.toLowerCase().contains(keyword.toLowerCase())
                        || keyword.toLowerCase().contains(date.toLowerCase())
                        || time.toLowerCase().contains(keyword.toLowerCase())
                        || keyword.toLowerCase().contains(time.toLowerCase())
                        || keyword.toLowerCase().equals(id)) {
                    message += "Dream #: " + id +"\n"+ " Date: " + date
                            + "\nTime: " + time  // dream
                            + "\n" + dream
                            + "\n";
                }
            } while(cursor.moveToNext());
        }

        // Close the cursor to avoid a resource leak.
        cursor.close();

        displayText(message);
    }
}

class dataItem{
    String date, time, dream;

    public dataItem(String da, String ti, String dr){
        this.date = da;
        this.time = ti;
        this.dream = dr;
    }


}









