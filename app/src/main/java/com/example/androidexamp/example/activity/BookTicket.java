package com.example.androidexamp.example.activity;

import android.content.Intent;
import android.os.Bundle;

import com.example.androidexamp.example.BaseActivity;
import com.example.androidexamp.example.R;

import androidx.cardview.widget.CardView;

public class BookTicket extends BaseActivity {
    CardView cardBookTicket;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_booking);
        cardBookTicket = findViewById(R.id.card_book_ticket);
        cardBookTicket.setOnClickListener(v -> {
            Intent intent = new Intent(BookTicket.this, NormalBook.class);
            startActivity(intent);
        });
    }
}
