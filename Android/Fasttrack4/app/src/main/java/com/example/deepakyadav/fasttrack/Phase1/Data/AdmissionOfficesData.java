package com.example.deepakyadav.fasttrack.Phase1.Data;

import android.util.Log;

import com.example.deepakyadav.fasttrack.Phase1.DataModels.AdmissionOfficesModel;

import java.util.ArrayList;

public class AdmissionOfficesData {
    private static AdmissionOfficesData admissionOfficesData=null;
    private ArrayList<AdmissionOfficesModel> admissionOfficesList;
    private ArrayList<String> statesList;

    public AdmissionOfficesData(){
        admissionOfficesList=new ArrayList<>();
        statesList=new ArrayList<>();
    }
    public static AdmissionOfficesData getInstance(){
        if(admissionOfficesData==null){
            admissionOfficesData=new AdmissionOfficesData();
        }
        return admissionOfficesData;
    }

    public ArrayList<AdmissionOfficesModel> getAdmissionOfficesList() {
        return admissionOfficesList;
    }

    public ArrayList<String> getStates(){
        return statesList;
    }

    public ArrayList<AdmissionOfficesModel> getByStatesList(String state) {
        ArrayList<AdmissionOfficesModel> bystate=new ArrayList<>();
        for (int i = 0; i <admissionOfficesList.size() ; i++) {
            if(admissionOfficesList.get(i).getStatename().equals(state)){
                bystate.add(admissionOfficesList.get(i));
                Log.e("admissionoffice", "item "+admissionOfficesList.get(i).getCityname());
            }

        }
        return bystate;
    }
}
