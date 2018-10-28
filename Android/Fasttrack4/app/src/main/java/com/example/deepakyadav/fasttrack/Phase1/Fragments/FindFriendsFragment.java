package com.example.deepakyadav.fasttrack.Phase1.Fragments;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.example.deepakyadav.fasttrack.Phase1.Adapters.FrinedFinderAdapter;
import com.example.deepakyadav.fasttrack.R;

public class FindFriendsFragment extends Fragment {
    View view;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view=inflater.inflate(R.layout.fragment_findfriends, container, false);;
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        ListView listview=view.findViewById(R.id.findfriend_listView);
        FrinedFinderAdapter frinedFinderAdapter=new FrinedFinderAdapter(getActivity());
        listview.setAdapter(frinedFinderAdapter);
    }
}
