package com.moringaschool.wishabook.UI;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.moringaschool.wishabook.Adapter.PopularListAdapter;
import com.moringaschool.wishabook.Model.PopularList;
import com.moringaschool.wishabook.R;

import java.util.ArrayList;
import java.util.List;

public class HomeActivity extends AppCompatActivity {

//    @BindView(R.id.listBook)
//    ListView mListView;

    RecyclerView rvMain, popularRecyclerView;
    PopularListAdapter popularListAdapter;
    List<PopularList> popularLists;


   // private String[] books = new String[]{"Brief History of Time", "Life 3.0", "The God Delusion",
    //    "The God Game", "Sapiens", "Cosmos"};

    public static final String TAG = HomeActivity.class.getSimpleName();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
//        ButterKnife.bind(this);
        rvMain= findViewById(R.id.rvMain);

        popularRecyclerView = findViewById(R.id.popularList);

        popularLists= new ArrayList<>();
        popularLists.add(new PopularList(1, R.drawable.top_10_fiction));
        popularLists.add(new PopularList(2, R.drawable.pl_25_of_25));
        popularLists.add(new PopularList(3, R.drawable.top_10_fiction));
        popularLists.add(new PopularList(2, R.drawable.pl_25_of_25));
        popularLists.add(new PopularList(3, R.drawable.top_10_fiction));

        setPopularRecycler(popularLists);

//        Context context;
//        ArrayAdapter adapter = new ArrayAdapter<String>(this, android.R.layout.simple_expandable_list_item_1, books);
//        mListView.setAdapter(adapter);
//
//        mListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
//            @Override
//            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
//                String book = ((TextView)view).getText().toString().trim();
//                Toast.makeText(HomeActivity.this, book,Toast.LENGTH_LONG).show();
//
//            }
//        });
    }

    private void setPopularRecycler(List<PopularList> dataList) {
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL,false);
        popularRecyclerView.setLayoutManager(layoutManager);
       // popularListAdapter = new PopularListAdapter(this, dataList);
        popularRecyclerView.setAdapter(popularListAdapter);
    }
}