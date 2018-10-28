package com.example.deepakyadav.fasttrack.Phase1.Fragments;

import android.animation.Animator;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.TextView;

import com.example.deepakyadav.fasttrack.Phase1.Data.CourseBrowserData;
import com.example.deepakyadav.fasttrack.Phase1.DataModels.CourseBrowserModel;
import com.example.deepakyadav.fasttrack.Phase1.NetworkOperations.NetworkOperations;
import com.example.deepakyadav.fasttrack.R;

public class CourseBrowserFragment extends Fragment {
    View detailsCard, placeHolderCard;
    TextView discipline,programName,duration,semfee,shortName,eligibiliy,programcode;
    AutoCompleteTextView courseBrowserSearch;
    public static ArrayAdapter<String> arrayAdapter;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_coursebrowser, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        detailsCard=view.findViewById(R.id.courseBrowser_details);
        placeHolderCard=view.findViewById(R.id.courseBrowser_placeholder);
        discipline=view.findViewById(R.id.courseBrowser_discpline);
        programName=view.findViewById(R.id.courseBrowser_programname);
        duration=view.findViewById(R.id.courseBrowser_duration);
        semfee=view.findViewById(R.id.courseBrowser_semesterfee);
        shortName=view.findViewById(R.id.courseBrowser_shortname);
        eligibiliy=view.findViewById(R.id.courseBrowser_eligibility);
        programcode=view.findViewById(R.id.courseBrowser_programcode);
        courseBrowserSearch=view.findViewById(R.id.courseBrowser_search);


    }

    @Override
    public void onStart() {
        super.onStart();
        arrayAdapter=new ArrayAdapter<>(getContext(), R.layout.row_custom_search_item, CourseBrowserData.getInstance()
                .getSearchText());
        courseBrowserSearch.setAdapter(arrayAdapter);
        courseBrowserSearch.setOnItemClickListener(courseBrowserSearchListener);
    }

    @Override
    public void onResume() {
        super.onResume();

        arrayAdapter.notifyDataSetChanged();



    }

    private AdapterView.OnItemClickListener courseBrowserSearchListener= new AdapterView.OnItemClickListener() {
        @Override
        public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
            int index=0;
            for (int j = 0; j <CourseBrowserData.getInstance().getSearchText().size() ; j++) {
                if(CourseBrowserData.getInstance().getSearchText().get(j).equals(courseBrowserSearch.getText().toString())){
                      index=j;
                }
            }
            courseBrowserSearch.setText(CourseBrowserData.getInstance().getCourseBrowserList().get(index).getProgramName());

            placeHolderCard.animate().alphaBy(0.5f).setDuration(1000).setListener(new Animator.AnimatorListener() {
                @Override
                public void onAnimationStart(Animator animator) {

                }

                @Override
                public void onAnimationEnd(Animator animator) {
                    placeHolderCard.setVisibility(View.GONE);
                }

                @Override
                public void onAnimationCancel(Animator animator) {

                }

                @Override
                public void onAnimationRepeat(Animator animator) {

                }
            });
            detailsCard.setVisibility(View.VISIBLE);
            detailsCard.setAlpha(0f);
            detailsCard.animate().alphaBy(1f).setDuration(2000).setListener(null);
            CourseBrowserModel courseBrowserModel=CourseBrowserData.getInstance().getCourseBrowserList().get(index);
            discipline.setText(courseBrowserModel.getDiscipline());
            programName.setText(courseBrowserModel.getProgramName());
            duration.setText(String.valueOf(courseBrowserModel.getDuration()));
            semfee.setText(String.valueOf(courseBrowserModel.getFeePerSemRS())+"\n"+String.valueOf(courseBrowserModel.getFeePerSemUSD()));
            shortName.setText(courseBrowserModel.getShortNamr());
            eligibiliy.setText(courseBrowserModel.getEligibility());
            programcode.setText(courseBrowserModel.getProgramCode());

        }



    };
}
