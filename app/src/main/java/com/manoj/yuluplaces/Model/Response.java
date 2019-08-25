package com.manoj.yuluplaces.Model;

import com.google.gson.Gson;

import java.util.List;

public class Response
{
    private String confident;

    private List<Venues> venues;

    public String getConfident ()
    {
        return confident;
    }

    public void setConfident (String confident)
    {
        this.confident = confident;
    }

    public List<Venues> getVenues ()
    {
        return venues;
    }

    public void setVenues (List<Venues> venues)
    {
        this.venues = venues;
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