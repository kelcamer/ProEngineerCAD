package remaclek.kelcamer.databasetesting;

import android.app.Activity;
import android.database.Cursor;
import android.os.Bundle;
import android.os.Environment;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.text.SimpleDateFormat;
import java.util.Date;

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

    DBAdapter myDb;
    String date = new SimpleDateFormat("MMMMMMMMMMMMMM dd, yyyy").format(new Date());
    String time = new SimpleDateFormat("HH:mm").format(new Date());
   // public
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

     //   String date = getDate();
      //  String date = new SimpleDateFormat("yyyy").format(new Date());

      //  String sec = new SimpleDateFormat("ss").format(new Date());
        System.out.println("Date: " + date);
      //  System.out.println("Time: " + time + "and  " + sec +" seconds.");
        setData(date, R.id.date);
        openDB();




    }
    @Override
    protected void onDestroy() {
        super.onDestroy();
        closeDB();
    }


    private void openDB() {
        myDb = new DBAdapter(this);
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

    public static void backupDatabase() throws IOException {
        //Open your local db as the input stream
        String inFileName = "/data/data/com.myapp.main/databases/MYDB";
        File dbFile = new File(inFileName);
        FileInputStream fis = new FileInputStream(dbFile);

        String outFileName = Environment.getExternalStorageDirectory()+"/MYDB";
        //Open the empty db as the output stream
        OutputStream output = new FileOutputStream(outFileName);
        //transfer bytes from the inputfile to the outputfile
        byte[] buffer = new byte[1024];
        int length;
        while ((length = fis.read(buffer))>0){
            output.write(buffer, 0, length);
        }
        //Close the streams
        output.flush();
        output.close();
        fis.close();
    }
    public void onClick_AddRecord(View v) {
        displayText("Clicked add record!");
       // System.out.println("Int " + Integer.parseInt(getData(R.id.id)));
        dataItem cur = new dataItem(getData(R.id.name), Integer.parseInt(getData(R.id.id)), getData(R.id.color));
        long newId = myDb.insertRow(cur.name, cur.id, cur.color);

        // Query for the record we just added.
        // Use the ID:
        Cursor cursor = myDb.getRow(newId);
        displayRecordSet(cursor);
        clear(R.id.name);
        clear(R.id.id);
        clear(R.id.color);
       /* try {
            backupDatabase();
        } catch (IOException e1) {
            // TODO Auto-generated catch block
            e1.printStackTrace();
        }*/
    }

    public void onClick_ClearAll(View v) {
        displayText("Clicked clear all!");
        myDb.deleteAll();
    }

    public void onClick_DisplayRecords(View v) {
        displayText("Clicked display record!");

        Cursor cursor = myDb.getAllRows();
        displayRecordSet(cursor);
    }
    public void onClick_search(View v){
        Cursor cursor = myDb.getAllRows();
        String key = getData(R.id.search_bar);

        displayCertain(cursor, key);

    }

    // Display an entire recordset to the screen.
    private void displayRecordSet(Cursor cursor) {
        String message = "";
        // populate the message from the cursor

        // Reset cursor to start, checking to see if there's data:
        if (cursor.moveToFirst()) {
            do {
                // Process the data:
                int id = cursor.getInt(DBAdapter.COL_ROWID);

                String name = cursor.getString(DBAdapter.COL_NAME);
                int studentNumber = cursor.getInt(DBAdapter.COL_STUDENTNUM);
                String favColour = cursor.getString(DBAdapter.COL_FAVCOLOUR);

                // Append data to the message:
                message += "id=" + id
                        +", name=" + name
                        +", #=" + studentNumber
                        +", Colour=" + favColour
                        +"\n";
            } while(cursor.moveToNext());
        }

        // Close the cursor to avoid a resource leak.
        cursor.close();

        displayText(message);
    }



    // Display an entire recordset to the screen.
    private void displayCertain(Cursor cursor, String keyword) {
        String message = "";
        // populate the message from the cursor

        // Reset cursor to start, checking to see if there's data:
        if (cursor.moveToFirst()) {
            do {
                // Process the data:

                int id = cursor.getInt(DBAdapter.COL_ROWID);
                String name = cursor.getString(DBAdapter.COL_NAME);
                int studentNumber = cursor.getInt(DBAdapter.COL_STUDENTNUM);
                String favColour = cursor.getString(DBAdapter.COL_FAVCOLOUR);
                //  || Integer.parseInt(keyword) == id
                Integer key = 0;
                try {
                    key = Integer.parseInt(keyword);
                }
                catch (NumberFormatException e) {
                    key = null;
                }
                //  || ((Integer.parseInt(keyword) == key) && key!=null)
                    if(keyword.contains(name) || keyword.contains(favColour)){
                        System.out.println("Message " + message);
                    // Append data to the message:
                    message += "id=" + id
                            + ", name=" + name
                            + ", #=" + studentNumber
                            + ", Colour=" + favColour
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
    String name, color;
    int id;

    public dataItem(String da, int id, String ti){
        this.name = da;
        this.color = ti;
        this.id = id;
    }


}









