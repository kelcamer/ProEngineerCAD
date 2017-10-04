package remaclek.kelcamer.dreamtest;


import android.app.Activity;
import android.app.Fragment;
import android.database.Cursor;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.text.method.ScrollingMovementMethod;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

public class DisplayNew extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.display);
        displayRecordSet(MainActivity.main_cursor);

    }

    // Display an entire recordset to the screen.
    public void displayRecordSet(Cursor cursor) {
        String list = "";
        // populate the message from the cursor
        list = MainActivity.getStringFromCursor(cursor);
        System.out.println(list);
        // Close the cursor to avoid a resource leak.
        cursor.close();
        displayText(list);
    }
    private void displayText(String message) {
        TextView textView = (TextView) findViewById(R.id.textDisplay2);
        textView.setMovementMethod(new ScrollingMovementMethod());
        textView.setText(message);
    }
   /* public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
*/
    /**
     * A placeholder fragment containing a simple view.
     */

}