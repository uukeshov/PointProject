package com.uukeshov.point;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v7.widget.Toolbar;

import com.google.android.gms.maps.CameraUpdate;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

import java.util.List;

public class MapsActivity extends FragmentActivity implements OnMapReadyCallback {
    private static final String LOG_TAG = "MainActivityLog";
    private GoogleMap mMap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        //setSupportActionBar(toolbar); //доделать toolbar
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
    }


    /**
     * Manipulates the map once available.
     * This callback is triggered when the map is ready to be used.
     * This is where we can add markers or lines, add listeners or move the camera. In this case,
     * we just add a marker near Sydney, Australia.
     * If Google Play services is not installed on the device, the user will be prompted to install
     * it inside the SupportMapFragment. This method will only be triggered once the user has
     * installed Google Play services and returned to the app.
     */
    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;
        init();
    }

    public void init() {

        PointDB db = new PointDB(MapsActivity.this);
        List<Point> stringItems = db.getAllPoints();
        //Log.d(LOG_TAG, "--- MapManager---" + db.getAllPoints());

       for (int i = 0; i < stringItems.size(); i++) {

            Point point = stringItems.get(i);

            LatLng coordinate = new LatLng(point.get_pointLat(),point.get_pointLon());
            CameraUpdate yourLocation = CameraUpdateFactory.newLatLngZoom(coordinate, 10);
            mMap.addMarker(new MarkerOptions().position(coordinate).title(point.get_pointName()));
            mMap.animateCamera(yourLocation);
       }
    }
}
