package com.sell.karo.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.sell.karo.R;


public class LoginSetUpActivity extends AppCompatActivity {
    String TAG = "LoginSetUpActivity";
    private static final String EMAIL = "email";
    Button btnLogin , btnEmail , btnFb;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_set_up);

        btnLogin = (Button)findViewById(R.id.btnLogin);
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(LoginSetUpActivity.this , LoginActivity.class);
                startActivity(i);
            }
        });

        btnEmail = (Button)findViewById(R.id.btnEmail);
        btnEmail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(LoginSetUpActivity.this , SignUpWithEmail.class);
                startActivity(i);
            }
        });

        btnFb = (Button)findViewById(R.id.btnFb);
        btnFb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
            }
        });
    }



}
