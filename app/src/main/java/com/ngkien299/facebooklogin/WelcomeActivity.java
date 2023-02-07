package com.ngkien299.facebooklogin;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class WelcomeActivity extends AppCompatActivity {
    TextView tvAccount;
    TextView tvPassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);

        tvAccount = (TextView) findViewById(R.id.tv_account);
        tvPassword = (TextView) findViewById(R.id.tv_password);

        Intent intent = getIntent();
        Bundle bundle = intent.getBundleExtra("data");
        String account = bundle.getString("username");
        String password = bundle.getString("password");

        tvAccount.setText(account);
        tvPassword.setText(password);
    }
}