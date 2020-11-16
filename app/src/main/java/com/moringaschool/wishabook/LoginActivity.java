package com.moringaschool.wishabook;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import butterknife.BindView;
import butterknife.ButterKnife;

public class LoginActivity extends AppCompatActivity {

    Button btnLogin;
    @BindView(R.id.userEmail)
    EditText userEmail;
    @BindView(R.id.userPassword) EditText userPassword;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        ButterKnife.bind(this);

        btnLogin=findViewById(R.id.btnLogin);

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email=userEmail.getText().toString().trim();
                String password=userPassword.getText().toString().trim();

                if(email.equals("admin") && (password.equals("password"))){
                    Intent intent = new Intent(LoginActivity.this, ShopActivity.class);
                    startActivity(intent);
                    Toast.makeText(getApplicationContext(), "Welcome to Wish-A-Book",Toast.LENGTH_SHORT).show();
                }else {
                    Toast.makeText(getApplicationContext(),"Wrong email or password",Toast.LENGTH_SHORT).show();
                }

            }
        });
    }
}