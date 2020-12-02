package com.moringaschool.wishabook.Adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.moringaschool.wishabook.Model.PopularList;

import java.util.List;

public class PopularListAdapter extends RecyclerView.Adapter<PopularListAdapter.PopularListViewHolder>{

    Context context;
    List<PopularList> productList;

    @NonNull
    @Override
    public PopularListViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return null;
    }

    @Override
    public void onBindViewHolder(@NonNull PopularListViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return productList.size();
    }

    public static class PopularListViewHolder extends RecyclerView.ViewHolder{

        public PopularListViewHolder(@NonNull View itemView) {
            super(itemView);
        }
    }
}
