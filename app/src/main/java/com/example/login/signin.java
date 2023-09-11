package com.example.login;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import javax.security.auth.login.LoginException;

public class signin extends AppCompatActivity {

    EditText et_username,et_password;
    Button btn_signin,btn_signup;
    Context context;
    String username;
    String password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signin);
        context = signin.this;
        initViews();

        btn_signin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                    Log.e("Atharva", "onClick: ");
                    login();
                }
        });

        btn_signup.setOnClickListener(v -> {
            Intent intent = new Intent(context, signup.class);
            startActivity(intent);
//                finish();
        });

    }

    private void initViews() {
        btn_signup = findViewById(R.id.btn_signup);
        btn_signin = findViewById(R.id.btn_signin);
        et_username = findViewById(R.id.et_username);
        et_password = findViewById(R.id.et_password);
    }

    private void login() {
        if(validation()){
            if(username.equals("abc") && password.equals("123")){
                Toast.makeText(context, "Success", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(context, MainActivity.class);
                startActivity(intent);
                finish();
            }else {
                Toast.makeText(context, "Failed Username Not Found!", Toast.LENGTH_SHORT).show();
            }
        }
    }

    private boolean validation() {
        username = et_username.getText().toString();
        password = et_password.getText().toString();

        if(username.isEmpty()){
            Toast.makeText(context, "Please enter Username!", Toast.LENGTH_SHORT).show();
//            et_username.setError("Please enter Username!");
            et_username.requestFocus();
            return false;
        }else if (password.isEmpty()){
            Toast.makeText(context, "Please enter Password!", Toast.LENGTH_SHORT).show();
            et_password.requestFocus();
            return false;
        }
        return true;
    }

}