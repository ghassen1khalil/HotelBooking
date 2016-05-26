package app.android.com.hotelbooking.Controller;

import android.content.ContentResolver;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
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

    public void searchHotels(String location) {
        int count = 0;
        ContentResolver contentResolver = context.getContentResolver();
        Uri hotels = Uri.parse(HotelsProvider.getURL());

        Cursor cursor = contentResolver.query(hotels, null, "location LIKE ?", new String[]{location + "%" }, "price");


        if (cursor.moveToFirst()) {
            Log.i(TAG, String.valueOf(cursor.getPosition()));
            do {
                count++;
                Log.i(TAG, ", _ID: " + cursor.getString(cursor.getColumnIndex(HotelsProvider.getId())) +
                        ", NAME: " + cursor.getString(cursor.getColumnIndex(HotelsProvider.getNAME())) +
                        ", LOCATION: " + cursor.getString(cursor.getColumnIndex(HotelsProvider.getLOCATION())) +
                        ", LATITUDE: " + cursor.getString(cursor.getColumnIndex(HotelsProvider.getLATITUDE())) +
                        ", LONGITUDE: " + cursor.getString(cursor.getColumnIndex(HotelsProvider.getLONGITUDE())) +
                        ", SCORE: " + cursor.getString(cursor.getColumnIndex(HotelsProvider.getSCORE())) +
                        ", STARSRATING: " + cursor.getString(cursor.getColumnIndex(HotelsProvider.getSTARSRATING())) +
                        ", PRICE: " + cursor.getString(cursor.getColumnIndex(HotelsProvider.getPRICE())) +
                        ", DISCOUNTPRICE: " + cursor.getString(cursor.getColumnIndex(HotelsProvider.getDISCOUNTPRICE())) +
                        ", PHOTO: " + cursor.getString(cursor.getColumnIndex(HotelsProvider.getPHOTO()))
                );

            } while (cursor.moveToNext());
        }
        Log.i(TAG, "Nombre de records enregistrés: " + String.valueOf(count));

    }
}
