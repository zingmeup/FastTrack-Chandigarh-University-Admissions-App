package com.example.deepakyadav.fasttrack.Phase1.Data;


import com.example.deepakyadav.fasttrack.Phase1.DataModels.MenuModel;
import com.example.deepakyadav.fasttrack.R;

import java.util.ArrayList;

public class MenuData {
    private static MenuData menuData=null;
    private ArrayList<MenuModel> menuList;

    public MenuData(){
        menuList=new ArrayList<MenuModel>();
        menuList.add(new MenuModel("Payments", R.drawable.ic_credit_card_1, true, false, "", ""));
        menuList.add(new MenuModel("Admission form", R.drawable.ic_file, true, false, "", ""));
        menuList.add(new MenuModel("CU SAT", R.drawable.ic_diploma, true, false, "", ""));
        menuList.add(new MenuModel("Document Upload", R.drawable.ic_file_1, true, false, "", ""));

    }
    public static MenuData getInstance(){
        if (menuData==null){
            menuData=new MenuData();
        }
        return menuData;
    }

    public static MenuData getMenuData() {
        return menuData;
    }

    public static void setMenuData(MenuData menuData) {
        MenuData.menuData = menuData;
    }

    public ArrayList<MenuModel> getMenuList() {
        return menuList;
    }

    public void setMenuList(ArrayList<MenuModel> menuList) {
        this.menuList = menuList;
    }
}
