package com.example.androidexamp.example;

import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

public class Main7Activity extends AppCompatActivity {
    CardView cardSourceStation;
    CardView cardDestinationStation;
    CardView cardDone;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main7);
        cardSourceStation=findViewById(R.id.card_source_station);
        cardSourceStation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
        cardDestinationStation=findViewById(R.id.card_destination_station);
        cardDestinationStation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
        cardDone=findViewById(R.id.card_done);
        cardDone.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
    }
}
