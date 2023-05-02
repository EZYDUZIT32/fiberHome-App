package com.example.fiberhomeapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Waitingpage extends AppCompatActivity
{
    private Button HOMER;
    private Button EXITER;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_waitingpage);
        HOMER=(Button) findViewById(R.id.waithomebtn);
        HOMER.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view)
            {
                Intent intent = new Intent(Waitingpage.this, MainActivity.class);
                startActivity(intent);
            }
        });

        EXITER=(Button) findViewById(R.id.exithomebtn);
        EXITER.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view)
            {
                moveTaskToBack(true);
                android.os.Process.killProcess(android.os.Process.myPid());
                System.exit(1);
            }
        });
    }
}