package com.example.deepakyadav.fasttrack.Phase1.Fragments;

import android.animation.Animator;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;

import com.example.deepakyadav.fasttrack.Phase1.Data.JoinUsData;
import com.example.deepakyadav.fasttrack.R;

public class FormsFragment extends Fragment {
    View genenForm,reqinForm;
    TextView genenBtn, reginBtn;
    Spinner disciplineSpinner,programSpinner;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_forms, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        genenForm=view.findViewById(R.id.genenqform);
        reqinForm=view.findViewById(R.id.reqinfoform);
        genenBtn=view.findViewById(R.id.form_switch_gef);
        reginBtn=view.findViewById(R.id.form_switch_rif);
        genenBtn.setOnClickListener(genBtnListener);
        reginBtn.setOnClickListener(rifBtnListener);

    }
    private View.OnClickListener genBtnListener=new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            genenForm.animate().alphaBy(0.5f).setDuration(500).setListener(new Animator.AnimatorListener() {
                @Override
                public void onAnimationStart(Animator animator) {

                }

                @Override
                public void onAnimationEnd(Animator animator) {
                    genenForm.setVisibility(View.GONE);
                    reqinForm.setVisibility(View.VISIBLE);
                    reqinForm.setAlpha(0f);
                    reqinForm.animate().alphaBy(1f).setDuration(500).setListener(null);

                    genenBtn.setTextSize(20f);
                    genenBtn.setAlpha(0.5f);
                    genenBtn.animate().alphaBy(1f).setDuration(1000).setListener(null);
                    reginBtn.setTextSize(15f);
                    reginBtn.setAlpha(0f);
                    reginBtn.animate().alphaBy(0.5f).setDuration(1000).setListener(null);

                }

                @Override
                public void onAnimationCancel(Animator animator) {

                }

                @Override
                public void onAnimationRepeat(Animator animator) {

                }
            });
        }
    };
    private View.OnClickListener rifBtnListener=new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            reqinForm.animate().alphaBy(0.5f).setDuration(500).setListener(new Animator.AnimatorListener() {
                @Override
                public void onAnimationStart(Animator animator) {

                }

                @Override
                public void onAnimationEnd(Animator animator) {
                    reqinForm.setVisibility(View.GONE);
                    genenForm.setVisibility(View.VISIBLE);
                    genenForm.setAlpha(0f);
                    genenForm.animate().alphaBy(1f).setDuration(500).setListener(null);

                    reginBtn.setTextSize(20f);
                    reginBtn.setAlpha(0.5f);
                    reginBtn.animate().alphaBy(1f).setDuration(1000).setListener(null);
                    genenBtn.setTextSize(15f);
                    genenBtn.setAlpha(0f);
                    genenBtn.animate().alphaBy(0.5f).setDuration(1000).setListener(null);
                }

                @Override
                public void onAnimationCancel(Animator animator) {

                }

                @Override
                public void onAnimationRepeat(Animator animator) {

                }
            });
        }
    };
}
