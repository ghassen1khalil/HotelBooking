package app.android.com.hotelbooking.View;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import org.apache.commons.lang3.math.NumberUtils;

import app.android.com.hotelbooking.Model.Booking;
import app.android.com.hotelbooking.Model.Hotel;
import app.android.com.hotelbooking.Model.User;
import app.android.com.hotelbooking.R;

public class SelectedHotelActivity extends AppCompatActivity {

    private static final String TAG = "SelectedHotelActivity";
    Button bookButton;
    User user;
    Booking booking;
    private TextView bookedHotelNameValue, bookedHotelStarsRatingValue, bookedHotelPriceValue, bookedHotelDiscountPriceValue;
    private EditText bookingUserLastNameEditText, bookingUserFirstNameEditText, bookingUserEmailEditText, bookingUserNbCompanionsEditText, bookingUserNbNightsEditText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_selected_hotel);

        final Hotel hotel = (Hotel) getIntent().getSerializableExtra("theHotel");
        bookButton = (Button) findViewById(R.id.bookButton);
        user = new User();
        booking = new Booking();


        bookedHotelNameValue = (TextView) findViewById(R.id.bookedHotelNameValueTextView);
        bookedHotelStarsRatingValue = (TextView) findViewById(R.id.bookedHotelStarsRatingValueTextView);
        bookedHotelPriceValue = (TextView) findViewById(R.id.bookedHotelPriceValueTextView);
        bookedHotelDiscountPriceValue = (TextView) findViewById(R.id.bookedHotelDiscountPriceValueTextView);



        bookedHotelNameValue.setText(hotel.getName().toString());
        bookedHotelStarsRatingValue.setText(hotel.getStarsRating().toString());
        bookedHotelPriceValue.setText(hotel.getPrice().toString());
        bookedHotelDiscountPriceValue.setText(hotel.getDiscountPrice().toString());


        bookButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                bookingUserLastNameEditText = (EditText) findViewById(R.id.bookingUserLastNameEditText);
                bookingUserFirstNameEditText = (EditText) findViewById(R.id.bookingUserFirstNameEditText);
                bookingUserEmailEditText = (EditText) findViewById(R.id.bookingUserEmailEditText);
                bookingUserNbCompanionsEditText = (EditText) findViewById(R.id.bookingUserNbCompanionsEditText);
                bookingUserNbNightsEditText = (EditText) findViewById(R.id.bookingUserNbNightsEditText);

                if (NumberUtils.isNumber(bookingUserNbCompanionsEditText.getText().toString()) && NumberUtils.isNumber(bookingUserNbNightsEditText.getText().toString())) {
                    user.setFirstName(bookingUserFirstNameEditText.getText().toString());
                    user.setLastName(bookingUserFirstNameEditText.getText().toString());
                    user.setEmail(bookingUserEmailEditText.getText().toString());

                    booking.setHotel(hotel);
                    booking.setUser(user);
                    booking.setNumberOfCompanions(Integer.valueOf(bookingUserNbCompanionsEditText.getText().toString()));
                    booking.setNumberOfNights(Integer.valueOf(bookingUserNbNightsEditText.getText().toString()));

                    Intent bookingIntent = new Intent(SelectedHotelActivity.this, BookHotelActivity.class);
                    bookingIntent.putExtra("booking", booking);
                    Log.i(TAG, booking.toString());
                    startActivity(bookingIntent);

                }


            }
        });

    }
}
