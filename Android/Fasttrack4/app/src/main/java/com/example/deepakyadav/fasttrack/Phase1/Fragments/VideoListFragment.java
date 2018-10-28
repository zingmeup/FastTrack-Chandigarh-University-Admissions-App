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
import android.widget.ListView;
import android.widget.Toast;

import com.example.deepakyadav.fasttrack.Phase1.Adapters.GalleryCategoryAdapter;
import com.example.deepakyadav.fasttrack.Phase1.Adapters.VideoGalleryAdapter;
import com.example.deepakyadav.fasttrack.Phase1.Data.GalleryData;
import com.example.deepakyadav.fasttrack.Phase1.DataModels.GalleryCategoryModel;
import com.example.deepakyadav.fasttrack.Phase1.DataModels.VideoGalleryModel;
import com.example.deepakyadav.fasttrack.Phase1.NetworkOperations.NetworkOperations;
import com.example.deepakyadav.fasttrack.R;

public class VideoListFragment extends Fragment {
    FragmentManager fragmentManager;
    FragmentTransaction fragmentTransaction;
    VideoPlayerFragment videoPlayerFragment;
    private AdapterView.OnItemClickListener GalleryVideoItemClickListener= new AdapterView.OnItemClickListener() {
        @Override
        public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
            VideoGalleryModel model= GalleryData.getInstance().getVideoGalleryList().get(i);
            Toast.makeText(getActivity(), model.getTitle(), Toast.LENGTH_SHORT).show();
           fragmentTransaction=fragmentManager.beginTransaction();
           videoPlayerFragment=new VideoPlayerFragment();
           videoPlayerFragment.url=model.getVideoUrl();
            fragmentTransaction.replace(R.id.fragment_container_main2activity, videoPlayerFragment);
            fragmentTransaction.addToBackStack("video");
            fragmentTransaction.commit();
        }
    };
    public View inflatedView;
    ListView listView;
    public static VideoGalleryAdapter videoGalleryAdapter;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        inflatedView=inflater.inflate(R.layout.fragment_videogallery, container, false);
        return inflatedView;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        listView=view.findViewById(R.id.gallery_category_listview);
        videoGalleryAdapter=new VideoGalleryAdapter(getActivity());
        listView.setAdapter(videoGalleryAdapter);
        listView.setOnItemClickListener(GalleryVideoItemClickListener);
        fragmentManager=getActivity().getSupportFragmentManager();

    }

}
