package com.lambton.projectquiz;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class TryAgain extends AppCompatActivity {

    private TextView failMessage;
    private TextView actualScore;
    private Button tryAgain;
    private Button mainMenu;

    private String score="0";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.tryagain);

        score = getIntent().getStringExtra("score");

        failMessage = findViewById(R.id.failmessage);
        actualScore = findViewById(R.id.actualscore);

        actualScore.setText(score);
        failMessage.setText("Please try again!");

        tryAgain.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), Page_1.class);
                startActivity(intent);
            }
        });

        mainMenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(intent);
            }
        });

    }

}
