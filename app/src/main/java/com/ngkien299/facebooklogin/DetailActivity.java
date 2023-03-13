package com.ngkien299.facebooklogin;


import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class DetailActivity extends AppCompatActivity {
    private static final int REQUEST_CODE_FOR_SOURCE = 1000;
    private Item item;
    private TextView tvDetailWord;
    private TextView tvPhoneNumber;
    private ImageView imgDetailImg;
    private Button callStoreBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        tvDetailWord = findViewById(R.id.tv_detail_word);
        imgDetailImg = findViewById(R.id.img_detail);
        tvPhoneNumber = findViewById(R.id.tv_phone_number);
        callStoreBtn = findViewById(R.id.btn_call);


        item = (Item) getIntent().getSerializableExtra("item");

        tvDetailWord.setText(item.getItemText());
        imgDetailImg.setImageResource(item.getItemId());

        callStoreBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                callStore();
            }
        });
    }

    private void callStore(){
        if(ContextCompat.checkSelfPermission(this, Manifest.permission.CALL_PHONE) == PackageManager.PERMISSION_GRANTED){
            Uri uri = Uri.parse("tel:" + tvPhoneNumber.getText().toString());
            Intent intent = new Intent(Intent.ACTION_CALL, uri);
            startActivity(intent);
        }else{
           Toast.makeText(DetailActivity.this, "Please granted call phone permission", Toast.LENGTH_SHORT).show();
        }

    }


//

}