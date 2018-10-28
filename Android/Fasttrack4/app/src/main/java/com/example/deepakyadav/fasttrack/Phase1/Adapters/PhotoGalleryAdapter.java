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
import com.example.deepakyadav.fasttrack.Phase1.DataModels.PhotoGalleryModel;
import com.example.deepakyadav.fasttrack.Phase1.DataModels.VideoGalleryModel;
import com.example.deepakyadav.fasttrack.Phase1.NetworkOperations.VolleyClass;
import com.example.deepakyadav.fasttrack.R;

public class PhotoGalleryAdapter extends BaseAdapter {
    private LayoutInflater layoutInflater;
    private class ViewHolder{
        NetworkImageView networkImageView;

    }
    public PhotoGalleryAdapter(Activity activity){
        layoutInflater=activity.getLayoutInflater();

    }
    @Override
    public int getCount() {
        return GalleryData.getInstance().getPhotoGalleryList().size();
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
        PhotoGalleryModel model=GalleryData.getInstance().getPhotoGalleryList().get(i);
        ViewHolder vh=new ViewHolder();
        if (view==null){
            view=layoutInflater.inflate(R.layout.row_photo_gallery,null);
        }
        vh.networkImageView=view.findViewById(R.id.gallery_photo);
        //
        vh.networkImageView.setImageUrl(model.getThumbLocation(), VolleyClass.getInstance(layoutInflater.getContext()).getImageLoader());
        return view;
    }
}
