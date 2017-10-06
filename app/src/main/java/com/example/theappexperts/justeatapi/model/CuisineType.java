package com.example.theappexperts.justeatapi.model;

/**
 * Created by TheAppExperts on 04/10/2017.
 */
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class CuisineType {

    @SerializedName("Id")
    @Expose
    private Double id;
    @SerializedName("Name")
    @Expose
    private String name;
    @SerializedName("SeoName")
    @Expose
    private String seoName;

    public Double getId() {
        return id;
    }

    public void setId(Double id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSeoName() {
        return seoName;
    }

    public void setSeoName(String seoName) {
        this.seoName = seoName;
    }

}