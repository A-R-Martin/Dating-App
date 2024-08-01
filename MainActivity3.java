package com.example.finalproject;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

public class MainActivity3 extends AppCompatActivity {

    Button buttonnext3;
    Button buttonback3;
    Button buttontakephoto3;
    ImageView photo3;
    Button buttonprompt3;
    int SELECT_PICTURE = 200;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);

        buttonnext3 = (Button) findViewById(R.id.buttonnext3);
        buttonback3 = (Button) findViewById(R.id.buttonback3);
        buttontakephoto3 = findViewById(R.id.buttontakephoto3);
        photo3 = findViewById(R.id.image3);
        buttonprompt3 = (Button) findViewById(R.id.buttonprompt3);
        buttonprompt3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity3.this, "lift your right arm in the air and take a picture with your face",
                        Toast.LENGTH_LONG).show();
            }
        });

        buttontakephoto3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                imageChooser();
            }
        });

        buttonback3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openMainActivity();}


        });
        buttonnext3.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                openMainActivity2();
            }

        });

    }
    void imageChooser() {


        Intent i = new Intent();
        i.setType("image/*");
        i.setAction(Intent.ACTION_GET_CONTENT);


        startActivityForResult(Intent.createChooser(i, "Select Picture"), SELECT_PICTURE);
    }
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (resultCode == RESULT_OK) {

            // compare the resultCode with the
            // SELECT_PICTURE constant
            if (requestCode == SELECT_PICTURE) {
                // Get the url of the image from data
                Uri selectedImageUri = data.getData();
                if (null != selectedImageUri) {
                    // update the preview image in the layout
                    photo3.setImageURI(selectedImageUri);
                }
            }
        }
    }
    public void openMainActivity(){
        Intent intent = new Intent(this, MainActivity2.class);
        startActivity(intent);
    }


    public void openMainActivity2() {
        Intent intent = new Intent(this, MainActivity4.class);
        startActivity(intent);
    }

}
