package com.example.fiberhomeapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Paint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class HomeActivity extends AppCompatActivity
{
    private CardView cardviewfiver, cardviewniner, cardviewfifteener, cardviewtwentier, cardviewthirtier, cardviewmorer;
    private TextView GETTY;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        cardviewfiver=(CardView) findViewById(R.id.cardviewfive);
        cardviewfiver.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(HomeActivity.this, fivembpscard.class);
                startActivity(intent);
            }
        });

        cardviewniner=(CardView) findViewById(R.id.cardviewnine);
        cardviewniner.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view)
            {
                Intent intent = new Intent(HomeActivity.this, ninembpscard_Activity.class);
                startActivity(intent);
            }
        });

        cardviewfifteener=(CardView) findViewById(R.id.cardviewfifteen);
        cardviewfifteener.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view)
            {
                Intent intent = new Intent(HomeActivity.this,fifteenmbpscard.class);
                startActivity(intent);
            }
        });

        cardviewtwentier=(CardView) findViewById(R.id.cardviewtwenty);
        cardviewtwentier.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view)
            {
                Intent intent = new Intent(HomeActivity.this, twentymbpscard.class);
                startActivity(intent);
            }
        });

        cardviewthirtier=(CardView) findViewById(R.id.cardviewthirty);
        cardviewthirtier.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view)
            {
                Intent intent = new Intent(HomeActivity.this, thirtymbpscard.class);
                startActivity(intent);
            }
        });

        cardviewmorer=(CardView) findViewById(R.id.cardviewmore);
        cardviewmorer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view)
            {
                Intent intent=new Intent(HomeActivity.this, getmore.class);
                startActivity(intent);

            }
        });
        GETTY=(TextView) findViewById(R.id.getty);
        GETTY.setPaintFlags(GETTY.getPaintFlags() | Paint.UNDERLINE_TEXT_FLAG);


    }
}