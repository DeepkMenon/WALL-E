package com.example.wall_e;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MainActivity2 extends AppCompatActivity {


    private MediaPlayer mediaPlayer;
    private ArrayList<String> artStyles = new ArrayList<>(Arrays.asList(
            "art deco", "abstract", "grunge", "minimalist", "comic book",
            "watercolor", "pop art", "pixel art", "retro"));

    private ArrayList<String> finartStyles = new ArrayList<>(Arrays.asList(
            "art deco", "abstract", "grunge", "minimalist", "comic book",
            "watercolor", "pop art", "pixel art", "retro"));

    private ArrayList<String> palettes = new ArrayList<>(Arrays.asList(
            "warm", "autumn", "complimentary", "cool", "analogous", "muted",
            "vibrant", "mono chromatic", "nature inspired"));

    private ArrayList<String> finpalettes = new ArrayList<>(Arrays.asList(
            "warm", "autumn", "complimentary", "cool", "analogous", "muted",
            "vibrant", "mono chromatic", "nature inspired"));

    private ArrayList<String> moods = new ArrayList<>(Arrays.asList(
            "calm", "mysterious", "dreamy", "magical",
            "powerful", "creative", "humorous", "spooky", "happy"));

    private ArrayList<String> finmoods = new ArrayList<>(Arrays.asList(
            "calm", "mysterious", "dreamy", "magical",
            "powerful", "creative", "humorous", "spooky", "happy"));

    private ArrayList<String> textures = new ArrayList<>(Arrays.asList(
            "polished", "grainy", "fluid", "weathered", "geometric patterns",
            "sleek", "glazed", "fractals", "sparkling"));

    private ArrayList<String> fintextures = new ArrayList<>(Arrays.asList(
            "polished", "grainy", "fluid", "weathered", "geometric patterns",
            "sleek", "glazed", "fractals", "sparkling"));


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        ImageView imageView5 = findViewById(R.id.imageView5);
        ImageView imageView6 = findViewById(R.id.imageView6);
        ImageView imageView7 = findViewById(R.id.imageView7);
        ImageView imageView8 = findViewById(R.id.imageView8);
        ImageView imageView9 = findViewById(R.id.imageView9);
        ImageView imageView10 = findViewById(R.id.imageView10);
        ImageView imageView15 = findViewById(R.id.imageView15);
        ImageView imageView20 = findViewById(R.id.imageView20);
        ImageView imageView16 = findViewById(R.id.imageView16);
        ImageView imageView21 = findViewById(R.id.imageView21);
        ImageView imageView22 = findViewById(R.id.imageView22);
        ImageView imageView17 = findViewById(R.id.imageView17);
        ImageView imageView13 = findViewById(R.id.imageView13);
        ImageView imageView14 = findViewById(R.id.imageView14);

        ImageButton button = findViewById(R.id.imageButton2);

        TextView txtView = findViewById(R.id.textView);


        // Initialize ImageView elements ending from 23 to 31
        ImageView imageView23 = findViewById(R.id.imageView23);
        ImageView imageView24 = findViewById(R.id.imageView24);
        ImageView imageView25 = findViewById(R.id.imageView25);
        ImageView imageView26 = findViewById(R.id.imageView26);
        ImageView imageView27 = findViewById(R.id.imageView27);
        ImageView imageView28 = findViewById(R.id.imageView28);
        ImageView imageView29 = findViewById(R.id.imageView29);
        ImageView imageView30 = findViewById(R.id.imageView30);
        ImageView imageView31 = findViewById(R.id.imageView31);


        ImageView imageView32 = findViewById(R.id.imageView32);
        ImageView imageView33 = findViewById(R.id.imageView33);
        ImageView imageView34 = findViewById(R.id.imageView34);

        ImageView imageView35 = findViewById(R.id.imageView35);
        ImageView imageView36 = findViewById(R.id.imageView36);
        ImageView imageView37 = findViewById(R.id.imageView37);
        ImageView imageView38 = findViewById(R.id.imageView38);
        ImageView imageView39 = findViewById(R.id.imageView39);
        ImageView imageView40 = findViewById(R.id.imageView40);

        ImageView imageView41 = findViewById(R.id.imageView41);
        ImageView imageView42 = findViewById(R.id.imageView42);
        ImageView imageView43 = findViewById(R.id.imageView43);

        ImageView imageView44 = findViewById(R.id.imageView44);
        ImageView imageView45 = findViewById(R.id.imageView45);
        ImageView imageView46 = findViewById(R.id.imageView46);
        ImageView imageView47 = findViewById(R.id.imageView47);
        ImageView imageView48 = findViewById(R.id.imageView48);
        ImageView imageView49 = findViewById(R.id.imageView49);

        // Initialize EditText element
        EditText promptEditText = findViewById(R.id.prompt);

        ArrayList<ImageView> imageViews = new ArrayList<>(Arrays.asList(
                imageView10, imageView13, imageView14, imageView15, imageView16,
                imageView17, imageView20, imageView21, imageView22));

        ArrayList<ImageView> paletteImageViews = new ArrayList<>(Arrays.asList(
                imageView23, imageView24, imageView25, imageView26, imageView27,
                imageView28, imageView29, imageView30, imageView31));

        ArrayList<ImageView> moodImageViews = new ArrayList<>(Arrays.asList(
                imageView32, imageView33, imageView34, imageView35, imageView36,
                imageView37, imageView38, imageView39, imageView40));

        ArrayList<ImageView> textureImageViews = new ArrayList<>(Arrays.asList(
                imageView41, imageView42, imageView43, imageView44, imageView46,
                imageView47, imageView48, imageView49, imageView45));


        // Initially, set ImageButton as not visible
        button.setVisibility(View.INVISIBLE);
        button.setClickable(false);

        // Retrieve the promptText from the Intent
        String promptText = getIntent().getStringExtra("PROMPT_TEXT");

        // Set the promptText to the EditText
        if (promptText != null) {
            promptEditText.setText(promptText);
        }

        promptEditText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {

                // Check if EditText has text
                if (s.toString().trim().length() > 0) {
                    // If there is text, make ImageButton visible and clickable
                    button.setVisibility(View.VISIBLE);
                    button.setClickable(true);
                } else {
                    // If EditText is empty, hide ImageButton and disable clickability
                    button.setVisibility(View.INVISIBLE);
                    button.setClickable(false);
                }

            }
        });

        // Set onClickListeners for the ImageViews
        for (int i = 0; i < imageViews.size(); i++) {
            final int finalI = i;
            imageViews.get(i).setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {


                    // Toggle tint color to green when clicked
                    ImageView clickedImageView = imageViews.get(finalI);

                    if (clickedImageView.getColorFilter() != null) {
                        clickedImageView.setColorFilter(null); // Reset tint if already green
                        // Initialize MediaPlayer and play the audio file
                        mediaPlayer = MediaPlayer.create(getApplicationContext(), R.raw.offsound); // Replace with your MP3 file name
                        mediaPlayer.start();
                        removeArtStyle(artStyles, finalI); // Remove from the array
                    } else {
                        clickedImageView.setColorFilter(Color.GREEN); // Apply green tint
                        // Initialize MediaPlayer and play the audio file
                        mediaPlayer = MediaPlayer.create(getApplicationContext(), R.raw.stylesound); // Replace with your MP3 file name
                        mediaPlayer.start();
                        addArtStyle(artStyles, finalI); // Add to the array
                    }
                }
            });
        }



        for (int i = 0; i < paletteImageViews.size(); i++) {
            final int finalI = i;
            paletteImageViews.get(i).setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {


                    // Toggle tint color to green when clicked
                    ImageView clickedImageView = paletteImageViews.get(finalI);

                    if (clickedImageView.getColorFilter() != null) {
                        clickedImageView.setColorFilter(null); // Reset tint if already green
                        // Initialize MediaPlayer and play the audio file
                        mediaPlayer = MediaPlayer.create(getApplicationContext(), R.raw.offsound); // Replace with your MP3 file name
                        mediaPlayer.start();
                        removePalette(palettes, finalI); // Remove from the array
                    } else {
                        clickedImageView.setColorFilter(Color.GREEN); // Apply green tint
                        // Initialize MediaPlayer and play the audio file
                        mediaPlayer = MediaPlayer.create(getApplicationContext(), R.raw.stylesound); // Replace with your MP3 file name
                        mediaPlayer.start();
                        addPalette(palettes, finalI); // Add to the array
                    }
                }
            });
        }




        // Set onClickListeners for the ImageViews 32-40
        for (int i = 0; i < moodImageViews.size(); i++) {
            final int finalI = i;
            moodImageViews.get(i).setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {


                    // Toggle tint color to green when clicked
                    ImageView clickedImageView = moodImageViews.get(finalI);

                    if (clickedImageView.getColorFilter() != null) {
                        clickedImageView.setColorFilter(null); // Reset tint if already green
                        // Initialize MediaPlayer and play the audio file
                        mediaPlayer = MediaPlayer.create(getApplicationContext(), R.raw.offsound); // Replace with your MP3 file name
                        mediaPlayer.start();
                        removeMood(moods, finalI); // Remove from the moods array
                    } else {
                        clickedImageView.setColorFilter(Color.GREEN); // Apply green tint
                        // Initialize MediaPlayer and play the audio file
                        mediaPlayer = MediaPlayer.create(getApplicationContext(), R.raw.stylesound); // Replace with your MP3 file name
                        mediaPlayer.start();
                        addMood(moods, finalI); // Add to the moods array
                    }
                }
            });
        }


        // Set onClickListeners for the ImageViews 41-49
        for (int i = 0; i < textureImageViews.size(); i++) {
            final int finalI = i;
            textureImageViews.get(i).setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {




                    // Toggle tint color to green when clicked
                    ImageView clickedImageView = textureImageViews.get(finalI);

                    if (clickedImageView.getColorFilter() != null) {
                        clickedImageView.setColorFilter(null); // Reset tint if already green
                        // Initialize MediaPlayer and play the audio file
                        mediaPlayer = MediaPlayer.create(getApplicationContext(), R.raw.offsound); // Replace with your MP3 file name
                        mediaPlayer.start();
                        removeTexture(textures, finalI); // Remove from the moods array
                    } else {
                        clickedImageView.setColorFilter(Color.GREEN); // Apply green tint
                        // Initialize MediaPlayer and play the audio file
                        mediaPlayer = MediaPlayer.create(getApplicationContext(), R.raw.stylesound); // Replace with your MP3 file name
                        mediaPlayer.start();
                        addTexture(moods, finalI); // Add to the moods array
                    }
                }
            });
        }

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("A sharp and crisp image, having a  really high resolution ");
                String fintext=promptEditText.getText().toString();
                stringBuilder.append(fintext);

                 //For the STYLES

                // Create a new ArrayList to store the difference
                ArrayList<String> options = new ArrayList<>();

                // Loop through elements in list1
                for (String element : finartStyles) {
                    // Check if the element is not present in list2
                    if (!artStyles.contains(element)) {
                        // Add the element to the difference list
                        options.add(element);
                    }
                }



                stringBuilder.append(" with an art style of  either one or more or a combination of ");
                // Append values from the ArrayList to a string
                for (String value : options) {
                    stringBuilder.append(value).append(", "); // Append each value and a new line
                }

                options.clear();


                //For the PALETTE


                // Loop through elements in finpalettes
                for (String element : finpalettes) {
                    // Check if the element is not present in list2
                    if (!palettes.contains(element)) {
                        // Add the element to the difference list
                        options.add(element);
                    }
                }



                stringBuilder.append(" and with  a  color palette of either one or more or a combination of ");
                // Append values from the ArrayList to a string
                for (String value : options) {
                    stringBuilder.append(value).append(", "); // Append each value and a new line
                }

                options.clear();

                //For the MOOD


                // Loop through elements in finpalettes
                for (String element : finmoods) {
                    // Check if the element is not present in list2
                    if (!moods.contains(element)) {
                        // Add the element to the difference list
                        options.add(element);
                    }
                }



                stringBuilder.append(" and the mood of the picture should be either one or more or a combination of ");
                // Append values from the ArrayList to a string
                for (String value : options) {
                    stringBuilder.append(value).append(", "); // Append each value and a new line
                }

                options.clear();

                //For the TEXTURE


                // Loop through elements in finpalettes
                for (String element : fintextures) {
                    // Check if the element is not present in list2
                    if (!textures.contains(element)) {
                        // Add the element to the difference list
                        options.add(element);
                    }
                }



                stringBuilder.append(" .Also the texture  of the image should be one or more or a combination of ");
                // Append values from the ArrayList to a string
                for (String value : options) {
                    stringBuilder.append(value).append(", "); // Append each value and a new line
                }

                options.clear();



