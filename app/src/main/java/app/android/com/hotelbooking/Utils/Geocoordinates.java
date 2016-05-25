package app.android.com.hotelbooking.Utils;

/**
 * Created by ghassen.ati on 25/05/2016.
 */

public class Geocoordinates {

    private double longitude;
    private double latitude;

    public Geocoordinates(double longitude, double latitude) {
        this.longitude = longitude;
        this.latitude = latitude;
    }

    public Geocoordinates() {
        super();
    }

    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }
}
