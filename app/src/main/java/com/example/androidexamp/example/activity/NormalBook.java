package com.example.androidexamp.example.activity;

import android.content.Intent;
import android.os.Bundle;

import com.example.androidexamp.example.BaseActivity;
import com.example.androidexamp.example.R;
import com.example.androidexamp.example.utils.Constants;
import com.google.zxing.integration.android.IntentIntegrator;
import com.google.zxing.integration.android.IntentResult;

import androidx.cardview.widget.CardView;

public class NormalBook extends BaseActivity {
    CardView cardNormalBook;
    CardView cardQuickBooking;
    CardView cardPlatFormTicket;
    CardView cardSeasonTicket;
    CardView cardQrBookingTicket;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bookingtype);
        cardNormalBook = findViewById(R.id.card_normal_book);
        cardNormalBook.setOnClickListener(v -> {
            Intent intent = new Intent(NormalBook.this, Stations.class);
            startActivity(intent);
        });
        cardQuickBooking = findViewById(R.id.card_quick_booking);
        cardQuickBooking.setOnClickListener(v -> {
            Intent intent = new Intent(NormalBook.this, Stations.class);
            startActivity(intent);
        });
        cardPlatFormTicket = findViewById(R.id.card_platform_ticket);
        cardPlatFormTicket.setOnClickListener(v -> {
            Intent intent = new Intent(NormalBook.this, Stations.class);
            startActivity(intent);
        });
        cardSeasonTicket = findViewById(R.id.card_season_ticket);
        cardSeasonTicket.setOnClickListener(v -> {
            Intent intent = new Intent(NormalBook.this, Stations.class);
            startActivity(intent);
        });
        cardQrBookingTicket = findViewById(R.id.card_QR_booking);
        cardQrBookingTicket.setOnClickListener(v -> {

            new IntentIntegrator(this).setOrientationLocked(false).initiateScan();
        });
    }


    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        IntentResult result = IntentIntegrator.parseActivityResult(requestCode, resultCode, data);
        if (result != null) {
            if (result.getContents() == null) {
                uiUtils.shortToast("Cancelled");
            } else {
                scanResult(result.getContents());
            }
        }
    }

    private void scanResult(final String stationName) {
        Bundle bundle = new Bundle();
        uiUtils.shortToast(stationName);
        bundle.putString(Constants.FROM_STATION, stationName);
        Intent intent = new Intent(NormalBook.this, Stations.class);
        intent.putExtras(bundle);
        startActivity(intent);
    }
}
