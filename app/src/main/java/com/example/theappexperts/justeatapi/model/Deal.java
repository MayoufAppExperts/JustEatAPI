package com.example.theappexperts.justeatapi.model;

/**
 * Created by TheAppExperts on 04/10/2017.
 */
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Deal {

    @SerializedName("Description")
    @Expose
    private String description;
    @SerializedName("DiscountPercent")
    @Expose
    private String discountPercent;
    @SerializedName("QualifyingPrice")
    @Expose
    private String qualifyingPrice;

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDiscountPercent() {
        return discountPercent;
    }

    public void setDiscountPercent(String discountPercent) {
        this.discountPercent = discountPercent;
    }

    public String getQualifyingPrice() {
        return qualifyingPrice;
    }

    public void setQualifyingPrice(String qualifyingPrice) {
        this.qualifyingPrice = qualifyingPrice;
    }

}