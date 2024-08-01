package com.example.create_account;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class login extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        Button back = (Button) findViewById(R.id.button11);
        Button next = (Button) findViewById(R.id.button10);
        Button forgot = (Button) findViewById(R.id.button9);

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(login.this, MainActivity.class));
            }
        });

        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                TextView password = (TextView) findViewById(R.id.editTextTextPersonName10);
                String in_pass = password.getText().toString();

                TextView email = (TextView) findViewById(R.id.editTextTextPersonName9);
                String in_email = email.getText().toString();

                if(in_email.length()!=0 && in_pass.length()!=0){
                    try{
                        FileInputStream fis = openFileInput("output.txt");
                        InputStreamReader isr = new InputStreamReader(fis);
                        BufferedReader br = new BufferedReader(isr);

                        boolean hasPass = false;

                        String line = "";

                        while((line = br.readLine()) != null){
                            String[] parts = line.split(",");

                            String emailtest = parts[0];
                            String passtest = parts[1];

                            if(in_email.equals(emailtest) && in_pass.equals(passtest)){
                                startActivity(new Intent(login.this, MainActivity.class));
                            }
                            else{
                                Toast.makeText(login.this, "Incorrect password.", Toast.LENGTH_SHORT).show();
                            }

                        }
                    }
                    catch(IOException e){
                        Toast.makeText(login.this, "No data in file.", Toast.LENGTH_SHORT).show();
                    }
                }
                else{
                    Toast.makeText(login.this, "Enter email and password.", Toast.LENGTH_SHORT).show();
                }
            }
        });

        forgot.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                TextView email = (TextView) findViewById(R.id.editTextTextPersonName9);
                String in_email = email.getText().toString();

                if(in_email.length()==0){
                    Toast.makeText(login.this, "Enter a valid email.", Toast.LENGTH_SHORT).show();
                }
                else{
                    Toast.makeText(login.this, "We have sent an email to reset your password.", Toast.LENGTH_SHORT).show();
                }

            }
        });
    }
}