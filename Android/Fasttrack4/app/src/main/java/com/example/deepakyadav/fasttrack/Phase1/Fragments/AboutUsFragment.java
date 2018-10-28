package com.example.deepakyadav.fasttrack.Phase1.Fragments;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.deepakyadav.fasttrack.R;

public class AboutUsFragment extends Fragment {
    View viewOnGoogleMaps;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_aboutus, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        viewOnGoogleMaps=view.findViewById(R.id.aboutus_viewongoogle);
        viewOnGoogleMaps.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    Uri location = Uri.parse("geo:30.770584,76.577860");
                    Intent i = new Intent(Intent.ACTION_VIEW, location);
                    i.setPackage("com.google.android.apps.maps");
                    startActivity(i);
                }catch (Exception e){

                }
            }
        });
    }
}
