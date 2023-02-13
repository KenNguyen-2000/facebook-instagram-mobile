package com.ngkien299.facebooklogin;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.LinearGradient;
import android.graphics.Shader;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.PaintDrawable;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.shapes.RectShape;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private static EditText edtLoginUsername;
    private static EditText edtLoginPassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        edtLoginUsername = (EditText) findViewById(R.id.et_username_main);
        edtLoginPassword = (EditText) findViewById(R.id.et_password_main);
    }

    public void onSignupClick(View view){
        Intent intent = new Intent(this, SignupActivity.class);
        startActivity(intent);
    }

    public void onLoginClick(View view){
        Intent intent = new Intent(MainActivity.this, HomeActivity.class);
//        Bundle bundle = new Bundle();
//        String username = edtLoginUsername.getText().toString().trim();
//        String password = edtLoginPassword.getText().toString().trim();
//
//        bundle.putString("username", username);
//        bundle.putString("password", password);
//        intent.putExtra("data", bundle);

        startActivity(intent);
//        if(username.equals("admin") && password.equals("123456")){
//            Toast.makeText(getBaseContext(), "Login successfully", Toast.LENGTH_SHORT).show();
//        }else{
//            Toast.makeText(getBaseContext(), "Login failed", Toast.LENGTH_SHORT).show();
//        }
    }

    public void loginWithFbClick(View view){
        Intent intent = new Intent(this, FacebookLoginActivity.class);
        startActivity(intent);
    }
}