package com.ngkien299.facebooklogin;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class SignupActivity extends AppCompatActivity {
    private static EditText edtSignupUsername;
    private static EditText edtSignupMobile;
    private static EditText edtSignupEmail;
    private static EditText edtSignupPassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);
    }

    public void onLoginClick(View view){
        finish();
    }

    public void onSignupClick(View view){
        edtSignupUsername = (EditText) findViewById(R.id.edtSignupUsername);
        edtSignupMobile = (EditText) findViewById(R.id.edtSignupMobile);
        edtSignupEmail = (EditText) findViewById(R.id.edtSignupEmail);
        edtSignupPassword = (EditText) findViewById(R.id.edtSignupPassword);
        System.out.println((edtSignupUsername.getText().toString()));
        System.out.println((edtSignupMobile.getText().toString()));
        System.out.println((edtSignupEmail.getText().toString()));
        System.out.println((edtSignupPassword.getText().toString()));
    }
}