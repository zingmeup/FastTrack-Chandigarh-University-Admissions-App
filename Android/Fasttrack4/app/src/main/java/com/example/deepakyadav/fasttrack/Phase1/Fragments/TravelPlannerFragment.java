package com.example.deepakyadav.fasttrack.Phase1.Fragments;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.example.deepakyadav.fasttrack.Phase1.Adapters.TravelPlannerAdapter;
import com.example.deepakyadav.fasttrack.Phase1.Data.TravelPlannerData;
import com.example.deepakyadav.fasttrack.Phase1.NetworkOperations.NetworkOperations;
import com.example.deepakyadav.fasttrack.R;

public class TravelPlannerFragment extends Fragment {
    public static View inflatedView,detailsCard;
    ListView listView;
    EditText searchCity;
    ImageView searchBtn;
    public static TextView name,aita,distance;
    public static TravelPlannerAdapter travelPlannerAdapter;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        inflatedView=inflater.inflate(R.layout.fragment_travelplanner, container, false);
        return inflatedView;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        detailsCard=view.findViewById(R.id.travel_details);
        detailsCard.setVisibility(View.GONE);
        name=view.findViewById(R.id.travel_details_name);
        distance=view.findViewById(R.id.travel_details_distance);
        aita=view.findViewById(R.id.travel_details_AITA);
        searchCity=view.findViewById(R.id.travel_searchET);
        searchBtn=view.findViewById(R.id.travel_searchBtn);
        listView=view.findViewById(R.id.travelplanner_listView);
        travelPlannerAdapter=new TravelPlannerAdapter(getActivity());
        listView.setAdapter(travelPlannerAdapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                if (view.getId()==R.id.knowmore){
                    startActivity(new Intent(Intent.ACTION_VIEW,Uri.parse(TravelPlannerData.getInstance().getTravellPlannerList().get(i).getRedirectUrl())));
                }else if(view.getId()==R.id.maps){
                    startActivity(new Intent(Intent.ACTION_VIEW,Uri.parse("geo:"+TravelPlannerData.getInstance().getTravellPlannerList().get(i).getLat()+TravelPlannerData.getInstance().getTravellPlannerList().get(i).getLon())));
                }
            }
        });
        searchBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (!(searchCity.getText().toString().equals(""))){
                        NetworkOperations.getInstance().fetchDistance(getActivity(), searchCity.getText().toString());
                    }
            }
        });
    }

    public View getDetailsCard() {
        return detailsCard;
    }

    public TextView getName() {
        return name;
    }

    public TextView getAita() {
        return aita;
    }

    public TextView getDistance() {
        return distance;
    }

    @Override
    public void onResume() {
        super.onResume();
        NetworkOperations.getInstance().fetchTravelPlanner(getActivity(),"");
    }
}
