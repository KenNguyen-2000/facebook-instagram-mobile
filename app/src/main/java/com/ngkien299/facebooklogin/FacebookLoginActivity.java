package com.ngkien299.facebooklogin;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class FacebookLoginActivity extends AppCompatActivity {
    private static EditText edtFbUsername;
    private static EditText edtFbPassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_facebook_login);

        edtFbUsername = (EditText) findViewById(R.id.et_fb_username);
        edtFbPassword = (EditText) findViewById(R.id.et_fb_password);
    }

    public void onFbLoginClick(View view){
        Intent intent = new Intent(FacebookLoginActivity.this, WelcomeActivity.class);
        Bundle bundle = new Bundle();
        String username = edtFbUsername.getText().toString().trim();
        String password = edtFbPassword.getText().toString().trim();

        bundle.putString("username", username);
        bundle.putString("password", password);
        intent.putExtra("data", bundle);

        startActivity(intent);
//        if(username.equals("admin") && password.equals("123456")){
//            Toast.makeText(getBaseContext(), "Login fb successfully", Toast.LENGTH_SHORT).show();
//            finish();
//        }else{
//            Toast.makeText(getBaseContext(), "Login fb failed", Toast.LENGTH_SHORT).show();
//        }
    }


}