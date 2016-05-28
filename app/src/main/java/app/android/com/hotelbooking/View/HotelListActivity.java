package app.android.com.hotelbooking.View;

import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.LoaderManager;
import android.support.v4.content.CursorLoader;
import android.support.v4.content.Loader;
import android.support.v4.widget.SimpleCursorAdapter;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;

import app.android.com.hotelbooking.Model.Hotel;
import app.android.com.hotelbooking.R;
import app.android.com.hotelbooking.Utils.HotelsProvider;

public class HotelListActivity extends AppCompatActivity implements LoaderManager
        .LoaderCallbacks<Cursor> {

    private static final String TAG = "HotelListActivity";


    String location;

    SimpleCursorAdapter mAdapter;
    ListView mListView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hotel_list);

        Intent intent = getIntent();
        Bundle bundle = intent.getExtras();

        setLocation(bundle.getString("location"));
        mListView = (ListView) findViewById(R.id.hotelsListview);

        String[] from = new String[]{HotelsProvider.getNAME(), HotelsProvider.getSTARSRATING(),
                HotelsProvider.getPRICE(), HotelsProvider.getDISCOUNTPRICE()};
        int[] to = new
                int[]{R.id.nameTextView, R.id.starsRatingTextView, R.id.priceTextView, R.id
                .discountPriceTextView};

        mAdapter = new SimpleCursorAdapter(getBaseContext(), R.layout.listview_item_layout, null, from, to, 0);
        mListView.setAdapter(mAdapter);
        getSupportLoaderManager().initLoader(0, null, this);

        mListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                TextView nameTextView = (TextView) view.findViewById(R.id.nameTextView);
                TextView starsRatingTextView = (TextView) view.findViewById(R.id.starsRatingTextView);
                TextView priceTextView = (TextView) view.findViewById(R.id.priceTextView);
                TextView discountPriceTextView = (TextView) view.findViewById(R.id.discountPriceTextView);

                Hotel hotel = new Hotel(nameTextView.getText().toString(), Integer.parseInt(starsRatingTextView.getText().toString()), Double.parseDouble(priceTextView.getText().toString()), Double.parseDouble(discountPriceTextView.getText().toString()));

                Intent bookingIntent = new Intent(HotelListActivity.this,SelectedHotelActivity.class);
                bookingIntent.putExtra("theHotel",hotel);
                startActivity(bookingIntent);
                Log.i(TAG, hotel.toString());

            }
        });


    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    /**
     * A callback method invoked by the loader when initLoader() is called
     */
    @Override
    public Loader<Cursor> onCreateLoader(int arg0, Bundle arg1) {
        Uri uri = HotelsProvider.getContentUri();
        String selection = "location" + "=?";
        String[] selectionArgs = {location};
        CursorLoader cursorLoader = new CursorLoader(this, uri, null, selection, selectionArgs, "price");
        return cursorLoader;
    }

    /**
     * A callback method, invoked after the requested content provider returned all the data
     */
    @Override

    public void onLoadFinished(Loader<Cursor> arg0, Cursor arg1) {
        mAdapter.swapCursor(arg1);
    }

    @Override
    public void onLoaderReset(Loader<Cursor> arg0) {
        mAdapter.swapCursor(null);
    }
}
