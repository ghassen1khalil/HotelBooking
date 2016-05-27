package app.android.com.hotelbooking.View;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import app.android.com.hotelbooking.Controller.HotelManager;
import app.android.com.hotelbooking.R;

public class SearchHotelActivity extends AppCompatActivity {

    private static final String TAG = "SearchHotelActivity";


    Context context;
    HotelManager hotelManager ;

    Button searchHotel;
    TextView hotelToSearch;



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

        hotelToSearch = (TextView) findViewById(R.id.hotelToSearchEditText);



        searchHotel = (Button) findViewById(R.id.searchHotelButton);
        searchHotel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Bundle bundle = new Bundle();

                Intent hotelsListIntent = new Intent(SearchHotelActivity.this,HotelListActivity.class);
                String hotelLocation = hotelToSearch.getText().toString();


                if (hotelLocation != null || hotelLocation != ""){
                    bundle.putString("location",hotelLocation);
                    hotelsListIntent.putExtras(bundle);
                    startActivity(hotelsListIntent);
                }

            }
        });

    }


}
