package com.example.aifedespaix.applicationnotee;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class LoginActivity extends AppCompatActivity {

    private Button btn_login;

    private EditText editText_login;
    private EditText editText_password;

    private TextView textView_error;

    private Intent intentLoginCheck;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        editText_login = (EditText) findViewById(R.id.editText_login);
        editText_password = (EditText) findViewById(R.id.editText_password);

        textView_error = (TextView) findViewById(R.id.textView_error);

        btn_login = (Button) findViewById(R.id.button_connexion);

        btn_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                nav_LoginCheck();
            }
        });

        intentLoginCheck = getIntent();
        String error = intentLoginCheck.getStringExtra("error");
        if(error != null) {
            textView_error.setText(error);
        }

    }

    private void nav_LoginCheck() {
        intentLoginCheck = new Intent(getApplicationContext(), Fullscreen_LoginCheckActivity.class);
        intentLoginCheck.putExtra("login", editText_login.getText().toString());
        intentLoginCheck.putExtra("password", editText_password.getText().toString());

        startActivity(intentLoginCheck);
    }
}
