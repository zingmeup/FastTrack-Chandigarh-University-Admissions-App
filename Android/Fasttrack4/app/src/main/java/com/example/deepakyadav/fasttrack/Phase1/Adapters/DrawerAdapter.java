package com.example.deepakyadav.fasttrack.Phase1.Adapters;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.example.deepakyadav.fasttrack.Phase1.DataModels.MenuModel;
import com.example.deepakyadav.fasttrack.R;

import java.util.ArrayList;

public class DrawerAdapter extends BaseAdapter implements View.OnClickListener {
    ArrayList<MenuModel> drawerModelArrayList;
    LayoutInflater layoutInflater;
    Activity activity;

    public DrawerAdapter(ArrayList<MenuModel> drawerModelArrayList, Activity activity) {
        this.layoutInflater= (LayoutInflater) activity.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        this.drawerModelArrayList = drawerModelArrayList;
        this.layoutInflater = layoutInflater;
        this.activity = activity;
    }

    @Override
    public void onClick(View view) {

    }

    @Override
    public int getCount() {
        return drawerModelArrayList.size();
    }

    @Override
    public Object getItem(int i) {
        return i;
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        if(view==null){
            view=layoutInflater.inflate(R.layout.phase1_drawer_row, null);
        }
        TextView title=view.findViewById(R.id.listtextview);
        ImageView icon=view.findViewById(R.id.listicon);
        MenuModel menuModel=drawerModelArrayList.get(i);
        title.setText(menuModel.getTitle());
        icon.setImageDrawable(activity.getResources().getDrawable(menuModel.getImageId()));
        return view;
    }
}
