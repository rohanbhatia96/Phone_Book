package bhatia.rohan.phonebook;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Created by Rohan on 08-Aug-16.
 */
public class DataProvider {

    public static HashMap<String, List<String>> getInfo() {
        HashMap<String, List<String>> contacts = new HashMap<String, List<String>>();
        List<String> details=new ArrayList<String>();
        details.add("Rohan");
        details.add("Bhatia");

        contacts.put("Rohan Bhatia", details);

        return contacts;
    }
}
