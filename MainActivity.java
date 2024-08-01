package com.example.finalproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity {
Button buttonnext;
Button buttontakephoto;
ImageView photo1;
Button buttonprompt;
    int SELECT_PICTURE = 200;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        buttontakephoto = findViewById(R.id.buttontakephoto);
        photo1 = findViewById(R.id.image1);
        buttonnext = (Button) findViewById(R.id.buttonnext);
        buttonprompt = (Button)findViewById(R.id.buttonprompt);
        buttonprompt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, "Put up 4 fingers and take a picture with your face",
                        Toast.LENGTH_LONG).show();
            }
        });

        buttontakephoto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                imageChooser();
            }
        });

        buttonnext.setOnClickListener(new View.OnClickListener() {

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
                    photo1.setImageURI(selectedImageUri);
                }
            }
        }
    }
public void openMainActivity2() {
    Intent intent = new Intent(this, MainActivity2.class);
    startActivity(intent);
        }




                                           }