//                txtView.setText(stringBuilder.toString());


                // Create an Intent to pass data to MainActivity3
                Intent intent = new Intent(MainActivity2.this, MainActivity3.class);

                // Put the StringBuilder string into the Intent
                intent.putExtra("STRING_DATA", stringBuilder.toString());
                intent.putExtra("prompt",fintext);

                // Start MainActivity3
                startActivity(intent);

            }
        });

    }

    private void addMood(ArrayList<String> moods, int index) {
        switch (index) {
            case 0: // imageView23
                addOrRemoveMood("calm", moods);
                break;
            case 1: // imageView23
                addOrRemoveMood("mysterious", moods);
                break;
            case 2: // imageView23
                addOrRemoveMood("dreamy", moods);
                break;
            case 3: // imageView23
                addOrRemoveMood("magical", moods);
                break;
            case 4: // imageView23
                addOrRemoveMood("powerful", moods);
                break;
            case 5: // imageView23
                addOrRemoveMood("creative", moods);
                break;
            case 6: // imageView23
                addOrRemoveMood("humorous", moods);
                break;
            case 7: // imageView23
                addOrRemoveMood("spooky", moods);
                break;
            case 8: // imageView23
                addOrRemoveMood("happy", moods);
                break;


            // Add cases for other ImageViews accordingly
        }
    }

    private void removeMood(ArrayList<String> moods, int index) {
        switch (index) {
            case 0: // imageView23
                addOrRemoveMood("calm", moods);
                break;
            case 1: // imageView23
                addOrRemoveMood("mysterious", moods);
                break;
            case 2: // imageView23
                addOrRemoveMood("dreamy", moods);
                break;
            case 3: // imageView23
                addOrRemoveMood("magical", moods);
                break;
            case 4: // imageView23
                addOrRemoveMood("powerful", moods);
                break;
            case 5: // imageView23
                addOrRemoveMood("creative", moods);
                break;
            case 6: // imageView23
                addOrRemoveMood("humorous", moods);
                break;
            case 7: // imageView23
                addOrRemoveMood("spooky", moods);
                break;
            case 8: // imageView23
                addOrRemoveMood("happy", moods);
                break;


            // Add cases for other ImageViews accordingly
        }
    }


    private void addTexture(ArrayList<String> moods, int index) {
        switch (index) {
            case 0: // imageView23
                addOrRemoveTexture("polished", textures);
                break;
            case 1: // imageView23
                addOrRemoveTexture("grainy", textures);
                break;
            case 2: // imageView23
                addOrRemoveTexture("fluid", textures);
                break;
            case 3: // imageView23
                addOrRemoveTexture("weathered", textures);
                break;
            case 4: // imageView23
                addOrRemoveTexture("geometric patterns", textures);
                break;
            case 5: // imageView23
                addOrRemoveTexture("sleek", textures);
                break;
            case 6: // imageView23
                addOrRemoveTexture("glazed", textures);
                break;
            case 7: // imageView23
                addOrRemoveTexture("fractals", textures);
                break;
            case 8: // imageView23
                addOrRemoveTexture("sparkling", textures);
                break;

            // Add cases for other ImageViews accordingly
        }
    }

    private void removeTexture(ArrayList<String> moods, int index) {
        switch (index) {
            case 0: // imageView23
                addOrRemoveTexture("polished", textures);
                break;
            case 1: // imageView23
                addOrRemoveTexture("grainy", textures);
                break;
            case 2: // imageView23
                addOrRemoveTexture("fluid", textures);
                break;
            case 3: // imageView23
                addOrRemoveTexture("weathered", textures);
                break;
            case 4: // imageView23
                addOrRemoveTexture("geometric patterns", textures);
                break;
            case 5: // imageView23
                addOrRemoveTexture("sleek", textures);
                break;
            case 6: // imageView23
                addOrRemoveTexture("glazed", textures);
                break;
            case 7: // imageView23
                addOrRemoveTexture("fractals", textures);
                break;
            case 8: // imageView23
                addOrRemoveTexture("sparkling", textures);
                break;

            // Add cases for other ImageViews accordingly
        }
    }


    private void addPalette(ArrayList<String> palettes, int index) {
        switch (index) {
            case 0: // imageView23
                addOrRemovePalette("warm", palettes);
                break;
            case 1: // imageView24
                addOrRemovePalette("autumn", palettes);
                break;
            case 2: // imageView25
                addOrRemovePalette("complimentary", palettes);
                break;
            case 3: // imageView25
                addOrRemovePalette("cool", palettes);
                break;
            case 4: // imageView25
                addOrRemovePalette("analogous", palettes);
                break;
            case 5: // imageView25
                addOrRemovePalette("muted", palettes);
                break;
            case 6: // imageView25
                addOrRemovePalette("vibrant", palettes);
                break;
            case 7: // imageView25
                addOrRemovePalette("mono chromatic", palettes);
                break;
            case 8: // imageView25
                addOrRemovePalette("nature inspired", palettes);
                break;

            // Add cases for other ImageViews accordingly
        }
    }


    private void removePalette(ArrayList<String> palettes, int index) {
        switch (index) {
            case 0: // imageView23
                addOrRemoveMood("warm", palettes);
                break;
            case 1: // imageView24
                addOrRemovePalette("autumn", palettes);
                break;
            case 2: // imageView25
                addOrRemovePalette("complimentary", palettes);
                break;
            case 3: // imageView25
                addOrRemovePalette("cool", palettes);
                break;
            case 4: // imageView25
                addOrRemovePalette("analogous", palettes);
                break;
            case 5: // imageView25
                addOrRemovePalette("muted", palettes);
                break;
            case 6: // imageView25
                addOrRemovePalette("vibrant", palettes);
                break;
            case 7: // imageView25
                addOrRemovePalette("mono chromatic", palettes);
                break;
            case 8: // imageView25
                addOrRemovePalette("nature inspired", palettes);
                break;
            // Add cases for other ImageViews accordingly
        }
    }

    private void addOrRemovePalette(String palette, ArrayList<String> palettes) {
        if (palettes.contains(palette)) {
            palettes.remove(palette);
        } else {
            palettes.add(palette);
        }
    }

    private void addOrRemoveMood(String mood, ArrayList<String> moods) {
        if (moods.contains(mood)) {
            moods.remove(mood);
        } else {
            moods.add(mood);
        }
    }



    private void addArtStyle(ArrayList<String> artStyles, int index) {
        switch (index) {
            case 0: // imageView10
                addOrRemoveStyle("art deco", artStyles);
                break;
            case 1: // imageView13
                addOrRemoveStyle("abstract", artStyles);
                break;
            case 2: // imageView14
                addOrRemoveStyle("grunge", artStyles);
                break;
            case 3: // imageView14
                addOrRemoveStyle("minimalist", artStyles);
                break;
            case 4: // imageView14
                addOrRemoveStyle("comic book", artStyles);
                break;
            case 5: // imageView14
                addOrRemoveStyle("watercolor", artStyles);
                break;
            case 6: // imageView14
                addOrRemoveStyle("pop art", artStyles);
                break;
            case 7: // imageView14
                addOrRemoveStyle("pixel art", artStyles);
                break;
            case 8: // imageView14
                addOrRemoveStyle("retro", artStyles);
                break;
            // Add cases for other ImageViews accordingly
        }
    }


    private void removeArtStyle(ArrayList<String> artStyles, int index) {
        switch (index) {
            case 0: // imageView10
                addOrRemoveStyle("art deco", artStyles);
                break;
            case 1: // imageView13
                addOrRemoveStyle("abstract", artStyles);
                break;
            case 2: // imageView14
                addOrRemoveStyle("grunge", artStyles);
                break;
            case 3: // imageView14
                addOrRemoveStyle("minimalist", artStyles);
                break;
            case 4: // imageView14
                addOrRemoveStyle("comic book", artStyles);
                break;
            case 5: // imageView14
                addOrRemoveStyle("watercolor", artStyles);
                break;
            case 6: // imageView14
                addOrRemoveStyle("pop art", artStyles);
                break;
            case 7: // imageView14
                addOrRemoveStyle("pixel art", artStyles);
                break;
            case 8: // imageView14
                addOrRemoveStyle("retro", artStyles);
                break;
            // Add cases for other ImageViews accordingly
        }
    }

    private void addOrRemoveTexture(String texture, ArrayList<String> textures) {
        if (textures.contains(texture)) {
            textures.remove(texture);
        } else {
            textures.add(texture);
        }
    }

    private void addOrRemoveStyle(String style, ArrayList<String> artStyles) {
        if (artStyles.contains(style)) {
            artStyles.remove(style);
        } else {
            artStyles.add(style);
        }
    }


    private void displayValues() {




        // Show the values in a Toast message
        //Toast.makeText(MainActivity2.this, stringBuilder.toString(), Toast.LENGTH_LONG).show();
    }
}


