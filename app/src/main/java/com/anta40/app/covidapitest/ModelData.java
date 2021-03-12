package com.anta40.app.covidapitest;

import com.google.gson.annotations.SerializedName;

public class ModelData {

    @SerializedName("country")
    private String country;

    @SerializedName("totalConfirmed")
    private String totalConfirmed;

    @SerializedName("newConfirmed")
    private String newConfirmed;

    @SerializedName("totalDeaths")
    private String totalDeaths;

    @SerializedName("newDeaths")
    private String newDeaths;

    @SerializedName("totalRecovered")
    private String totalRecovered;

    @SerializedName("newRecovered")
    private String newRecovered;

    public ModelData(String country, String totalConfirmed, String newConfirmed, String totalDeaths,
                     String newDeaths, String totalRecovered, String newRecovered){

        this.country = country;
        this.totalConfirmed = totalConfirmed;
        this.newConfirmed = newConfirmed;
        this.totalDeaths = totalDeaths;
        this.newDeaths = newDeaths;
        this.totalRecovered = totalRecovered;
        this.newRecovered = newRecovered;
    }

    public String getCountry() { return country; }
    public String getTotalConfirmed() { return totalConfirmed; }
    public String getNewConfirmed() { return newConfirmed; }
    public String getTotalDeaths() { return totalDeaths; }
    public String getNewDeaths() { return newDeaths; }
    public String getTotalRecovered()  { return totalRecovered; }
    public String getNewRecovered(){ return newRecovered; }
}
