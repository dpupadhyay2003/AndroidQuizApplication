package com.lambton.projectquiz;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

public class Page_1 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.page_1);
        // FragmentManager fm=getSupportFragmentManager();
        // fm.beginTransaction().replace(R.id.page_1,new Fragment_1()).addToBackStack(null).commit();

        FragmentManager fm = getSupportFragmentManager();
        FragmentTransaction ft = fm.beginTransaction();
        Fragment frag = new Fragment_1();
        ft.add(R.id.page_1, frag, "Fragment1Tag");
        ft.commit();

    }

}
