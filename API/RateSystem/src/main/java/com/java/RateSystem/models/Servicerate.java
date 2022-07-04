package com.java.RateSystem.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.UUID;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "Services")
public class Servicerate {
    @Id
    @GenericGenerator(name = "UUIDGenerator", strategy = "uuid2")
    @GeneratedValue(generator = "UUIDGenerator")
    @Column(name = "uuid", updatable = false, nullable = false)
    private UUID uuid;

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", unique = true)
    private Integer id;
    private String name;
    private String image;
    private String description;
    private Double avgscore;

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
