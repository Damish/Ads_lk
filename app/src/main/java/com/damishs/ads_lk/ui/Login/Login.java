package com.damishs.ads_lk.ui.Login;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.damishs.ads_lk.R;

public class Login extends AppCompatActivity {
    private EditText  s_email, s_password;
    private TextView txt_create_acc;
    private String email, pwd;
    Button btn_login;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        
        setContentView(R.layout.activity_login);

        s_email = findViewById(R.id.txtEmail2);
        s_password = findViewById(R.id.txtPwd2);

        btn_login = findViewById(R.id.btnLogin);
        txt_create_acc = findViewById(R.id.txtLogin3);

        txt_create_acc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intToHome = new Intent(Login.this, signup.class);
                    startActivity(intToHome);
                    finish();
            }
        });
        btn_login.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {

                login();

            }
        });
    }
    public void login(){
        initialize();
        if(!validate()){
            Toast.makeText(this, "Login Failed!", Toast.LENGTH_LONG).show();
        }
        else {
            Toast.makeText(this, "Login Successful!", Toast.LENGTH_LONG).show();
        }
    }

    public boolean validate(){
        boolean valid = true;

        if (email.isEmpty() || !Patterns.EMAIL_ADDRESS.matcher(email).matches() ){
            s_email.setError("Please Enter a valid Email Address.");
            valid = false;
        }
        else if (pwd.isEmpty()){
            s_password.setError("Password field cannot be empty.");
            valid = false;
        }
            return valid;


    }

    public void initialize(){

        email =  s_email.getText().toString().trim();
        pwd =  s_password.getText().toString().trim();

    }

//     if(validate()){
//
//        Intent intToHome = new Intent(Login.this, signup.class);
//        startActivity(intToHome);
//        finish();
//    }


}
