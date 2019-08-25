package com.manoj.yuluplaces.Model;

import com.google.gson.Gson;

public class Icon
{
    private String prefix;

    private String suffix;

    public String getPrefix ()
    {
        return prefix;
    }

    public void setPrefix (String prefix)
    {
        this.prefix = prefix;
    }

    public String getSuffix ()
    {
        return suffix;
    }

    public void setSuffix (String suffix)
    {
        this.suffix = suffix;
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
