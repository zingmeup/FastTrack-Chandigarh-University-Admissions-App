package com.example.deepakyadav.fasttrack.Phase1.Data;

import com.example.deepakyadav.fasttrack.Phase1.DataModels.TravellPlannerModel;

import java.util.ArrayList;

public class TravelPlannerData {
    private static TravelPlannerData travelPlannerData;
    private ArrayList<TravellPlannerModel> travellPlannerList;
    int distance;
    String airportname, airportaiat;

    public TravelPlannerData(){
        travellPlannerList=new ArrayList<>();
    }

    public static TravelPlannerData getInstance() {
        if (travelPlannerData==null){
            travelPlannerData=new TravelPlannerData();
        }
        return travelPlannerData;
    }


    public ArrayList<TravellPlannerModel> getTravellPlannerList() {
        return travellPlannerList;
    }

    public void setTravellPlannerList(ArrayList<TravellPlannerModel> travellPlannerList) {
        this.travellPlannerList = travellPlannerList;
    }

    public int getDistance() {
        return distance;
    }

    public String getAirportname() {
        return airportname;
    }

    public String getAirportaiat() {
        return airportaiat;
    }

    public void setDistance(int distance) {
        this.distance = distance;
    }

    public void setAirportname(String airportname) {
        this.airportname = airportname;
    }

    public void setAirportaiat(String airportaiat) {
        this.airportaiat = airportaiat;
    }
}
