package com.manoj.yuluplaces.Model;

import com.google.gson.Gson;

public class Venues
{
    private String hasPerk;

    private HereNow hereNow;

    private Stats stats;

    private String referralId;

    private Object contact;

    private String[] venueChains;

    private String name;

    private String verified;

    private Location location;

    private String id;

    private Categories[] categories;

    private BeenHere beenHere;

    public String getHasPerk ()
    {
        return hasPerk;
    }

    public void setHasPerk (String hasPerk)
    {
        this.hasPerk = hasPerk;
    }

    public HereNow getHereNow ()
    {
        return hereNow;
    }

    public void setHereNow (HereNow hereNow)
    {
        this.hereNow = hereNow;
    }

    public Stats getStats ()
    {
        return stats;
    }

    public void setStats (Stats stats)
    {
        this.stats = stats;
    }

    public String getReferralId ()
    {
        return referralId;
    }

    public void setReferralId (String referralId)
    {
        this.referralId = referralId;
    }

    public Object getContact ()
    {
        return contact;
    }

    public void setContact (String contact)
    {
        this.contact = contact;
    }

    public String[] getVenueChains ()
    {
        return venueChains;
    }

    public void setVenueChains (String[] venueChains)
    {
        this.venueChains = venueChains;
    }

    public String getName ()
    {
        return name;
    }

    public void setName (String name)
    {
        this.name = name;
    }

    public String getVerified ()
    {
        return verified;
    }

    public void setVerified (String verified)
    {
        this.verified = verified;
    }

    public Location getLocation ()
    {
        return location;
    }

    public void setLocation (Location location)
    {
        this.location = location;
    }

    public String getId ()
    {
        return id;
    }

    public void setId (String id)
    {
        this.id = id;
    }

    public Categories[] getCategories ()
    {
        return categories;
    }

    public void setCategories (Categories[] categories)
    {
        this.categories = categories;
    }

    public BeenHere getBeenHere ()
    {
        return beenHere;
    }

    public void setBeenHere (BeenHere beenHere)
    {
        this.beenHere = beenHere;
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
