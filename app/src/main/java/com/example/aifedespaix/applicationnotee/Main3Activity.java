package com.example.aifedespaix.applicationnotee;

import android.content.Intent;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.net.Uri;
import android.provider.ContactsContract;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class Main3Activity extends AppCompatActivity {

    Button btnOk;
    Button btnPasOk;
    Button btnOption;

    TextView textViewContact;

    private static final int REQUEST_FLAG = 1;
    private static final int PICK_CONTACT_REQUEST = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);

        btnOption = (Button) findViewById(R.id.buttonOption);
        btnOption.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                PackageManager pm = getPackageManager();
                Intent intContacts = new Intent(Intent.ACTION_PICK, Uri.parse("content://contacts"));
                intContacts.setType(ContactsContract.CommonDataKinds.Phone.CONTENT_TYPE);
                startActivityForResult(intContacts, PICK_CONTACT_REQUEST);
            }
        });

        btnOk = (Button) findViewById(R.id.buttonOk);
        btnOk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setResult(RESULT_OK);
                finish();
            }
        });

        btnPasOk = (Button) findViewById(R.id.buttonPasOk);
        btnPasOk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setResult(RESULT_CANCELED);
                finish();
            }
        });

        textViewContact = (TextView) findViewById(R.id.textViewContact);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if(requestCode == REQUEST_FLAG) {
            if(resultCode == RESULT_OK) {
                Toast.makeText(getApplicationContext(), "OK", Toast.LENGTH_LONG).show();
            } else if(resultCode== RESULT_CANCELED) {
                Toast.makeText(getApplicationContext(), "NTM", Toast.LENGTH_LONG).show();
            }
        }
        if(requestCode == PICK_CONTACT_REQUEST) {
            if(resultCode == RESULT_OK) {
                Uri contactUrl = data.getData();
                String[] projection = {ContactsContract.CommonDataKinds.Phone.NUMBER};
                Cursor cursor = getContentResolver().query(contactUrl, projection, null, null, null);
                cursor.moveToFirst();
                int column = cursor.getColumnIndex(ContactsContract.CommonDataKinds.Phone.NUMBER);
                String number = cursor.getString(column);
                textViewContact.setText(number);
            }
        }
    }
}
