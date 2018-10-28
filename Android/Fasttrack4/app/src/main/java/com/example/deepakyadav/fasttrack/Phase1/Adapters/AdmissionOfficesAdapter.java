package com.example.deepakyadav.fasttrack.Phase1.Adapters;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.support.v4.app.FragmentActivity;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.deepakyadav.fasttrack.Phase1.Data.AdmissionOfficesData;
import com.example.deepakyadav.fasttrack.Phase1.DataModels.AdmissionOfficesModel;
import com.example.deepakyadav.fasttrack.R;

public class AdmissionOfficesAdapter extends BaseAdapter {
    Activity callingActivity;
    LayoutInflater layoutInflater;
    String selectedState;


    public AdmissionOfficesAdapter(FragmentActivity activity, String all) {

        Log.d("admissionoffice", "Adapter constructed");
        this.callingActivity = activity;
        this.layoutInflater = (LayoutInflater) callingActivity.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        this.selectedState=all;
    }

    @Override
    public int getCount() {
        return AdmissionOfficesData.getInstance().getByStatesList(selectedState).size();
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
        final ViewHolder v=new ViewHolder();
        if(view==null){
            view=layoutInflater.inflate(R.layout.row_admission_offices, null);
        }
        v.name=view.findViewById(R.id.nearby_name);
        v.address=view.findViewById(R.id.nearby_address);
        v.city=view.findViewById(R.id.nearby_city);
        v.phone1=view.findViewById(R.id.nearby_phone1);
        v.phone2=view.findViewById(R.id.nearby_phone2);
        v.directions=view.findViewById(R.id.nearby_direction);
        AdmissionOfficesModel model=AdmissionOfficesData.getInstance().getByStatesList(selectedState).get(i);
        v.name.setText(model.getEmpname());
        v.address.setText(model.getAddress());
        v.city.setText(model.getCityname());
        v.phone1.setText(model.getPhone1());
        v.phone2.setText(model.getPhone2());
        v.phone1.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                callingActivity.startActivity(new Intent(Intent.ACTION_DIAL, Uri.parse("tel:" + v.phone1.getText().toString())));
                }
        });
        v.phone2.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    callingActivity.startActivity(new Intent(Intent.ACTION_DIAL, Uri.parse("tel:"+v.phone2.getText().toString())));
                }
        });
        v.directions.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String preparedAddress=v.address.getText().toString()+" "+v.city.getText().toString()+" "+selectedState;
                preparedAddress=preparedAddress.replace(" ","+");
                callingActivity.startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("https://maps.google.com/?q="+preparedAddress)));
            }
        });

        return view;
    }

    private class ViewHolder{
        TextView city,address, name, phone1,phone2;
        View directions;
    }
}
