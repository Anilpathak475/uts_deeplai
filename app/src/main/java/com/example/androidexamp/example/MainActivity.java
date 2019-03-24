package com.example.androidexamp.example;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


import java.util.List;

import androidx.appcompat.app.AppCompatActivity;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import io.realm.Realm;

import static com.example.androidexamp.example.R.*;

public class MainActivity extends AppCompatActivity {
    Button btnRegister;
    Button btnShow;
    @BindView(R.id.edtEmail)
    EditText edtEmail;
    @BindView(R.id.edtPassword)
    EditText edtPassword;
    @BindView(id.btn_login)
    Button btnLogin;
    private Realm mRealm;
    private SharedPreferenceManager sharedPreferenceManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(layout.activity_main);
        mRealm = Realm.getInstance(this);
        mRealm.beginTransaction();
      /*  MyBook book = mRealm.createObject(MyBook.class);
        book.setTitle("Sample title");
        mRealm.commitTransaction();
        List<MyBook> bookList= mRealm.allObjects(MyBook.class);*/
        btnLogin=findViewById(id.btn_login);
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
                public void onClick(View v) {
                if (validate()) {
                    sharedPreferenceManager.saveValue(Constants.Email, edtEmail.getText().toString());
                    sharedPreferenceManager.saveValue(Constants.Password, edtPassword.getText().toString());
                    Toast.makeText(MainActivity.this, "Login", Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(MainActivity.this, Main2Activity.class);
                    startActivity(intent);
                }
            }

            private boolean validate() {
                if (TextUtils.isEmpty(edtEmail.getText().toString())) {
                    Toast.makeText(MainActivity.this, "Please enter your email address", Toast.LENGTH_SHORT).show();
                return false;
                }
                if (TextUtils.isEmpty(edtPassword.getText().toString())) {
                    Toast.makeText(MainActivity.this, "Please enter your password", Toast.LENGTH_SHORT).show();
                    return false;
                }
                return true;
            }
        });
        btnRegister=findViewById(id.btn_register);
        btnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                btnRegister.setOnClickListener(this);
                Toast.makeText(MainActivity.this,"register",Toast.LENGTH_SHORT).show();
                Intent intent=new Intent(MainActivity.this,Main5Activity.class);
                startActivity(intent);
            }
        });
        btnShow=findViewById(id.btn_Show);
        btnShow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                btnShow.setOnClickListener(this);
                Toast.makeText(MainActivity.this,"booked",Toast.LENGTH_SHORT).show();
            }
        });
        ButterKnife.bind(this);
        sharedPreferenceManager=SharedPreferenceManager.getInstance(this);
    }

}
