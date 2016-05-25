package app.android.com.hotelbooking.Model;

import app.android.com.hotelbooking.Utils.Geocoordinates;

/**
 * Created by ghassen.ati on 25/05/2016.
 */

public class Hotel {

    private int id;
    private String location;
    private String name;
    private int starsRating;
    private double price;
    private double discountPrice;
    private int score;
    private String photo;
    private Geocoordinates geocoordinates;

    public Hotel() {
        super();
    }

    public Hotel(int id, String location, String name, int starsRating, double price, double discountPrice, int score, String photo, Geocoordinates geocoordinates) {
        this.id = id;
        this.location = location;
        this.name = name;
        this.starsRating = starsRating;
        this.price = price;
        this.discountPrice = discountPrice;
        this.score = score;
        this.photo = photo;
        this.geocoordinates = geocoordinates;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getStarsRating() {
        return starsRating;
    }

    public void setStarsRating(int starsRating) {
        this.starsRating = starsRating;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public double getDiscountPrice() {
        return discountPrice;
    }

    public void setDiscountPrice(double discountPrice) {
        this.discountPrice = discountPrice;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public Geocoordinates getGeocoordinates() {
        return geocoordinates;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public void setGeocoordinates(Geocoordinates geocoordinates) {
        this.geocoordinates = geocoordinates;
    }

}
