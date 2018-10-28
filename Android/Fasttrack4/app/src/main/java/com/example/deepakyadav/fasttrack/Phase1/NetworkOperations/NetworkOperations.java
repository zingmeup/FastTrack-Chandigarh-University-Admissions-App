import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.ImageLoader;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.deepakyadav.fasttrack.Phase1.Activities.Phase2Activity;
import com.example.deepakyadav.fasttrack.Phase1.Adapters.StudentSpeakAdapter;
import com.example.deepakyadav.fasttrack.Phase1.Data.AdmissionOfficesData;
import com.example.deepakyadav.fasttrack.Phase1.Data.CourseBrowserData;
import com.example.deepakyadav.fasttrack.Phase1.Data.GalleryData;
import com.example.deepakyadav.fasttrack.Phase1.Data.JoinUsData;
import com.example.deepakyadav.fasttrack.Phase1.Data.SessionData;
import com.example.deepakyadav.fasttrack.Phase1.Data.StudentSpeakData;
import com.example.deepakyadav.fasttrack.Phase1.Data.TravelPlannerData;
import com.example.deepakyadav.fasttrack.Phase1.DataModels.AdmissionOfficesModel;
import com.example.deepakyadav.fasttrack.Phase1.DataModels.CityModel;
import com.example.deepakyadav.fasttrack.Phase1.DataModels.CourseBrowserModel;
import com.example.deepakyadav.fasttrack.Phase1.DataModels.GalleryCategoryModel;
import com.example.deepakyadav.fasttrack.Phase1.DataModels.PhotoGalleryModel;
import com.example.deepakyadav.fasttrack.Phase1.DataModels.ProgramModel;
import com.example.deepakyadav.fasttrack.Phase1.DataModels.StudentSpreakModel;
import com.example.deepakyadav.fasttrack.Phase1.DataModels.TravellPlannerModel;
import com.example.deepakyadav.fasttrack.Phase1.DataModels.VideoGalleryModel;
import com.example.deepakyadav.fasttrack.Phase1.Fragments.CourseBrowserFragment;
import com.example.deepakyadav.fasttrack.Phase1.Fragments.JoinUsFragment;
import com.example.deepakyadav.fasttrack.Phase1.Fragments.NearByFragment;
import com.example.deepakyadav.fasttrack.Phase1.Fragments.PhotoGalleryFragment;
import com.example.deepakyadav.fasttrack.Phase1.Fragments.PhotoListFragment;
import com.example.deepakyadav.fasttrack.Phase1.Fragments.RegisterFragment;
import com.example.deepakyadav.fasttrack.Phase1.Fragments.StudentSpeaksFragment;
import com.example.deepakyadav.fasttrack.Phase1.Fragments.TravelPlannerFragment;
import com.example.deepakyadav.fasttrack.Phase1.Fragments.VideoGalleryFragment;
import com.example.deepakyadav.fasttrack.Phase1.Fragments.VideoListFragment;
import com.example.deepakyadav.fasttrack.R;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class NetworkOperations {
    private static NetworkOperations networkOperations = null;

    public NetworkOperations() {
    }

    public static NetworkOperations getInstance() {
        if (networkOperations == null) {
            networkOperations = new NetworkOperations();
        }
        return networkOperations;
    }
    public void fetchDiscipline(final Activity activity) {
        Log.e("Discipline Adapter","Started to make query");
        RequestQueue requestQueue = Volley.newRequestQueue(activity);
        StringRequest StringRequest = new StringRequest(Request.Method.GET, activity.getResources().getString(R.string.API_DISC),
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        JoinUsData.getData().getDisciplineList().clear();
                        Log.e("RESPONSE", response);

                        try {
                            Log.e("Next", "next");
                            JSONArray jsonArray = new JSONArray(response);
                            for (int i = 0; i < jsonArray.length(); i++) {
                                JSONObject tempJsonObj = jsonArray.getJSONObject(i);
                                Log.e("" + i, "added" + tempJsonObj.getString("Discipline"));
                                JoinUsData.getData().getDisciplineList().add(tempJsonObj.getString("Discipline"));
                            }
                            RegisterFragment.disciplineAdapter.notifyDataSetChanged();
                        } catch (JSONException e) {
                            e.printStackTrace();
                            Log.e("JSONOBJ ERROR", e + "");
                        }
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Toast.makeText(activity, error.toString(), Toast.LENGTH_SHORT).show();
                    }

                });
        requestQueue.add(StringRequest);
    }
    public void fetchProgram(final Activity activity, String selectedDiscipline) {
        RequestQueue requestQueue = Volley.newRequestQueue(activity);
        StringRequest StringRequest = new StringRequest(Request.Method.GET, activity.getResources().getString(R.string.API_PROG) + selectedDiscipline,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        JoinUsData.getData().getProgramList().clear();
                        RegisterFragment.programAdapter.notifyDataSetChanged();
                        Log.e("RESPONSE", response);

                        try {
                            Log.e("Next", "next");
                            JSONArray jsonArray = new JSONArray(response);
                            for (int i = 0; i < jsonArray.length(); i++) {
                                JSONObject tempJsonObj = jsonArray.getJSONObject(i);
                                //Log.e(""+i, "added"+tempJsonObj.getString("Code")+"added"+tempJsonObj.getString("Description"));
                                ProgramModel tempProgram = new ProgramModel(tempJsonObj.getString("Code"),minify(tempJsonObj.getString("Description")));
                                JoinUsData.getData().getProgramList().add(tempProgram);
                            }
                            RegisterFragment.programAdapter.notifyDataSetChanged();
                        } catch (JSONException e) {
                            e.printStackTrace();
                            Log.e("JSONOBJ ERROR", e + "");
                        }
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Toast.makeText(activity, error.toString(), Toast.LENGTH_SHORT).show();
                    }
                });
        requestQueue.add(StringRequest);
    }

    public void fetchTravelPlanner(final Activity activity, String selectedDiscipline) {
        RequestQueue requestQueue = Volley.newRequestQueue(activity);
        StringRequest StringRequest = new StringRequest(Request.Method.GET, activity.getResources().getString(R.string.API_TRAVEL) + selectedDiscipline,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        TravelPlannerData.getInstance().getTravellPlannerList().clear();
                        TravelPlannerFragment.travelPlannerAdapter.notifyDataSetChanged();
                        Log.e("RESPONSE", response);

                        try {
                            Log.e("Next-travel", "next");
                            JSONObject jsonObject=new JSONObject(response);
                            JSONArray jsonArray=jsonObject.getJSONArray("places");
                            for (int i = 0; i < jsonArray.length(); i++) {
                                Log.e("travelplanner-network", "reading"+i);
                                JSONObject tempJsonObj = jsonArray.getJSONObject(i);
                                //Log.e(""+i, "added"+tempJsonObj.getString("Code")+"added"+tempJsonObj.getString("Description"));
                                String name=tempJsonObj.getString("name");
                                int timeopen=tempJsonObj.getInt("timeopen");
                                int timeclose=tempJsonObj.getInt("timeclose");
                                JSONArray infoArray=tempJsonObj.getJSONArray("info");
                                JSONObject infoObj=infoArray.getJSONObject(0);
                                String info1=infoObj.getString("info");
                                infoObj=infoArray.getJSONObject(1);
                                String info2=infoObj.getString("info");
                                String imgsrc=tempJsonObj.getString("image");
                                String redirect=tempJsonObj.getString("redir");
                                Log.e("travelplanner-network", "album"+i);
                                JSONArray albumArray=tempJsonObj.getJSONArray("album");
                                String album[]=new String[5];
                                for (int j = 0; j <5 ; j++) {
                                    Log.e("travelplanner-network", "album-img"+j);
                                    JSONObject img=albumArray.getJSONObject(j);

                                    album[j]=img.getString("img");
                                }

                                JSONObject coordinates=tempJsonObj.getJSONObject("coordinates");
                                double lat=coordinates.getDouble("lat");
                                double lon=coordinates.getDouble("lon");




                                TravellPlannerModel model=new TravellPlannerModel(name, imgsrc,timeopen,timeclose,info1,info2,redirect, album, lat,lon);
                                TravelPlannerData.getInstance().getTravellPlannerList().add(model);
                                Log.e("travelplanner-network", "success"+i);
                            }

                            TravelPlannerFragment.travelPlannerAdapter.notifyDataSetChanged();
                        } catch (JSONException e) {
                            e.printStackTrace();
                            Log.e("JSONOBJ ERROR", e + "");
                        }
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Toast.makeText(activity, error.toString(), Toast.LENGTH_SHORT).show();
                    }
                });
        requestQueue.add(StringRequest);
    }


    public void fetchCourseStructure(final Activity activity) {
        RequestQueue requestQueue = Volley.newRequestQueue(activity);
        StringRequest StringRequest = new StringRequest(Request.Method.GET, activity.getResources().getString(R.string.API_COURSES),
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        CourseBrowserData.getInstance().getCourseBrowserList().clear();

                        try {
                            Log.e("Next", "next");
                            JSONArray jsonArray = new JSONArray(response);
                            for (int i = 0; i < jsonArray.length(); i++) {
                                JSONObject tempJsonObj = jsonArray.getJSONObject(i);
                                CourseBrowserModel courseBrowserModel=new CourseBrowserModel(tempJsonObj.getString("ProgramCode"),tempJsonObj.getString("ShortName"),tempJsonObj.getString("ProgramName"),tempJsonObj.getString("Eligibility"),tempJsonObj.getString("Discipline"),tempJsonObj.getString("DurationInYear"),tempJsonObj.getString("FeePerSemester")+" Rs",tempJsonObj.getString("FeePerSemesterUSD")+" USD");
                                CourseBrowserData.getInstance().getCourseBrowserList().add(courseBrowserModel);
                                Log.e("courseBrowser-obj", i+courseBrowserModel.getProgramName());
                            }
                       //     CourseBrowserFragment.arrayAdapter.notifyDataSetChanged();
                        } catch (JSONException e) {
                            e.printStackTrace();
                            Log.e("JSONOBJ ERROR", e+"");
                        }
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Toast.makeText(activity, error.toString(), Toast.LENGTH_SHORT).show();
                    }
                });
        requestQueue.add(StringRequest);
    }
    public void fetchGalleryCategory(final Activity activity) {
        RequestQueue requestQueue = Volley.newRequestQueue(activity);
        final String baseAPI=activity.getResources().getString(R.string.API_BASE);
        StringRequest StringRequest = new StringRequest(Request.Method.GET, activity.getResources().getString(R.string.API_GALLERY_CATEGORIES),
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        GalleryData.getInstance().getGalleryCategoryList().clear();

                        try {
                            Log.e("fetchGalleryCategory", "trying decode");
                            JSONObject mainObject=new JSONObject(response);
                            if(mainObject.get("error").equals(null)){
                                JSONArray result=mainObject.getJSONArray("result");
                                for (int i = 0; i < result.length(); i++) {
                                    JSONObject tempJsonObj = result.getJSONObject(i);
                                    GalleryCategoryModel model=new GalleryCategoryModel(
                                            tempJsonObj.getString("category_tag"),
                                            tempJsonObj.getString("category_name"),
                                            baseAPI+tempJsonObj.getString("category_img_video"),
                                            baseAPI+tempJsonObj.getString("category_img_photo"),
                                            tempJsonObj.getString("video_redirect"),
                                            tempJsonObj.getString("photo_redirect")
                                    );
                                    GalleryData.getInstance().getGalleryCategoryList().add(model);
                                    Log.e("fetchGalleryCategory", "result "+i);
                                    Log.e("fetchGalleryCategory", "title "+model.getName());
                                }
                            }
                            try{
                                VideoGalleryFragment.galleryCategoryAdapter.notifyDataSetChanged();
                            }catch (NullPointerException e){
                                Log.e("fetchGalleryCategory", e.toString());
                            }
                        } catch (JSONException e) {
                            e.printStackTrace();
                            Log.e("JSONOBJ ERROR", e+"");
                        }
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Toast.makeText(activity, error.toString(), Toast.LENGTH_SHORT).show();
                    }
                });
        requestQueue.add(StringRequest);
    }
    public void fetchGalleryCategoryPhoto(final Activity activity) {
        RequestQueue requestQueue = Volley.newRequestQueue(activity);
        final String baseAPI=activity.getResources().getString(R.string.API_BASE);
        StringRequest StringRequest = new StringRequest(Request.Method.GET, activity.getResources().getString(R.string.API_GALLERY_CATEGORIES),
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        GalleryData.getInstance().getGalleryCategoryList().clear();

                        try {
                            Log.e("fetchGalleryCategory", "trying decode");
                            JSONObject mainObject=new JSONObject(response);
                            if(mainObject.get("error").equals(null)){
                                JSONArray result=mainObject.getJSONArray("result");
                                for (int i = 0; i < result.length(); i++) {
                                    JSONObject tempJsonObj = result.getJSONObject(i);
                                    GalleryCategoryModel model=new GalleryCategoryModel(
                                            tempJsonObj.getString("category_tag"),
                                            tempJsonObj.getString("category_name"),
                                            baseAPI+tempJsonObj.getString("category_img_video"),
                                            baseAPI+tempJsonObj.getString("category_img_photo"),
                                            tempJsonObj.getString("video_redirect"),
                                            tempJsonObj.getString("photo_redirect")
                                    );
                                    GalleryData.getInstance().getGalleryCategoryList().add(model);
                                    Log.e("fetchGalleryCategory", "result "+i);
                                    Log.e("fetchGalleryCategory", "title "+model.getName());
                                }
                            }
                            try{
                                PhotoGalleryFragment.galleryCategoryAdapter.notifyDataSetChanged();
                            }catch (NullPointerException e){
                                Log.e("fetchGalleryCategory", e.toString());
                            }
                        } catch (JSONException e) {
                            e.printStackTrace();
                            Log.e("JSONOBJ ERROR", e+"");
                        }
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Toast.makeText(activity, error.toString(), Toast.LENGTH_SHORT).show();
                    }
                });
        requestQueue.add(StringRequest);
    }
    public void fetchPhotoGallery(final Activity activity, String category) {
        RequestQueue requestQueue = Volley.newRequestQueue(activity);
        final String baseAPI=activity.getResources().getString(R.string.API_BASE);
        StringRequest StringRequest = new StringRequest(Request.Method.GET, activity.getResources().getString(R.string.API_GALLERY_PHOTO_BY_CATEGORY)+category,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        GalleryData.getInstance().getPhotoGalleryList().clear();

                        try {
                            Log.e("photoGallery-network", "trying decode");
                            JSONObject mainObject=new JSONObject(response);
                            if(mainObject.get("error").equals(null)){
                                JSONArray result=mainObject.getJSONArray("result");
                                for (int i = 0; i < result.length(); i++) {
                                    JSONObject tempJsonObj = result.getJSONObject(i);
                                    PhotoGalleryModel model=new PhotoGalleryModel(baseAPI+tempJsonObj.getString("thumb_loc"),
                                            baseAPI+tempJsonObj.getString("full_loc"),
                                            tempJsonObj.getString("title"));

                                    GalleryData.getInstance().getPhotoGalleryList().add(model);
                                    Log.e("photoGallery-network", "result "+i);
                                    Log.e("photoGallery-network", "title "+model.getTitle());
                                }
                            }
                            try{
                                PhotoListFragment.photoGalleryAdapter.notifyDataSetChanged();
                            }catch (NullPointerException e){
                                Log.e("photoGallery-network", e.toString());
                            }
                        } catch (JSONException e) {
                            e.printStackTrace();
                            Log.e("photoGallery-JSONOBJERR", e+"");
                        }
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Toast.makeText(activity, error.toString(), Toast.LENGTH_SHORT).show();
                    }
                });
        requestQueue.add(StringRequest);
    }
    public void fetchVideoGallery(final Activity activity, String category) {
        RequestQueue requestQueue = Volley.newRequestQueue(activity);
        final String baseAPI=activity.getResources().getString(R.string.API_BASE);
        StringRequest StringRequest = new StringRequest(Request.Method.GET, activity.getResources().getString(R.string.API_GALLERY_VIDEO_BY_CATEGORY)+category,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        GalleryData.getInstance().getVideoGalleryList().clear();

                        try {
                            Log.e("fetchVideoGallery", "trying decode");
                            JSONObject mainObject=new JSONObject(response);
                            if(mainObject.get("error").equals(null)){
                                JSONArray result=mainObject.getJSONArray("result");
                                for (int i = 0; i < result.length(); i++) {
                                    JSONObject tempJsonObj = result.getJSONObject(i);
                                    VideoGalleryModel model=new VideoGalleryModel(
                                            tempJsonObj.getString("title"),
                                            baseAPI+"uploads/"+tempJsonObj.getString("thumbnail_image"),
                                            tempJsonObj.getString("video_category"),
                                            tempJsonObj.getString("video_url"),
                                            tempJsonObj.getString("date"),
                                            tempJsonObj.getString("video_description")
                                    );
                                    GalleryData.getInstance().getVideoGalleryList().add(model);
                                    Log.e("fetchVideoGallery", "result "+i);
                                    Log.e("fetchVideoGallery", "title "+model.getTitle());
                                }
                            }
                            try{
                                VideoListFragment.videoGalleryAdapter.notifyDataSetChanged();
                            }catch (NullPointerException e){
                                Log.e("fetchVideoGallery", e.toString());
                            }
                        } catch (JSONException e) {
                            e.printStackTrace();
                            Log.e("JSONOBJ ERROR", e+"");
                        }
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Toast.makeText(activity, error.toString(), Toast.LENGTH_SHORT).show();
                    }
                });
        requestQueue.add(StringRequest);
    }


    public void fetchOffices(final Context activity) {
        RequestQueue requestQueue = Volley.newRequestQueue(activity);
        StringRequest StringRequest = new StringRequest(Request.Method.GET, activity.getResources().getString(R.string.API_OFFICES),
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        AdmissionOfficesData.getInstance().getAdmissionOfficesList().clear();
                        AdmissionOfficesData.getInstance().getStates().clear();

                        try {
                            Log.e("Next", "next");
                            Log.d("admissionoffice", "fetching Data");
                            JSONArray jsonArray = new JSONArray(response);
                            for (int i = 0; i < jsonArray.length(); i++) {
                                JSONObject tempJsonObj = jsonArray.getJSONObject(i);

                                Log.d("admissionoffice", "fetching state"+i);

                                AdmissionOfficesData.getInstance().getStates().add(tempJsonObj.getString("state"));
                                JSONArray contacts=tempJsonObj.getJSONArray("contacts");
                                for (int j = 0; j < contacts.length(); j++) {
                                    JSONObject details=contacts.getJSONObject(j);
                                    AdmissionOfficesModel model=new AdmissionOfficesModel(details.getString("city"), tempJsonObj.getString("state"), details.getString("add"),details.getString("person"),details.getString("phone"),details.getString("phone2"));
                                    AdmissionOfficesData.getInstance().getAdmissionOfficesList().add(model);
                                }
                            }
                            NearByFragment.arrayAdapter.notifyDataSetChanged();
                            NearByFragment.admissionOfficesAdapter.notifyDataSetChanged();
                        } catch (JSONException e) {
                            e.printStackTrace();
                            Log.e("JSONOBJ ERROR", e+"");
                        }
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                    }
                });
        requestQueue.add(StringRequest);
    }

    public void fetchReviews(Context activity) {
        RequestQueue requestQueue = Volley.newRequestQueue(activity);
        StringRequest StringRequest = new StringRequest(Request.Method.GET, activity.getResources().getString(R.string.API_REVIEWS),
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        StudentSpeakData.getInstance().getStudentSpeakDataList().clear();
                        //StudentSpeaksFragment.studentSpeakAdapter.notifyDataSetChanged();

                        try {
                            Log.e("Next", "next");
                            JSONArray jsonArray = new JSONArray(response);
                            for (int i = 0; i < jsonArray.length(); i++) {
                                JSONObject tempJsonObj = jsonArray.getJSONObject(i);
                                StudentSpreakModel studentSpreakModel=new StudentSpreakModel(tempJsonObj.getString("author"),tempJsonObj.getString("placed"),tempJsonObj.getString("comment"),tempJsonObj.getDouble("rating"),tempJsonObj.getInt("year"),null,tempJsonObj.getString("imgsrc"));
                                StudentSpeakData.getInstance().getStudentSpeakDataList().add(studentSpreakModel);

                                Log.e("fetchReviews", i+"");

                            }
                         //   StudentSpeaksFragment.studentSpeakAdapter.notifyDataSetChanged();
                        } catch (JSONException e) {
                            e.printStackTrace();
                            Log.e("JSONOBJ ERROR", e+"");
                        }
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                    }
                });
        requestQueue.add(StringRequest);
    }


    public void fetchDistance(final Activity activity, final String city) {
        Log.d("distanceAPI", city);
        RequestQueue requestQueue = Volley.newRequestQueue(activity);
        StringRequest StringRequest = new StringRequest(Request.Method.GET, activity.getResources().getString(R.string.API_DISTANCE)+city,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        TravelPlannerData.getInstance().setAirportaiat("");
                        TravelPlannerData.getInstance().setAirportname("");
                        TravelPlannerData.getInstance().setDistance(0);

                        try {
                            JSONObject mainObject=new JSONObject(response);
                            JSONObject travelObject=mainObject.getJSONObject("travel");
                            JSONObject destinationObject=travelObject.getJSONObject("destination");
                            JSONArray airportsArray=destinationObject.getJSONArray("airports");
                            JSONObject actualThing=airportsArray.getJSONObject(0);
                            TravelPlannerData.getInstance().setDistance(mainObject.getInt("distance"));
                            TravelPlannerData.getInstance().setAirportaiat(actualThing.getString("iata"));
                            TravelPlannerData.getInstance().setAirportname(actualThing.getString("name"));

                            TravelPlannerFragment.detailsCard.setVisibility(View.VISIBLE);
                            TravelPlannerFragment.detailsCard.setAlpha(0f);
                            TravelPlannerFragment.detailsCard.animate().alphaBy(1f).setDuration(1000).setListener(null);
                            Log.d("", "Distance "+mainObject.getInt("distance"));
                            Log.d("distanceAPI", "IATA "+actualThing.getString("iata"));
                            Log.d("distanceAPI", "NAME"+actualThing.getString("name"));
                        } catch (JSONException e) {
                            e.printStackTrace();
                            Log.e("JSONOBJ ERROR", e+"");

                            TravelPlannerData.getInstance().setDistance(0);
                            TravelPlannerData.getInstance().setAirportaiat(city);
                            TravelPlannerData.getInstance().setAirportname("Sorry we could't find");
                        }

                        TravelPlannerFragment.distance.setText(TravelPlannerData.getInstance().getDistance()+" KM");
                        TravelPlannerFragment.name.setText(TravelPlannerData.getInstance().getAirportname());
                        TravelPlannerFragment.aita.setText(TravelPlannerData.getInstance().getAirportaiat());
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                    }
                });
        requestQueue.add(StringRequest);
    }






    public String minify(String string){
        string=string.replace("Bachelor of Engineering", "B.E")
                .replace("Bachelor Of Engineering", "B.E")
                .replace("Master of Engineering", "M.E")
                .replace("Bachelor of Science", "B.Sc")
                .replace("Bachelor Of Science", "B.Sc")
                .replace("Master Of Engineering", "M.E")
                .replace("Bachelor Of Science", "B.Sc")
                .replace("Master of Science", "M.Sc")
                .replace("Master Of Science", "M.Sc")
                .replace("Bachelor of Business Administration", "B.B.A")
                .replace("Master of Business Administration", "M.B.A")
                .replace("Masters of Business Administration", "M.B.A")
                .replace("Master of Computer Application", "M.C.A")
                .replace("Bachelor of Computer Applications", "B.C.A")
                .replace("Diploma", "")
                .replace("Bachelor of Arts", "B.A")
                .replace("Master of Arts", "M.A")
                .replace("Bachelor of", "B. ");
        return string;
    }
    public void fetchCity(final Activity activity) {
        RequestQueue requestQueue = Volley.newRequestQueue(activity);
        StringRequest StringRequest = new StringRequest(Request.Method.GET, activity.getResources().getString(R.string.API_CITY),
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        JoinUsData.getData().getCityList().clear();
                        RegisterFragment.cityAdapter.notifyDataSetChanged();
                        Log.e("RESPONSE", response);
                        try {
                            Log.e("Next", "next");
                            JSONArray jsonArray = new JSONArray(response);
                            for (int i = 0; i < jsonArray.length(); i++) {
                                JSONObject tempJsonObj = jsonArray.getJSONObject(i);
                                //Log.e(""+i, "added"+tempJsonObj.getString("Code")+"added"+tempJsonObj.getString("Description"));
                                CityModel tempCity = new CityModel(tempJsonObj.getInt("CityId"), tempJsonObj.getString("CityName"),
                                        tempJsonObj.getString("Disttrict"), tempJsonObj.getString("State"));
                                JoinUsData.getData().getCityList().add(tempCity);
                            }
                            RegisterFragment.cityAdapter.notifyDataSetChanged();
                        } catch (JSONException e) {
                            e.printStackTrace();
                            Log.e("JSONOBJ ERROR", e + "");
                        }
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Toast.makeText(activity, error.toString(), Toast.LENGTH_SHORT).show();
                    }

                });
        requestQueue.add(StringRequest);
    }


    public void SubmitData(final Activity activity, String name, String email, String mobile, String programCode, String selected_city_code, final String dob) {
        Log.e("asdadad","dsadadadadadad");
        String data = "http://172.17.60.27/api/mobapp/PostJsonRegistrationMobile?Data={";
        data += "\"FullName\":\"" +name+ "\",";
        data += "\"Email\":\"" +email+ "\",";
        data += "\"Mobile\":\"" +mobile+ "\",";
        data += "\"ProgramCode\":\"" +programCode+ "\",";
        data += "\"CityId\":\"" +selected_city_code+ "\",";
        data += "\"DOB\":\"" +dob+ "\"}";
        Log.e("asdadad",data);
        RequestQueue requestQueue = Volley.newRequestQueue(activity);
        StringRequest StringRequest = new StringRequest(Request.Method.GET, data,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        Log.e("RESPONSE", response);
                        try {
                            Log.e("Next", "next");
                            final JSONObject jsonObject = new JSONObject(response);
                            JoinUsFragment.responceDialog.show();
                            TextView tv1 = JoinUsFragment.responceDialog.findViewById(R.id.dialog_responce1);
                            TextView tv2 = JoinUsFragment.responceDialog.findViewById(R.id.dialog_responce2);
                            if (jsonObject.getString("Message").equals("Saved")) {

                                Log.e("SUBMIT", "SAVED");
                                tv1.setText("Congratulation on being a part of Asia's Fastest Growing Univeristy.");
                                String text2="Your FastTrackId is: " + jsonObject.getString("FastTrackId")+"\n"
                                        +"Your password is: "+passwordGenerator(dob);
                                tv2.setText(text2);
                                Button loginbtn = JoinUsFragment.responceDialog.findViewById(R.id.dialog_okbtn);
                                loginbtn.setText("Login");
                                loginbtn.setOnClickListener(new View.OnClickListener() {
                                    @Override
                                    public void onClick(View view) {
                                        JoinUsFragment.responceDialog.dismiss();
                                        JoinUsFragment.firstBtn.callOnClick();
                                        try {
                                            storeTempLoginData(jsonObject.getString("FastTrackId"), passwordGenerator(dob));
                                        } catch (JSONException e) {
                                            e.printStackTrace();
                                        }
                                    }
                                });

                            } else if (jsonObject.getString("Message").equals("Already Exist")) {

                                Log.e("SUBMIT", "already Exists");

                                tv1.setText("Welcome Back");
                                tv2.setText("Looks Like you are already with us. \n" + jsonObject.getString("FastTrackId"));
                                Button loginbtn = JoinUsFragment.responceDialog.findViewById(R.id.dialog_okbtn);
                                loginbtn.setText("Ok");
                                loginbtn.setOnClickListener(new View.OnClickListener() {
                                    @Override
                                    public void onClick(View view) {
                                        JoinUsFragment.responceDialog.dismiss();
                                        JoinUsFragment.firstBtn.callOnClick();
                                        try {
                                            storeTempLoginData(jsonObject.getString("FastTrackId"), "");
                                        } catch (JSONException e) {
                                            e.printStackTrace();
                                        }
                                    }
                                });


                            } else {

                                Log.e("SUBMIT", "ELSE");
                                tv1.setText("Error");
                                tv2.setText("Looks Like something went wrong, try again?");
                                Button loginbtn = JoinUsFragment.responceDialog.findViewById(R.id.dialog_okbtn);
                                loginbtn.setText("Ok");
                                loginbtn.setOnClickListener(new View.OnClickListener() {
                                    @Override
                                    public void onClick(View view) {

                                        JoinUsFragment.responceDialog.dismiss();
                                    }
                                });


                            }

                        } catch (JSONException e) {
                            e.printStackTrace();
                            Log.e("JSONOBJ ERROR", e + "");
                        }
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Toast.makeText(activity, error.toString(), Toast.LENGTH_SHORT).show();
                    }

                });
        requestQueue.add(StringRequest);

    }


    public void validate(final Activity activity,String username, String password) {
        Log.e("asdadad","dsadadadadadad");
        String data = activity.getResources().getString(R.string.API_VALIDATE);
        data+="UserId="+username+"&"+"Credential="+password;
        Log.e("asdadad",data);
        RequestQueue requestQueue = Volley.newRequestQueue(activity);
        StringRequest StringRequest = new StringRequest(Request.Method.GET, data,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        Log.e("RESPONSE", response);
                        try {
                            Log.e("Next", "next");
                            final JSONObject jsonObject = new JSONObject(response);
                            JoinUsFragment.responceDialog.show();
                            TextView tv1 = JoinUsFragment.responceDialog.findViewById(R.id.dialog_responce1);
                            TextView tv2 = JoinUsFragment.responceDialog.findViewById(R.id.dialog_responce2);

                            if (jsonObject.getString("Message").equals("Success")) {
                                JoinUsFragment.responceDialog.dismiss();
                                SessionData.getSessionData().setFastrackId(jsonObject.getString("LoginId"));
                                SessionData.getSessionData().setAccessToken(jsonObject.getString("ReDirectURL"));
                                Intent i=new Intent(activity, Phase2Activity.class);
                                i.putExtra("AccessToken", jsonObject.getString("ReDirectURL"));
                                activity.startActivity(i);


                            } else {
                                tv1.setText("Oops..! Looks like there has been a mistake");
                                tv2.setText("Try Login again with your credentials");
                                Button loginbtn = JoinUsFragment.responceDialog.findViewById(R.id.dialog_okbtn);
                                loginbtn.setText("Ok");
                                loginbtn.setOnClickListener(new View.OnClickListener() {
                                    @Override
                                    public void onClick(View view) {
                                        JoinUsFragment.responceDialog.dismiss();
                                        //JoinUsFragment.firstBtn.callOnClick();
                                        try {
                                            storeTempLoginData(jsonObject.getString("FastTrackId"), "");
                                        } catch (JSONException e) {
                                            e.printStackTrace();
                                        }
                                    }
                                });


                            }

                        } catch (JSONException e) {
                            e.printStackTrace();
                            Log.e("JSONOBJ ERROR", e + "");
                        }
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Toast.makeText(activity, error.toString(), Toast.LENGTH_SHORT).show();
                    }

                });
        requestQueue.add(StringRequest);

    }

    private void storeTempLoginData(String ftid, String pass){
        Log.e("storeTest", ftid);
        Log.e("storeTest", pass);
        JoinUsData.getData().getTempLoginData().put("fasttrackid", ftid);
        JoinUsData.getData().getTempLoginData().put("password", pass);

    }
    private String passwordGenerator(String dob){
        String pass="";

        String[] dobSplit=dob.split("/");
        if(dobSplit[0].equals("1")){
            pass="JAN";
        }else if(dobSplit[0].equals("2")){
            pass="FEB";
        }else if(dobSplit[0].equals("3")){
            pass="MAR";
        }else if(dobSplit[0].equals("4")){
            pass="APR";
        }else if(dobSplit[0].equals("5")){
            pass="MAY";
        }else if(dobSplit[0].equals("6")){
            pass="JUN";
        }else if(dobSplit[0].equals("7")){
            pass="JUL";
        }else if(dobSplit[0].equals("8")){
            pass="AUG";
        }else if(dobSplit[0].equals("9")){
            pass="SEP";
        }else if(dobSplit[0].equals("10")){
            pass="OCT";
        }else if(dobSplit[0].equals("11")){
            pass="NOV";
        }else if(dobSplit[0].equals("12")){
            pass="DEC";
        }
        pass=dobSplit[1]+pass+dobSplit[2];

        return pass;
    }

}
    /*

ImageLoader imageLoader=AppSingleton.getInstance(getApplicationContext()).getImageLoader();

imageLoader.get(url, new ImageLoader.ImageListener(){
	@Override
	public void onResponse(ImageLoader.ImageContainer, boolean arg1){
		if(response.getBitmap()!=null){

		}
	}
	@Override
	public void onErrorResponse(Volley error){

	}
});




*/
