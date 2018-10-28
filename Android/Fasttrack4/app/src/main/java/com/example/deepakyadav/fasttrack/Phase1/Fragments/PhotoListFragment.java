package com.example.deepakyadav.fasttrack.Phase1.Fragments;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.ListView;
import android.widget.Toast;

import com.example.deepakyadav.fasttrack.Phase1.Adapters.PhotoGalleryAdapter;
import com.example.deepakyadav.fasttrack.Phase1.Adapters.VideoGalleryAdapter;
import com.example.deepakyadav.fasttrack.Phase1.Data.GalleryData;
import com.example.deepakyadav.fasttrack.Phase1.DataModels.VideoGalleryModel;
import com.example.deepakyadav.fasttrack.R;

public class PhotoListFragment extends Fragment {
    FragmentManager fragmentManager;
    FragmentTransaction fragmentTransaction;
    PhotoViewer photoViewer;
    private AdapterView.OnItemClickListener GalleryPhotoItemClickListener = new AdapterView.OnItemClickListener() {

        @Override
        public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
            PhotoViewer.photoid = i;
            fragmentTransaction = fragmentManager.beginTransaction();
            fragmentTransaction.replace(R.id.fragment_container_main2activity, photoViewer);
            fragmentTransaction.addToBackStack("photo");
            fragmentTransaction.commit();
        }
    };
    public View inflatedView;
    GridView listView;
    public static PhotoGalleryAdapter photoGalleryAdapter;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        inflatedView = inflater.inflate(R.layout.fragment_gallery_grid, container, false);
        return inflatedView;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        photoViewer = new PhotoViewer();
        listView = view.findViewById(R.id.gallery_category_listview);
        photoGalleryAdapter = new PhotoGalleryAdapter(getActivity());
        listView.setAdapter(photoGalleryAdapter);
        listView.setOnItemClickListener(GalleryPhotoItemClickListener);
        fragmentManager = getActivity().getSupportFragmentManager();

    }

}
