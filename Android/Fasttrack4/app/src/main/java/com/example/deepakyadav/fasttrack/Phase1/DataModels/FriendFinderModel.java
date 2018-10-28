package com.example.deepakyadav.fasttrack.Phase1.DataModels;

import android.graphics.Bitmap;

public class FriendFinderModel {
    String name, program,city,state,imgurl;
    Bitmap img;

    public FriendFinderModel(String name, String program, String city, String state, String imgurl, Bitmap img) {
        this.name = name;
        this.program = program;
        this.city = city;
        this.state = state;
        this.imgurl = imgurl;
        this.img = img;
    }

    public String getName() {
        return name;
    }

    public String getProgram() {
        return program;
    }

    public String getCity() {
        return city;
    }

    public String getState() {
        return state;
    }

    public String getImgurl() {
        return imgurl;
    }

    public Bitmap getImg() {
        return img;
    }
}
