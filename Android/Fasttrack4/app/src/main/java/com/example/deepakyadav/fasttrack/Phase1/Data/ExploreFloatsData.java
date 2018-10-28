package com.example.deepakyadav.fasttrack.Phase1.Data;

import com.example.deepakyadav.fasttrack.Phase1.DataModels.ExploreFloatsModel;
import com.example.deepakyadav.fasttrack.Phase1.DataModels.MenuModel;
import com.example.deepakyadav.fasttrack.R;

import java.util.ArrayList;

public class ExploreFloatsData {
    private static ExploreFloatsData exploreFloatsData=null;
    private ArrayList<ExploreFloatsModel> exploreFloatsList;

    public ExploreFloatsData() {
        exploreFloatsList = new ArrayList<>();
        //add data
        exploreFloatsList.add(new ExploreFloatsModel("Transport",
                "CONVENIENT & MODERN TRANSPORTATION FACILITY\n" +
                        "To give a comfortable traveling experience\n" +
                        "Safety and added comfort, both are the prime concerns of Chandigarh University. To bestow with the same, the fleet of University buses provide pick and drop facility to students coming from within a radial distance of 100Kms. The buses are modern to give a comfortable traveling experience.\n",
                "http://www.cuchd.in/student-services/transport-facility.php",
                "http://cuadmissions.digihostel.com/img/transport.jpg",
                15,
                30));
        exploreFloatsList.add(new ExploreFloatsModel("Hostels","Choosing a University is also about choosing a new home. We ensure that students dwell in a healthy environment that helps them to grow and learn without any obstacle. \n" +
                "Chandigarh University Campus has separate hostels for boys and girls with all modern facilities and attached mess. The hostel mess serves fresh and hygienic food. You will be provided with facilities like internet, music room, common room with TV & cable facility, room for indoor games and a reading room with a collection of national/international newspapers, magazines, etc. The hostels houses have a fully equipped gym and separate courts for Volley Ball, Basket Ball, and Badminton. The concerned staff looks after the university assets and ensures that the hostel remains responsive all the time.","http://www.cuchd.in/student-services/hostel-facility.php","http://cuadmissions.digihostel.com/img/hostel1.jpg",15,30));
        exploreFloatsList.add(new ExploreFloatsModel("Sports","GOLD & SILVER MEDAL IN\n" +
                "Asian Powerlifting & Rowing Championships\n" +
                "Nothing is more worth than a healthy body. Sports and games are an essential part of an individual's life, contributing in enhancing the quality of life. Understanding the importance of sports, Chandigarh University promotes the sports activities and ensures the student participation. The university organizes inter university and inter college/department events that foster team spirit among the participants and make them disciplined. ","http://www.cuchd.in/student-services/sports.php","http://cuadmissions.digihostel.com/img/sports.jpg",15,30));
        exploreFloatsList.add(new ExploreFloatsModel("Cultural","From music, dance, theatre to literature and fine arts, Chandigarh University encourages its students to actively engage in countless of cultural events whether taking place on or off campus. To purposely engage the students in meaningful activities, Chandigarh University boasts various cultural clubs and committees. These clubs and committees regularly arrange national level and inter-university competitions for the students that lets them nurture their instinctive talents and serves as platform to them.","http://www.cuchd.in/student-services/cultural.php","http://cuadmissions.digihostel.com/img/cultural.jpg",15,30));
        exploreFloatsList.add(new ExploreFloatsModel("Student Welfare","Department of Student Welfare (DSW) is a student care and supervision center that serves as a liaison between students and administration. DSW closely works with students across all years and all societies to explore ways to enhance or address aspects of the entire student experience, from education to student life to career planning, and works with students to develop innovative solutions to issues and concerns.","http://www.cuchd.in/student-services/studen-welfare-services.php","http://cuadmissions.digihostel.com/img/stuent-welfare1.jpg",15,30));
        exploreFloatsList.add(new ExploreFloatsModel("Clubs","Cultural activities are much more beneficial than they seem. These activities play a vital role in shaping the passion and interest of the students, apart from the academics. Time management, self-exploration, personal growth, improved self-esteem; CU believes that indulging in such activities teaches the real-time aspects of the life.","http://www.cuchd.in/student-services/studen-welfare-services.php","http://cuadmissions.digihostel.com/img/clubs.jpg",15,30));
        exploreFloatsList.add(new ExploreFloatsModel("Library","KNOWLEDGE RESOURCE CENTRE - LIBRARY\n" +
                "At Chandigarh University your learning needs are our top priority. In addition to high-quality facilities specific to your course, you will find a range of general learning resources which provide you with all the help you need to succeed.","http://www.cuchd.in/student-services/libraries.php","http://www.cuchd.in/student-services/images/libraries.jpg",15,30));
        exploreFloatsList.add(new ExploreFloatsModel("Eating joints","We have many outlets across campus including restaurants, delis and cafés in easy to reach locations. There are also many more exciting choices and offers in all of our outlets including grab and go salads, sandwiches at great value. Stocking all essentials for daily needs, our on-campus tuck- shops provide convenience groceries, grab and go snacks, stationery essentials plus some specialist stationery and equipment. We also sell a wide range of Chandigarh University – branded clothing and gifts which can be bought in brand store located at Academic Block 6.","http://www.cuchd.in/student-services/libraries.php","http://cuadmissions.digihostel.com/img/eating.jpg",15,30));
        exploreFloatsList.add(new ExploreFloatsModel("Campus Tour","Information about the Chandigarh University building, academic and campus life and surrounding suburbs and attractions to give you an overview of Chandigarh University facilities and services and help orient you to the campus and surrounding areas.","http://cuadmissions.digihostel.in/vtour.html","http://cuadmissions.digihostel.com/img/tour.jpeg",15,30));
        exploreFloatsList.add(new ExploreFloatsModel("CU Times","The Chandigarh University News portal provides you an insight view of the latest happening of the university campus. It keeps you updated with the campus life and achievements of the students & faculty.","http://news.cuchd.in/","http://cuadmissions.digihostel.com/img/cutimes.jpg",15,30));


    }

    public static ExploreFloatsData getInstance() {
        if(exploreFloatsData==null){
            exploreFloatsData=new ExploreFloatsData();
        }
        return exploreFloatsData;
    }

    public ArrayList<ExploreFloatsModel> getExploreFloatsList() {
        return exploreFloatsList;
    }
}
