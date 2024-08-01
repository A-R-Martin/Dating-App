package com.example.create_account;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

public class moreaboutyou extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_moreaboutyou);

        Button back = (Button) findViewById(R.id.button5);
        Button next = (Button) findViewById(R.id.button6);

        String[] arraySpinner = new String[] {
                "Rutland", "Glenmore", "Downtown", "Lower Mission", "Pandosy", "SE Kelowna", "University District"
        };
        Spinner s = (Spinner) findViewById(R.id.spinner2);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_spinner_item, arraySpinner);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        s.setAdapter(adapter);

        String[] arraySpinner2 = new String[] {
                "Male", "Female", "Both", "Other"
        };
        Spinner s2 = (Spinner) findViewById(R.id.spinner);
        ArrayAdapter<String> adapter2 = new ArrayAdapter<String>(this,
                android.R.layout.simple_spinner_item, arraySpinner2);
        adapter2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        s2.setAdapter(adapter2);

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(moreaboutyou.this, signup.class));
            }
        });

        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(moreaboutyou.this, activities.class));

                TextView name = (TextView) findViewById(R.id.editTextTextPersonName3);
                String in_name = name.getText().toString();

                RadioButton male = (RadioButton) findViewById(R.id.radioButton);
                RadioButton female = (RadioButton) findViewById(R.id.radioButton2);

                TextView dob = (TextView) findViewById(R.id.editTextDate2);
                String in_dob = dob.getText().toString();

                boolean test = false;

                if(in_dob.charAt(2)=='/'&&in_dob.charAt(5)=='/'&&in_dob.length()==10){

                }
                else{
                    Toast.makeText(moreaboutyou.this, "Enter date correctly.", Toast.LENGTH_SHORT).show();
                    test=true;
                }

                boolean in_male = male.isChecked();
                boolean in_female = female.isChecked();

                if(in_male==false && in_female==false){
                    Toast.makeText(moreaboutyou.this, "Enter a gender.", Toast.LENGTH_SHORT).show();
                    test=true;
                }

                if(in_name.length()==0){
                    Toast.makeText(moreaboutyou.this, "Enter a name.", Toast.LENGTH_SHORT).show();
                    test=true;
                }

                if(test==false){
                    startActivity(new Intent(moreaboutyou.this, activities.class));
                }
            }
        });

    }
}