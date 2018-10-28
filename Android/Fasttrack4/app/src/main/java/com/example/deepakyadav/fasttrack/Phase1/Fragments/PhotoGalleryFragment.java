package com.example.deepakyadav.fasttrack.Phase1.Fragments;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import com.example.deepakyadav.fasttrack.Phase1.Adapters.GalleryCategoryAdapter;
import com.example.deepakyadav.fasttrack.Phase1.Data.GalleryData;
import com.example.deepakyadav.fasttrack.Phase1.DataModels.GalleryCategoryModel;
import com.example.deepakyadav.fasttrack.Phase1.NetworkOperations.NetworkOperations;
import com.example.deepakyadav.fasttrack.R;

public class PhotoGalleryFragment extends Fragment {
    FragmentManager fragmentManager;
    FragmentTransaction fragmentTransaction;
    PhotoListFragment photoListFragment;

    private AdapterView.OnItemClickListener GalleryCategoryItemClickListener= new AdapterView.OnItemClickListener() {
        @Override
        public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
            GalleryCategoryModel model= GalleryData.getInstance().getGalleryCategoryList().get(i);
            Toast.makeText(getActivity(), model.getName(), Toast.LENGTH_SHORT).show();
            fragmentTransaction=fragmentManager.beginTransaction();
            NetworkOperations.getInstance().fetchPhotoGallery(getActivity(), model.getTag());
            fragmentTransaction.replace(R.id.fragment_container_main2activity, photoListFragment);
            fragmentTransaction.addToBackStack("photo");
            fragmentTransaction.commit();
        }
    };
    public View inflatedView;
    ListView listView;
    public static GalleryCategoryAdapter galleryCategoryAdapter;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        inflatedView=inflater.inflate(R.layout.fragment_videogallery, container, false);
        Log.i("photoGallery-fragment", "onCreateView");
        return inflatedView;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        Log.i("photoGallery-fragment", "onViewCreated");
        fragmentManager=getActivity().getSupportFragmentManager();
        photoListFragment=new PhotoListFragment();
        listView=view.findViewById(R.id.gallery_category_listview);
        galleryCategoryAdapter=new GalleryCategoryAdapter(getActivity());
        listView.setAdapter(galleryCategoryAdapter);
        galleryCategoryAdapter.notifyDataSetChanged();
        listView.setOnItemClickListener(GalleryCategoryItemClickListener);
    }

}

