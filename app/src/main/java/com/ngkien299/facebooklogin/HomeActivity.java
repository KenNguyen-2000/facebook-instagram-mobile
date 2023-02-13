package com.ngkien299.facebooklogin;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;

public class HomeActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        RecyclerView rcvItem = findViewById(R.id.rcv_item);
        ItemAdapter mAdapter = new ItemAdapter(this, getListItem());

        rcvItem.setAdapter(mAdapter);

        mAdapter.notifyDataSetChanged();
        rcvItem.setHasFixedSize(true);
        rcvItem.setLayoutManager(new GridLayoutManager(this, 3));
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
}