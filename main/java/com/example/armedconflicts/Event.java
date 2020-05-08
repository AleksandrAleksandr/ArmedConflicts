package com.example.armedconflicts;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Event {
    @SerializedName("filename")
    @Expose
    private String filename;

    @SerializedName("data")
    @Expose
    private EventData[] data;

    @SerializedName("success")
    @Expose
    private boolean success;

    @SerializedName("last_update")
    @Expose
    private int last_update;

    @SerializedName("count")
    @Expose
    private int count;

    @SerializedName("status")
    @Expose
    private int status;

    public EventData[] getData() {
        return data;
    }

    public void setData(EventData[] data) {
        this.data = data;
    }

    public String getFilename ()
    {
        return filename;
    }

    public void setFilename (String filename)
    {
        this.filename = filename;
    }


    public boolean getSuccess ()
    {
        return success;
    }

    public void setSuccess (boolean success)
    {
        this.success = success;
    }

    public int getLast_update ()
    {
        return last_update;
    }

    public void setLast_update (int last_update)
    {
        this.last_update = last_update;
    }

    public int getCount ()
    {
        return count;
    }

    public void setCount (int count)
    {
        this.count = count;
    }

    public int getStatus ()
    {
        return status;
    }

    public void setStatus (int status)
    {
        this.status = status;
    }
}

