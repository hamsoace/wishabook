package com.moringaschool.wishabook.UI;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.moringaschool.wishabook.R;

public class Registration extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);

        TextView login = (TextView) findViewById(R.id.txtlogintext);

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(Registration.this, MyAccount.class));
            }
        });


        Button register = (Button) findViewById(R.id.btnRegister);
        register.setOnClickListener(new View.OnClickListener(){

            public void onClick(View view)
            {
                Toast.makeText(Registration.this, "Registered Successfully!", Toast.LENGTH_SHORT).show();
            }
        });

    }
}