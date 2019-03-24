package com.example.androidexamp.example.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Toast;

import com.example.androidexamp.example.R;
import com.example.androidexamp.example.utils.Constants;

import java.util.Arrays;
import java.util.List;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;
import androidx.appcompat.widget.AppCompatSpinner;
import androidx.cardview.widget.CardView;

public class Stations extends AppCompatActivity {

    List<String> stations = null;
    CardView cardSourceStation;
    CardView cardDestinationStation;
    AppCompatSpinner spFromStn;
    AppCompatSpinner spToStn;
    CardView cardDone;
    String fromStn, toStn;
    AppCompatButton submit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_station);
        /*cardSourceStation=findViewById(R.id.card_source_station);
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
        });*/

        stations = Arrays.asList(getResources().getStringArray(R.array.stations));
        spFromStn = findViewById(R.id.sp_from_stn);
        spFromStn.setSelection(0, false);
        spFromStn.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                if (i != 0)
                    fromStn = stations.get(i);
                else
                    Toast.makeText(getApplicationContext(), "Plese select Valid starting point", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
        spToStn = findViewById(R.id.sp_to_stn);
        spToStn.setSelection(0, false);
        spToStn.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                if (i != 0)
                    if (stations.indexOf(fromStn) != stations.indexOf(stations.get(i)))
                        toStn = stations.get(i);
                    else
                        Toast.makeText(getApplicationContext(), "Journey start and end cannot be same", Toast.LENGTH_SHORT).show();
                else
                    Toast.makeText(getApplicationContext(), "Plese select Valid starting point", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {
            }
        });

        submit = findViewById(R.id.btn_submit_journey);
        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent fareActivity = new Intent(Stations.this, FareActivity.class);
                Bundle data = new Bundle();
                data.putString(Constants.FROM_STATION, fromStn);
                data.putString(Constants.TO_STATION, toStn);
                fareActivity.putExtras(data);
                startActivity(fareActivity);
            }
        });

    }
}
