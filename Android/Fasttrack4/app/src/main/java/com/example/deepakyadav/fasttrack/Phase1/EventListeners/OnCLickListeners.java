package com.example.deepakyadav.fasttrack.Phase1.EventListeners;

import android.app.Activity;
import android.content.Intent;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.android.volley.toolbox.NetworkImageView;
import com.example.deepakyadav.fasttrack.Phase1.Activities.Main2Activity;
import com.example.deepakyadav.fasttrack.Phase1.Data.ExploreFloatsData;
import com.example.deepakyadav.fasttrack.Phase1.Data.StudentSpeakData;
import com.example.deepakyadav.fasttrack.Phase1.DataModels.ExploreFloatsModel;
import com.example.deepakyadav.fasttrack.Phase1.DataModels.VideoGalleyFloatsModle;
import com.example.deepakyadav.fasttrack.Phase1.Fragments.StudentSpeaksFragment;
import com.example.deepakyadav.fasttrack.Phase1.Fragments.VideoGalleryFragment;
import com.example.deepakyadav.fasttrack.Phase1.NetworkOperations.VolleyClass;
import com.example.deepakyadav.fasttrack.R;

public class OnCLickListeners {
    static Activity callingActivity;
    private static OnCLickListeners onCLickListeners=null;

    private View.OnClickListener exploreFloatsOnCLickListener=new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            NetworkImageView background;
            TextView tv;
            final TextView info;
            info=callingActivity.findViewById(R.id.infra_info);
            background=callingActivity.findViewById(R.id.explore_background);
            Button letGo;
            int[] views={R.id.infra_1,R.id.infra_2,R.id.infra_3,R.id.infra_4,R.id.infra_5,
                    R.id.infra_6,R.id.infra_7,R.id.infra_8,R.id.infra_9,R.id.infra_10};
            for (int i = 0; i <views.length ; i++) {
                tv=(TextView) view;
                final ExploreFloatsModel exploreFloatsModel=ExploreFloatsData.getInstance().getExploreFloatsList().get(i);

                Log.e("viewId", view.getId()+"");
                if (tv.getId()==views[i]){
                    final Intent intent=new Intent(callingActivity, Main2Activity.class);
                    tv.setAlpha(0.5f);
                    letGo=callingActivity.findViewById(R.id.explore_btn);
                    tv.animate().alphaBy(1f).setDuration(1000).setListener(null);
                    tv.setTextSize(exploreFloatsModel.getMaxSize());
                    info.setText(exploreFloatsModel.getInfo());
                    letGo.setText("Explore "+exploreFloatsModel.getTitle());
                    background.setImageUrl(exploreFloatsModel.getImgsrc(), VolleyClass.getInstance(callingActivity).getImageLoader());
                    letGo.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            intent.putExtra("isWebView", true);
                            intent.putExtra("Url", exploreFloatsModel.getUrl());
                            intent.putExtra("title",exploreFloatsModel.getTitle());
                            callingActivity.startActivity(intent);
                        }
                    });

                }else{
                    for (int j = 0; j <views.length ; j++) {
                        if (views[i]!=view.getId()){
                            TextView v1=callingActivity.findViewById(views[i]);
                            v1.setAlpha(0.5f);
                            v1.animate().alpha(0.5f).setDuration(1000).setListener(null);
                            v1.setTextSize(exploreFloatsModel.getMinSize());
                        }
                    }
                }
            }
        }
    };
    private View.OnClickListener studentSpeaksFloats=new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            StudentSpeaksFragment.listView.setAlpha(0f);
            StudentSpeaksFragment.listView.animate().alphaBy(1f).setDuration(1000).setListener(null);
            TextView tv;
            //switchadapters
            switch (view.getId()){
                case R.id.ss_2017:
                    Log.e("SS_onclick_id", view.getId()+"ss_2017");
                    StudentSpeakData.getInstance().yearWise(2017);

                    break;
                case R.id.ss_2016:
                    Log.e("SS_onclick_id", view.getId()+"ss_2016");
                    StudentSpeakData.getInstance().yearWise(2016);
                    break;
                case R.id.ss_2015:
                    Log.e("SS_onclick_id", view.getId()+"ss_2015");
                    StudentSpeakData.getInstance().yearWise(2015);
                    break;
                case R.id.ss_iitnit:
                    Log.e("SS_onclick_id", view.getId()+"ss_iitnit");
                    StudentSpeakData.getInstance().yearWise(1);
                    break;
                case R.id.ss_visitors:
                    Log.e("SS_onclick_id", view.getId()+"ss_visitors");
                    StudentSpeakData.getInstance().yearWise(0002);
                    break;
                    default:
                        Log.e("SS_onclick_id", view.getId()+"defalut");


            }

            StudentSpeaksFragment.studentSpeakAdapter.notifyDataSetChanged();

            int[] contents={R.id.ss_2017,R.id.ss_2016,R.id.ss_2015,R.id.ss_iitnit,R.id.ss_visitors};
            for (int i = 0; i <contents.length ; i++) {
                tv=(TextView) view;
                Log.e("viewId", view.getId()+"");

                if (tv.getId()==contents[i]){
                    tv.setAlpha(0.5f);
                    tv.animate().alphaBy(1f).setDuration(1000).setListener(null);
                    tv.setTextSize(25f);


                }else{
                    for (int j = 0; j <contents.length ; j++) {
                        if (contents[i]!=view.getId()){
                            TextView v1=callingActivity.findViewById(contents[i]);
                            v1.setAlpha(0.5f);
                            v1.animate().alpha(0.5f).setDuration(1000).setListener(null);
                            v1.setTextSize(15f);
                        }
                    }
                }
            }
        }
    };

    public View.OnClickListener getStudentSpeaksFloats() {
        return studentSpeaksFloats;
    }



    public View.OnClickListener getExploreFloatsOnCLickListener() {
        return exploreFloatsOnCLickListener;
    }

    public OnCLickListeners() {

    }
    public static OnCLickListeners getInstance(Activity activity){
        if(onCLickListeners==null){
            onCLickListeners=new OnCLickListeners();
        }
        callingActivity=activity;
        return onCLickListeners;
    }
}
