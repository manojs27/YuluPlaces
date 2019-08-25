package com.manoj.yuluplaces.Model;

import com.google.gson.Gson;

public class Location {
    private String cc;

    private String country;

    private String address;

    private LabeledLatLngs[] labeledLatLngs;

    private String lng;

    private String distance;

    private String[] formattedAddress;

    private String city;

    private String postalCode;

    private String state;

    private String crossStreet;

    private String lat;

    public String getCc() {
        return cc;
    }

    public void setCc(String cc) {
        this.cc = cc;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public LabeledLatLngs[] getLabeledLatLngs() {
        return labeledLatLngs;
    }

    public void setLabeledLatLngs(LabeledLatLngs[] labeledLatLngs) {
        this.labeledLatLngs = labeledLatLngs;
    }

    public String getLng() {
        return lng;
    }

    public void setLng(String lng) {
        this.lng = lng;
    }

    public String getDistance() {
        return distance;
    }

    public void setDistance(String distance) {
        this.distance = distance;
    }

    public String[] getFormattedAddress() {
        return formattedAddress;
    }

    public void setFormattedAddress(String[] formattedAddress) {
        this.formattedAddress = formattedAddress;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getCrossStreet() {
        return crossStreet;
    }

    public void setCrossStreet(String crossStreet) {
        this.crossStreet = crossStreet;
    }

    public String getLat() {
        return lat;
    }

    public void setLat(String lat) {
        this.lat = lat;
    }


    @Override
    public String toString() {
        return toJson();
    }

    public String toJson() {
        return new Gson().toJson(this);
    }
}