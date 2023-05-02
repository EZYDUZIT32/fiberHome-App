package com.example.fiberhomeapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.graphics.Paint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class fifteenmbpscard extends AppCompatActivity {
    private Button PROCEEDBTN;
    private TextView GETTY;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fifteenmbpscard);
        PROCEEDBTN=(Button) findViewById(R.id.proceedbtn);
        PROCEEDBTN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(fifteenmbpscard.this, signuppagefifteen.class);
                startActivity(intent);
            }
        });
        GETTY=(TextView) findViewById(R.id.getty);
        GETTY.setPaintFlags(GETTY.getPaintFlags() | Paint.UNDERLINE_TEXT_FLAG);


    }
}