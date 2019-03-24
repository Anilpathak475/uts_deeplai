package com.example.androidexamp.example.activity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.example.androidexamp.example.R;
import com.example.androidexamp.example.utils.Constants;

import java.util.Arrays;
import java.util.List;

import androidx.appcompat.app.AppCompatActivity;

public class FareActivity extends AppCompatActivity {

    List<String> stations = null;
    List<String> ticketTypeList = null;
    List<String> ticketClassList = null;
    String fromStn, toStn;
    TextView fromTOStn;
    int totalFare;
    EditText adultPassengers, childPassengers;
    Spinner ticketType, ticketClass;
    Button submit;
    Constants.TicketType ticketTypeVal;
    Constants.TicketClass ticketClassVal;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fare);
        /*Get Intent Extras*/
        Bundle _extras = getIntent().getExtras();
        fromStn = _extras.getString("$FROM_STATION");
        toStn = _extras.getString("$TO_STATION");
        /*End*/

        stations = Arrays.asList(getResources().getStringArray(R.array.stations));
        ticketTypeList = Arrays.asList(getResources().getStringArray(R.array.ticket_type));
        ticketClassList = Arrays.asList(getResources().getStringArray(R.array.ticket_class));

        fromTOStn = findViewById(R.id.frm_to_to_stn);
        fromTOStn.setText(fromStn + " --------> " + toStn);

        adultPassengers = findViewById(R.id.adult_passengers);
        childPassengers = findViewById(R.id.child_passengers);
        ticketType = findViewById(R.id.ticket_type);
        ticketType.setSelection(0, false);
        ticketType.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                if (i != 0)
                    ticketTypeVal = Enum.valueOf(Constants.TicketType.class, ticketTypeList.get(i));
                else
                    Toast.makeText(getApplicationContext(), "Please select valid ticket type", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        ticketClass = findViewById(R.id.ticket_class);
        ticketClass.setSelection(0, false);
        ticketClass.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                if (i != 0)
                    ticketClassVal = Enum.valueOf(Constants.TicketClass.class, ticketClassList.get(i));
                else
                    Toast.makeText(getApplicationContext(), "Please select valid ticket class", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        submit = findViewById(R.id.submit_journey);
        submit.setOnClickListener(view -> {
            if (adultPassengers.getText().toString()!=null
                    && childPassengers.getText().toString()!=null
                    && ticketTypeVal!=null
                    && ticketClassVal!=null){
                int fare = calculateTicketFare();
                Toast.makeText(getApplicationContext(), "Total Fare Price" + fare, Toast.LENGTH_SHORT).show();
            }
        });
    }

    private int calculateTicketFare() {
        int totalFare = 0;
        int stnMultiplier = 0;
        int totalStations = Math.abs(stations.indexOf(toStn) - stations.indexOf(fromStn));

        if (totalStations >= 2) {
            stnMultiplier = Constants.TICKET_FARE_SINGLE;
        }
        if (totalStations >= 4) {
            stnMultiplier = Constants.TICKET_FARE_MULTIPLE;
        }
        if (totalStations >= 6) {
            stnMultiplier = Constants.TICKET_FARE_MAX;
        }

        int adultPassengerCount = Integer.valueOf(adultPassengers.getText().toString());


        int childPassengerCount = Integer.valueOf(childPassengers.getText().toString());
        if (ticketClassVal == Constants.TicketClass.First) {
            totalFare += (adultPassengerCount+childPassengerCount )*  (stnMultiplier*10);
        } else {
            totalFare += (adultPassengerCount+childPassengerCount )*  stnMultiplier;
        }

        if (ticketTypeVal == Constants.TicketType.Return) {
            totalFare = totalFare*2;
        }

        return totalFare;

    }
}
