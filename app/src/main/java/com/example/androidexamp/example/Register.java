package com.example.androidexamp.example;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Toast;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import butterknife.BindView;

public class Register extends AppCompatActivity {
    EditText edtBirthday;
    @BindView(R.id.edtPhoneNumber)
    EditText edtPhoneNumber;
    @BindView(R.id.edtName)
    EditText edtName;
    @BindView(R.id.edtRegisterPassword)
    EditText edtRegisterPassword;
    @BindView(R.id.edtRegisterConfirmPassword)
    EditText edtRegisterConfirmPassword;
    @BindView(R.id.edt_birthday)
    EditText edt_birthday;
    @BindView(R.id.card_get_otp)
    CardView cardGetOtp;
    private SharedPreferenceManager sharedPreferenceManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main5);
        sharedPreferenceManager = SharedPreferenceManager.getInstance(this);

        final Calendar myCalendar = Calendar.getInstance();
        edtBirthday = findViewById(R.id.edt_birthday);
        DatePickerDialog.OnDateSetListener date = new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker datePicker, int year, int monthOfYear, int dayOfMonth) {
                myCalendar.set(Calendar.YEAR, year);
                myCalendar.set(Calendar.MONTH, monthOfYear);
                myCalendar.set(Calendar.DAY_OF_MONTH, dayOfMonth);
                updateLabel();
            }

            private void updateLabel() {
                String myFormat = "dd - MM - YYYY";
                SimpleDateFormat sdf = new SimpleDateFormat(myFormat, Locale.US);
                edtBirthday.setText(sdf.format(myCalendar.getTime()));
            }
        };

        edtBirthday.setOnClickListener(view -> new DatePickerDialog(Register.this, date, myCalendar.get(Calendar.YEAR), myCalendar.get(Calendar.MONTH), myCalendar.get(Calendar.DAY_OF_MONTH)).show());
        cardGetOtp = findViewById(R.id.card_get_otp);
        cardGetOtp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (validate()) {
                    sharedPreferenceManager.saveValue(Constants.Phone, edtPhoneNumber.getText().toString());
                    sharedPreferenceManager.saveValue(Constants.Name, edtName.getText().toString());
                    sharedPreferenceManager.saveValue(Constants.Birthday, edt_birthday.getText().toString());
                    sharedPreferenceManager.saveValue(Constants.RegisterPassword, edtRegisterPassword.getText().toString());
                    sharedPreferenceManager.saveValue(Constants.RegisterConfirmPassword, edtRegisterConfirmPassword.getText().toString());
                    Intent intent = new Intent(Register.this, BookTicket.class);
                    startActivity(intent);
                }
            }

            private boolean validate() {
                if (TextUtils.isEmpty(edtPhoneNumber.getText().toString())) {
                    Toast.makeText(Register.this, "Please enter your phone number", Toast.LENGTH_SHORT).show();
                }
                if (TextUtils.isEmpty(edtName.getText().toString())) {
                    Toast.makeText(Register.this, "Please enter your name", Toast.LENGTH_SHORT).show();
                    return false;
                }
                if (TextUtils.isEmpty(edt_birthday.getText().toString())) {
                    Toast.makeText(Register.this, "Please enter your name", Toast.LENGTH_SHORT).show();
                }
                if (TextUtils.isEmpty(edtRegisterPassword.getText().toString())) {
                    Toast.makeText(Register.this, "Please enter password", Toast.LENGTH_SHORT).show();
                }
                if (TextUtils.isEmpty(edtRegisterConfirmPassword.getText().toString())) {
                    Toast.makeText(Register.this, "Please re-enter password", Toast.LENGTH_SHORT).show();
                }
                return true;
            }
        });
    }
}