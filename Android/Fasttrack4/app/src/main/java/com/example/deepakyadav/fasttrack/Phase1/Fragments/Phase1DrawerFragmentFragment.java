package com.example.deepakyadav.fasttrack.Phase1.Fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.DialogFragment;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.Toast;

import com.example.deepakyadav.fasttrack.Phase1.Adapters.DrawerAdapter;
import com.example.deepakyadav.fasttrack.Phase1.Data.MenuStaticData;
import com.example.deepakyadav.fasttrack.Phase1.EventListeners.OnItemClickListeners;
import com.example.deepakyadav.fasttrack.R;

public class Phase1DrawerFragmentFragment extends DialogFragment{
    static Phase1DrawerFragmentFragment phase1DrawerFragmentFragment=null;
    FloatingActionButton floatingActionButton;
    ListView listView;
    DrawerAdapter drawerAdapter;

    public Phase1DrawerFragmentFragment() {
    }

    public static Phase1DrawerFragmentFragment getEditNameDialogFragment() {
        if(phase1DrawerFragmentFragment==null){
            phase1DrawerFragmentFragment=new Phase1DrawerFragmentFragment();
        }
        return phase1DrawerFragmentFragment;
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
        return inflater.inflate(R.layout.phase1_drawer, container);
    }
    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        getDialog().getWindow().setWindowAnimations(R.style.dialogAnimation);
        super.onActivityCreated(savedInstanceState);
    }
    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        listView=view.findViewById(R.id.drawerStaticListView_phase1);
        drawerAdapter=new DrawerAdapter(MenuStaticData.getInstance().getMenuListDrawer1(), getActivity());
        listView.setAdapter(drawerAdapter);
        listView.setOnItemClickListener(OnItemClickListeners.getInstance(getActivity()).getDrawerStaticPhasse1ItemClickListener());
        floatingActionButton=view.findViewById(R.id.phase1_drawer_back_btn);
        floatingActionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getDialog().dismiss();
            }
        });
        getDialog().setCanceledOnTouchOutside(true);
        getDialog().getWindow().setGravity(Gravity.BOTTOM);
    }

}
