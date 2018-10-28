package com.example.deepakyadav.fasttrack.Phase1.DataModels;

public class AdmissionOfficesModel {
    String cityname, statename,address,empname,phone1,phone2;

    public AdmissionOfficesModel(String cityname, String statename, String address, String empname, String phone1, String phone2) {
        this.cityname = cityname;
        this.statename = statename;
        this.address = address;
        this.empname = empname;
        this.phone1 = phone1;
        this.phone2 = phone2;
    }

    public String getCityname() {
        return cityname;
    }

    public void setCityname(String cityname) {
        this.cityname = cityname;
    }

    public String getStatename() {
        return statename;
    }

    public void setStatename(String statename) {
        this.statename = statename;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getEmpname() {
        return empname;
    }

    public void setEmpname(String empname) {
        this.empname = empname;
    }

    public String getPhone1() {
        return phone1;
    }

    public void setPhone1(String phone1) {
        this.phone1 = phone1;
    }

    public String getPhone2() {
        return phone2;
    }

    public void setPhone2(String phone2) {
        this.phone2 = phone2;
    }
}
