package com.example.deepakyadav.fasttrack.Phase1.Adapters;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.android.volley.toolbox.NetworkImageView;
import com.example.deepakyadav.fasttrack.Phase1.Data.GalleryData;
import com.example.deepakyadav.fasttrack.Phase1.DataModels.VideoGalleryModel;
import com.example.deepakyadav.fasttrack.Phase1.NetworkOperations.VolleyClass;
import com.example.deepakyadav.fasttrack.R;

public class VideoGalleryAdapter extends BaseAdapter {
    private LayoutInflater layoutInflater;
    private class ViewHolder{
        NetworkImageView networkImageView;
        TextView title,description;
        ImageView share,play;

    }
    public VideoGalleryAdapter(Activity activity){
        layoutInflater=activity.getLayoutInflater();

    }
    @Override
    public int getCount() {
        return GalleryData.getInstance().getVideoGalleryList().size();
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
        VideoGalleryModel model=GalleryData.getInstance().getVideoGalleryList().get(i);
        ViewHolder vh=new ViewHolder();
        if (view==null){
            view=layoutInflater.inflate(R.layout.row_videogallery,null);
        }
        vh.networkImageView=view.findViewById(R.id.video_image);
        vh.title=view.findViewById(R.id.video_title);
        vh.description=view.findViewById(R.id.video_description);
        vh.play=view.findViewById(R.id.video_play);
        vh.share=view.findViewById(R.id.video_share);
        //
        vh.networkImageView.setImageUrl(model.getImg(), VolleyClass.getInstance(layoutInflater.getContext()).getImageLoader());
        vh.title.setText(model.getTitle());
        vh.description.setText(model.getDescription());
        return view;
    }
}
