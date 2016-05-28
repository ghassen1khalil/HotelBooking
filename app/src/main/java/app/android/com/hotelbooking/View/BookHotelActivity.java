package app.android.com.hotelbooking.View;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import app.android.com.hotelbooking.Model.Booking;
import app.android.com.hotelbooking.R;

public class BookHotelActivity extends AppCompatActivity {

    private static final String TAG = "BookHotelActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_book_hotel);

        Booking booking = (Booking) getIntent().getSerializableExtra("booking");
        Log.i(TAG,booking.toString());



    }
}
