package bhatia.rohan.phonebook;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Created by Rohan on 08-Aug-16.
 */
public class DataProvider {

    public static HashMap<String, List<String>> getInfo(SQLiteDatabase sq) {
        HashMap<String, List<String>> contacts = new HashMap<String, List<String>>();
        List<String> details=new ArrayList<String>();
        Cursor obj=sq.query("phonebook",null,null,null,null,null,null,null);
        if(obj.moveToFirst())
        {
            String s;
            while(obj.isAfterLast()==false)
            {
                details.clear();
                for(int i=0;i<4;i++)
                {
                    s=obj.getString(i);
                    details.add(s);
                }
                contacts.put(details.get(0)+" "+details.get(1), details);
                obj.moveToNext();
            }
        }

        obj.close();


        return contacts;
    }
}
