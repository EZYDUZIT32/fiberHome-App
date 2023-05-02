package com.example.fiberhomeapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Paint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class twentymbpscard extends AppCompatActivity {
    private Button PROCEEDBTN;
    private TextView GETTY;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_twentymbpscard);
        PROCEEDBTN=(Button) findViewById(R.id.proceedbtn);
        PROCEEDBTN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(twentymbpscard.this, signuppagetwenty.class);
                startActivity(intent);
            }
        });
        GETTY=(TextView) findViewById(R.id.getty);
        GETTY.setPaintFlags(GETTY.getPaintFlags() | Paint.UNDERLINE_TEXT_FLAG);
    }
}