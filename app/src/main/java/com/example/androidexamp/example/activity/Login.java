package com.example.androidexamp.example.activity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.androidexamp.example.BaseActivity;
import com.example.androidexamp.example.R;
import com.example.androidexamp.example.utils.Constants;
import com.example.androidexamp.example.utils.SharedPreferenceManager;
import com.marlonmafra.android.widget.EditTextPassword;

import butterknife.BindView;
import butterknife.ButterKnife;
import io.realm.Realm;

import static com.example.androidexamp.example.R.id;
import static com.example.androidexamp.example.R.layout;

public class Login extends BaseActivity {
    Button btnRegister;
    Button btnShow;
    @BindView(R.id.edtEmail)
    EditText edtEmail;
    @BindView(R.id.edt_password)
    EditTextPassword edtPassword;
    @BindView(id.btn_login)
    Button btnLogin;
    private Realm mRealm;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(layout.activity_login);
        ButterKnife.bind(this);
        mRealm = Realm.getInstance(this);
        mRealm.beginTransaction();
       /* MyBook book = mRealm.createObject(MyBook.class);
        book.setTitle("Sample title");
        mRealm.commitTransaction();
        List<MyBook> bookList= mRealm.allObjects(MyBook.class);*/
        btnLogin=findViewById(id.btn_login);

        btnLogin.setOnClickListener(v -> {
            if (validate()) {
                sharedPreferenceManager.saveValue(Constants.Email, edtEmail.getText().toString());
                sharedPreferenceManager.saveValue(Constants.Password, edtPassword.getText().toString());
                Toast.makeText(Login.this, "Login", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(Login.this, BookTicket.class);
                startActivity(intent);
            }
        });

        btnRegister=findViewById(id.btn_register);
        btnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                btnRegister.setOnClickListener(this);
                Toast.makeText(Login.this, "register", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(Login.this, Register.class);
                startActivity(intent);
            }
        });

        sharedPreferenceManager=SharedPreferenceManager.getInstance(this);
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

        if (!sharedPreferenceManager.getValue(Constants.Email).equalsIgnoreCase(edtEmail.getText().toString())) {
            Toast.makeText(Login.this, "Email or password is wrong", Toast.LENGTH_SHORT).show();
            return false;
        }
        if (!sharedPreferenceManager.getValue(Constants.Password).equalsIgnoreCase(edtPassword.getText().toString())) {
            Toast.makeText(Login.this, "Email or password is wrong", Toast.LENGTH_SHORT).show();
            return false;
        }
        return true;
    }

}
