package com.example.theappexperts.justeatapi.service;

import com.example.theappexperts.justeatapi.model.EatModel;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.Query;

/**
 * Created by TheAppExperts on 04/10/2017.
 */

public interface RestaurantAPI {

    @Headers({
            Constants.HEADER_ACCEPT_TENANT,
            Constants.HEADER_ACCEPT_LANGUAGE,
            Constants.HEADER_AUTHORIZATION,
            Constants.HEADER_HOST
    })
    @GET(Constants.BASE_URL)
    Observable<EatModel> getRestaurantList(@Query(Constants.QUERY) String location);
}
