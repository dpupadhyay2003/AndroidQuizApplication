package com.lambton.projectquiz;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;


public class Fragment_5 extends Fragment {

    private String[] question = {
            "What is the correct HTML for inserting an image?", //List View
            "How can you make a numbered list?",    // List View
    };

//    sshikharshah@gmail.com

    private String[][] answers = {
            {"<img href=\"image.gif\" alt=\"MyImage\">",
                    "<image src=\"image.gif\" alt=\"MyImage\">",
                    "<img src=\"image.gif\" alt=\"MyImage\">", "<img alt=\"MyImage\">image.gif</img>"},
            {"<list>", "<dl>", "<ul>", "<ol>"},
    };

    private String[] rightAnswer = {
            "<img src=\"image.gif\" alt=\"MyImage\">", "<ol>"
    };

    private TextView question5;
    private ListView listView;
    private int score = 0;

    String[] options = new String[4];

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_5, container, false);

        Bundle bundle = getArguments();
        score = bundle.getInt("score");

        question5 = (TextView) v.findViewById(R.id.question_5);
        listView = (ListView) v.findViewById(R.id.listView);

        Random rnd = new Random();
        final int questionIndex = rnd.nextInt(1);

        question5.setText(question[questionIndex]);
        options[0] = answers[questionIndex][0];
        options[1] = answers[questionIndex][1];
        options[2] = answers[questionIndex][2];
        options[3] = answers[questionIndex][3];

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(getActivity(), R.layout.itemlist, options);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                if (options[position].equals(rightAnswer[questionIndex])) {
                    score++;
                    Toast.makeText(getActivity(), "You Got the Right Answer.", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(getActivity(), "Wrong Answer..!!", Toast.LENGTH_SHORT).show();
                }

                if (score <= 2) {
                    // Try Again Option
                    Intent intent = new Intent(getContext(), TryAgain.class);
                    intent.putExtra("score", String.valueOf(score));
                    startActivity(intent);
                } else {
                    // Pass Option
                    Intent intent = new Intent(getContext(), Result.class);
                    intent.putExtra("score", String.valueOf(score));
                    startActivity(intent);
                }
            }
        });

        return v;
    }
}
