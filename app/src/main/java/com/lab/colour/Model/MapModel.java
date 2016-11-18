package com.lab.colour.Model;

import java.io.Serializable;

/**
 * Created by SeoHyeonBae on 2016-11-15.
 */

public class MapModel implements Serializable {

    private String lat;
    private String lon;
    private String restaurantName;
    private String address;

    public MapModel(String lat, String lon, String restaurantName, String address) {
        this.lat = lat;
        this.lon = lon;
        this.restaurantName = restaurantName;
        this.address = address;
    }

    public String getLat() {
        return lat;
    }

    public void setLat(String lat) {
        this.lat = lat;
    }

    public String getLon() {
        return lon;
    }

    public void setLon(String lon) {
        this.lon = lon;
    }

    public String getRestaurantName() {
        return restaurantName;
    }

    public void setRestaurantName(String restaurantName) {
        this.restaurantName = restaurantName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
