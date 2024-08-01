package com.example.create_account;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.io.FileOutputStream;

public class signup extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);

        Button back = (Button) findViewById(R.id.button3);
        Button next = (Button) findViewById(R.id.button4);

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(signup.this, MainActivity.class));
            }
        });

        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                TextView email = (TextView) findViewById(R.id.editTextTextPersonName11);
                String in_email = email.getText().toString();

                TextView password = (TextView) findViewById(R.id.editTextTextPersonName12);
                String in_pass = password.getText().toString();

                TextView redo = (TextView) findViewById(R.id.editTextTextPersonName13);
                String in_redo = redo.getText().toString();

                if(in_email.length()==0){
                    Toast.makeText(signup.this, "Ensure you have entered an email.", Toast.LENGTH_SHORT).show();
                }
                else{
                    if(in_pass.equals(in_redo)){
                        String filename = "output.txt";
                        String fileContents = in_email + "," + in_pass + "\n";
                        FileOutputStream fos; //allow a file to be opened for writing
                        try {
                            fos = openFileOutput(filename, Context.MODE_APPEND);
                            fos.write(fileContents.getBytes());
                            fos.close();
                        }
                        catch (Exception e) {
                            e.printStackTrace();
                        }
                        startActivity(new Intent(signup.this, moreaboutyou.class));
                    }
                    else{
                        Toast.makeText(signup.this, "Passwords do not match.", Toast.LENGTH_SHORT).show();
                    }
                }


            }
        });


    }
}