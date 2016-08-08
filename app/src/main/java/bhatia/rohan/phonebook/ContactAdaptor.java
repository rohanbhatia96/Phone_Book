package bhatia.rohan.phonebook;

import android.content.Context;
import android.graphics.Typeface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.TextView;

import java.util.HashMap;
import java.util.List;

/**
 * Created by Rohan on 08-Aug-16.
 */
public class ContactAdaptor extends BaseExpandableListAdapter {

    private Context ctx;
    private HashMap<String,List<String>> contacts;
    private List<String> details;

    public ContactAdaptor(Context ct, HashMap<String,List<String>> hm,List<String> li)
    {
        ctx=ct;
        contacts=hm;
        details=li;
    }

    @Override
    public int getGroupCount() {
        return details.size();
    }

    @Override
    public int getChildrenCount(int i) {
        return contacts.get(details.get(i)).size();
    }

    @Override
    public Object getGroup(int i) {
        return details.get(i);
    }

    @Override
    public Object getChild(int parent, int child) {

        return contacts.get(details.get(parent)).get(child);
    }

    @Override
    public long getGroupId(int i) {
        return i;
    }

    @Override
    public long getChildId(int parent, int child) {
        return child;
    }

    @Override
    public boolean hasStableIds() {
        return false;
    }

    @Override
    public View getGroupView(int parent, boolean isExpanded, View convertView, ViewGroup parentView) {
        String con_name = (String) getGroup(parent);
        if(convertView==null)
        {
            LayoutInflater inf= (LayoutInflater) ctx.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView=inf.inflate(R.layout.parent_layout,parentView,false);
        }
        TextView parent_text= (TextView) convertView.findViewById(R.id.parent_text);
        parent_text.setTypeface(null, Typeface.BOLD);
        parent_text.setText(con_name);
        return convertView;
    }

    @Override
    public View getChildView(int parent, int child, boolean lastChild, View convertView, ViewGroup parentView) {
        String child_title=(String)getChild(parent,child);
        if(convertView==null)
        {
            LayoutInflater inflater=(LayoutInflater) ctx.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView=inflater.inflate(R.layout.child_layout,parentView,false);
        }

        TextView child_textview= (TextView) convertView.findViewById(R.id.child_text);
        child_textview.setText(child_title);
        return convertView;
    }

    @Override
    public boolean isChildSelectable(int i, int i1) {
        return false;
    }
}
