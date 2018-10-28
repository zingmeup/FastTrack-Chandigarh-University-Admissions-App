package com.example.deepakyadav.fasttrack.Phase1.Wizzard;

import android.content.Intent;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ProgressBar;

import com.example.deepakyadav.fasttrack.Phase1.Activities.Phase1Activity;
import com.example.deepakyadav.fasttrack.R;

public class Wizzard extends AppCompatActivity {
    FloatingActionButton floatingActionButton;
    View page1,page2,page3,page4;
    ProgressBar progressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_wizzard);
        //getWindow().setContentView(R.layout.fragment_aboutus);
        progressBar=findViewById(R.id.wizzard_progressbar);
        progressBar.setMax(100);
        page1=findViewById(R.id.wizzard_page1);
        page2=findViewById(R.id.wizzard_page2);
        page3=findViewById(R.id.wizzard_page3);
        page4=findViewById(R.id.wizzard_page4);
        page1.setVisibility(View.VISIBLE);
        floatingActionButton=findViewById(R.id.fab_wizzard);
        progressBar.setProgress(25);
        floatingActionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (page1.getVisibility()==View.VISIBLE){
                    page1.setVisibility(View.GONE);
                    page1.animate().alphaBy(0f).setDuration(10000).setListener(null);
                    page2.setVisibility(View.VISIBLE);
                    progressBar.setProgress(50);
                } else if(page2.getVisibility()==View.VISIBLE) {
                    page2.setVisibility(View.GONE);
                    page2.animate().alphaBy(0f).setDuration(10000).setListener(null);
                    page3.setVisibility(View.VISIBLE);
                    progressBar.setProgress(75);
                } else if(page3.getVisibility()==View.VISIBLE) {
                    page3.setVisibility(View.GONE);
                    page3.animate().alphaBy(0f).setDuration(10000).setListener(null);
                    page4.setVisibility(View.VISIBLE);
                    progressBar.setProgress(100);
                } else {
                    startActivity(new Intent(Wizzard.this, Phase1Activity.class));
                }
            }
        });
    }
}
