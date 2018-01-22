package com.praveen.session9assignment3;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by Praveen on 22/01/2018.
 */

public  class ContactsListAdapter extends BaseAdapter {

    private Context context;
    private ArrayList<Contact> contactsArrayList;

    /**
     * ContactsListAdapter Constructor
     *
     * @param context  gets context from the Activity calling the constructor
     * @param contactsArrayList gets a populated ArrayList object which needs to be used to populate the ListView
     */
    public ContactsListAdapter(Context context, ArrayList<Contact> contactsArrayList){
        this.context = context;
        this.contactsArrayList = contactsArrayList;
    }


    /**
     * How many items are in the data set represented by this Adapter.
     *
     * @return Count of items.
     */
    @Override
    public int getCount() {
        return contactsArrayList.size();
    }


    /**
     * Get the data item associated with the specified position in the data set.
     *
     * @param position Position of the item whose data we want within the adapter's
     *                 data set.
     * @return The data at the specified position.
     */
    @Override
    public Object getItem(int position) {
        return contactsArrayList.get(position);
    }


    /**
     * Get the row id associated with the specified position in the list.
     *
     * @param position The position of the item within the adapter's data set whose row id we want.
     * @return The id of the item at the specified position.
     */
    @Override
    public long getItemId(int position) {
        return position;
    }


    /**
     * Get a View that displays the data at the specified position in the data set. You can either
     * create a View manually or inflate it from an XML layout file. When the View is inflated, the
     * parent View (GridView, ListView...) will apply default layout parameters unless you use
     * {@link LayoutInflater#inflate(int, ViewGroup, boolean)}
     * to specify a root view and to prevent attachment to the root.
     *
     * @param position    The position of the item within the adapter's data set of the item whose view
     *                    we want.
     * @param convertView The old view to reuse, if possible. Note: You should check that this view
     *                    is non-null and of an appropriate type before using. If it is not possible to convert
     *                    this view to display the correct data, this method can create a new view.
     *                    Heterogeneous lists can specify their number of view types, so that this View is
     *                    always of the right type (see {@link #getViewTypeCount()} and
     *                    {@link #getItemViewType(int)}).
     * @param parent      The parent that this view will eventually be attached to
     * @return A View corresponding to the data at the specified position.
     */
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        // Create View Object with Inflating the Layout
        View contactItemView =  LayoutInflater.from(context).inflate(R.layout.contacts_list_item_layout,null);

        // Find Name, Phone Number Text View From Inflated Layout
        TextView contactName =   contactItemView.findViewById(R.id.contactName);
        TextView contactNumber =  contactItemView.findViewById(R.id.contactNumber);

        // Set Text To Name And Phone Number TextView based on Contacts List Object and the Position where the
        // View Called from.
        contactName.setText(contactsArrayList.get(position).getName().toString());
        contactNumber.setText(contactsArrayList.get(position).getPhoneNumber().toString());

        // Return Custom List View
        return contactItemView;
    }
}

