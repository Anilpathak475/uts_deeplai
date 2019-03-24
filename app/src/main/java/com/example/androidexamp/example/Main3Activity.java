package com.example.androidexamp.example;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

public class Main3Activity extends AppCompatActivity {
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
                Intent intent= new Intent(Main3Activity.this,Main4Activity.class);
                startActivity(intent);
            }
        });
        cardQuickBooking=findViewById(R.id.card_quick_booking);
        cardQuickBooking.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(Main3Activity.this,Main4Activity.class);
                startActivity(intent);
            }
        });
        cardPlatFormTicket=findViewById(R.id.card_platform_ticket);
        cardPlatFormTicket.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(Main3Activity.this,Main4Activity.class);
                startActivity(intent);
            }
        });
        cardSeasonTicket=findViewById(R.id.card_season_ticket);
        cardSeasonTicket.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent= new Intent(Main3Activity.this,Main4Activity.class);
                startActivity(intent);
            }
        });
    }
}
