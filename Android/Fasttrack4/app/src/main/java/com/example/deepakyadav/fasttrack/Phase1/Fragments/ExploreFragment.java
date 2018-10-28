package com.example.deepakyadav.fasttrack.Phase1.Fragments;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.deepakyadav.fasttrack.Phase1.Data.ExploreFloatsData;
import com.example.deepakyadav.fasttrack.Phase1.EventListeners.OnCLickListeners;
import com.example.deepakyadav.fasttrack.R;

public class ExploreFragment extends Fragment {
    public View inflatedView;
    TextView tv,tvInfo;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        inflatedView=inflater.inflate(R.layout.fragment_explore, container, false);
        return inflatedView;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        int[] views={R.id.infra_1,R.id.infra_2,R.id.infra_3,R.id.infra_4,R.id.infra_5,
                R.id.infra_6,R.id.infra_7,R.id.infra_8,R.id.infra_9,R.id.infra_10};
        for (int i = 0; i <views.length ; i++) {
            tv = view.findViewById(views[i]);
            tv.setText(ExploreFloatsData.getInstance().getExploreFloatsList().get(i).getTitle());
            tv.setOnClickListener(OnCLickListeners.getInstance(getActivity()).getExploreFloatsOnCLickListener());
        }


    }
}
