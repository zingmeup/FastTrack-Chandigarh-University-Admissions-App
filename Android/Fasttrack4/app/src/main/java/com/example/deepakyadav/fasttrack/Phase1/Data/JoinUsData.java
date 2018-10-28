package com.example.deepakyadav.fasttrack.Phase1.Data;

import android.util.Log;

import com.example.deepakyadav.fasttrack.Phase1.DataModels.CityModel;
import com.example.deepakyadav.fasttrack.Phase1.DataModels.ProgramModel;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class JoinUsData {
    private static JoinUsData data=null;
    private List<String> disciplineList;
    private ArrayList<ProgramModel> programList;
    private ArrayList<CityModel> cityList;
    private HashMap<String, String> tempLoginData;

    public HashMap<String, String> getTempLoginData() {
        return tempLoginData;
    }

    public JoinUsData() {
        Log.e("Discipline Adapter","List Created");
        this.disciplineList = new ArrayList<>();
        this.programList = new ArrayList<>();
        this.cityList=new ArrayList<>();
        tempLoginData=new HashMap<>();
        tempLoginData.put("fasttrackid","");
        tempLoginData.put("password","");

    }
    public static JoinUsData getData(){
        if (data==null){
            data=new JoinUsData();
        }
        return data;
    }

    public List<String> getDisciplineList() {
        return disciplineList;
    }

    public ArrayList<ProgramModel> getProgramList() {
        return programList;
    }

    public ArrayList<CityModel> getCityList() {
        return cityList;
    }
    public int getCityCode(int index){
        CityModel e=cityList.get(index);

        return e.getCityId();
    }
    public String getProgramCode(int index){
        ProgramModel e=programList.get(index);

        return e.getProgramCode();
    }
}
