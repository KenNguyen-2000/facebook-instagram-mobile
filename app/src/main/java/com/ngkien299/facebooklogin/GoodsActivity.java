package com.ngkien299.facebooklogin;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;
import java.util.LinkedList;

public class GoodsActivity extends AppCompatActivity {
    private static final int REQUEST_PERMISSION_CODE = 1000;
    private RecyclerView rcvGood;
    private GoodAdapter mAdapter;
    private ArrayList<Good> goodList;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_goods);

        rcvGood = findViewById(R.id.rvGoodsList);
        goodList = GoodDao.getAllGoods(GoodsActivity.this);
        System.out.println("GoodList: " + goodList);
        mAdapter = new GoodAdapter(this, goodList);

        rcvGood.setAdapter(mAdapter);

        mAdapter.notifyDataSetChanged();
        rcvGood.setHasFixedSize(true);
        rcvGood.setLayoutManager(new LinearLayoutManager(GoodsActivity.this));

    }


}