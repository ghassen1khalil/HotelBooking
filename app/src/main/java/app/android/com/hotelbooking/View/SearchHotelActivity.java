package app.android.com.hotelbooking.View;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import app.android.com.hotelbooking.Controller.HotelManager;
import app.android.com.hotelbooking.R;

public class SearchHotelActivity extends AppCompatActivity {
    Context context;
    HotelManager hotelManager ;

    private static final String TAG = "SearchHotelActivity";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search_hotel);

        context = getApplicationContext();
        hotelManager = new HotelManager(context);
        hotelManager.addHotel("Sousse","Marhaba Club", "5","75","une photo", "120", "100","34","10");
        hotelManager.addHotel("Mahdia","Novotel", "5","75","une photo", "120", "100","34","10");
        hotelManager.addHotel("Tunis","Med V", "5","75","une photo", "120", "100","34","10");
        hotelManager.addHotel("Hammamet","Sahara Beach", "5","75","une photo", "120", "100","34","10");
        hotelManager.addHotel("Sfax","Arcades", "5","75","une photo", "120", "100","34","10");
        hotelManager.searchHotels("Sousse");

    }


}
