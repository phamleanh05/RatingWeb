package com.java.RateSystem.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "options")
public class Options {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", unique = true)
    private long id;
    private String serviceName;
    private Integer serviceid;
    private String name;
    private Double point;
    public Options(long id, String serviceName, Integer serviceid, String name, Double point) {
        this.id = id;
        this.serviceName = serviceName;
        this.serviceid = serviceid;
        this.name = name;
        this.point = point;
    }

    @Override
    public String toString() {
        return "Options{" +
                "id=" + id +
                ", serviceName='" + serviceName + '\'' +
                ", serviceid=" + serviceid +
                ", name='" + name + '\'' +
                ", point=" + point +
                '}';
    }
}