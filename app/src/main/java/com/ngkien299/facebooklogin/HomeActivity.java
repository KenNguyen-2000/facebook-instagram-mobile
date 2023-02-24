package com.ngkien299.facebooklogin;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.Manifest;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Bundle;
import android.widget.Toast;

import java.util.ArrayList;

public class HomeActivity extends AppCompatActivity {
    private static final int REQUEST_PERMISSION_CODE = 1000;
    private RecyclerView rcvItem;
    private ItemAdapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        rcvItem = findViewById(R.id.rcv_item);
        mAdapter = new ItemAdapter(this, getListItem());

        rcvItem.setAdapter(mAdapter);

        mAdapter.notifyDataSetChanged();
        rcvItem.setHasFixedSize(true);
        rcvItem.setLayoutManager(new GridLayoutManager(this, 3));

        getCallPhonePermission();
    }

    private static ArrayList<Item> getListItem() {
        ArrayList<Item> items = new ArrayList<>();

        items.add(new Item(R.mipmap.ic_medical_item, "Pharmacy"));
        items.add(new Item(R.mipmap.ic_registry_item, "Registry"));
        items.add(new Item(R.mipmap.ic_cartwheel_item, "Cartwheel"));
        items.add(new Item(R.mipmap.ic_cloth_item, "Cloth"));
        items.add(new Item(R.mipmap.ic_gift_item, "Souvenir"));
        items.add(new Item(R.mipmap.ic_basket_item, "Accessories"));
        items.add(new Item(R.mipmap.ic_baby_item, "Baby"));
        items.add(new Item(R.mipmap.ic_home_item, "Home"));
        items.add(new Item(R.mipmap.ic_grill_item, "Patio & Grill"));



        return items;
    }

    public void  getCallPhonePermission(){
        if(Build.VERSION.SDK_INT < Build.VERSION_CODES.M){
            return;
        }

        if(checkSelfPermission(Manifest.permission.CALL_PHONE) == PackageManager.PERMISSION_GRANTED){
            Toast.makeText(HomeActivity.this, "Granted", Toast.LENGTH_LONG).show();
        }else{
            if(shouldShowRequestPermissionRationale(Manifest.permission.CALL_PHONE)){

            }

            String[] permissions = {Manifest.permission.CALL_PHONE};
            requestPermissions(permissions, REQUEST_PERMISSION_CODE);
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        switch (requestCode){
            case REQUEST_PERMISSION_CODE: {
                if(grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED){

                }else{

                }
                return;
            }
        }
    }
}