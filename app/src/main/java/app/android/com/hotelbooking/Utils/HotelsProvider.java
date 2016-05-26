package app.android.com.hotelbooking.Utils;

import android.content.ContentProvider;
import android.content.ContentUris;
import android.content.ContentValues;
import android.content.Context;
import android.content.UriMatcher;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.database.sqlite.SQLiteQueryBuilder;
import android.net.Uri;
import android.support.annotation.Nullable;

import java.util.HashMap;

/**
 * Created by ghassen.ati on 25/05/2016.
 */

public class HotelsProvider extends ContentProvider {

    static final String PROVIDER_NAME = "app.android.com.hotelbooking.Utils.HotelsProvider";

    static final String URL = "content://" + PROVIDER_NAME + "/hotel";
    static final Uri CONTENT_URI = Uri.parse(URL);

    static final String _ID = "_id";
    static final String LOCATION = "location";
    static final String NAME = "name";
    static final String STARSRATING = "starsrating";
    static final String PRICE = "price";
    static final String DISCOUNTPRICE = "discountprice";
    static final String SCORE = "score";
    static final String PHOTO = "photo";
    static final String LATITUDE = "latitude";
    static final String LONGITUDE = "longitude";

    private static HashMap<String, String> HOTELS_PROJECTION_MAP;
    static final int HOTEL = 1;
    static final int HOTEL_ID = 2;

    static final UriMatcher uriMatcher;
    static {
        uriMatcher = new UriMatcher(UriMatcher.NO_MATCH);
        uriMatcher.addURI(PROVIDER_NAME, "hotel", HOTEL);
        uriMatcher.addURI(PROVIDER_NAME, "hotel/#", HOTEL_ID);
    }

    private SQLiteDatabase db;
    static final String DATABASE_NAME = "Hotels";
    static final String TABLE_NAME = "hotel";
    static final int DATABASE_VERSION = 1;
    static final String CREATE_DB_TABLE = "CREATE TABLE " + TABLE_NAME + "(_id INTEGER PRIMARY " +
            "KEY AUTOINCREMENT," + "location TEXT NOT NULL," + "name TEXT NOT NULL, " +
            "starsrating INTEGER NOT NULL," + "price INTEGER NOT NULL," + "discountprice INTEGER " +
            "NOT NULL," + "score INTEGER NOT NULL," + "photo TEXT NOT NULL," + "latitude INTEGER " +
            "NOT NULL," + "longitude INTEGER NOT NULL);";

    private static class DataBaseHelper extends SQLiteOpenHelper{

        DataBaseHelper (Context context) {super(context, DATABASE_NAME,null,DATABASE_VERSION);}

        @Override
        public void onCreate(SQLiteDatabase db) {db.execSQL(CREATE_DB_TABLE);}

        @Override
        public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVesion){
            db.execSQL("DROP TABLE IF EXISTS "+TABLE_NAME);
            onCreate(db);
        }

    }

    @Override
    public boolean onCreate(){
        Context context = getContext();
        DataBaseHelper dbHelper = new DataBaseHelper(context);
        db = dbHelper.getWritableDatabase();
        return (db==null)?false:true;
    }

    @Nullable
    @Override
    public Cursor query(Uri uri, String[] projection, String selection, String[] selectionArgs, String sortOrder) {
        SQLiteQueryBuilder queryBuilder = new SQLiteQueryBuilder();
        queryBuilder.setTables(TABLE_NAME);
        switch (uriMatcher.match(uri)) {
            case HOTEL:
                queryBuilder.setProjectionMap(HOTELS_PROJECTION_MAP);
                break;
            case HOTEL_ID:
                queryBuilder.appendWhere(_ID+"="+uri.getPathSegments().get(1));
                break;
            default:
                throw new IllegalArgumentException("URI Inconnue " + uri);
        }
        if (sortOrder == null || sortOrder==""){
            sortOrder = NAME;
        }
        Cursor cursor = queryBuilder.query(db,projection,selection,selectionArgs,null,null,sortOrder);
        cursor.setNotificationUri(getContext().getContentResolver(), uri);
        return cursor;
    }

    @Nullable
    @Override
    public String getType(Uri uri) {
        switch (uriMatcher.match(uri)){
            case HOTEL:
                return "vnd.android.cursor.dir/vnd.app.android.com.hotelbooking";
            case HOTEL_ID:
                return "vnd.android.cursor.item/vnd.app.android.com.hotelbooking";
            default:
                throw new IllegalArgumentException("URI Inconnue" + uri);
        }
    }

    @Nullable
    @Override
    public Uri insert (Uri uri, ContentValues values){
        //Ajout d'un enregistrement
        long rowID = db.insert(TABLE_NAME,"",values);

        //Si l'ajout est effectué avec succès
        if (rowID > 0) {
            Uri _uri = ContentUris.withAppendedId(CONTENT_URI,rowID);
            getContext().getContentResolver().notifyChange(_uri,null);
            return _uri;
        }
        throw new SQLException("Echec lors de l'ajout d'un enregistrement"+uri);
    }

    @Override
    public int delete(Uri uri, String selection, String[] selectionArgs) {
        int count = 0;
        switch (uriMatcher.match(uri)){
            case HOTEL:
                count = db.delete(TABLE_NAME,null,selectionArgs);
                break;
            case HOTEL_ID:
                count  = db.delete(TABLE_NAME,_ID + " = " + selection,selectionArgs);
                break;
            default:
                throw new IllegalArgumentException("URI Inconnue "+ uri);
        }
        getContext().getContentResolver().notifyChange(uri,null);
        return count;

    }

    @Override
    public int update(Uri uri, ContentValues values, String selection, String[] selectionArgs) {
        int count = 0;
        switch (uriMatcher.match(uri)) {
            case HOTEL:
                count = db.update(TABLE_NAME,values,selection,selectionArgs);
                break;
            case HOTEL_ID:
                count = db.update(TABLE_NAME,values, _ID + " = " + selection , selectionArgs);
                break;
            default:
                throw new IllegalArgumentException("URI Inconnue"+ uri);
        }
        getContext().getContentResolver().notifyChange(uri, null);
        return count;
    }

    public static String getId() {
        return _ID;
    }

    public static String getLOCATION() {
        return LOCATION;
    }

    public static String getNAME() {
        return NAME;
    }

    public static String getSTARSRATING() {
        return STARSRATING;
    }

    public static String getPRICE() {
        return PRICE;
    }

    public static String getDISCOUNTPRICE() {
        return DISCOUNTPRICE;
    }

    public static String getSCORE() {
        return SCORE;
    }

    public static String getPHOTO() {
        return PHOTO;
    }

    public static String getLATITUDE() {
        return LATITUDE;
    }

    public static String getLONGITUDE() {
        return LONGITUDE;
    }

    public static Uri getContentUri() {
        return CONTENT_URI;
    }

    public static String getURL() {
        return URL;
    }
}
