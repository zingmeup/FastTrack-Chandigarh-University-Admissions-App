package com.example.deepakyadav.fasttrack.Phase1.Data;

import com.example.deepakyadav.fasttrack.Phase1.DataModels.StudentSpreakModel;

import java.util.ArrayList;

public class StudentSpeakData {
    private static StudentSpeakData studentSpeakData=null;
    private ArrayList<StudentSpreakModel> studentSpeakDataList;
    private ArrayList<StudentSpreakModel> studentSpeakDataYear;
    public StudentSpeakData(){
        studentSpeakDataList=new ArrayList<>();
        studentSpeakDataYear=new ArrayList<>();
    }
    public static StudentSpeakData getInstance() {
        if (studentSpeakData==null){
            studentSpeakData=new StudentSpeakData();
        }
        return studentSpeakData;
    }



    public ArrayList<StudentSpreakModel> getStudentSpeakDataList() {
        return studentSpeakDataList;
    }

    public void setStudentSpeakDataList(ArrayList<StudentSpreakModel> studentSpeakDataList) {
        this.studentSpeakDataList = studentSpeakDataList;
    }

    public ArrayList<StudentSpreakModel> yearWise(int year){
        studentSpeakDataYear.clear();
        for (int i = 0; i <studentSpeakDataList.size() ; i++) {
            StudentSpreakModel model=studentSpeakDataList.get(i);
            if(model.getYear()==year){
                studentSpeakDataYear.add(model);
            }
        }

       return studentSpeakDataYear;
    }

    public ArrayList<StudentSpreakModel> getStudentSpeakDataYear() {
        return studentSpeakDataYear;
    }
}
