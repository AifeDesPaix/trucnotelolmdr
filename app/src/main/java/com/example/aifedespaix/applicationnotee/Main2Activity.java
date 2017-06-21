package com.example.aifedespaix.applicationnotee;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class Main2Activity extends AppCompatActivity {

    private static final int REQUEST_FLAG = 1;
    Button btnA;
    Button btnB;

    Intent intentMain;
    Intent intMain3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        
        intentMain = getIntent();

        btnA = (Button) findViewById(R.id.buttonA);
        btnA.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                nav_main3();
                startActivityForResult(intMain3, REQUEST_FLAG);
            }
        });
//        btnB = (Button) findViewById(R.id.buttonB);
//        btnB.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                nav_main3();
//                startActivityForResult(intentMain, REQUEST_FLAG);
//            }
//        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if(requestCode == REQUEST_FLAG) {
            if(resultCode == RESULT_OK) {
                Toast.makeText(getApplicationContext(), "Validay", Toast.LENGTH_LONG).show();
            } else if(resultCode == RESULT_CANCELED) {
                Toast.makeText(getApplicationContext(), "Annulay", Toast.LENGTH_LONG).show();
            }
        }
//        super.onActivityResult(requestCode, resultCode, data);
    }

    private void nav_main3() {
        intMain3 = new Intent(getApplicationContext(), Main3Activity.class);
//        startActivity(intMain3);
    }
}
