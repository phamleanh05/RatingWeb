package com.java.RateSystem.models;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.UUID;

@Entity
@Table(name = "Services")
public class Servicerate {

    @Id
    @GenericGenerator(name = "UUIDGenerator", strategy = "uuid2")
    @GeneratedValue(generator = "UUIDGenerator")
    @Column(name = "uuid", updatable = false, nullable = false)

    private UUID uuid;
    private Integer id;
    private String name;
    private String image;
    private String description;
    private Double avgscore;

    public Servicerate() {
    }

    public Servicerate(UUID uuid, String name, String image, String description, Double avgscore) {
        this.uuid = uuid;
        this.name = name;
        this.image = image;
        this.description = description;
        this.avgscore = avgscore;
    }

    public UUID getUuid() {
        return uuid;
    }

    public void setUuid(UUID uuid) {
        this.uuid = uuid;
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

    public String getImage() {
        return image;
    }

    public void setImage(String serviceimg) {
        this.image = serviceimg;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String servicedesc) {
        this.description = servicedesc;
    }

    public Double getAvgscore() {
        return avgscore;
    }

    public void setAvgscore(Double avgscore) {
        this.avgscore = avgscore;
    }

    @Override
    public String toString() {
        return "Servicerate{" +
                "name='" + name + '\'' +
                ", serviceimg='" + image + '\'' +
                ", servicedesc='" + description + '\'' +
                ", avgscore=" + avgscore +
                '}';
    }
}
