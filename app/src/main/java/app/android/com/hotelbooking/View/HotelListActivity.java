package app.android.com.hotelbooking.View;

import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.LoaderManager;
import android.support.v4.content.CursorLoader;
import android.support.v4.content.Loader;
import android.support.v4.widget.SimpleCursorAdapter;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;

import app.android.com.hotelbooking.R;
import app.android.com.hotelbooking.Utils.HotelsProvider;

public class HotelListActivity extends AppCompatActivity implements LoaderManager
        .LoaderCallbacks<Cursor> {

    SimpleCursorAdapter mAdapter;
    ListView mListView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hotel_list);

        mListView = (ListView) findViewById(R.id.hotelsListview);

        mAdapter = new SimpleCursorAdapter(getBaseContext(), R.layout.listview_item_layout, null,
                new String[]{HotelsProvider.getNAME(), HotelsProvider.getSTARSRATING(),
                        HotelsProvider.getPRICE(), HotelsProvider.getDISCOUNTPRICE()}, new
                int[]{R.id.nameTextView, R.id.starsRatingTextView, R.id.priceTextView, R.id
                .discountPriceTextView},
                0);
        mListView.setAdapter(mAdapter);
        getSupportLoaderManager().initLoader(0,null,this);

    }

    /**
     * A callback method invoked by the loader when initLoader() is called
     */
    @Override
    public Loader<Cursor> onCreateLoader(int arg0, Bundle arg1) {
        Uri uri = HotelsProvider.getContentUri();
        return new CursorLoader(this, uri, null, null, null, null);
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
