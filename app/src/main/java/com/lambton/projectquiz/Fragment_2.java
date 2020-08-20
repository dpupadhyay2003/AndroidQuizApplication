package com.lambton.projectquiz;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.TextView;
import android.widget.Toast;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;


public class Fragment_2 extends Fragment {

    private TextView question_2;
    private CheckBox option_1;
    private CheckBox option_2;
    private CheckBox option_3;
    private CheckBox option_4;
    private Button nextButton;

    private int score=0;

    private String[] question = {
            "Select All HTML Tags for Heading?",   // Button
            "Which is the correct CSS syntax?",        // Button
    };
    private String[][] answers = {
            {"<head>", "<h1>", "<title>", "<h7>"},
            {"#id1:{color:black}", "body:color=black;", "{body:color=black;}", "body {color: black;}"}
    };
    private String[] rightAnswer = {
            "<h1>",
            "body {color: black;}"
    };

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_2, container, false);
        Bundle bundle = getArguments();
        score = bundle.getInt("score");


        Random rnd = new Random();
        final int questionIndex = rnd.nextInt(1);
        question_2 = (TextView) v.findViewById(R.id.question_2);

        option_1 = (CheckBox) v.findViewById(R.id.checkbox1);
        option_2 = (CheckBox) v.findViewById(R.id.checkbox2);
        option_3 = (CheckBox) v.findViewById(R.id.checkbox3);
        option_4 = (CheckBox) v.findViewById(R.id.checkbox4);
        nextButton = (Button) v.findViewById(R.id.nextButton2);

        question_2.setText(question[questionIndex]);
        option_1.setText(answers[questionIndex][0]);
        option_2.setText(answers[questionIndex][1]);
        option_3.setText(answers[questionIndex][2]);
        option_4.setText(answers[questionIndex][3]);

        nextButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                boolean answerFlag = false;
                ArrayList<String> current = new ArrayList<>();

                if(option_1.isChecked() && !option_2.isChecked() && !option_3.isChecked() && !option_4.isChecked() ){
                    if(option_1.getText().toString().equals(rightAnswer[questionIndex])){
                        answerFlag=true;
                    }else{
                        answerFlag=false;
                    }
                }else if(option_2.isChecked() && !option_1.isChecked() && !option_3.isChecked() && !option_4.isChecked() ){
                    if(option_2.getText().toString().equals(rightAnswer[questionIndex])){
                        answerFlag=true;
                    }else{
                        answerFlag=false;
                    }
                }else if(option_3.isChecked() && !option_2.isChecked() && !option_1.isChecked() && !option_4.isChecked() ){
                    if(option_3.getText().toString().equals(rightAnswer[questionIndex])){
                        answerFlag=true;
                    }else{
                        answerFlag=false;
                    }
                }else if(option_4.isChecked() && !option_2.isChecked() && !option_3.isChecked() && !option_1.isChecked() ){
                    if(option_4.getText().toString().equals(rightAnswer[questionIndex])){
                        answerFlag=true;
                    }else{
                        answerFlag=false;
                    }
                }else{
                    answerFlag=false;
                }

                if(answerFlag){
                    score++;
                    Bundle bundle = new Bundle();
                    bundle.putInt("score", score);
                    Toast.makeText(getActivity(), "You Got the Right Answers!", Toast.LENGTH_SHORT).show();
                    Fragment frag = new Fragment_3();
                    frag.setArguments(bundle);
                    FragmentTransaction ft = getFragmentManager().beginTransaction();
                    ft.replace(R.id.page_1, frag, "Fragment3Tag");
                    ft.commit();

                }else{
                    Toast.makeText(getActivity(), "Wrong Answers..!!", Toast.LENGTH_SHORT).show();
                }

            }
        });


        return v;
    }

}
