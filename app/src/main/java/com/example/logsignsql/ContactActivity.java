package com.example.logsignsql;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.ContentValues;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.net.Uri;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class ContactActivity extends Activity {
    private EditText mNameEditText, mNameEditText2;
    private EditText mPhoneEditText, mPhoneEditText2;
    private final ArrayList<String> mContactsList = new ArrayList<>();
    private ArrayAdapter<String> mContactsAdapter;
    private ContactDBHelper mDBHelper;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.contact_activity);

        mNameEditText2 = (EditText) findViewById(R.id.edit_name2);
        mNameEditText = (EditText) findViewById(R.id.edit_name);
        mPhoneEditText = (EditText) findViewById(R.id.edit_phone);
        Button mSaveButton = (Button) findViewById(R.id.button_save);
        ListView mContactsListView = (ListView) findViewById(R.id.list_contacts);
        mContactsAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, mContactsList);
        mContactsListView.setAdapter(mContactsAdapter);
        Button mDeleteButton = (Button) findViewById(R.id.button_Delete1);
        mDBHelper = new ContactDBHelper(this);

        // load contacts from the database and display them in the list view
        loadContacts();

        mSaveButton.setOnClickListener(v -> {
            String name = mNameEditText.getText().toString();
            String phone = mPhoneEditText.getText().toString();
            if (!name.isEmpty() && !phone.isEmpty()) {
                // add the contact to the database
                addContact(name, phone);
                // add the contact to the list view
                mContactsList.add(name + " - " + phone);
                mContactsAdapter.notifyDataSetChanged();
                mNameEditText.setText("");
                mPhoneEditText.setText("");
                Toast.makeText(getApplicationContext(), "Contact saved successfully", Toast.LENGTH_SHORT).show();
            } else {
                Toast.makeText(getApplicationContext(), "Please enter both name and email", Toast.LENGTH_SHORT).show();
            }
        });

        mDeleteButton.setOnClickListener(v -> {
            String name2 = mNameEditText2.getText().toString();
            // delete the contact to the database
            mDBHelper.deleteContact(name2);
            loadContacts();
            mContactsList.remove(name2);
            mContactsAdapter.notifyDataSetChanged();
            mNameEditText2.setText("");
            Toast.makeText(getApplicationContext(), "Contact deleted successfully", Toast.LENGTH_SHORT).show();


        });

        mContactsListView.setOnItemClickListener((parent, view, position, id) -> {
            String contact = mContactsList.get(position);
            String[] parts = contact.split(" - ");
            String number = parts[1];
            Intent intent = new Intent(Intent.ACTION_DIAL);
            intent.setData(Uri.parse("tel:" + number));
            startActivity(intent);
        });

    }

    private void addContact(String name, String phone) {
        SQLiteDatabase db = mDBHelper.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(ContactDBHelper.COL_NAME, name);
        values.put(ContactDBHelper.COL_PHONE, phone);
        db.insert(ContactDBHelper.TABLE_NAME, null, values);
        db.close();
    }
    

    private void loadContacts() {
        mContactsList.clear();
        SQLiteDatabase db = mDBHelper.getReadableDatabase();
        Cursor cursor = db.query(ContactDBHelper.TABLE_NAME, new String[]{ContactDBHelper.COL_NAME, ContactDBHelper.COL_PHONE},
                null, null, null, null, null);
        while (cursor.moveToNext()) {
            String name = cursor.getString(cursor.getColumnIndex(ContactDBHelper.COL_NAME));
            String phone = cursor.getString(cursor.getColumnIndex(ContactDBHelper.COL_PHONE));
            mContactsList.add(name + " - " + phone);
        }
        cursor.close();
        mContactsAdapter.notifyDataSetChanged();
        db.close();
    }
}
