package com.example.deepakyadav.fasttrack.Phase1.Adapters;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.deepakyadav.fasttrack.Phase1.Data.FriendFinderData;
import com.example.deepakyadav.fasttrack.Phase1.DataModels.FriendFinderModel;
import com.example.deepakyadav.fasttrack.R;

public class FrinedFinderAdapter extends BaseAdapter {
    Activity activity;
    LayoutInflater inflater;

    public FrinedFinderAdapter(Activity activity) {
        this.activity = activity;
        this.inflater = (LayoutInflater)activity.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getCount() {
        return FriendFinderData.getInstance().getFriendFinderList().size();
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
        FriendFinderModel model= FriendFinderData.getInstance().getFriendFinderList().get(i);
        ViewHolder vh=new ViewHolder();

        if (view==null){
            view=inflater.inflate(R.layout.row_findfrineds, null);
        }
        vh.imageView=view.findViewById(R.id.img);
        vh.textViewName=view.findViewById(R.id.name);
        vh.textViewProgram=view.findViewById(R.id.program);

        //vh.imageView.setImageBitmap(model.getImg());
        vh.textViewName.setText(model.getName());
        vh.textViewProgram.setText(model.getProgram());

        return view;
    }
    private static class ViewHolder{
        ImageView imageView;
        TextView textViewName,textViewProgram;
    }
}
