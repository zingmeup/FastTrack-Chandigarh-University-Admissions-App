package com.example.deepakyadav.fasttrack.Phase1.EventListeners;

import android.app.Activity;
import android.content.Intent;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Toast;

import com.example.deepakyadav.fasttrack.Phase1.Activities.Main2Activity;
import com.example.deepakyadav.fasttrack.Phase1.Data.GalleryData;
import com.example.deepakyadav.fasttrack.Phase1.Data.MenuData;
import com.example.deepakyadav.fasttrack.Phase1.Data.MenuStaticData;
import com.example.deepakyadav.fasttrack.Phase1.DataModels.GalleryCategoryModel;
import com.example.deepakyadav.fasttrack.Phase1.DataModels.MenuModel;
import com.example.deepakyadav.fasttrack.Phase1.Fragments.Phase1DrawerFragmentFragment;
import com.example.deepakyadav.fasttrack.Phase1.Fragments.Phase2DrawerFragment;

public class OnItemClickListeners {
    private static Activity callingActivity;
    private static OnItemClickListeners onItemClickListeners;

    private AdapterView.OnItemClickListener drawerStaticPhasse1ItemClickListener=new AdapterView.OnItemClickListener() {
        @Override
        public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
            if(Phase1DrawerFragmentFragment.getEditNameDialogFragment().isVisible()){
                Phase1DrawerFragmentFragment.getEditNameDialogFragment().dismiss();
            }else if(Phase2DrawerFragment.getPhase2DrawerFragment().isVisible()){
                Phase2DrawerFragment.getPhase2DrawerFragment().dismiss();
            }
            MenuModel menuModel=MenuStaticData.getInstance().getMenuListDrawer1().get(i);
            Intent intent=new Intent(callingActivity,Main2Activity.class);
            Log.e("onItemclick", menuModel.getTitle());
            if(menuModel.isIswebView()){
                intent.putExtra("title", menuModel.getTitle());
                intent.putExtra("isWebView", true);
                intent.putExtra("isNative", false);
                intent.putExtra("Url", menuModel.getUrl());
            }else{
                intent.putExtra("title", menuModel.getTitle());
                intent.putExtra("isNative", true);
                intent.putExtra("isWebView", false);
                intent.putExtra("Fragment", menuModel.getFragmentName());


            }
            callingActivity.startActivity(intent);


        }
    };
    private AdapterView.OnItemClickListener drawerStaticPhasse2ItemClickListener=new AdapterView.OnItemClickListener() {
        @Override
        public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
            if(Phase1DrawerFragmentFragment.getEditNameDialogFragment().isVisible()){
                Phase1DrawerFragmentFragment.getEditNameDialogFragment().dismiss();
            }else if(Phase2DrawerFragment.getPhase2DrawerFragment().isVisible()){
                Phase2DrawerFragment.getPhase2DrawerFragment().dismiss();
            }
            MenuModel menuModel=MenuStaticData.getInstance().getMenuListDrawer2().get(i);
            Intent intent=new Intent(callingActivity,Main2Activity.class);
            Log.e("onItemclick", menuModel.getTitle());
            if(menuModel.isIswebView()){
                intent.putExtra("title", menuModel.getTitle());
                intent.putExtra("isWebView", true);
                intent.putExtra("isNative", false);
                intent.putExtra("Url", menuModel.getUrl());
            }else{
                intent.putExtra("title", menuModel.getTitle());
                intent.putExtra("isNative", true);
                intent.putExtra("isWebView", false);
                intent.putExtra("Fragment", menuModel.getFragmentName());


            }
            callingActivity.startActivity(intent);


        }
    };
    private AdapterView.OnItemClickListener drawerDynamicPhasse2ItemClickListener=new AdapterView.OnItemClickListener() {
        @Override
        public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
            if(Phase1DrawerFragmentFragment.getEditNameDialogFragment().isVisible()){
                Phase1DrawerFragmentFragment.getEditNameDialogFragment().dismiss();
            }else if(Phase2DrawerFragment.getPhase2DrawerFragment().isVisible()){
                Phase2DrawerFragment.getPhase2DrawerFragment().dismiss();
            }
            MenuModel menuModel= MenuData.getInstance().getMenuList().get(i);
            Intent intent=new Intent(callingActivity,Main2Activity.class);
            Log.e("onItemclick", menuModel.getTitle());
            if(menuModel.isIswebView()){
                intent.putExtra("title", menuModel.getTitle());
                intent.putExtra("isWebView", true);
                intent.putExtra("isNative", false);
                intent.putExtra("Url", menuModel.getUrl());
            }else{
                intent.putExtra("title", menuModel.getTitle());
                intent.putExtra("isNative", true);
                intent.putExtra("isWebView", false);
                intent.putExtra("Fragment", menuModel.getFragmentName());


            }
            callingActivity.startActivity(intent);


        }
    };

    public OnItemClickListeners() {
    }
    public static OnItemClickListeners getInstance(Activity activity){
        if(onItemClickListeners==null){
            onItemClickListeners=new OnItemClickListeners();
        }
        callingActivity=activity;
        return  onItemClickListeners;
    }

    public AdapterView.OnItemClickListener getDrawerStaticPhasse1ItemClickListener() {
        return drawerStaticPhasse1ItemClickListener;
    }

    public AdapterView.OnItemClickListener getDrawerStaticPhasse2ItemClickListener() {
        return drawerStaticPhasse2ItemClickListener;
    }

    public AdapterView.OnItemClickListener getDrawerDynamicPhasse2ItemClickListener() {
        return drawerDynamicPhasse2ItemClickListener;
    }
}
