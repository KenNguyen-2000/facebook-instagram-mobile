package com.ngkien299.facebooklogin;


import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class DetailActivity extends AppCompatActivity {
    private static final int REQUEST_PERMISSION_CODE = 1000;
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
        Uri uri = Uri.parse("tel:" + tvPhoneNumber.getText().toString());
        Intent intent = new Intent(Intent.ACTION_CALL, uri);
        startActivity(intent);
    }

}