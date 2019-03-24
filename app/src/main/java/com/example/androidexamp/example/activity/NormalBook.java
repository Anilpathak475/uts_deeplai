package com.example.androidexamp.example.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.androidexamp.example.R;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

public class NormalBook extends AppCompatActivity {
    CardView cardNormalBook;
    CardView cardQuickBooking;
    CardView cardPlatFormTicket;
    CardView cardSeasonTicket;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);
        cardNormalBook=findViewById(R.id.card_normal_book);
        cardNormalBook.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(NormalBook.this, BookTravel.class);
                startActivity(intent);
            }
        });
        cardQuickBooking=findViewById(R.id.card_quick_booking);
        cardQuickBooking.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(NormalBook.this, BookTravel.class);
                startActivity(intent);
            }
        });
        cardPlatFormTicket=findViewById(R.id.card_platform_ticket);
        cardPlatFormTicket.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(NormalBook.this, BookTravel.class);
                startActivity(intent);
            }
        });
        cardSeasonTicket=findViewById(R.id.card_season_ticket);
        cardSeasonTicket.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(NormalBook.this, BookTravel.class);
                startActivity(intent);
            }
        });
    }
}
