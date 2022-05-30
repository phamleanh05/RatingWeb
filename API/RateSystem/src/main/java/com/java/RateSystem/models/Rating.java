package com.java.RateSystem.models;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.Date;
import java.util.UUID;

@Entity
@Table(name = "rating")
public class Rating {
    @Id
    @GenericGenerator(name = "UUIDGenerator", strategy = "uuid2")
    @GeneratedValue(generator = "UUIDGenerator")
    @Column(name = "uuid", updatable = false, nullable = false)

    private UUID uuid;
    private Integer id;
    private Integer serviceid;
    private String username;
    private Double point;
    private String comment;
    private Date date;

    public Rating() {
    }

    public Rating(Integer serviceid, String username, Double point, String comment, java.util.Date date) {
        this.serviceid = serviceid;
        this.username = username;
        this.point = point;
        this.comment = comment;
        this.date = date;
    }

    public UUID getUuid() {
        return uuid;
    }

    public void setUuid(UUID uuid) {
        this.uuid = uuid;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public UUID getId() {
        return uuid;
    }

    public void setId(UUID id) {
        this.uuid = uuid;
    }

    public Integer getServiceid() {
        return serviceid;
    }

    public void setServiceid(Integer serviceid) {
        this.serviceid = serviceid;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String userName) {
        this.username = userName;
    }

    public Double getPoint() {
        return point;
    }

    public void setPoint(Double point) {
        this.point = point;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public java.util.Date getDate() {
        return date;
    }

    public void setDate(java.util.Date date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "Rating{" +
                "id=" + id +
                ", serviceid=" + serviceid +
                ", userName='" + username + '\'' +
                ", point=" + point +
                ", Comment='" + comment + '\'' +
                ", Date=" + date +
                '}';
    }
}
