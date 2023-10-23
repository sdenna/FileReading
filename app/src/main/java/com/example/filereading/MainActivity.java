package com.example.filereading;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        readFile();
    }

    public void readFile() {
        try {
            // Open the file
            InputStream inputStream = getResources().openRawResource(R.raw.readmee);

            // Create a BufferedReader to read the file
            BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));

            // Read lines from the file
            String line;
            while ((line = reader.readLine()) != null) {
                // Do something with each line
                Log.i("Denna", line);
            }

            // Close the file
            inputStream.close();
        } catch (IOException e) {
            // Handle any exceptions
            Log.i("Denna", "IOException: " + e.getCause());
            Log.i("Denna", e.getMessage());
        }
    }
}