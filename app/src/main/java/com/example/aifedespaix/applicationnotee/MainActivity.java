package com.example.aifedespaix.applicationnotee;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private static final int REQUEST_FLAG = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if(requestCode == REQUEST_FLAG) {
            if(requestCode == RESULT_OK) {
                Toast.makeText(getApplicationContext(), "Validay", Toast.LENGTH_LONG).show();
            } else if(requestCode == RESULT_CANCELED) {
                Toast.makeText(getApplicationContext(), "Annulay", Toast.LENGTH_LONG).show();
            }
        }
        super.onActivityResult(requestCode, resultCode, data);
    }
}
