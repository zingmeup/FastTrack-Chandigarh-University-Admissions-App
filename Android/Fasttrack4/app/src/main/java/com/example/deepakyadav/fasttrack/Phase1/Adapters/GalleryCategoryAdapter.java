package com.example.deepakyadav.fasttrack.Phase1.Adapters;

import android.app.Activity;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.android.volley.toolbox.NetworkImageView;
import com.example.deepakyadav.fasttrack.Phase1.Data.GalleryData;
import com.example.deepakyadav.fasttrack.Phase1.DataModels.GalleryCategoryModel;
import com.example.deepakyadav.fasttrack.Phase1.NetworkOperations.VolleyClass;
import com.example.deepakyadav.fasttrack.R;

public class GalleryCategoryAdapter extends BaseAdapter {
    private class ViewHolder {
        NetworkImageView networkImageView;
        TextView textView;
    }

    private LayoutInflater layoutInflater;

    public GalleryCategoryAdapter(Activity activity) {
        layoutInflater = activity.getLayoutInflater();
    }

    @Override
    public int getCount() {
        return GalleryData.getInstance().getGalleryCategoryList().size();
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
        GalleryCategoryModel model = GalleryData.getInstance().getGalleryCategoryList().get(i);
        ViewHolder vh = new ViewHolder();
        if (view == null) {
            view = layoutInflater.inflate(R.layout.row_video_gallery_preview, null);
            vh.networkImageView = view.findViewById(R.id.gallery_category_img);
            vh.textView = view.findViewById(R.id.gallery_category_title);

            vh.networkImageView.setImageUrl(model.getVideo_img_url(), VolleyClass.getInstance(layoutInflater.getContext()).getImageLoader());
            vh.textView.setText(model.getName());
            Log.e("fetchGalleryCategory", "view :" + i);
            Log.e("fetchGalleryCategory", model.getName());
        } else {
            vh.networkImageView = view.findViewById(R.id.gallery_category_img);
            vh.textView = view.findViewById(R.id.gallery_category_title);
            vh.networkImageView.setImageUrl(model.getVideo_img_url(), VolleyClass.getInstance(layoutInflater.getContext()).getImageLoader());
            vh.textView.setText(model.getName());
            Log.e("fetchGalleryCategory", "view :" + i);
            Log.e("fetchGalleryCategory", model.getName());
        }
        return view;
    }
}
