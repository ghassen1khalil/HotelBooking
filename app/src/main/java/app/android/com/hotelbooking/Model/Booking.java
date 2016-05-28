package app.android.com.hotelbooking.Model;

import java.io.Serializable;

/**
 * Created by ASUS on 25/05/2016.
 */

public class Booking implements Serializable {

    private Hotel hotel;
    private User user;
    private Integer numberOfCompanions;
    private Integer numberOfNights;


    public Booking() {
        super();
    }

    public Booking(Hotel hotel, User user, Integer numberOfCompanions, Integer numberOfNights) {
        this.hotel = hotel;
        this.user = user;
        this.numberOfCompanions = numberOfCompanions;
        this.numberOfNights = numberOfNights;
    }

    public Hotel getHotel() {
        return hotel;
    }

    public void setHotel(Hotel hotel) {
        this.hotel = hotel;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Integer getNumberOfCompanions() {
        return numberOfCompanions;
    }

    public void setNumberOfCompanions(Integer numberOfCompanions) {
        this.numberOfCompanions = numberOfCompanions;
    }

    public Integer getNumberOfNights() {
        return numberOfNights;
    }

    public void setNumberOfNights(Integer numberOfNights) {
        this.numberOfNights = numberOfNights;
    }

    @Override
    public String toString() {
        return "Hôtel réservé: "+this.hotel.getName()  + " pour l'utilisateur: "+this.user.getFirstName()+ " "+ this.user.getLastName()+ " Avec "+this.getNumberOfCompanions()+" compagnon(s)"+ " pour une durée de "+this.getNumberOfNights()+" nuit(s)";
    }
}
