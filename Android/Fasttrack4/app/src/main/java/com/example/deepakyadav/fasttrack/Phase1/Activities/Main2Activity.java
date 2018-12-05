package com.example.deepakyadav.fasttrack.Phase1.Activities;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.example.deepakyadav.fasttrack.Phase1.Fragments.AboutUsFragment;
import com.example.deepakyadav.fasttrack.Phase1.Fragments.BrandingFragment;
import com.example.deepakyadav.fasttrack.Phase1.Fragments.CourseBrowserFragment;
import com.example.deepakyadav.fasttrack.Phase1.Fragments.ExploreFragment;
import com.example.deepakyadav.fasttrack.Phase1.Fragments.FindFriendsFragment;
import com.example.deepakyadav.fasttrack.Phase1.Fragments.FormsFragment;
import com.example.deepakyadav.fasttrack.Phase1.Fragments.GamesFragment;
import com.example.deepakyadav.fasttrack.Phase1.Fragments.NearByFragment;
import com.example.deepakyadav.fasttrack.Phase1.Fragments.NotificationsFragment;
import com.example.deepakyadav.fasttrack.Phase1.Fragments.PhotoGalleryFragment;
import com.example.deepakyadav.fasttrack.Phase1.Fragments.StudentSpeaksFragment;
import com.example.deepakyadav.fasttrack.Phase1.Fragments.TravelPlannerFragment;
import com.example.deepakyadav.fasttrack.Phase1.Fragments.VideoGalleryFragment;
import com.example.deepakyadav.fasttrack.Phase1.NetworkOperations.NetworkOperations;
import com.example.deepakyadav.fasttrack.R;

