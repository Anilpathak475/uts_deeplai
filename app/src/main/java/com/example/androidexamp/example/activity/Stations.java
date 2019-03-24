package com.example.androidexamp.example.activity;

import android.os.Bundle;

import com.example.androidexamp.example.R;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

public class Stations extends AppCompatActivity {
    CardView cardSourceStation;
    CardView cardDestinationStation;
    CardView cardDone;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_station);
        cardSourceStation=findViewById(R.id.card_source_station);
        cardSourceStation.setOnClickListener(view -> {

        });
        cardDestinationStation=findViewById(R.id.card_destination_station);
        cardDestinationStation.setOnClickListener(view -> {

        });
        cardDone=findViewById(R.id.card_done);
        cardDone.setOnClickListener(view -> {

        });
    }
}
