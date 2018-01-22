package com.praveen.session9assignment3;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    // Create Object Of ListView, Collection of Person Class, And Object of ContactListAdapter Class

    private ListView contactsListView; // Declares ListView object type variable to show the content from contacts
    private ArrayList<Contact> contactsList; // Declares ArrayList object type variable to store the content from contacts
    private ContactsListAdapter contactsListAdapter; // Declares a customAdapter object type variable to connect the List view with content from contacts

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        //References View Object with Layout Views
        contactsListView = findViewById(R.id.contactsListView);

        // Instantiates contactsList ArrayList
        contactsList = new ArrayList<>();

        // Assigns Values into contactsList ArrayList
        contactsList.add(new Contact("Ankit", "+1234567890"));
        contactsList.add(new Contact("Bharadwaj", "+2345678901"));
        contactsList.add(new Contact("Ramesh", "+3456789012"));
        contactsList.add(new Contact("Rakesh", "+4567890123"));
        contactsList.add(new Contact("Suresh", "+567890.1234"));

        // Instantiates Object of the CustomAdapter(contactListAdapter) and Assigns contactsList ArrayList to it
        contactsListAdapter = new ContactsListAdapter(getApplicationContext(), contactsList);

        // Assigns Custom Adapter(contactListAdapter) to ListView.
        contactsListView.setAdapter(contactsListAdapter);

        // Register Context Menu for List View
        registerForContextMenu(contactsListView);
    }


    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);

        // Set Header Text
        menu.setHeaderTitle(R.string.contextMenuTitle);

        // Add Menu Items to Context Menu
        menu.add("Call");
        menu.add("Send SMS");

    }

    @Override
    public boolean onContextItemSelected(MenuItem item) {

        // Retrieve Context Menu Info.
        AdapterView.AdapterContextMenuInfo info = (AdapterView.AdapterContextMenuInfo) item.getMenuInfo();

        // Get Contacts Item Based on Selected Menu and Position of ListView
        Contact contact = contactsList.get(info.position);

        // Create an Intent Object
        Intent i = new Intent();

        // Check Whether Clicked Menu Item is Call/SMS
        if (item.getTitle().equals("Call")) {
            // If Selected Menu Item is Call, Start Call Activity
            i.setAction(Intent.ACTION_DIAL);
            i.setData(Uri.parse("tel:" + contact.getPhoneNumber()));
        } else if (item.getTitle().equals("Send SMS")) {

            // Set SMS Intent
            i.setAction(Intent.ACTION_VIEW);
            i.setData(Uri.parse("sms:" + contact.getPhoneNumber()));

        }
        // Start Activity
        startActivity(i);
        return true;

    }
}
