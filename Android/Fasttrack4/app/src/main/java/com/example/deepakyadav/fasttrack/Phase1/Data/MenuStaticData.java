package com.example.deepakyadav.fasttrack.Phase1.Data;

import com.example.deepakyadav.fasttrack.Phase1.DataModels.MenuModel;
import com.example.deepakyadav.fasttrack.R;

import java.util.ArrayList;

public class MenuStaticData {
    private static MenuStaticData menuData=null;
    private ArrayList<MenuModel> menuListDrawer2;
    private ArrayList<MenuModel> menuListDrawer1;

    public MenuStaticData() {
        menuListDrawer2=new ArrayList<MenuModel>();
        menuListDrawer2.add(new MenuModel("Video Gallery", R.drawable.ic_youtube, false, true, "","VideoGalleryFragment"));
        menuListDrawer2.add(new MenuModel("Photo Gallery", R.drawable.ic_gallery, false, true, "http://cuadmissions.digihostel.com","PhotoGalleryFragment"));
        menuListDrawer2.add(new MenuModel("This is Us", R.drawable.ic_trophy, true, false, "http://cuchd.in",""));
        menuListDrawer2.add(new MenuModel("Students Speak", R.drawable.ic_graduate, false, true, "","StudentSpeakFragment"));
        menuListDrawer2.add(new MenuModel("How to Reach", R.drawable.ic_placeholder, true, false, "http://cuadmissions.digihostel.com/howtoreach.html",""));
        menuListDrawer2.add(new MenuModel("Explore University", R.drawable.ic_team, false, true, "","ExploreFragment"));
        menuListDrawer2.add(new MenuModel("Travel Planner", R.drawable.ic_map, false, true, "http://cuadmissions.digihostel.com","TravelPlannerFragment"));
        menuListDrawer2.add(new MenuModel("Find a Friend", R.drawable.ic_team_1, false, true, "","FindFriendsFragment"));
        menuListDrawer2.add(new MenuModel("Game Box", R.drawable.ic_joystick, false, true, "","GamesFragment"));
        menuListDrawer1=new ArrayList<>();
        menuListDrawer1.add(new MenuModel("Scholarships", R.drawable.ic_diploma, true, false, "http://cuchd.in/scholarship/",""));
        menuListDrawer1.add(new MenuModel("Video Gallery", R.drawable.ic_youtube, false, true, "","VideoGalleryFragment"));
        menuListDrawer1.add(new MenuModel("Photo Gallery", R.drawable.ic_gallery, false, true, "http://cuadmissions.digihostel.com","PhotoGalleryFragment"));
        menuListDrawer1.add(new MenuModel("Admission Offices", R.drawable.ic_world, false, true, "","NearByFragment"));
        menuListDrawer1.add(new MenuModel("Request Forms", R.drawable.ic_forms_1, false, true, "","FormsFragment"));
        menuListDrawer1.add(new MenuModel("About us", R.drawable.ic_information, false, true, "","AboutUsFragment"));
    }
    public static MenuStaticData getInstance(){
        if (menuData==null){
            menuData=new MenuStaticData();

        }
        return menuData;
    }

    public ArrayList<MenuModel> getMenuListDrawer1() {
        return menuListDrawer1;
    }

    public ArrayList<MenuModel> getMenuListDrawer2() {
        return menuListDrawer2;
    }


}
