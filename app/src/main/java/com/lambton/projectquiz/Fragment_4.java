package com.lambton.projectquiz;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;


public class Fragment_4 extends Fragment {

    private TextView question4;
    private ImageView expressjs;
    private ImageView jquery;
    private ImageView reactjs;
    private ImageView vuejs;

    private int score=0;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_4, container, false);

        Bundle bundle = getArguments();
        score = bundle.getInt("score");

        question4 = (TextView) v.findViewById(R.id.question_4);
        expressjs = (ImageView) v.findViewById(R.id.express);
        jquery = (ImageView) v.findViewById(R.id.jquery);
        reactjs = (ImageView) v.findViewById(R.id.reactjs);
        vuejs = (ImageView) v.findViewById(R.id.vuejs);

        expressjs.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                score++;
                Toast.makeText(getActivity(), "You Got the Right Answer.", Toast.LENGTH_SHORT).show();
                loadAnotherFragment();
            }
        });
        jquery.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getActivity(), "Wrong Answer..!!", Toast.LENGTH_SHORT).show();
                loadAnotherFragment();
            }
        });
        reactjs.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getActivity(), "Wrong Answer..!!", Toast.LENGTH_SHORT).show();
                loadAnotherFragment();
            }
        });
        vuejs.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getActivity(), "Wrong Answer..!!", Toast.LENGTH_SHORT).show();
                loadAnotherFragment();
            }
        });
        return v;
    }

    private void loadAnotherFragment(){
        Bundle bundle = new Bundle();
        bundle.putInt("score", score);
        Fragment frag = new Fragment_5();
        frag.setArguments(bundle);
        FragmentTransaction ft = getFragmentManager().beginTransaction();
        ft.replace(R.id.page_1, frag, "Fragment4Tag");
        ft.commit();
    }

}
