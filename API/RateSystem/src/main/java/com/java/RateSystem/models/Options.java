package com.java.RateSystem.models;

import javax.persistence.*;

@Entity
@Table(name = "options")
public class Options {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)

    private Integer id;
    private String serviceName;
    private Integer serviceid;
    private Integer point;

    public Options() {
    }

    public Options(Integer id, String serviceName, Integer serviceid, Integer point) {
        this.id = id;
        this.serviceName = serviceName;
        this.serviceid = serviceid;
        this.point = point;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getServiceName() {
        return serviceName;
    }

    public void setServiceName(String serviceName) {
        this.serviceName = serviceName;
    }

    public Integer getServiceid() {
        return serviceid;
    }

    public void setServiceid(Integer serviceid) {
        this.serviceid = serviceid;
    }

    public Integer getPoint() {
        return point;
    }

    public void setPoint(Integer point) {
        this.point = point;
    }

    @Override
    public String toString() {
        return "Options{" +
                "id=" + id +
                ", serviceName='" + serviceName + '\'' +
                ", serviceid=" + serviceid +
                ", point=" + point +
                '}';
    }
}
