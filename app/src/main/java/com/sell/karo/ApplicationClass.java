package com.sell.karo;

import android.app.Application;
import android.content.Context;
import android.support.multidex.MultiDex;
import android.text.TextUtils;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.toolbox.ImageLoader;
import com.android.volley.toolbox.Volley;

import org.acra.ACRA;


//import com.appnosys.sellkaroapp.activities.ChatActivity;

/**
 * Created by Khushvinders on 21-Nov-16.
 */



public class ApplicationClass extends Application {

    public static final String TAG = ApplicationClass.class.getSimpleName();
    private RequestQueue mRequestQueue;
    private ImageLoader mImageLoader;
    private static ApplicationClass mInstance;
  //  public Socket mSocket;

    @Override
    public void onCreate() {
        super.onCreate();
//        {
//            try {
//                mSocket = IO.socket("http://sellkaro.in:3000");
//            } catch (
//                    Exception e) {
//                System.out.println("jjjjj"+e.getMessage());
//            }
//        }
      //      mSocket.connect();
            mInstance = this;
    }


    public static synchronized ApplicationClass getInstance() {
        return mInstance;
    }

    public RequestQueue getRequestQueue() {
        if (mRequestQueue == null) {
            mRequestQueue = Volley.newRequestQueue(getApplicationContext());
        }

        return mRequestQueue;
    }


    public <T> void addToRequestQueue(Request<T> req, String tag) {
        // set the default tag if tag is empty
        req.setTag(TextUtils.isEmpty(tag) ? TAG : tag);
        getRequestQueue().add(req);
    }

    public <T> void addToRequestQueue(Request<T> req) {
        req.setTag(TAG);
        getRequestQueue().add(req);
    }

    @Override
    protected void attachBaseContext(Context base) {
        super.attachBaseContext(base);
        MultiDex.install(this);
        ACRA.init(this);
    }

    public void cancelPendingRequests(Object tag) {
        if (mRequestQueue != null) {
            mRequestQueue.cancelAll(tag);
        }
    }

    //--------CHECKING INTERNET CONNECTION CODE IN BACKGROUND----------
  /*  public void setConnectivityListener(ConnectivityReceiver.ConnectivityReceiverListener listener) {
        ConnectivityReceiver.connectivityReceiverListener = listener;
    }*/
}