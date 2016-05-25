package app.android.com.hotelbooking.Controller;

import android.content.ContentValues;
import android.content.Context;
import android.net.Uri;
import android.util.Log;

import app.android.com.hotelbooking.Utils.HotelsProvider;

/**
 * Created by ghassen.ati on 25/05/2016.
 */

public class HotelManager {

    private static final String TAG = "HotelManager";
    private Context context;

    public HotelManager(Context context) {
        this.context = context;
    }

    public void addHotel(String location, String name, String starsRating, String score, String photo, String price, String discountPrice, String latitude, String longitude) {
        ContentValues values = new ContentValues();
        values.put(HotelsProvider.getLOCATION(), location);
        values.put(HotelsProvider.getNAME(), name);
        values.put(HotelsProvider.getSTARSRATING(), starsRating);
        values.put(HotelsProvider.getSCORE(), score);
        values.put(HotelsProvider.getPHOTO(), photo);
        values.put(HotelsProvider.getPRICE(), price);
        values.put(HotelsProvider.getDISCOUNTPRICE(), discountPrice);
        values.put(HotelsProvider.getLATITUDE(), latitude);
        values.put(HotelsProvider.getLONGITUDE(), longitude);
        //values.put(HotelsProvider.getId(), "1");
        Uri uri = context.getContentResolver().insert(HotelsProvider.getContentUri(), values);
        Log.i(TAG, "----------->>>>>>>  L'HOTEL "+ name +" VIENT D'ÊTRE AJOUTE  <<<<<<<-----------");


    }
}
