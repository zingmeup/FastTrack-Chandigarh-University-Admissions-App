package com.example.deepakyadav.fasttrack.Phase1.DataModels;

public class ExploreFloatsModel {
    String title, info, url,imgsrc;
    int minSize, maxSize;

    public ExploreFloatsModel(String title, String info, String url, String imgsrc, int minSize, int maxSize) {
        this.title = title;
        this.info = info;
        this.url = url;
        this.minSize = minSize;
        this.maxSize = maxSize;
        this.imgsrc= imgsrc;
    }

    public String getImgsrc() {
        return imgsrc;
    }

    public void setImgsrc(String imgsrc) {
        this.imgsrc = imgsrc;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public void setMinSize(int minSize) {
        this.minSize = minSize;
    }

    public void setMaxSize(int maxSize) {
        this.maxSize = maxSize;
    }

    public int getMinSize() {
        return minSize;
    }

    public int getMaxSize() {
        return maxSize;
    }

}
