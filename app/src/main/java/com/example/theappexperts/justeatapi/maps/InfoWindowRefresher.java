package com.example.theappexperts.justeatapi.maps;

import android.util.Log;

import com.google.android.gms.maps.model.Marker;
import com.squareup.picasso.Callback;

/**
 * Created by TheAppExperts on 05/10/2017.
 */

class InfoWindowRefresher implements Callback {

    Marker marker = null;
    public InfoWindowRefresher(Marker marker) {
        this.marker=marker;
    }

    @Override
    public void onSuccess() {
        if (marker != null && marker.isInfoWindowShown()) {
            marker.showInfoWindow();

        }
    }

    @Override
    public void onError() {
        Log.i("blah", getClass().getSimpleName());

    }
}
