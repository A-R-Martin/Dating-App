package com.example.create_account;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.Switch;
import android.widget.Toast;

public class almostdone extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_almostdone);

        Button back = (Button) findViewById(R.id.button13);
        Button complete = (Button) findViewById(R.id.button14);
        Button tc = (Button) findViewById(R.id.button12);

        tc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(almostdone.this, "Lorem ipsum TC blah blah.", Toast.LENGTH_SHORT).show();
            }
        });

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(almostdone.this, uploadphoto.class));
            }
        });

        complete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Switch s = (Switch) findViewById(R.id.switch1);

                RadioButton agree = (RadioButton) findViewById(R.id.radioButton3);
                RadioButton disagree = (RadioButton) findViewById(R.id.radioButton4);

                boolean sw = s.isChecked();
                boolean ag = agree.isChecked();
                boolean dis = disagree.isChecked();

                if(sw && ag){
                    startActivity(new Intent(almostdone.this, MainActivity.class));
                }
                else{
                    Toast.makeText(almostdone.this, "Please agree to T's and C's and pass robot test.", Toast.LENGTH_SHORT).show();
                }


            }
        });
    }
}