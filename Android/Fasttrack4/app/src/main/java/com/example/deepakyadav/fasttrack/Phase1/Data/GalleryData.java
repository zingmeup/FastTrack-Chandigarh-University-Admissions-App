package com.example.deepakyadav.fasttrack.Phase1.Data;


import com.example.deepakyadav.fasttrack.Phase1.DataModels.GalleryCategoryModel;
import com.example.deepakyadav.fasttrack.Phase1.DataModels.PhotoGalleryModel;
import com.example.deepakyadav.fasttrack.Phase1.DataModels.VideoGalleryModel;

import java.util.ArrayList;

public class GalleryData {
    private static GalleryData galleryData=null;
    private ArrayList<GalleryCategoryModel> galleryCategoryList;
    private ArrayList<VideoGalleryModel> videoGalleryList;
    private ArrayList<PhotoGalleryModel> photoGalleryList;
    GalleryData(){
        galleryCategoryList=new ArrayList<>();
        videoGalleryList=new ArrayList<>();
        photoGalleryList=new ArrayList<>();
    }

    public static GalleryData getInstance(){
        if (galleryData==null){
            galleryData=new GalleryData();
        }
        return galleryData;
    }

    public ArrayList<GalleryCategoryModel> getGalleryCategoryList() {
        return galleryCategoryList;
    }

    public ArrayList<VideoGalleryModel> getVideoGalleryList() {
        return videoGalleryList;
    }

    public ArrayList<PhotoGalleryModel> getPhotoGalleryList() {
        return photoGalleryList;
    }
}