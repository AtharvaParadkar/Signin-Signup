package com.example.login;

import static androidx.constraintlayout.motion.widget.TransitionBuilder.validate;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class signup extends AppCompatActivity {
    Button btn_signup, btn_signin;
    Context context;
    EditText et_firstname,et_lastname,et_emailid,et_mobileno,et_username,et_password;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        context = signup.this;
        setContentView(R.layout.activity_signup);
        btn_signin = findViewById(R.id.btn_signin);
        btn_signup = findViewById(R.id.btn_signup);
        et_firstname = findViewById(R.id.et_firstname);
        et_lastname = findViewById(R.id.et_lastname);
        et_emailid = findViewById(R.id.et_emailid);
        et_mobileno = findViewById(R.id.et_mobileno);
        et_username = findViewById(R.id.et_username);
        et_password = findViewById(R.id.et_password);

        btn_signin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, signin.class);
                startActivity(intent);
                finish();
            }
        });

        btn_signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                registration();
            }
        });
    }

    private void registration() {
        if(validate()){
            String firstname = et_firstname.getText().toString();
            String lastname = et_lastname.getText().toString();
            String emailid = et_emailid.getText().toString();
            String mobileno = et_mobileno.getText().toString();
            String username = et_username.getText().toString();
            String password = et_password.getText().toString();




            finish();
        }
    }

    private boolean validate() {

        if (et_firstname.getText().toString().isEmpty()) {
            et_firstname.setError(getResources().getString(R.string.enter_first_name));
            et_firstname.requestFocus();
            return false;
        } else if (et_lastname.getText().toString().isEmpty()) {
            et_lastname.setError(getResources().getString(R.string.enter_last_name));
            et_lastname.requestFocus();
            return false;
        } else if (et_emailid.getText().toString().isEmpty()) {
            et_emailid.setError(getResources().getString(R.string.enter_email_id));
            et_emailid.requestFocus();
            return false;
        } else if (et_mobileno.getText().toString().isEmpty()) {
            et_mobileno.setError(getResources().getString(R.string.enter_mobileno));
            et_mobileno.requestFocus();
            return false;
        } else if (et_username.getText().toString().isEmpty()) {
            et_username.setError(getResources().getString(R.string.username));
            et_username.requestFocus();
            return false;
        } else if (et_password.getText().toString().isEmpty()) {
            et_password.setError(getResources().getString(R.string.password));
            et_password.requestFocus();
            return false;
        }
        return true;
    }
}