public class Main2Activity extends AppCompatActivity {
    Toolbar toolbar;
    FragmentManager fragmentManager;
    FragmentTransaction fragmentTransaction;
    WebView webView;
    ImageView backbtn;
    FloatingActionButton backbtnfab;
    ProgressBar progressBar;
    boolean stateisFragment=true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Intent i=getIntent();
        Toast.makeText(this, i.getStringExtra("title"), Toast.LENGTH_SHORT).show();
        //setTheme(R.style.fullscreen);
        setContentView(R.layout.activity_main2);
        toolbar=findViewById(R.id.toolbar_phase1_activity2);
        setSupportActionBar(toolbar);
        getWindow().setStatusBarColor(getResources().getColor(R.color.colorPrimaryDark));
        backbtn=findViewById(R.id.back_btn_activity2);
        backbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });
        fragmentManager=getSupportFragmentManager();
        contentChooser(i);
    }
    public void contentChooser(Intent intent){
        fragmentTransaction=fragmentManager.beginTransaction();
        if (intent.getBooleanExtra("isWebView", false)){
            setContentView(R.layout.fragment_genericwebview);
            stateisFragment=false;
            toolbar=findViewById(R.id.toolbar_phase1_activity2);
            setSupportActionBar(toolbar);
            backbtnfab=findViewById(R.id.back_btn_activity2);
            progressBar=findViewById(R.id.main2activity_progressbar);
            progressBar.setMax(100);
            backbtnfab.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    onBackPressed();
                }
            });
            setupWebView();
            Log.e("contentChooser", intent.getStringExtra("Url"));
            webView.loadUrl(intent.getStringExtra("Url"));
        }else if(intent.getBooleanExtra("isNative", false)){
            switch (intent.getStringExtra("Fragment")){
                case "StudentSpeakFragment":
                    fragmentTransaction.replace(R.id.fragment_container_main2activity, new StudentSpeaksFragment());
                    break;
                case "ExploreFragment":
                    fragmentTransaction.replace(R.id.fragment_container_main2activity, new ExploreFragment());
                    break;
                case "VideoGalleryFragment":
                    NetworkOperations.getInstance().fetchGalleryCategory(Main2Activity.this);
                    fragmentTransaction.replace(R.id.fragment_container_main2activity, new VideoGalleryFragment());
                    break;

                case "PhotoGalleryFragment":
                    NetworkOperations.getInstance().fetchGalleryCategoryPhoto(Main2Activity.this);
                    fragmentTransaction.replace(R.id.fragment_container_main2activity, new PhotoGalleryFragment());
                    break;

                case "AboutUsFragment":
                    fragmentTransaction.replace(R.id.fragment_container_main2activity, new AboutUsFragment());
                    break;

                case "BrandingFragment":
                    fragmentTransaction.replace(R.id.fragment_container_main2activity, new BrandingFragment());
                    break;

                case "CourseBrowserFragment":
                    fragmentTransaction.replace(R.id.fragment_container_main2activity, new CourseBrowserFragment());
                    break;

                case "FormsFragment":
                    fragmentTransaction.replace(R.id.fragment_container_main2activity, new FormsFragment());
                    break;

                case "NearByFragment":
                    NetworkOperations.getInstance().fetchOffices(getApplicationContext());
                    fragmentTransaction.replace(R.id.fragment_container_main2activity, new NearByFragment());
                    break;
                case "NotificationFragment":
                    fragmentTransaction.replace(R.id.fragment_container_main2activity, new NotificationsFragment());
                    break;

                case "ScholarshipFragment":
                    fragmentTransaction.replace(R.id.fragment_container_main2activity, new NotificationsFragment());
                    break;
                case "FindFriendsFragment":
                    fragmentTransaction.replace(R.id.fragment_container_main2activity, new FindFriendsFragment());
                    break;
                case "GamesFragment":
                    fragmentTransaction.replace(R.id.fragment_container_main2activity, new GamesFragment());
                    break;

                case "TravelPlannerFragment":
                    fragmentTransaction.replace(R.id.fragment_container_main2activity, new TravelPlannerFragment());
                    break;
                default:

                    Toast.makeText(this, "Make sure you are connected to internet.", Toast.LENGTH_SHORT).show();

            }
            fragmentTransaction.commit();

        }
        getSupportActionBar().setTitle(intent.getStringExtra("title"));

    }
    public void intentDial(View view){
        TextView tv=(TextView)view;
        String call=tv.getText().toString();
        String URI="tel:"+call;
        startActivity(new Intent(Intent.ACTION_DIAL).setData(Uri.parse(URI)));

    }
    public void intentMail(View view){
        TextView tv=(TextView)view;
        String mailTo=tv.getText().toString();

        startActivity(new Intent(Intent.ACTION_SENDTO).setType("text/plain").setData(Uri.fromParts("mailto",mailTo,null)));

    }

    public void intentChooser(View view){
        String url="https://google.com";
        switch (view.getId()){
            case R.id.social_fb:
                url="https://facebook.com/chandigarhuniversitygharuan/";
                break;
            case R.id.social_googleplus:
                url="https://plus.google.com/107369330661384288656";
                break;
            case R.id.social_skype:
                break;
            case R.id.social_insta:
                url="https://instagram.com/chandigarhuniversity/";
                break;
            case R.id.social_twitter:
                url="https://mobile.twitter.com/Chandigarh_uni";
                break;
            case R.id.social_whatsapp:

                break;
        }

        Intent i=new Intent(Intent.ACTION_VIEW, Uri.parse(url));
        startActivity(i);

    }
    public void setupWebView(){
        webView=findViewById(R.id.webview_generic);
        webView.setWebChromeClient(new WebChromeClient(){
            @Override
            public void onProgressChanged(WebView view, int newProgress) {
                super.onProgressChanged(view, newProgress);
                if(newProgress==100){
                    //Toast.makeText(Main2Activity.this, "Loaded", Toast.LENGTH_SHORT).show();
                    toolbar.setVisibility(View.GONE);
                    progressBar.setVisibility(View.GONE);
                }else{
                    progressBar.setProgress(newProgress);
                }

            }
        });
        webView.setWebViewClient(new WebViewClient());
        webView.getSettings().setJavaScriptEnabled(true);

    }
}



