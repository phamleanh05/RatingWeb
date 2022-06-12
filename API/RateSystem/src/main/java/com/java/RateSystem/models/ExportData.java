package com.java.RateSystem.models;

import org.hibernate.annotations.Immutable;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Immutable
@Table(name = "export")
public class ExportData {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)

    private Integer id;
    private String name;
    private String description;
    private Double avgscore;
    private LocalDate date;
    private LocalDate month;

    public ExportData() {
    }

    public ExportData(String name, String description, Double avgscore, LocalDate date) {
        this.name = name;
        this.description = description;
        this.avgscore = avgscore;
        this.date = date;
    }

    public int getMonth() { return date.getMonth().getValue(); }

    public void setMonth(LocalDate month) {
        this.month = month;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    public int getDate() { return date.getMonth().getValue(); }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "Export{" +
                "name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", avgscore='" + avgscore + '\'' +
                ", month=" + month +
                '}';
    }
}
