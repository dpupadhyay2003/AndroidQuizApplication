package com.lambton.projectquiz;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class Result extends AppCompatActivity {

    private TextView resultmessage;
    private TextView actualScore;
    private Button mainMenu;
    private String score="0";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.result);

        score = getIntent().getStringExtra("score");

        resultmessage = findViewById(R.id.resultmessage);
        actualScore = findViewById(R.id.actualscore);
        mainMenu = findViewById(R.id.mainMenu);

        if(Integer.parseInt(score) == 3){
            resultmessage.setText("Good Job!");
        }else if(Integer.parseInt(score) == 4){
            resultmessage.setText("Excellent Work");
        }else if(Integer.parseInt(score) == 5){
            resultmessage.setText("You are a Genius!");
        }else{
            resultmessage.setText("Score Not Found..!!");
        }

        actualScore.setText(score);

        mainMenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(intent);
            }
        });
    }

}
