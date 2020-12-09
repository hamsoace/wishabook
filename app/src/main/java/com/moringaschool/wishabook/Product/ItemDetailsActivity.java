package com.moringaschool.wishabook.Product;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.facebook.drawee.view.SimpleDraweeView;
import com.moringaschool.wishabook.Fragments.ImageListFragment;
import com.moringaschool.wishabook.Notifications.NotificationCountSetClass;
import com.moringaschool.wishabook.R;
import com.moringaschool.wishabook.UI.Item;
import com.moringaschool.wishabook.UI.MainActivity;
import com.moringaschool.wishabook.UI.SearchProduct;
import com.moringaschool.wishabook.UI.Word;
import com.moringaschool.wishabook.Utilities.ImageUrlUtils;

import java.util.List;

public class ItemDetailsActivity extends AppCompatActivity {
    int imagePosition;
    String stringImageUri;

    public static final String STRING_IMAGE_URI = "ImageUri";
    public static final String STRING_IMAGE_POSITION = "ImagePosition";

    private String name;
    private String price;
    private String desc;
    private Word word;

    SearchProduct products = new SearchProduct();
    List<Item> productitems;

    ImageView itemImage;
    TextView itemName;
    TextView itemDesc;
    TextView itemPrice;

    int productPosition;
    int position = -1;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_item_details);
        SimpleDraweeView mImageView = (SimpleDraweeView)findViewById(R.id.image1);
        TextView textViewAddToCart = (TextView)findViewById(R.id.text_action_bottom1);
        TextView textViewBuyNow = (TextView)findViewById(R.id.text_action_bottom2);
        TextView product_names = (TextView)findViewById(R.id.item_detail_name);
        TextView product_price = (TextView)findViewById(R.id.item_detail_price);

        LinearLayout Desc_Layout = (LinearLayout)findViewById(R.id.text_layout);
        LinearLayout apriori_layout = (LinearLayout)findViewById(R.id.apriori);

        if (getIntent() != null){
            stringImageUri = getIntent().getStringExtra(ImageListFragment.STRING_IMAGE_URI);
            imagePosition = getIntent().getIntExtra(ImageListFragment.STRING_IMAGE_POSITION, 0);
            name = getIntent().getStringExtra("name");
            price = getIntent().getStringExtra("price");
            desc = getIntent().getStringExtra("desc");
            Boolean flag = getIntent().getBooleanExtra("flag", false);
            productPosition = getIntent().getIntExtra("position", -1);

            boolean suggest = false;

            if(name.equals("Best SciFi Book")){
                position = 10;
                suggest = true;
            }
            else if(name.equals("Best Fictional Book")){
                position = 9;
                suggest = true;
            }
            else if(name.equals("Stephen Hawkins Books")){
                position = 12;
                suggest = true;
            }
            else if(name.contentEquals("Science Books")){
                position = 14;
                suggest = true;
            }
            else if(name.contentEquals("Romantic Novel")){
                position = 7;
                suggest = true;
            }
            else if(name.contentEquals("AI & Coding Books")){
                position = 6;
                suggest = true;
            }else
                position = 0;

                if (flag & suggest){
                    Desc_Layout.setVisibility(View.GONE);
                }
                else{
                    apriori_layout.setVisibility(View.GONE);
                }

                word = new Word(name, desc, price);

                productitems = products.getProductList();

                itemImage = (ImageView)findViewById(R.id.search_image);
                itemName = (TextView) findViewById(R.id.search_name);
                itemDesc = (TextView) findViewById(R.id.description_part);
                itemPrice = (TextView) findViewById(R.id.search_price);


                itemImage.setImageResource(productitems.get(position).getItemImage());
                itemName.setText(productitems.get(position).getItemName());
                itemDesc.setText(productitems.get(position).getItemDesc());
                itemPrice.setText("$ "+ productitems.get(position).getItemPrice());

            }

            product_names.setText(name);
            product_price.setText(price);

            final boolean flagg = false;

            apriori_layout.setOnClickListener((view) -> {
                    Intent intent = getIntent();
                    intent.putExtra(STRING_IMAGE_URI, productitems.get(position).getItemImageUrl());
                    intent.putExtra(STRING_IMAGE_POSITION, position);
                    intent.putExtra("name", productitems.get(position).getItemName());
                    intent.putExtra("price", productitems.get(position).getItemPrice());
                    intent.putExtra("desc", productitems.get(position).getItemDesc());
                    intent.putExtra("flag", flagg);
                    intent.putExtra("position", position);
                    startActivity(intent);

            });

            Uri uri = Uri.parse(stringImageUri);
            mImageView.setImageURI(uri);

            textViewAddToCart.setOnClickListener((view) -> {
                ImageUrlUtils imageUrlUtils = new ImageUrlUtils();
                imageUrlUtils.addCartListImageUri(stringImageUri);
                word.SetMyCard(word);

                Toast.makeText(ItemDetailsActivity.this, "Items added to cart", Toast.LENGTH_SHORT).show();
                MainActivity.notificationCountCart++;
                NotificationCountSetClass.setNotifyCount(MainActivity.notificationCountCart);
            });

            textViewBuyNow.setOnClickListener((view) -> {
                Toast.makeText(ItemDetailsActivity.this, "Coming Soon", Toast.LENGTH_SHORT).show();
            });

        }
    }
