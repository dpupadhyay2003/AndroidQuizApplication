package com.lambton.projectquiz;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private Button startButton;
    private Button exitButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.start_page);

        startButton = findViewById(R.id.startButton);
        exitButton = findViewById(R.id.exitButton);

        startButton.setOnClickListener(this);
        exitButton.setOnClickListener(this);
    }


    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.startButton:  // Starting Quiz by initializing Activity
                 Intent intent = new Intent(getApplicationContext(), Page_1.class);
                 startActivity(intent);
                Log.d("page_1", "INTENT: " + String.valueOf(intent));
                Log.e("Page_1", "INTENT: " + String.valueOf(intent));
                Log.w("Page_1", "INTENT: " + String.valueOf(intent));
                Log.i("Page_1", "INTENT: " + String.valueOf(intent));
                break;
            case R.id.exitButton:
                finishAffinity();
                System.exit(0);
                break;

        }
    }
}
