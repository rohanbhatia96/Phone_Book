package bhatia.rohan.phonebook;

import android.content.ContentValues;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class AddActivity extends AppCompatActivity {

    Button b1;
    TextView fn,ln,em,num;
    SQLiteDatabase sq1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add);
        sq1 = openOrCreateDatabase("mydb", SQLiteDatabase.CREATE_IF_NECESSARY, null);
        sq1.execSQL("create table if not exists phonebook(first text,last text,email text, phone text)");
        b1=(Button)findViewById(R.id.AddConBut);
        b1.setOnClickListener(new a());
        fn=(TextView)findViewById(R.id.editFirst);
        ln=(TextView)findViewById(R.id.editLast);
        em=(TextView)findViewById(R.id.editMail);
        num=(TextView)findViewById(R.id.editPhone);
    }

    class a implements View.OnClickListener{

        @Override
        public void onClick(View view) {
            String S1,S2,S3,S4;
            S1=fn.getText().toString();
            S2=ln.getText().toString();
            S3=em.getText().toString();
            S4=num.getText().toString();
            ContentValues cv=new ContentValues();
            cv.put("first",S1);
            cv.put("last",S2);
            cv.put("email",S3);
            cv.put("phone",S4);
            sq1.insertOrThrow("phonebook",null,cv);
            Toast.makeText(getApplicationContext(),"Contact Added",Toast.LENGTH_LONG).show();
            Intent ob=new Intent(AddActivity.this,MainActivity.class);
            startActivity(ob);

        }
    }
}
