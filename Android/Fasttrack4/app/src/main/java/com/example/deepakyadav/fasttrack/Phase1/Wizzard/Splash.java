package com.example.deepakyadav.fasttrack.Phase1.Wizzard;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.example.deepakyadav.fasttrack.Phase1.Activities.Phase1Activity;
import com.example.deepakyadav.fasttrack.R;

public class Splash extends AppCompatActivity {
    SharedPreferences sharedPreferences;
    SharedPreferences.Editor editor;
    View mainSplash;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        mainSplash=findViewById(R.id.main_splash);
        mainSplash.setAlpha(0f);
        mainSplash.animate().alphaBy(1f).setDuration(3000).setListener(null);
        sharedPreferences=getSharedPreferences(getPackageName(), Context.MODE_PRIVATE);
        editor=sharedPreferences.edit();
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                if(sharedPreferences.getBoolean("first_launch", true)==true){
                    editor.putBoolean("first_launch", false);
                    editor.commit();
                    startActivity(new Intent(Splash.this,Wizzard.class));
                }else{
                    startActivity(new Intent(Splash.this, Phase1Activity.class));
                }
                finish();
            }
        },3000);
    }
}
