package com.moringaschool.wishabook.Data;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.SearchManager;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.SearchView;

import com.moringaschool.wishabook.Adapter.SearchAdapter;
import com.moringaschool.wishabook.R;
import com.moringaschool.wishabook.UI.Item;
import com.moringaschool.wishabook.UI.SearchProduct;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SearchResultActivity extends AppCompatActivity {

    //private FrequentItemsetData apriori;

    RecyclerView recyclerView;
    SearchAdapter adapter;

    SearchProduct products = new SearchProduct();
    List<Item> productitems;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search_result);

        recyclerView = (RecyclerView) findViewById(R.id.listshow);
        recyclerView.setHasFixedSize(true);

        productitems= products.getProductList();

        Context context;
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(linearLayoutManager);
        adapter = new SearchAdapter(productitems, SearchResultActivity.this);
        recyclerView.setAdapter(adapter);

        handleIntent(getIntent());
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu){
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.search_menu, menu);
        MenuItem searchItem = menu.getItem(0);

        SearchManager searchManager = (SearchManager) getSystemService(Context.SEARCH_SERVICE);
        SearchView searchView = (SearchView) menu.findItem(R.id.action_search).getActionView();
        searchView.setSearchableInfo(searchManager.getSearchableInfo(getComponentName()));
        searchView.setFocusable(true);
        searchItem.expandActionView();
        return true;
    }
    @Override
    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        handleIntent(intent);
    }
    private void handleIntent(Intent intent){
        if(Intent.ACTION_SEARCH.equals(intent.getAction())){
            String query = intent.getStringExtra(SearchManager.QUERY);

            final List<Item> filterlist = listFilter(productitems, query);
            adapter.setFilter(filterlist);
        }
    }

    private List<Item> listFilter(List<Item> list, String query){
        query = query.toLowerCase();
        final List<Item> filterModeList = new ArrayList<>();

        for (Item item: list){
            final String name = item.getItemName().toLowerCase();

            String [] tokens = name.split(" ");

            String patternString = "\\b(" + StringUtils.join(tokens, "|") + ")\\b";
            Pattern pattern = Pattern.compile(patternString);

            Matcher matcher = pattern.matcher(query);

            if (matcher.find()){
                filterModeList.add(item);
            }
        }
        return filterModeList;
    }
}