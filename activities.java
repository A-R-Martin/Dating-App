package com.example.create_account;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class activities extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_activities);

        Button next = (Button) findViewById(R.id.button8);
        Button back = (Button) findViewById(R.id.button7);

        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                TextView tv = (TextView) findViewById(R.id.editTextTextPersonName3);
                TextView tv1 = (TextView) findViewById(R.id.editTextTextPersonName4);
                TextView tv2= (TextView) findViewById(R.id.editTextTextPersonName5);
                TextView tv3 = (TextView) findViewById(R.id.editTextTextPersonName6);
                TextView tv4 = (TextView) findViewById(R.id.editTextTextPersonName7);
                TextView tv5 = (TextView) findViewById(R.id.editTextTextPersonName8);

                String tv_in = tv.getText().toString();
                String tv_in1 = tv1.getText().toString();
                String tv_in2= tv2.getText().toString();
                String tv_in3 = tv3.getText().toString();
                String tv_in4 = tv4.getText().toString();
                String tv_in5 = tv5.getText().toString();

                if(tv_in.length()!=0&&tv_in1.length()!=0&&tv_in2.length()!=0&&tv_in3.length()!=0&&tv_in4.length()!=0&&tv_in5.length()!=0){
                    Toast.makeText(activities.this, "Ensure all fields are filled.", Toast.LENGTH_SHORT).show();
                }
                else{
                    startActivity(new Intent(activities.this, uploadphoto.class));
                }

            }
        });

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(activities.this, moreaboutyou.class));
            }
        });
    }
}