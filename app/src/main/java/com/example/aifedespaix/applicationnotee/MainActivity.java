package com.example.aifedespaix.applicationnotee;

import android.Manifest;
import android.content.Intent;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Button btnCommencer;
    Button btnSms;
    Button btnCours;

    Intent intGhetto;
    Intent intCours;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnCours = (Button) findViewById(R.id.buttonCours);
        btnCours.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                intCours = new Intent(getApplicationContext(), Main2Activity.class);
                startActivity(intCours);
            }
        });
        btnCommencer = (Button) findViewById(R.id.buttonCommencer);
        btnCommencer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                intGhetto = new Intent(getApplicationContext(), GuettoActivity.class);
                startActivity(intGhetto);
            }
        });

        btnSms = (Button) findViewById(R.id.buttonSms);
        btnSms.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                sendSmsTo("0618141984", "Coucou je suis androide");
            }
        });
    }

    private void sendSmsTo(String num, String message) {
        try {
            SmsManager manager = SmsManager.getDefault();
            manager.sendTextMessage(num, null, message, null, null);
            Toast.makeText(getApplicationContext(), message, Toast.LENGTH_LONG).show();
        } catch (Exception e) {
            System.out.println(e);
        }

    }

}
