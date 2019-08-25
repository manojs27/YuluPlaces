package com.manoj.yuluplaces.Model;

import com.google.gson.Gson;

public class BeenHere
{
    private String marked;

    private String count;

    private String lastCheckinExpiredAt;

    private String unconfirmedCount;

    public String getMarked ()
    {
        return marked;
    }

    public void setMarked (String marked)
    {
        this.marked = marked;
    }

    public String getCount ()
    {
        return count;
    }

    public void setCount (String count)
    {
        this.count = count;
    }

    public String getLastCheckinExpiredAt ()
    {
        return lastCheckinExpiredAt;
    }

    public void setLastCheckinExpiredAt (String lastCheckinExpiredAt)
    {
        this.lastCheckinExpiredAt = lastCheckinExpiredAt;
    }

    public String getUnconfirmedCount ()
    {
        return unconfirmedCount;
    }

    public void setUnconfirmedCount (String unconfirmedCount)
    {
        this.unconfirmedCount = unconfirmedCount;
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
