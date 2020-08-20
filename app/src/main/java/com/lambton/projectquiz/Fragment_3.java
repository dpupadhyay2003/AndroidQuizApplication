package com.lambton.projectquiz;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class Fragment_3 extends Fragment {

    private String[] question = {
            "What does HTML Stand for ?",       // Radio Button
            "What is the correct HTML tag for inserting a line break?", // Radio Button
    };

    private String[][] answers = {
            {"Hyperlinks and Text Markup Language", "Hyper Text Markup Language", "Home Tool Markup Language", "Hyper Tool Markdown Language"},
            {"<br>", "&nbsp;", "<break>", "<b>"},
    };

    private String[] rightAnswer = {
            "Hyper Text Markup Language", "<br>"
    };

    private TextView question_3;
    private RadioButton radioButton1;
    private RadioButton radioButton2;
    private RadioButton radioButton3;
    private RadioButton radioButton4;
    private Button nextButton;

    private int score=0;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_3, container, false);
        Bundle bundle = getArguments();

        score = bundle.getInt("score");

        Random rnd = new Random();
        final int questionIndex = rnd.nextInt(1);

        question_3 = (TextView) v.findViewById(R.id.question_3);

        radioButton1 = (RadioButton) v.findViewById(R.id.radioButton1);
        radioButton2 = (RadioButton) v.findViewById(R.id.radioButton2);
        radioButton3 = (RadioButton) v.findViewById(R.id.radioButton3);
        radioButton4 = (RadioButton) v.findViewById(R.id.radioButton4);
        nextButton = (Button) v.findViewById(R.id.nextButton3);

        question_3.setText(question[questionIndex]);
        radioButton1.setText(answers[questionIndex][0]);
        radioButton2.setText(answers[questionIndex][1]);
        radioButton3.setText(answers[questionIndex][2]);
        radioButton4.setText(answers[questionIndex][3]);

        nextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(radioButton1.isChecked()){
                    if(radioButton1.getText().toString().equals(rightAnswer[questionIndex])){
                        score++;
                        Toast.makeText(getActivity(), "You Got the Right Answer", Toast.LENGTH_SHORT).show();
                    }else{
                        Toast.makeText(getActivity(), "Wrong Answer..!!", Toast.LENGTH_SHORT).show();
                    }

                }
                else if(radioButton2.isChecked()){
                    if(radioButton2.getText().toString().equals(rightAnswer[questionIndex])){
                        score++;
                        Toast.makeText(getActivity(), "You Got the Right Answer", Toast.LENGTH_SHORT).show();
                    }else{
                        Toast.makeText(getActivity(), "Wrong Answer..!!", Toast.LENGTH_SHORT).show();
                    }
                }
                else if(radioButton3.isChecked()){
                    if(radioButton3.getText().toString().equals(rightAnswer[questionIndex])){
                        score++;
                        Toast.makeText(getActivity(), "You Got the Right Answer", Toast.LENGTH_SHORT).show();
                    }else{
                        Toast.makeText(getActivity(), "Wrong Answer..!!", Toast.LENGTH_SHORT).show();
                    }
                }
                else if(radioButton4.isChecked()){
                    if(radioButton4.getText().toString().equals(rightAnswer[questionIndex])){
                        score++;
                        Toast.makeText(getActivity(), "You Got the Right Answer", Toast.LENGTH_SHORT).show();
                    }else{
                        Toast.makeText(getActivity(), "Wrong Answer..!!", Toast.LENGTH_SHORT).show();
                    }
                }else{
                    Toast.makeText(getActivity(), "None Selected", Toast.LENGTH_SHORT).show();
                }

                Bundle bundle = new Bundle();
                bundle.putInt("score", score);
                Fragment frag = new Fragment_4();
                frag.setArguments(bundle);
                FragmentTransaction transaction = getFragmentManager().beginTransaction();
                transaction.replace(R.id.page_1, frag, "Fragment4Tag");
                transaction.commit();
            }
        });

        return v;
    }
}
