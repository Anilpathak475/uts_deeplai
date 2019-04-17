package com.example.androidexamp.example.activity;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.example.androidexamp.example.BaseActivity;
import com.example.androidexamp.example.R;
import com.example.androidexamp.example.room.DatabaseCallback;
import com.example.androidexamp.example.room.LocalCacheManager;
import com.example.androidexamp.example.room.User;
import com.example.androidexamp.example.utils.SharedPreferenceManager;
import com.marlonmafra.android.widget.EditTextPassword;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;
import java.util.Locale;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class Register extends BaseActivity implements DatabaseCallback {
    @BindView(R.id.edtPhoneNumber)
    EditText edtPhoneNumber;
    @BindView(R.id.edtName)
    EditText edtName;
    final Calendar myCalendar = Calendar.getInstance();
    @BindView(R.id.edtEmail)
    EditText edtEmail;
    @BindView(R.id.rd_gender)
    RadioGroup rdGender;
    @BindView(R.id.edt_new_password)
    EditTextPassword edtRegisterPassword;
    @BindView(R.id.edt_confirm_password)
    EditTextPassword edtRegisterConfirmPassword;
    @BindView(R.id.txtDob)
    TextView edtBirthday;
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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registeration);
        ButterKnife.bind(this);
        sharedPreferenceManager = SharedPreferenceManager.getInstance(this);
    }

    @OnClick(R.id.txtDob)
    void onBithdayClick() {
        new DatePickerDialog(Register.this, date, myCalendar.get(Calendar.YEAR), myCalendar.get(Calendar.MONTH), myCalendar.get(Calendar.DAY_OF_MONTH)).show();
    }

    @OnClick(R.id.btnRegisterDone)
    void onRegister() {
        if (validate()) {
            User user = new User();
            user.setName(edtName.getText().toString());
            user.setPhoneNumber(edtPhoneNumber.getText().toString());
            int selectedId = rdGender.getCheckedRadioButtonId();
            RadioButton selected = (RadioButton) findViewById(selectedId);
            user.setGender(selected.getText().toString());
            user.setDob(edtBirthday.getText().toString());
            user.setEmail(edtEmail.getText().toString());
            user.setPassword(edtRegisterConfirmPassword.getText().toString());
            uiUtils.showProgressDialog();
            LocalCacheManager.getInstance(this).addUser(this, user);

        }
    }

    private boolean validate() {
        if (TextUtils.isEmpty(edtPhoneNumber.getText().toString())) {
            Toast.makeText(Register.this, "Please enter your phone number", Toast.LENGTH_SHORT).show();
            return false;
        }
        if (TextUtils.isEmpty(edtName.getText().toString())) {
            Toast.makeText(Register.this, "Please enter your name", Toast.LENGTH_SHORT).show();
            return false;
        }
        if (TextUtils.isEmpty(edtBirthday.getText().toString())) {
            Toast.makeText(Register.this, "Please enter your dob", Toast.LENGTH_SHORT).show();
            return false;
        }
        if (TextUtils.isEmpty(edtRegisterPassword.getText().toString())) {
            Toast.makeText(Register.this, "Please enter password", Toast.LENGTH_SHORT).show();
            return false;
        }
        if (TextUtils.isEmpty(edtRegisterConfirmPassword.getText().toString())) {
            Toast.makeText(Register.this, "Please re-enter password", Toast.LENGTH_SHORT).show();
            return false;
        }
        if (!edtRegisterPassword.getText().toString().equalsIgnoreCase(edtRegisterConfirmPassword.getText().toString())) {
            Toast.makeText(Register.this, "Both password should match", Toast.LENGTH_SHORT).show();
            return false;
        }
        if (rdGender.getCheckedRadioButtonId() == -1) {
            Toast.makeText(Register.this, "Both password should match", Toast.LENGTH_SHORT).show();
            return false;

        }
        return true;
    }

    @Override
    public void onUserAdded() {
        uiUtils.dismissDialog();
        Intent intent = new Intent(Register.this, Login.class);
        startActivity(intent);
    }

    @Override
    public void onLogin() {

    }

    @Override
    public void onFailed() {

    }

}