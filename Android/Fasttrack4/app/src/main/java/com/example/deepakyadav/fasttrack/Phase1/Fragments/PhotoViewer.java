package com.example.deepakyadav.fasttrack.Phase1.Fragments;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.android.volley.toolbox.NetworkImageView;
import com.example.deepakyadav.fasttrack.Phase1.Data.GalleryData;
import com.example.deepakyadav.fasttrack.Phase1.NetworkOperations.VolleyClass;
import com.example.deepakyadav.fasttrack.R;

public class PhotoViewer extends Fragment {
    View inflaterView;
    public static int photoid;
    NetworkImageView networkImageView;
    ImageView prev, next, play;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        inflaterView = inflater.inflate(R.layout.fragment_photoviewer, container, false);
        return inflaterView;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        networkImageView = view.findViewById(R.id.photoviewer_img);
        prev = view.findViewById(R.id.photoviewer_prev);
        play = view.findViewById(R.id.photoviewer_play);
        next = view.findViewById(R.id.photoviewer_next);
        networkImageView.setImageUrl(GalleryData.getInstance().getPhotoGalleryList().get(photoid).getLargeLocation(), VolleyClass.getInstance(getActivity()).getImageLoader());
        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if ((photoid + 1) <= GalleryData.getInstance().getPhotoGalleryList().size()) {
                    networkImageView.setImageUrl(GalleryData.getInstance().getPhotoGalleryList().get(++photoid).getLargeLocation(), VolleyClass.getInstance(getActivity()).getImageLoader());
                }

            }
        });
        prev.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if ((photoid - 1) >= 0) {
                    networkImageView.setImageUrl(GalleryData.getInstance().getPhotoGalleryList().get(--photoid).getLargeLocation(), VolleyClass.getInstance(getActivity()).getImageLoader());
                }
            }
        });
    }
}
