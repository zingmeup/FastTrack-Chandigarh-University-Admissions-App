package com.example.deepakyadav.fasttrack.Phase1.Data;

import com.example.deepakyadav.fasttrack.Phase1.DataModels.CourseBrowserModel;

import java.util.ArrayList;

public class CourseBrowserData {
    private static CourseBrowserData courseBrowserData=null;
    ArrayList<CourseBrowserModel> courseBrowserList;

    public CourseBrowserData(){
        courseBrowserList=new ArrayList<>();
    }

    public static CourseBrowserData getInstance(){
        if (courseBrowserData==null){
            courseBrowserData=new CourseBrowserData();
        }
        return courseBrowserData;
    }

    public ArrayList<CourseBrowserModel> getCourseBrowserList() {
        return courseBrowserList;
    }
    public ArrayList<String> getSearchText(){
        ArrayList<String> searchtext=new ArrayList<>();
        for (int i = 0; i <courseBrowserList.size() ; i++) {
            searchtext.add(courseBrowserList.get(i).getSearchtext());
        }
        return searchtext;
    }
}
