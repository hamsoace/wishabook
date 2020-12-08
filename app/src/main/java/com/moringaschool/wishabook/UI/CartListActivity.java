package com.moringaschool.wishabook.UI;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.ViewHolder;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.facebook.drawee.view.SimpleDraweeView;
import com.moringaschool.wishabook.R;

import java.util.ArrayList;

public class CartListActivity extends AppCompatActivity {
    private static Context mContext;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cart_list);
        mContext = CartListActivity.this;

        ImageUrlUtils imageUrlUtils = new ImageUrlUtils();
        ArrayList<String> cartlistImageUri = imageUrlUtils.getCartListImageUri();

        word word = new Word();
        ArrayList<Word> list = word.getMyCard();

        setCartLayout();

        RecyclerView recyclerView = (RecyclerView)findViewById(R.id.recyclerview);
        RecyclerView.LayoutManager recyclerViewLayoutManager = new LinearLayoutManager(mContext);

        recyclerView.setLayoutManager(recyclerViewLayoutManager);
        recyclerView.setAdapter(new  CartListActivity.SimpleStringRecyclerViewAdapter(recyclerView, cartlistImageUri, list));
    }

    public static class SimpleStringRecyclerViewAdapter extends RecyclerView.Adapter<CartListActivity.SimpleStringRecyclerViewAdapter.ViewHolder>{
        private ArrayList<String> mCartlistImageUri;
        private ArrayList<Word> productDetails;
        private RecyclerView mRecyclerView;

        public static class ViewHolder extends RecyclerView.ViewHolder{
            public final View mView;
            public final SimpleDraweeView mImageView;
            public final LinearLayout mLayoutItem, mLayoutRemove, mLayoutEdit;
            public final TextView textViewName, textViewDesc, textViewPrice;

            public ViewHolder(View view){
                super(view);
                mView = view;
                mImageView = (SimpleDraweeView) view.findViewById(R.id.image_cartlist);
                mLayoutItem = (LinearLayout) view.findViewById(R.id.layout_item_desc);
                mLayoutRemove = (LinearLayout) view.findViewById(R.id.layout_action1);
                mLayoutEdit = (LinearLayout) view.findViewById(R.id.layout_action2);
                textViewName = (TextView) view.findViewById(R.id.cardlist_name);
                textViewDesc = (TextView) view.findViewById(R.id.cardlist_desc);
                textViewPrice = (TextView) view.findViewById(R.id.cardlist_price);
            }
        }

        public SimpleStringRecyclerViewAdapter(RecyclerView recyclerView, ArrayList<String> wishlistImageUri, ArrayList<Word> listitem){
            mCartlistImageUri = wishlistImageUri;
            mRecyclerView = recyclerView;
            productDetails = listitem;
        }

        @Override
        public CartListActivity.SimpleStringRecyclerViewAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType){
            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_cartlist_item, parent, false);
            return  new CartListActivity.SimpleStringRecyclerViewAdapter.ViewHolder(view);
        }

        @Override
        public void onViewRecycled(CartListActivity.SimpleStringRecyclerViewAdapter.ViewHolder holder){
            if (holder.mImageView.getController() !=null){
                holder.mImageView.getController().onDetach();
            }if (holder.mImageView.getTopLevelDrawable() !=null){
                holder.mImageView.getTopLevelDrawable().setCallback(null);
            }
        }

        @Override
        public void onBindViewHolder(final CartListActivity.SimpleStringRecyclerViewAdapter.ViewHolder holder, final int position){
            final Uri uri = Uri.parse(mCartlistImageUri.get(position));
            holder.mImageView.setImageURI(uri);

            holder.textViewName.setText(productDetails.get(position).getWordName());
            holder.textViewDesc.setText(productDetails.get(position).getWordDesc());
            holder.textViewPrice.setText(productDetails.get(position).getWordPrice());

            final String name = productDetails.get(position).getWordName();
            final String price = productDetails.get(position).getWordPrice();
            final String desc = productDetails.get(position).getWordDesc();

            holder.mLayoutItem.setOnClickListener((v) ->{
                Intent intent = new Intent(mContext, ItemDetailsActivity.class);
                intent.putExtra(STRING_IMAGE_URI, mCartlistImageUri.get(position));
                intent.putExtra(STRING_IMAGE_POSITION, position);

                intent.putExtra("naame", name);
                intent.putExtra("price", price);
                intent.putExtra("desc", desc);

                mContext.startActivity(intent);
            });

            holder.mLayoutRemove.setOnClickListener((view) ->{
                ImaageUrlUtils imaageUrlUtils = new ImageUrlUtils();
                imageUrlUtils.removeCartListImageUri(position);
                Word word = new Word();
                word.removeMyCard(position);
                notifyDataSetChanged();
                MainActivity.notificationCountCart--;
            });

            holder.mLayoutEdit.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                }
            });
        }

        @Override
        public int getItemCount(){
            return mCartlistImageUri.size();
        }

        protected void setCartLayout(){
            LinearLayout layoutCartItems = (LinearLayout) findViewById(R.id.layout_items);
            LinearLayout layoutCartPayments = (LinearLayout) findViewById(R.id.layout_payment);
            LinearLayout layoutCartNoItems = (LinearLayout) findViewById(R.id.layout_cart_empty);

            if (MainActivity.notificationCountCart > 0){
                layoutCartNoItems.setVisibility(View.GONE);
                layoutCartItems.setVisibility(View.VISIBLE);
                layoutCartPayments.setVisibility(View.VISIBLE);
            }else {
                layoutCartNoItems.setVisibility(View.VISIBLE);
                layoutCartItems.setVisibility(View.GONE);
                layoutCartPayments.setVisibility(View.GONE);

                Button bStartShopping = (Button) findViewById(R.id.bAddNew);
                bStartShopping.setOnClickListener((view) -> {
                    finish();
                });
            }
        }
    }
}