package com.manoj.yuluplaces.Model;

import com.google.gson.Gson;

public class Stats
{
    private String visitsCount;

    private String checkinsCount;

    private String usersCount;

    private String tipCount;

    public String getVisitsCount ()
    {
        return visitsCount;
    }

    public void setVisitsCount (String visitsCount)
    {
        this.visitsCount = visitsCount;
    }

    public String getCheckinsCount ()
    {
        return checkinsCount;
    }

    public void setCheckinsCount (String checkinsCount)
    {
        this.checkinsCount = checkinsCount;
    }

    public String getUsersCount ()
    {
        return usersCount;
    }

    public void setUsersCount (String usersCount)
    {
        this.usersCount = usersCount;
    }

    public String getTipCount ()
    {
        return tipCount;
    }

    public void setTipCount (String tipCount)
    {
        this.tipCount = tipCount;
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
