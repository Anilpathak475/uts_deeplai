package com.example.androidexamp.example;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

public class BookTicket extends AppCompatActivity {
    CardView cardBookTicket;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        cardBookTicket = findViewById(R.id.card_book_ticket);
        cardBookTicket.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(BookTicket.this, NormalBook.class);
                startActivity(intent);
                }
        });
    }
}
