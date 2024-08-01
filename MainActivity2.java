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

public class MainActivity2 extends AppCompatActivity {
    Button buttonnext2;
    Button buttonback2;
    Button buttontakephoto2;
    ImageView photo2;
    Button buttonprompt2;
    int SELECT_PICTURE = 200;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        buttonnext2 = (Button) findViewById(R.id.buttonnext2);
        buttonback2 = (Button) findViewById(R.id.buttonback2);
        buttontakephoto2 = findViewById(R.id.buttontakephoto2);
        photo2 = findViewById(R.id.image2);
        buttonprompt2 = (Button) findViewById(R.id.buttonprompt2);
        buttonprompt2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity2.this, "Smile while looking to the right and take a picture with your face",
                        Toast.LENGTH_LONG).show();
            }
        });
        buttontakephoto2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                imageChooser();
            }
        });

        buttonback2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openMainActivity();}


        });
        buttonnext2.setOnClickListener(new View.OnClickListener() {

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
                    photo2.setImageURI(selectedImageUri);
                }
            }
        }
    }
    public void openMainActivity(){
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }


    public void openMainActivity2() {
        Intent intent = new Intent(this, MainActivity3.class);
        startActivity(intent);
    }

}
