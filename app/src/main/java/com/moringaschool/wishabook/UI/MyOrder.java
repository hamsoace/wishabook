package com.moringaschool.wishabook.UI;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.moringaschool.wishabook.R;

public class MyOrder extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_order);

        Button orderBtn = (Button) findViewById(R.id.btnOrder);
        orderBtn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view)
            {
                Toast.makeText(MyOrder.this, "Order Submitted Successfully!", Toast.LENGTH_SHORT).show();
            }

        });

    }
}
