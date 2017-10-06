package com.example.theappexperts.justeatapi.maps;

import android.content.Context;
import android.support.v4.app.FragmentActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;

import com.example.theappexperts.justeatapi.ConnectionService;
import com.example.theappexperts.justeatapi.MainActivity;
import com.example.theappexperts.justeatapi.PicassoMarker;
import com.example.theappexperts.justeatapi.R;
import com.example.theappexperts.justeatapi.model.EatModel;
import com.example.theappexperts.justeatapi.model.Restaurant;
import com.example.theappexperts.justeatapi.service.Constants;
import com.example.theappexperts.justeatapi.service.RestaurantAPI;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;
import com.squareup.picasso.Picasso;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

public class RestaurantList extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap;
    RestaurantAPI restaurantAPI;
    EatModel eatModel;
    Marker marker;
    PicassoMarker picassoMarker;





    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_restaurant_list);

        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
    }

    private void onSuccess(EatModel eatModel) {
        for (int i = 0; i < eatModel.getRestaurants().size(); i++) {
            LatLng foodPlace = new LatLng(eatModel.getRestaurants().get(i).getLatitude(),
                    eatModel.getRestaurants().get(i).getLongitude());


            marker = mMap.addMarker(new MarkerOptions().position(foodPlace)
                    .title(eatModel.getRestaurants().get(i).getName())
                    .snippet(eatModel.getRestaurants().get(i).getRatingAverage().toString()));
                    //mMap.addMarker(new MarkerOptions().position(foodPlace)
                    //.icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_AZURE)));


            picassoMarker = new PicassoMarker(marker);
            Picasso.with(RestaurantList.this)
                    .load(eatModel.getRestaurants().get(i).getLogo().get(0).getStandardResolutionURL())
                    .resize(80,80)
                    .into(picassoMarker);

            //.snippet(eatModel.getRestaurants().get(i).getLogo().get(i).getStandardResolutionURL()));
            mMap.moveCamera(CameraUpdateFactory.newLatLng(foodPlace));
            mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(foodPlace, 10));

        }
    }

    private void onError(Throwable throwable) {
        Log.i("Error", throwable.getMessage());
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
        // Add a marker in Sydney and move the camera
        //LatLng sydney = new LatLng(-34, 151);


        restaurantAPI = ConnectionService.getConnectionService();
        restaurantAPI.getRestaurantList(Constants.VALUE)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.newThread())
                .subscribe(this::onSuccess, this::onError);

    }
}
