package com.example.flamingocookbook;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private EditText loginUser, loginPassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        loginUser = findViewById(R.id.username);
        loginPassword = findViewById(R.id.password);
    }

    public void login(View view) {
        //authenticate and login
        String name = loginUser.getText().toString();
        String password = loginPassword.getText().toString();

        if (name.equals("admin") && password.equals("admin")){
            
            startActivity(new Intent(this,HomeActivity.class));
        }
        else{
            Toast.makeText(this, "Invalid Username or Password", Toast.LENGTH_SHORT).show();
        }

    }
}
