package bhatia.rohan.phonebook;

import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageButton;

public class MainActivity extends AppCompatActivity {

    ImageButton I1;
    SQLiteDatabase sq;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        sq=openOrCreateDatabase("mydb",SQLiteDatabase.CREATE_IF_NECESSARY,null);
        sq.execSQL("create table if not exists phonebook(first text,last text,email text, phone integer)");
    }
}
