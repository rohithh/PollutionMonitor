package com.example.rohith.pollutionmonitor;

import java.util.Date;

/**
 * Created by Rohith on 6/14/16.
 */
public class Data {
    private Date date;
    private double value;

    public double getValue() {
        return value;
    }

    public void setValue(double value) {
        this.value = value;
    }

    public Date getDate() {

        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}

