package com.example.lamaison;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder> {
    private Context context;
    private ArrayList item_name, item_price;

    public MyAdapter(Context context, ArrayList item_name, ArrayList item_price) {
        this.context = context;
        this.item_name = item_name;
        this.item_price = item_price;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(context).inflate(R.layout.cart, parent, false);
        return new MyViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        holder.item_name.setText(String.valueOf(item_name.get(position)));
        holder.item_price.setText(String.valueOf(item_price.get(position)));
    }

    @Override
    public int getItemCount() {
        return item_name.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        TextView item_name, item_price;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            item_name = itemView.findViewById(R.id.itemsname);
            item_price = itemView.findViewById(R.id.itemsprice);
        }
    }
}
