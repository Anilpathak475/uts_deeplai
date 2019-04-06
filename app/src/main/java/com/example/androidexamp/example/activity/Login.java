package com.example.androidexamp.example.activity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.androidexamp.example.BaseActivity;
import com.example.androidexamp.example.R;
import com.example.androidexamp.example.room.DatabaseCallback;
import com.example.androidexamp.example.room.LocalCacheManager;
import com.example.androidexamp.example.utils.Constants;
import com.marlonmafra.android.widget.EditTextPassword;


import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

import static com.example.androidexamp.example.R.id;


public class Login extends BaseActivity implements DatabaseCallback {
    @BindView(R.id.edtEmail)
    EditText edtEmail;

    @BindView(R.id.edt_password)
    EditTextPassword edtPassword;

    @BindView(id.chkLogin)
    CheckBox chkLogin;

    @BindView(id.txtForgotPassword)
    TextView txtForgotPassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        ButterKnife.bind(this);
        if (Boolean.valueOf(sharedPreferenceManager.getValue(Constants.AutoLogin))) {
            if (!TextUtils.isEmpty(sharedPreferenceManager.getValue(Constants.Email))) {
                edtEmail.setText(sharedPreferenceManager.getValue(Constants.Email));
                edtPassword.setText(sharedPreferenceManager.getValue(Constants.Password));
                chkLogin.setChecked(true);
            }
        }
    }

    @OnClick(id.btn_register)
    void onRegister() {
        Intent intent = new Intent(Login.this, Register.class);
        startActivity(intent);
    }

    @OnClick(id.txtForgotPassword)
    void onForgotPassword() {
        Intent intent = new Intent(Login.this, Register.class);
        startActivity(intent);
    }

    @Override
    public void onUserAdded() {

    }

    @Override
    public void onLogin() {
        uiUtils.dismissDialog();
        sharedPreferenceManager.saveValue(Constants.AutoLogin, Boolean.toString(chkLogin.isChecked()));
        Toast.makeText(Login.this, "Login", Toast.LENGTH_SHORT).show();
        Intent intent = new Intent(Login.this, BookTicket.class);
        startActivity(intent);
    }

    @Override
    public void onFailed() {

    }

    @OnClick(id.btn_login)
    void onLoginClick() {

        if (validate()) {
            uiUtils.showProgressDialog();
            LocalCacheManager.getInstance(this).login(this, edtEmail.getText().toString(), edtPassword.getText().toString());

        }
    }

    private boolean validate() {
        if (TextUtils.isEmpty(edtEmail.getText().toString())) {
            Toast.makeText(Login.this, "Please enter your email address", Toast.LENGTH_SHORT).show();
            return false;
        }
        if (TextUtils.isEmpty(edtPassword.getText().toString())) {
            Toast.makeText(Login.this, "Please enter your password", Toast.LENGTH_SHORT).show();
            return false;
        }
        return true;
    }

}
