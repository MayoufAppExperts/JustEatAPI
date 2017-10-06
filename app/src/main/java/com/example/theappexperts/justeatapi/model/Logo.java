package com.example.theappexperts.justeatapi.model;

/**
 * Created by TheAppExperts on 04/10/2017.
 */

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Logo {

    @SerializedName("StandardResolutionURL")
    @Expose
    private String standardResolutionURL;

    public String getStandardResolutionURL() {
        return standardResolutionURL;
    }

    public void setStandardResolutionURL(String standardResolutionURL) {
        this.standardResolutionURL = standardResolutionURL;
    }

}