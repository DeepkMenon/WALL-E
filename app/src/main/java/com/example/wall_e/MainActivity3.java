package com.example.wall_e;

import android.Manifest;

import static android.content.ContentValues.TAG;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.os.Environment;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;



import com.google.android.material.button.MaterialButton;
import com.squareup.picasso.Picasso;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

public class MainActivity3 extends AppCompatActivity {


    EditText inputText;
    MaterialButton generateBtn;
    ProgressBar progressBar;
    ImageView imageView;

    Button downloadButton;
    Button backButton;

    // Add a variable to request permission
    private static final int REQUEST_WRITE_PERMISSION = 786;

    public static final MediaType JSON
            = MediaType.get("application/json; charset=utf-8");

    OkHttpClient client = new OkHttpClient();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);


        generateBtn = findViewById(R.id.generate_btn);
        progressBar = findViewById(R.id.progressBar);
        imageView = findViewById(R.id.image_view);

        backButton=findViewById(R.id.back);


        // Get the passed string from MainActivity2
        String receivedString = getIntent().getStringExtra("STRING_DATA");

        String promptText = getIntent().getStringExtra("prompt");






        generateBtn.setOnClickListener((v)->{
            // Toggle the visibility of the progress bar
            if (progressBar.getVisibility() == View.GONE) {
                progressBar.setVisibility(View.VISIBLE);
            } else {
                progressBar.setVisibility(View.GONE);
            }

            // Toggle the visibility of the ImageView
            if (imageView.getVisibility() == View.INVISIBLE || imageView.getVisibility() == View.GONE) {
                imageView.setVisibility(View.VISIBLE);
            } else {

            }

            String text = receivedString;
            if(text.isEmpty()){
                inputText.setError("Text can't be empty");
                return;
            }
            callAPI(text);
        });

        downloadButton = findViewById(R.id.download);

        // Handle the click event of the "Downloads" button
        downloadButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                saveImageToDownloads();
            }
        });

        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                // Navigate back to MainActivity2
                Intent intent = new Intent(MainActivity3.this, MainActivity2.class);
                intent.putExtra("PROMPT_TEXT", promptText);
                startActivity(intent);
            }
        });

    }

    void callAPI(String text){
        //API CALL
        setInProgress(true);
        JSONObject jsonBody = new JSONObject();
        try{
            jsonBody.put("prompt",text);
            jsonBody.put("size","256x256");
        }catch (Exception e){
            e.printStackTrace();
        }
        RequestBody requestBody = RequestBody.create(jsonBody.toString(),JSON);
        Request request = new Request.Builder()
                .url("https://api.openai.com/v1/images/generations")
                .header("Authorization","Bearer YOUR OpenAI API Key")
                .post(requestBody)
                .build();

        client.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(@NonNull Call call, @NonNull IOException e) {
                Toast.makeText(getApplicationContext(),"Failed to generate image",Toast.LENGTH_LONG).show();
            }

            @Override
            public void onResponse(@NonNull Call call, @NonNull Response response) throws IOException {

                try{
                    JSONObject jsonObject = new JSONObject(response.body().string());
                    String imageUrl = jsonObject.getJSONArray("data").getJSONObject(0).getString("url");
                    loadImage(imageUrl);
                    setInProgress(false);
                }catch (Exception e){
                    e.printStackTrace();
                }
            }
        });

    }

    void setInProgress(boolean inProgress){
        runOnUiThread(()->{
            if(inProgress){
                progressBar.setVisibility(View.VISIBLE);
                generateBtn.setVisibility(View.GONE);
            }else{
                progressBar.setVisibility(View.GONE);
                generateBtn.setVisibility(View.VISIBLE);

                // Show the download button when inProgress is false
                downloadButton.setVisibility(View.VISIBLE);

                // Show the download button when inProgress is false
                backButton.setVisibility(View.VISIBLE);
            }
        });

    }

    void loadImage(String url){
        //load image

        runOnUiThread(()->{
            Picasso.get().load(url).into(imageView);

        });

    }

    private void saveImageToDownloads() {
        // Check if permission to write to external storage is granted
        if (ContextCompat.checkSelfPermission(this, Manifest.permission.WRITE_EXTERNAL_STORAGE)
                != PackageManager.PERMISSION_GRANTED) {
            // Request permission to write to external storage if not granted
            ActivityCompat.requestPermissions(this,
                    new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE},
                    REQUEST_WRITE_PERMISSION);
        } else {
            // If permission is already granted, proceed to save the image
            // Notify the user that the image has been saved
            Toast.makeText(getApplicationContext(), "Saving image...", Toast.LENGTH_SHORT).show();
            saveImage();
        }
    }

    private void saveImage() {
        // Get the Bitmap from the ImageView
        BitmapDrawable drawable = (BitmapDrawable) imageView.getDrawable();
        Bitmap bitmap = drawable.getBitmap();

        String timeStamp = new SimpleDateFormat("yyyyMMdd_HHmmss", Locale.getDefault()).format(new Date());
        String fileName = "WALL-e_image" + timeStamp + ".png"; // Unique file name using timestamp


        File downloadsFolder = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS);

        if (!downloadsFolder.exists()) {
            downloadsFolder.mkdirs(); // Create Downloads folder if it doesn't exist
        }

        File imageFile = new File(downloadsFolder, fileName);
        try {
            OutputStream outputStream = new FileOutputStream(imageFile);
            bitmap.compress(Bitmap.CompressFormat.PNG, 100, outputStream);
            outputStream.flush();
            outputStream.close();

            // Notify the user that the image has been saved
            Toast.makeText(getApplicationContext(), "Image saved to Downloads folder", Toast.LENGTH_SHORT).show();
        } catch (IOException e) {
            e.printStackTrace();
            // Notify the user if there's an error in saving the image
            Toast.makeText(getApplicationContext(), "Failed to save image", Toast.LENGTH_SHORT).show();
        }
    }

    // Handle permission request result (if needed)
    @Override
    public void onRequestPermissionsResult(int requestCode, String[] permissions, int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if (requestCode == REQUEST_WRITE_PERMISSION) {
            if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                saveImage(); // Save image if permission is granted after the request
            } else {
                // Notify the user if permission is denied
                Toast.makeText(getApplicationContext(), "Permission denied", Toast.LENGTH_SHORT).show();
            }
        }
    }



    }

