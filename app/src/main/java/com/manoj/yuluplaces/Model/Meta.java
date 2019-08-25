package com.manoj.yuluplaces.Model;

import com.google.gson.Gson;

public class Meta
{
    private String code;

    private String requestId;

    public String getCode ()
    {
        return code;
    }

    public void setCode (String code)
    {
        this.code = code;
    }

    public String getRequestId ()
    {
        return requestId;
    }

    public void setRequestId (String requestId)
    {
        this.requestId = requestId;
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