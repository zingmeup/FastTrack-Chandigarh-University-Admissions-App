package com.example.deepakyadav.fasttrack.Phase1.DataModels;

import android.graphics.Bitmap;

public class StudentSpreakModel {
    String author;
    String placed;
    String comment;
    double rating;
    int year;
    Bitmap img;
    String imgsrc;

    public StudentSpreakModel(String author, String placed, String comment, double rating, int year, Bitmap img, String imgsrc) {
        this.author = author;
        this.placed = placed;
        this.comment = comment;
        this.rating = rating;
        this.year = year;
        this.img = img;
        this.imgsrc = imgsrc;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getPlaced() {
        return placed;
    }

    public void setPlaced(String placed) {
        this.placed = placed;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public double getRating() {
        return rating;
    }

    public void setRating(float rating) {
        this.rating = rating;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public Bitmap getImg() {
        return img;
    }

    public void setImg(Bitmap img) {
        this.img = img;
    }

    public String getImgsrc() {
        return imgsrc;
    }

    public void setImgsrc(String imgsrc) {
        this.imgsrc = imgsrc;
    }
}
