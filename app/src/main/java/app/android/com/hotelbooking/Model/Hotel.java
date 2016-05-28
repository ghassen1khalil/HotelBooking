package app.android.com.hotelbooking.Model;

import java.io.Serializable;

import app.android.com.hotelbooking.Utils.Geocoordinates;

/**
 * Created by ghassen.ati on 25/05/2016.
 */

public class Hotel implements Serializable{

    private int id;
    private String location;
    private String name;
    private Integer starsRating;
    private Double price;
    private Double discountPrice;
    private Integer score;
    private String photo;
    private Geocoordinates geocoordinates;

    public Hotel() {
        super();
    }

    public Hotel(int id, String location, String name, Integer starsRating, Double price, Double discountPrice, Integer score, String photo, Geocoordinates geocoordinates) {
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

    public Hotel( String name, Integer starsRating, Double price, Double discountPrice) {
        this.name = name;
        this.starsRating = starsRating;
        this.price = price;
        this.discountPrice = discountPrice;

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

    public Integer getStarsRating() {
        return starsRating;
    }

    public void setStarsRating(Integer starsRating) {
        this.starsRating = starsRating;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Double getDiscountPrice() {
        return discountPrice;
    }

    public void setDiscountPrice(Double discountPrice) {
        this.discountPrice = discountPrice;
    }

    public Integer getScore() {
        return score;
    }

    public void setScore(Integer score) {
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

    @Override
    public String toString() {
        return "Nom: "+this.name + " | "+this.starsRating+" Etoiles | Prix intilal: "+ this.price + " | Nouveau Prix: "+this.discountPrice;
    }

}
