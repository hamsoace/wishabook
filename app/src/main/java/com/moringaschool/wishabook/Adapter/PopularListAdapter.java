package com.moringaschool.wishabook.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.moringaschool.wishabook.Model.PopularList;
import com.moringaschool.wishabook.R;

import java.util.List;

public class PopularListAdapter extends RecyclerView.Adapter<PopularListAdapter.PopularListViewHolder>{

    Context context;
    List<PopularList> productList;

    @NonNull
    @Override
    public PopularListViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(context).inflate(R.layout.product_row_items, parent, false);
        return new PopularListViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull PopularListViewHolder holder, int position) {

        holder.productImageView.setImageResource(Integer.parseInt(productList.get(position).getImageUrl()));

    }

    @Override
    public int getItemCount() {
        return productList.size();
    }

    public static class PopularListViewHolder extends RecyclerView.ViewHolder{

        ImageView productImageView;

        public PopularListViewHolder(@NonNull View itemView) {
            super(itemView);

            productImageView = itemView.findViewById(R.id.productListImage);
        }
    }
}
