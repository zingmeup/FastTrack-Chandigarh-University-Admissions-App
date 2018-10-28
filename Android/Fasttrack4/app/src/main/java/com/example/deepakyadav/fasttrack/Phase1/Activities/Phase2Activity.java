package com.example.deepakyadav.fasttrack.Phase1.Activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.widget.ImageView;

import com.example.deepakyadav.fasttrack.Phase1.Data.SessionData;
import com.example.deepakyadav.fasttrack.Phase1.Fragments.Phase2DrawerFragment;
import com.example.deepakyadav.fasttrack.R;

public class Phase2Activity extends AppCompatActivity {
    ImageView drawerButton;
    Toolbar toolbar;
    FragmentManager fragmentManager;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);
        Intent intent=getIntent();
        if(!(SessionData.getSessionData().getAccessToken().equals(intent.getStringExtra("AccessToken")))){
            Log.e("Session","INVALID");
            startActivity(new Intent(Phase2Activity.this, Phase1Activity.class));
        }else{
            Log.e("Session","VALID");
        }

        fragmentManager=getSupportFragmentManager();
        toolbar = (Toolbar) findViewById(R.id.toolbar_phase2_activity3);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("");
        drawerButton=findViewById(R.id.drawer_btn_phase2);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.assistant_fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(Phase2Activity.this, AssistantActivity.class));
            }
        });


    }

    public void showDialog(View view) {
        Phase2DrawerFragment.getPhase2DrawerFragment().show(fragmentManager, "fragment_edit_name");
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.phase2_menu, menu);
        return true;
    }

}
