package com.example.deepakyadav.fasttrack.Phase1.DataModels;

public class VideoGalleryModel {
    String title,img,category,videoUrl,date,description;

    public VideoGalleryModel(String title, String img, String category, String videoUrl, String date, String description) {
        this.title = title;
        this.img = img;
        this.category = category;
        this.videoUrl = videoUrl;
        this.date = date;
        this.description = description;
    }

    public String getTitle() {
        return title;
    }

    public String getImg() {
        return img;
    }

    public String getCategory() {
        return category;
    }

    public String getVideoUrl() {
        return videoUrl;
    }

    public String getDate() {
        return date;
    }

    public String getDescription() {
        return description;
    }
}
