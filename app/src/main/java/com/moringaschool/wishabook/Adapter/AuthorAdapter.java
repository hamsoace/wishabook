package com.moringaschool.wishabook.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.moringaschool.wishabook.Model.Author;
import com.moringaschool.wishabook.R;

import java.util.List;

public class AuthorAdapter extends RecyclerView.Adapter<AuthorAdapter.AuthorViewHolder> {

    Context context;
    List<Author> authorList;

    @NonNull
    @Override
    public AuthorViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(context).inflate(R.layout.author_name_list, parent, false);

        return new AuthorViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull AuthorViewHolder holder, int position) {
    }

    @Override
    public int getItemCount() {
        return authorList.size();
    }

    public class AuthorViewHolder extends RecyclerView.ViewHolder{
        public AuthorViewHolder(@NonNull View itemView) {
            super(itemView);
        }
    }
}
