package com.example.deepakyadav.fasttrack.Phase1.Adapters;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.android.volley.toolbox.NetworkImageView;
import com.example.deepakyadav.fasttrack.Phase1.Data.StudentSpeakData;
import com.example.deepakyadav.fasttrack.Phase1.DataModels.StudentSpreakModel;
import com.example.deepakyadav.fasttrack.Phase1.NetworkOperations.VolleyClass;
import com.example.deepakyadav.fasttrack.R;

public class StudentSpeakAdapter extends BaseAdapter {
    LayoutInflater layoutInflater;
    Activity activity;
    public StudentSpeakAdapter(Activity activity){
        this.activity=activity;
        this.layoutInflater=(LayoutInflater)activity.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getCount() {
        return StudentSpeakData.getInstance().getStudentSpeakDataYear().size();
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
            view=layoutInflater.inflate(R.layout.row_studentspreak, null);
        }
        StudentSpreakModel studentSpreakModel=StudentSpeakData.getInstance().getStudentSpeakDataYear().get(i);
        TextView author=view.findViewById(R.id.author);
        NetworkImageView authorimg=view.findViewById(R.id.author_image);
        TextView placed=view.findViewById(R.id.placed);
        TextView rating=view.findViewById(R.id.rating);
        TextView comment=view.findViewById(R.id.comment);
        author.setText(studentSpreakModel.getAuthor());
        authorimg.setImageUrl("http://cuchd.in/"+studentSpreakModel.getImgsrc(), VolleyClass.getInstance(activity).getImageLoader());
        placed.setText(studentSpreakModel.getPlaced());
        rating.setText(String.valueOf(studentSpreakModel.getRating()));
        comment.setText(studentSpreakModel.getComment());
        return view;
    }
}
