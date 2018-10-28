package com.example.deepakyadav.fasttrack.Phase1.DataModels;

public class PhotoGalleryModel {
    String thumbLocation, largeLocation, Title;

    public PhotoGalleryModel(String thumbLocation, String largeLocation, String title) {
        this.thumbLocation = thumbLocation;
        this.largeLocation = largeLocation;
        Title = title;
    }

    public String getThumbLocation() {
        return thumbLocation;
    }

    public String getLargeLocation() {
        return largeLocation;
    }

    public String getTitle() {
        return Title;
    }
}
