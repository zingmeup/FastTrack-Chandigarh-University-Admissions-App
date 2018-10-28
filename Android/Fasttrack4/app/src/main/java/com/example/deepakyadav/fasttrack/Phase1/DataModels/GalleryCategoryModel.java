package com.example.deepakyadav.fasttrack.Phase1.DataModels;

public class GalleryCategoryModel {
    String tag,name,video_img_url,photo_img_url,video_rediect,photo_redirect;

    public GalleryCategoryModel(String tag, String name, String video_img_url, String photo_img_url, String video_rediect, String photo_redirect) {
        this.tag = tag;
        this.name = name;
        this.video_img_url = video_img_url;
        this.photo_img_url = photo_img_url;
        this.video_rediect = video_rediect;
        this.photo_redirect = photo_redirect;
    }

    public String getTag() {
        return tag;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getVideo_img_url() {
        return video_img_url;
    }

    public void setVideo_img_url(String video_img_url) {
        this.video_img_url = video_img_url;
    }

    public String getPhoto_img_url() {
        return photo_img_url;
    }

    public void setPhoto_img_url(String photo_img_url) {
        this.photo_img_url = photo_img_url;
    }

    public String getVideo_rediect() {
        return video_rediect;
    }

    public void setVideo_rediect(String video_rediect) {
        this.video_rediect = video_rediect;
    }

    public String getPhoto_redirect() {
        return photo_redirect;
    }

    public void setPhoto_redirect(String photo_redirect) {
        this.photo_redirect = photo_redirect;
    }
}
