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

public class ItemAdapter extends  RecyclerView.Adapter<ItemAdapter.ItemViewHolder> {
    private Context context;
    private ArrayList<Item> mItemList;
    private LayoutInflater mInflater;


    public ItemAdapter(Context context, ArrayList<Item> itemList) {
        mInflater = LayoutInflater.from(context);
        this.mItemList = itemList;
    }

    public void setData(ArrayList<Item> list){
        this.mItemList = list;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public ItemViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        this.context = parent.getContext();

        View mItemView = mInflater.inflate(R.layout.item_file, parent, false);
        ItemViewHolder itemViewHolder = new ItemViewHolder(mItemView, this, context);
        return  itemViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ItemViewHolder holder, int position) {
        Item mItem = mItemList.get(position);
        holder.tvWord.setText(mItem.getItemText());
        holder.imgItem.setImageResource(mItem.getItemId());
    }

    @Override
    public int getItemCount() {
        return mItemList.size();
    }

    public class ItemViewHolder extends  RecyclerView.ViewHolder implements  View.OnClickListener{
        private ImageView imgItem;
        private TextView tvWord;
        private ItemAdapter mAdapter;
        private Context context;

        public ItemViewHolder(@NonNull View itemView, ItemAdapter adapter, Context context) {
            super(itemView);

            imgItem = itemView.findViewById(R.id.img_item);
            tvWord = itemView.findViewById(R.id.tv_item_word);

            this.mAdapter = adapter;
            this.context = context;

            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            int position = getAdapterPosition();
            if(position != RecyclerView.NO_POSITION){
                Item item = mItemList.get(position);
                Intent intent = new Intent(context, DetailActivity.class);

                intent.putExtra("item", item);
                context.startActivity(intent);
            }
        }


    }
}
