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
import com.damishs.ads_lk.ui.Login.Login;

public class signup extends AppCompatActivity {

    private EditText s_userName, s_email, s_password, s_cPassword;
    private String uname, email, pwd, cpwd;
    private TextView s_login,s_left_login;
    Button btn_signup,rmember,rseller;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);

        s_userName =  findViewById(R.id.txtUname);
        s_email = findViewById(R.id.txtEmail);
        s_password = findViewById(R.id.txtPwd);
        s_cPassword = findViewById(R.id.txtCPwd);
        btn_signup = findViewById(R.id.btnSignup);
        rmember = findViewById(R.id.rBtnMember);
        rseller = findViewById(R.id.rBtnSeller);
        s_left_login = findViewById(R.id.txtLeftLogin);
        s_login = findViewById(R.id.txtLogin);

        s_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intToHome = new Intent(signup.this, Login.class);
                startActivity(intToHome);
                finish();
            }
        });

        s_left_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intToHome = new Intent(signup.this, Login.class);
                startActivity(intToHome);
                finish();
            }
        });

        btn_signup.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                register();
            }
        });
    }
    public void register(){
        initialize();
        if(!validate()){
            Toast.makeText(this, "Sign up has Failed!", Toast.LENGTH_LONG).show();
        }
        if(validate()) {
            Toast.makeText(this, "Sign in Successful!", Toast.LENGTH_LONG).show();
//            Intent intToHome = new Intent(signup.this, Login.class);
//            startActivity(intToHome);
//            finish();
        }
    }

    public boolean validate(){
        boolean valid = true;
        if(uname.isEmpty() || uname.length() > 32) {
            s_userName.setError("Please Enter a valid name.");
            valid = false;
        }
        else if(uname.length() < 5 || uname.contains(" ")) {
            s_userName.setError("Use 5 letters or more without spaces.");
            valid = false;
        }
         else if (email.isEmpty() || !Patterns.EMAIL_ADDRESS.matcher(email).matches()){
            s_email.setError("Please Enter a valid Email Address.");
            valid = false;
        }
         else if (pwd.isEmpty()){
            s_password.setError("Password field cannot be empty.");
            valid = false;
        }
        else if (cpwd.isEmpty()){
            s_cPassword.setError("Confirm Password field cannot be empty.");
            valid = false;
        }
        else if (pwd.length() < 8 ){
            s_password.setError("Use 8 characters or more.");
        }
        else if (pwd.contains(" ") ){
            s_password.setError("Use 8 characters or more without spaces");
        }
        else if ( cpwd.length() < 8){
            s_cPassword.setError("Use 8 characters or more.");
            valid = false;
        }
        else if ( cpwd.contains(" ")){
            s_cPassword.setError("Use 8 characters or more without spaces");
            valid = false;
        }
        else if (!(pwd.equals(cpwd)) ){
            Toast.makeText(this, "Passwords do not match!", Toast.LENGTH_LONG).show();
        }

        return valid;
    }
    public void initialize(){
        uname =  s_userName.getText().toString().trim();
        email =  s_email.getText().toString().trim();
        pwd =  s_password.getText().toString().trim();
        cpwd =  s_cPassword.getText().toString().trim();
    }
}
