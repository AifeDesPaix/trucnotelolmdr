package com.example.aifedespaix.applicationnotee;

import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.provider.ContactsContract;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Main3Activity extends AppCompatActivity {

    Button btnOk;
    Button btnPasOk;
    Button btnOption;

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
                startActivityForResult(intContacts, RESULT_OK);
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

    }
}
