package com.manoj.yuluplaces.Model;

import com.google.gson.Gson;

public class HereNow
{
    private String summary;

    private String count;

    private String[] groups;

    public String getSummary ()
    {
        return summary;
    }

    public void setSummary (String summary)
    {
        this.summary = summary;
    }

    public String getCount ()
    {
        return count;
    }

    public void setCount (String count)
    {
        this.count = count;
    }

    public String[] getGroups ()
    {
        return groups;
    }

    public void setGroups (String[] groups)
    {
        this.groups = groups;
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
