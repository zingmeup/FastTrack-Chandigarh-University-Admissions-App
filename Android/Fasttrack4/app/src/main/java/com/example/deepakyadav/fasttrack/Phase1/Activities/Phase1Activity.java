package com.example.deepakyadav.fasttrack.Phase1.Activities;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import com.example.deepakyadav.fasttrack.Phase1.Fragments.BrandingFragment;
import com.example.deepakyadav.fasttrack.Phase1.Fragments.CourseBrowserFragment;
import com.example.deepakyadav.fasttrack.Phase1.Fragments.JoinUsFragment;
import com.example.deepakyadav.fasttrack.Phase1.Fragments.Phase1DrawerFragmentFragment;
import com.example.deepakyadav.fasttrack.Phase1.Fragments.StudentSpeaksFragment;
import com.example.deepakyadav.fasttrack.Phase1.NetworkOperations.NetworkOperations;
import com.example.deepakyadav.fasttrack.R;



public class Phase1Activity extends AppCompatActivity {
    SharedPreferences sharedPreferences;
    SharedPreferences.Editor sharedPrefrencesEditor;
    FragmentManager fragmentManager;
    FragmentTransaction fragmentTransaction;
    BrandingFragment brandingFragment;
    CourseBrowserFragment courseBrowserFragment;
    JoinUsFragment joinUsFragment;
    StudentSpeaksFragment studentSpeaksFragment;
    BottomNavigationView navigation;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        fragmentManager=getSupportFragmentManager();
        brandingFragment=new BrandingFragment();courseBrowserFragment=new CourseBrowserFragment();
        joinUsFragment=new JoinUsFragment();studentSpeaksFragment=new StudentSpeaksFragment();
        navigation= (BottomNavigationView) findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
        navigation.setSelectedItemId(R.id.navigation_joinus);
    }



    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            fragmentTransaction=fragmentManager.beginTransaction();
            fragmentTransaction.setCustomAnimations(android.R.anim.fade_in,android.R.anim.fade_out);
            switch (item.getItemId()){
                case R.id.navigation_course:
                    getSupportActionBar().setTitle(R.string.title_course_full);
                    fragmentTransaction.replace(R.id.fragment_container, courseBrowserFragment).commit();
                    return true;
                case R.id.navigation_joinus:
                    getSupportActionBar().setTitle(R.string.title_join_full);
                    fragmentTransaction.replace(R.id.fragment_container, joinUsFragment).commit();
                    return true;
                case R.id.navigation_branding:
                    getSupportActionBar().setTitle(R.string.title_branding_full);
                    fragmentTransaction.replace(R.id.fragment_container, brandingFragment).commit();
                    return true;
                case R.id.navigation_studentspreak:
                    getSupportActionBar().setTitle(R.string.title_studentspeak_full);
                    fragmentTransaction.replace(R.id.fragment_container, studentSpeaksFragment).commit();
                    return true;
            }
            return false;
        }
    };
    public void showDialog(View view) {
        Phase1DrawerFragmentFragment.getEditNameDialogFragment().show(fragmentManager, "fragment_edit_name");
    }

    @Override
    protected void onPostResume() {
        super.onPostResume();
        NetworkOperations.getInstance().fetchCourseStructure(Phase1Activity.this);
        NetworkOperations.getInstance().fetchReviews(Phase1Activity.this);
    }

    @Override
    public void onBackPressed() {
        if(navigation.getSelectedItemId()!=R.id.navigation_joinus){
            navigation.setSelectedItemId(R.id.navigation_joinus);
        }else{
            super.onBackPressed();
        }
    }





    @Override
    protected void onPause() {
        super.onPause();
    }


}
