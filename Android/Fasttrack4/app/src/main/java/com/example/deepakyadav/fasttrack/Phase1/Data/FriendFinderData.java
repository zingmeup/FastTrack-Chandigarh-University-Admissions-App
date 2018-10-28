package com.example.deepakyadav.fasttrack.Phase1.Data;

import com.example.deepakyadav.fasttrack.Phase1.DataModels.FriendFinderModel;

import java.util.ArrayList;

public class FriendFinderData {
    private static FriendFinderData friendFinderData=null;
    private ArrayList<FriendFinderModel> friendFinderList;

    public static FriendFinderData getInstance(){
        if (friendFinderData==null){
            friendFinderData=new FriendFinderData();
        }
       return friendFinderData;
    }

    public FriendFinderData() {
        friendFinderList=new ArrayList<>();
        friendFinderList.add(new FriendFinderModel("Deepak Yadav", "BE CSE IBM cloud", "Mumbai", "Maharashtra", "", null));
        friendFinderList.add(new FriendFinderModel("Deepak Yadav", "BE CSE IBM cloud", "Mumbai", "Maharashtra", "", null));
        friendFinderList.add(new FriendFinderModel("Deepak Yadav", "BE CSE IBM cloud", "Mumbai", "Maharashtra", "", null));
        friendFinderList.add(new FriendFinderModel("Deepak Yadav", "BE CSE IBM cloud", "Mumbai", "Maharashtra", "", null));
        friendFinderList.add(new FriendFinderModel("Deepak Yadav", "BE CSE IBM cloud", "Mumbai", "Maharashtra", "", null));

    }

    public ArrayList<FriendFinderModel> getFriendFinderList() {
        return friendFinderList;
    }
}
