package com.example.deepakyadav.fasttrack.Phase1.DataModels;

public class TravellPlannerModel {
    String name, backimgsrc,  info1, info2, redirectUrl;
    String[] album;
    double lat,lon;
    int timeopen, timeclore;

    public TravellPlannerModel(String name, String backimgsrc, int timeopen, int timeclore, String info1, String info2, String redirectUrl, String[] album, double lat, double lon) {
        this.name = name;
        this.backimgsrc = backimgsrc;
        this.timeopen = timeopen;
        this.timeclore = timeclore;
        this.info1 = info1;
        this.info2 = info2;
        this.redirectUrl = redirectUrl;
        this.album = album;
        this.lat = lat;
        this.lon = lon;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBackimgsrc() {
        return backimgsrc;
    }

    public void setBackimgsrc(String backimgsrc) {
        this.backimgsrc = backimgsrc;
    }

    public int getTimeopen() {
        return timeopen;
    }

    public void setTimeopen(int timeopen) {
        this.timeopen = timeopen;
    }

    public int getTimeclore() {
        return timeclore;
    }

    public void setTimeclore(int timeclore) {
        this.timeclore = timeclore;
    }

    public String getInfo1() {
        return info1;
    }

    public void setInfo1(String info1) {
        this.info1 = info1;
    }

    public String getInfo2() {
        return info2;
    }

    public void setInfo2(String info2) {
        this.info2 = info2;
    }

    public String getRedirectUrl() {
        return redirectUrl;
    }

    public void setRedirectUrl(String redirectUrl) {
        this.redirectUrl = redirectUrl;
    }

    public String[] getAlbum() {
        return album;
    }

    public void setAlbum(String[] album) {
        this.album = album;
    }

    public double getLat() {
        return lat;
    }

    public void setLat(double lat) {
        this.lat = lat;
    }

    public double getLon() {
        return lon;
    }

    public void setLon(double lon) {
        this.lon = lon;
    }
}
