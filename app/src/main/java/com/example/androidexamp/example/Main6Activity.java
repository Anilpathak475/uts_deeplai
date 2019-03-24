package com.example.androidexamp.example;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import butterknife.BindView;
import butterknife.ButterKnife;

public class Main6Activity extends AppCompatActivity {
    @BindView(R.id.edtBookPhoneNumber)
    EditText edtBookPhoneNumber;
    @BindView(R.id.edtBookingPassword)
    EditText edtBookingPassword;
    @BindView(R.id.card__already_register)
    CardView cardAlreadyRegister;
    CardView cardNewRegister;
private SharedPreferenceManager sharedPreferenceManager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main6);
        ButterKnife.bind(this);
        sharedPreferenceManager=SharedPreferenceManager.getInstance(this);
        cardAlreadyRegister=findViewById(R.id.card__already_register);
        cardAlreadyRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (validate()){
                    sharedPreferenceManager.saveValue(Constants.BookPhoneNumber,edtBookPhoneNumber.getText().toString());
                    sharedPreferenceManager.saveValue(Constants.BookinpPssword,edtBookingPassword.getText().toString());
                }

            }

            private boolean validate() {
                if (TextUtils.isEmpty(edtBookPhoneNumber.getText().toString())){
                    Toast.makeText(Main6Activity.this, "Please enter your Phone number", Toast.LENGTH_SHORT).show();
                    return false;
                }
                if (TextUtils.isEmpty(edtBookingPassword.getText().toString())){
                    Toast.makeText(Main6Activity.this, "Please enter password", Toast.LENGTH_SHORT).show();
                    return false;
                }
                return true;
            }
        });
        cardNewRegister=findViewById(R.id.card_new_register);
        cardNewRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
    }
}
