package bhatia.rohan.phonebook;

import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ExpandableListView;
import android.widget.ImageButton;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    ImageButton I1;
    SQLiteDatabase sq;
    HashMap<String, List<String> > contacts;
    List<String> con_details;
    ExpandableListView EV;
    ContactAdaptor CA;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        sq=openOrCreateDatabase("mydb",SQLiteDatabase.CREATE_IF_NECESSARY,null);
        sq.execSQL("create table if not exists phonebook(first text,last text,email text, phone integer)");
        EV=(ExpandableListView) findViewById(R.id.NameList);
        contacts=DataProvider.getInfo();
        con_details=new ArrayList<String>(contacts.keySet());
        CA=new ContactAdaptor(this,contacts,con_details);
        EV.setAdapter(CA);
    }
}
