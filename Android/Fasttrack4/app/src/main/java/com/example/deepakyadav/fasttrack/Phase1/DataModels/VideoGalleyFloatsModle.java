package com.example.deepakyadav.fasttrack.Phase1.DataModels;

public class VideoGalleyFloatsModle {
    MenuModel menuModel;
    int minSize, maxSize;

    public VideoGalleyFloatsModle(MenuModel menuModel, int minSize, int maxSize) {
        this.menuModel = menuModel;
        this.minSize = minSize;
        this.maxSize = maxSize;
    }

    public MenuModel getMenuModel() {
        return menuModel;
    }

    public int getMinSize() {
        return minSize;
    }

    public int getMaxSize() {
        return maxSize;
    }

}
