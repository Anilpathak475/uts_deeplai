package com.example.androidexamp.example;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.marlonmafra.android.widget.EditTextPassword;

import androidx.appcompat.app.AppCompatActivity;
import butterknife.BindView;
import butterknife.ButterKnife;
import io.realm.Realm;

import static com.example.androidexamp.example.R.id;
import static com.example.androidexamp.example.R.layout;

public class Login extends AppCompatActivity {
    Button btnRegister;
    Button btnShow;
    @BindView(R.id.edtEmail)
    EditText edtEmail;
    @BindView(R.id.edt_password)
    EditTextPassword edtPassword;
    @BindView(id.btn_login)
    Button btnLogin;
    private Realm mRealm;
    private SharedPreferenceManager sharedPreferenceManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(layout.activity_main);
        ButterKnife.bind(this);
        mRealm = Realm.getInstance(this);
        mRealm.beginTransaction();
       /* MyBook book = mRealm.createObject(MyBook.class);
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
                    Toast.makeText(Login.this, "Login", Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(Login.this, BookTicket.class);
                    startActivity(intent);
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
        });

       /* BackgroundMail backgroundMail = new BackgroundMail(this);
        backgroundMail.setGmailUserName("Anil@theprocedure.in");
        backgroundMail.setGmailPassword("Cullean*1");
        backgroundMail.setFormSubject("rvwdsayntre");
        backgroundMail.setMailTo("Anil@theprocedure.in");
        backgroundMail.send();*/
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

}
