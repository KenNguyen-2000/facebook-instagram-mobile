package com.ngkien299.facebooklogin;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.LinkedList;

public class GoodAdapter extends RecyclerView.Adapter<GoodAdapter.GoodViewHolder> {
    private Context context;
    private ArrayList<Good> mGoodList;
    private LayoutInflater mInflater;

    public GoodAdapter(Context context, ArrayList<Good> mGoodList) {
        mInflater = LayoutInflater.from(context);
        this.mGoodList = mGoodList;
    }

    public void setData(ArrayList<Good> list){
        this.mGoodList = list;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public GoodViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        this.context = parent.getContext();

        View mItemView = mInflater.inflate(R.layout.good_item, parent, false);
        GoodAdapter.GoodViewHolder goodViewHolder = new GoodAdapter.GoodViewHolder(mItemView, this, context);
        return  goodViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull GoodViewHolder holder, int position) {
        Good mGood = mGoodList.get(position);
        holder.tvGoodName.setText(mGood.get_name());
        holder.tvGoodTotal.setText(mGood.get_total());
    }

    @Override
    public int getItemCount() {
        return mGoodList.size();
    }

    public class GoodViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        private TextView tvGoodName;
        private TextView tvGoodTotal;
        private GoodAdapter mAdapter;
        private Context context;

        public GoodViewHolder(@NonNull View itemView, GoodAdapter adapter, Context context) {
            super(itemView);

            tvGoodName = itemView.findViewById(R.id.tvGoodName);
            tvGoodTotal = itemView.findViewById(R.id.tvGoodTotal);

            this.mAdapter = adapter;
            this.context = context;

            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            int position = getAdapterPosition();
            if(position != RecyclerView.NO_POSITION){
                Good goodItem = mGoodList.get(position);
                Intent intent = new Intent(context, DetailActivity.class);

                intent.putExtra("Good", goodItem);
                context.startActivity(intent);
            }
        }
    }
}
