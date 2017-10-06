package com.example.theappexperts.justeatapi;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import com.example.theappexperts.justeatapi.model.EatModel;
import com.example.theappexperts.justeatapi.service.Constants;
import com.example.theappexperts.justeatapi.service.RestaurantAPI;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

public class MainActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    RestaurantAPI restaurantAPI;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initialiseRecyclerView();

        restaurantAPI = ConnectionService.getConnectionService();
        restaurantAPI.getRestaurantList(Constants.VALUE)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.newThread())
                .subscribe(this::onSuccess, this::onError);


    }

    private void onError(Throwable throwable) {
        Log.i("Error", throwable.getMessage());

    }

    private void onSuccess(EatModel eatModel) {


        Log.i("check ", eatModel.getRestaurants().get(1).getName());
        recyclerView.setAdapter(new EatAdapter(eatModel, R.layout.row, getApplication()));

    }

    private void initialiseRecyclerView() {
        recyclerView = (RecyclerView) findViewById(R.id.recyclerCake);
        recyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext()));

    }
}
