package com.example.deepakyadav.fasttrack.Phase1.DataModels;

public class MenuModel {
    String title;
    int imageId;
    boolean iswebView;
    boolean isNative;
    String url;
    String fragmentName;

    public MenuModel(String title, int imageId, boolean iswebView, boolean isNative, String url, String fragmentName) {
        this.title = title;
        this.imageId = imageId;
        this.iswebView = iswebView;
        this.isNative = isNative;
        this.url = url;
        this.fragmentName = fragmentName;
    }

    public String getTitle() {
        return title;
    }

    public int getImageId() {
        return imageId;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setImageId(int imageId) {
        this.imageId = imageId;
    }

    public boolean isIswebView() {
        return iswebView;
    }

    public void setIswebView(boolean iswebView) {
        this.iswebView = iswebView;
    }

    public boolean isNative() {
        return isNative;
    }

    public void setNative(boolean aNative) {
        isNative = aNative;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getFragmentName() {
        return fragmentName;
    }

    public void setFragmentName(String fragmentName) {
        this.fragmentName = fragmentName;
    }
}
