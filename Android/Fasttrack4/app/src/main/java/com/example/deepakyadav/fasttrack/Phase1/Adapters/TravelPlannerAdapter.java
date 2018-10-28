package com.example.deepakyadav.fasttrack.Phase1.Adapters;

import android.app.Activity;
import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.android.volley.toolbox.NetworkImageView;
import com.example.deepakyadav.fasttrack.Phase1.Data.TravelPlannerData;
import com.example.deepakyadav.fasttrack.Phase1.DataModels.TravellPlannerModel;
import com.example.deepakyadav.fasttrack.Phase1.NetworkOperations.NetworkOperations;
import com.example.deepakyadav.fasttrack.Phase1.NetworkOperations.VolleyClass;
import com.example.deepakyadav.fasttrack.R;

public class TravelPlannerAdapter extends BaseAdapter{
    Activity callingActivity;
    LayoutInflater layoutInflater;
    public TravelPlannerAdapter(Activity callingActivity){
        this.callingActivity=callingActivity;
        this.layoutInflater=(LayoutInflater) callingActivity.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }


    @Override
    public int getCount() {
        Log.e("travelplanner-count",TravelPlannerData.getInstance().getTravellPlannerList().size()+"");
        return TravelPlannerData.getInstance().getTravellPlannerList().size();
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
        ViewHolder v=new ViewHolder();
        Log.e("travelplanner-getView",i+"");

        if (view==null){
            view=layoutInflater.inflate(R.layout.row_travelplaces, null);
        }
        v.name=view.findViewById(R.id.travel_row__name);
        v.info=view.findViewById(R.id.travel_row__info);
        v.timing=view.findViewById(R.id.travel_row__timing);
        v.back=view.findViewById(R.id.travel_row__back);
        v.album1=view.findViewById(R.id.img1);
        v.album2=view.findViewById(R.id.img2);
        v.album3=view.findViewById(R.id.img3);
        v.album4=view.findViewById(R.id.img4);
        v.album5=view.findViewById(R.id.img5);
        v.knowmore=view.findViewById(R.id.knowmore);
        v.showonmaps=view.findViewById(R.id.maps);
        TravellPlannerModel model=TravelPlannerData.getInstance().getTravellPlannerList().get(i);

        v.name.setText(model.getName());
        v.info.setText(model.getInfo1()+model.getInfo2());
        v.timing.setText(model.getTimeopen()+"-"+model.getTimeclore());
        v.back.setImageUrl(model.getBackimgsrc(), VolleyClass.getInstance(callingActivity).getImageLoader());
        v.album1.setImageUrl(model.getAlbum()[0], VolleyClass.getInstance(callingActivity).getImageLoader());
        v.album2.setImageUrl(model.getAlbum()[1], VolleyClass.getInstance(callingActivity).getImageLoader());
        v.album3.setImageUrl(model.getAlbum()[2], VolleyClass.getInstance(callingActivity).getImageLoader());
        v.album4.setImageUrl(model.getAlbum()[3], VolleyClass.getInstance(callingActivity).getImageLoader());
        v.album5.setImageUrl(model.getAlbum()[4], VolleyClass.getInstance(callingActivity).getImageLoader());
        return view;
    }
    private class ViewHolder{
        NetworkImageView back,album1,album2,album3,album4,album5;
        TextView name, info,timing,knowmore,showonmaps;


    }
}
