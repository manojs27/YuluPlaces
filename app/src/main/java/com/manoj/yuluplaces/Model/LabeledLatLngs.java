package com.manoj.yuluplaces.Model;

import com.google.gson.Gson;

public class LabeledLatLngs
{
    private String lng;

    private String label;

    private String lat;

    public String getLng ()
    {
        return lng;
    }

    public void setLng (String lng)
    {
        this.lng = lng;
    }

    public String getLabel ()
    {
        return label;
    }

    public void setLabel (String label)
    {
        this.label = label;
    }

    public String getLat ()
    {
        return lat;
    }

    public void setLat (String lat)
    {
        this.lat = lat;
    }


    @Override
    public String toString()
    {
        return toJson();
    }

    public String toJson() {
        return new Gson().toJson(this);
    }
}