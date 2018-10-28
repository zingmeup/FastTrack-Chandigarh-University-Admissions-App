package com.example.deepakyadav.fasttrack.Phase1.Fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.DialogFragment;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.example.deepakyadav.fasttrack.Phase1.Adapters.DrawerAdapter;
import com.example.deepakyadav.fasttrack.Phase1.Data.MenuData;
import com.example.deepakyadav.fasttrack.Phase1.Data.MenuStaticData;
import com.example.deepakyadav.fasttrack.Phase1.EventListeners.OnItemClickListeners;
import com.example.deepakyadav.fasttrack.R;

public class Phase2DrawerFragment extends DialogFragment{
    static Phase2DrawerFragment phase2DrawerFragment=null;
    FloatingActionButton floatingActionButton;
    ListView listView,listViewExplore;
    DrawerAdapter drawerAdapter,drawerExploreAdapter;

    public Phase2DrawerFragment() {
    }

    public static Phase2DrawerFragment getPhase2DrawerFragment() {
        if(phase2DrawerFragment==null){
            phase2DrawerFragment=new Phase2DrawerFragment();
        }
        return phase2DrawerFragment;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setEnterTransition(android.R.anim.slide_in_left);
        setExitTransition(android.R.anim.slide_out_right);
        setStyle(DialogFragment.STYLE_NO_TITLE, R.style.customDialog);
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.phase2_drawer, container);
    }
    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        getDialog().getWindow().setWindowAnimations(R.style.dialogAnimation);
        super.onActivityCreated(savedInstanceState);
    }
    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        listView=view.findViewById(R.id.drawerListView_phase2);
        listViewExplore=view.findViewById(R.id.phase2_drawer_explore_listView);
        drawerAdapter=new DrawerAdapter(MenuData.getInstance().getMenuList(), getActivity());
        drawerExploreAdapter=new DrawerAdapter(MenuStaticData.getInstance().getMenuListDrawer2(),getActivity());
        floatingActionButton=view.findViewById(R.id.phase2_drawer_back_btn);
        floatingActionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getDialog().dismiss();
            }
        });
        getDialog().setCanceledOnTouchOutside(true);
        getDialog().getWindow().setGravity(Gravity.BOTTOM);
        listView.setAdapter(drawerAdapter);
        listView.setOnItemClickListener(OnItemClickListeners.getInstance(getActivity()).getDrawerDynamicPhasse2ItemClickListener());
        listViewExplore.setAdapter(drawerExploreAdapter);
        listViewExplore.setOnItemClickListener(OnItemClickListeners.getInstance(getActivity()).getDrawerStaticPhasse2ItemClickListener());

    }

}
