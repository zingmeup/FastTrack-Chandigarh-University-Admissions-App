import android.content.Context;
import android.graphics.Bitmap;
import android.support.v4.util.LruCache;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.toolbox.ImageLoader;
import com.android.volley.toolbox.Volley;


public class VolleyClass{
    private static VolleyClass volleyClass;
    private RequestQueue requestQueue;
    private ImageLoader imageLoader;
    private static Context context;



    public static synchronized VolleyClass getInstance(Context context){
        if(volleyClass==null){
            volleyClass=new VolleyClass(context);
        }
        return volleyClass;
    }
    VolleyClass(Context context) {
        VolleyClass.context=context;
        requestQueue=getRequestQueue();
        imageLoader=new ImageLoader(requestQueue,new ImageLoader.ImageCache(){
            private final LruCache<String, Bitmap> lruCache=new LruCache<>(20);
            @Override
            public Bitmap getBitmap(String url){
                return lruCache.get(url);
            }
            @Override
            public void putBitmap(String url, Bitmap bitmap){
                lruCache.put(url, bitmap);
            }
        });
    }
    public RequestQueue getRequestQueue(){
        if(requestQueue==null){
            requestQueue=Volley.newRequestQueue(context.getApplicationContext());
        }
        return requestQueue;
    }
    public ImageLoader getImageLoader(){
			return imageLoader;
	}
    public <T> void addToRequestQueue(Request<T> req) {
        getRequestQueue().add(req);
    }

}
