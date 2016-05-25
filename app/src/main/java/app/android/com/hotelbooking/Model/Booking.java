package app.android.com.hotelbooking.Model;

/**
 * Created by ASUS on 25/05/2016.
 */

public class Booking {

    private Hotel hotel;
    private User user;
    private int numberOfCompanions;

    public Booking() {
        super();
    }

    public Booking(Hotel hotel, User user, int numberOfCompanions) {
        this.hotel = hotel;
        this.user = user;
        this.numberOfCompanions = numberOfCompanions;
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

    public int getNumberOfCompanions() {
        return numberOfCompanions;
    }

    public void setNumberOfCompanions(int numberOfCompanions) {
        this.numberOfCompanions = numberOfCompanions;
    }
}
