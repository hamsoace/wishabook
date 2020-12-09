package com.moringaschool.wishabook.UI;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import com.moringaschool.wishabook.R;

public class MyAccount extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_account);

        TextView register = (TextView) findViewById(R.id.registerclick);

        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MyAccount.this, Registration.class));
            }
        });

        CardView view = (CardView) findViewById(R.id.btnlogin);

        view.setOnClickListener(new View.OnClickListener(){

            public void onClick(View view)
            {
                startActivity(new Intent(MyAccount.this, MainActivity.class));
            }

        });

    }
}
