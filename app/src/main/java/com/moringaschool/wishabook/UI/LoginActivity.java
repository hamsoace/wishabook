  package com.moringaschool.wishabook.UI;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.moringaschool.wishabook.R;

import butterknife.BindView;
import butterknife.ButterKnife;

public class LoginActivity extends AppCompatActivity {

//    Button btnLogin;
    @BindView(R.id.btnlogin) Button btnlogin;
    @BindView(R.id.userEmail)
    EditText userEmail;
    @BindView(R.id.userPassword) EditText userPassword;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        ButterKnife.bind(this);

//        btnLogin=findViewById(R.id.btnLogin);

        btnlogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email=userEmail.getText().toString().trim();
                String password=userPassword.getText().toString().trim();

                if(email.equals("admin@mail.com") && (password.equals("password"))){
                    Toast.makeText(getApplicationContext(), "Welcome to Wish-A-Book",Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(LoginActivity.this, ShopActivity.class);
                    intent.putExtra("email", email);
                    startActivity(intent);
                }else {
                    Toast.makeText(getApplicationContext(),"Wrong email or password",Toast.LENGTH_SHORT).show();
                }

            }
        });
    }
}