package com.lambton.projectquiz;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Random;


public class Fragment_1 extends Fragment {
    private TextView question_1;
    private Button option_1;
    private Button option_2;
    private Button option_3;
    private Button option_4;
    private Button nextButton;

    Bundle bundle = new Bundle();

    private int score=0;

    private String[] question = {
            "What is the correct HTML for creating a hyperlink?",   // Button
            "Which of these tags are all <table> tags?",        // Button
      };
    private String[][] answers = {
            {"<a url='http://www.google.com'>google</a>", "<a name='http://www.google.com'>google</a>", "<a href='http://www.google.com'>google</a>", "<a>google</a>"},
            {"table><tr><tt>", "<thead><body><tr>", "<table><tr><td>", "<table><head><tfoot>"},
    };
    private String[] rightAnswer = {
            "<a href='http://www.google.com'>google</a>",
            "<table><tr><td>"
    };

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View fragmentView = inflater.inflate(R.layout.fragment_1, container, false);

        Random rnd = new Random();
        final int questionIndex = rnd.nextInt(1);
        question_1 = (TextView) fragmentView.findViewById(R.id.question_1);

        option_1 = (Button) fragmentView.findViewById(R.id.button1);
        option_2 = (Button) fragmentView.findViewById(R.id.button2);
        option_3 = (Button) fragmentView.findViewById(R.id.button3);
        option_4 = (Button) fragmentView.findViewById(R.id.button4);
        nextButton = (Button) fragmentView.findViewById(R.id.nextButton);

        question_1.setText(question[questionIndex]);
        option_1.setText(answers[questionIndex][0]);
        option_2.setText(answers[questionIndex][1]);
        option_3.setText(answers[questionIndex][2]);
        option_4.setText(answers[questionIndex][3]);



        option_1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(option_1.getText() == rightAnswer[questionIndex]){
                    score++;
                    Toast.makeText(getActivity(), "You Got the Right Answer", Toast.LENGTH_SHORT).show();
                }else{
                    Toast.makeText(getActivity(), "Wrong Answer, Correct Answer is "+rightAnswer[questionIndex], Toast.LENGTH_SHORT).show();
                }
                bundle.putInt("score", score);
                LoadNextFragment();
            }
        });

        option_2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(option_2.getText() == rightAnswer[questionIndex]){
                    score++;
                    Toast.makeText(getActivity(), "You Got the Right Answer", Toast.LENGTH_SHORT).show();
                }else{
                    Toast.makeText(getActivity(), "Wrong Answer, Correct Answer is "+rightAnswer[questionIndex], Toast.LENGTH_SHORT).show();
                }
                bundle.putInt("score", score);
                LoadNextFragment();
            }
        });

        option_3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(option_3.getText() == rightAnswer[questionIndex]){
                    score++;
                    Toast.makeText(getActivity(), "You Got the Right Answer", Toast.LENGTH_SHORT).show();
                }else{
                    Toast.makeText(getActivity(), "Wrong Answer, Correct Answer is "+rightAnswer[questionIndex], Toast.LENGTH_SHORT).show();
                }
                bundle.putInt("score", score);
                LoadNextFragment();
            }
        });

        option_4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(option_4.getText() == rightAnswer[questionIndex]){
                    score++;
                    Toast.makeText(getActivity(), "You Got the Right Answer", Toast.LENGTH_SHORT).show();
                }else{
                    Toast.makeText(getActivity(), "Wrong Answer, Correct Answer is "+rightAnswer[questionIndex], Toast.LENGTH_SHORT).show();
                }
                bundle.putInt("score", score);
                LoadNextFragment();
            }
        });

        return fragmentView;
    }
    private void LoadNextFragment(){
        FragmentManager fm = getFragmentManager();
        FragmentTransaction ft = fm.beginTransaction();
        Fragment frag = new Fragment_2();
        frag.setArguments(bundle);
        ft.replace(R.id.page_1, frag, "Fragment2Tag");
        ft.commit();
    }



}
