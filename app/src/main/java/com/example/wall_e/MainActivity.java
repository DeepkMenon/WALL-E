package com.example.wall_e;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    int selectedValue = 0; // Initialize it with a default value
    // Initialize MediaPlayer
    MediaPlayer mediaPlayer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        ImageView set = findViewById(R.id.imageView3);

        ImageButton imageButton = findViewById(R.id.go);

//        upload.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//
//                // Initialize MediaPlayer and play the audio file
//                mediaPlayer = MediaPlayer.create(getApplicationContext(), R.raw.select); // Replace with your MP3 file name
//                mediaPlayer.start();
//
//                imageButton.setImageResource(R.drawable.icon1);
//                if (imageButton.getVisibility() != View.VISIBLE) {
//                    // If it's not visible, make it visible
//                    imageButton.setVisibility(View.VISIBLE);
//
//                }
//                imageButton.setClickable(true);
//
//                selectedValue = 1;
//            }
//        });

        set.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                // Initialize MediaPlayer and play the audio file
                mediaPlayer = MediaPlayer.create(getApplicationContext(), R.raw.select); // Replace with your MP3 file name
                mediaPlayer.start();


                imageButton.setImageResource(R.drawable.icon2);
                if (imageButton.getVisibility() != View.VISIBLE) {
                    // If it's not visible, make it visible
                    imageButton.setVisibility(View.VISIBLE);
                }
                imageButton.setClickable(true);
                selectedValue = 2;
            }
        });
//
//        surprise.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//
//                // Initialize MediaPlayer and play the audio file
//                mediaPlayer = MediaPlayer.create(getApplicationContext(), R.raw.select); // Replace with your MP3 file name
//                mediaPlayer.start();
//
//                imageButton.setImageResource(R.drawable.icon3);
//                if (imageButton.getVisibility() != View.VISIBLE) {
//                    // If it's not visible, make it visible
//                    imageButton.setVisibility(View.VISIBLE);
//                }
//                imageButton.setClickable(true);
//                selectedValue = 3;
//            }
//        });

        imageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                // Open MainActivity2 upon ImageButton click
                Intent intent = new Intent(MainActivity.this, MainActivity2.class);
                startActivity(intent);
            }
        });
    }
}