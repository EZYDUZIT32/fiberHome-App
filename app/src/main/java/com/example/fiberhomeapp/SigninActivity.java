package com.example.fiberhomeapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class SigninActivity extends AppCompatActivity {
    private Button LOGINBTN, ADMINSIGNINBTN;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signin);
        ADMINSIGNINBTN=(Button) findViewById(R.id.loginadmin_btn);
        ADMINSIGNINBTN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(SigninActivity.this, Adminsignin.class);
                startActivity(intent);
            }
        });

        LOGINBTN=(Button) findViewById(R.id.userlogin_btn);
        LOGINBTN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
             goLink("https://billing.fiberhome.co.ke/index.php/login");
            }
        });
    }
    private void goLink(String s) {
        Uri uri = Uri.parse(s);
        startActivity(new Intent(Intent.ACTION_VIEW,uri));
    }
}