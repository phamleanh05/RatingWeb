package com.java.RateSystem.models;

import java.util.Date;

public class ExportData {
    private String servicename;
    private String description;
    private Double avgscore;
    private Date date;

    public ExportData(String servicename, String description, Double avgscore, Date date) {
        this.servicename = servicename;
        this.description = description;
        this.avgscore = avgscore;
        this.date = date;
    }


    public String getServicename() {
        return servicename;
    }

    public void setServicename(String servicename) {
        this.servicename = servicename;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Double getAvgscore() {
        return avgscore;
    }

    public void setAvgscore(Double avgscore) {
        this.avgscore = avgscore;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "Export{" +
                "servicename='" + servicename + '\'' +
                ", description='" + description + '\'' +
                ", avgscore='" + avgscore + '\'' +
                ", date=" + date +
                '}';
    }
}
