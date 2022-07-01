package com.java.RateSystem.models;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.UUID;

@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "rating")
public class Rating {
    @Id
    @GenericGenerator(name = "UUIDGenerator", strategy = "uuid2")
    @GeneratedValue(generator = "UUIDGenerator")
    @Column(name = "uuid", updatable = false, nullable = false)
    private UUID uuid;

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", unique = true)
    private long id;
    @Column(name = "serviceid")
    private Integer serviceid;
    private String username;
    private Double optionAvg;
    private String comment;
    private LocalDate date;
    private String serviceName;
    private Integer optionid;

    public Rating(long id, Integer serviceid, Integer optionid, String serviceName, String username, Double optionAvg, String comment, LocalDate date) {
        this.id = id;
        this.serviceid = serviceid;
        this.serviceName = serviceName;
        this.username = username;
        this.optionAvg = optionAvg;
        this.comment = comment;
        this.date = date;
        this.optionid = optionid;
    }

    public Integer getOptionid() {
        return optionid;
    }

    public void setOptionid(Integer optionid) {
        this.optionid = optionid;
    }

    public UUID getUuid() {
        return uuid;
    }

    public void setUuid(UUID uuid) {
        this.uuid = uuid;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getId() {
        return id;
    }

    public Integer getServiceid() {
        return serviceid;
    }

    public void setServiceid(Integer serviceid) {
        this.serviceid = serviceid;
    }

    public String getServiceName() {
        return serviceName;
    }

    public void setServiceName(String serviceName) {
        this.serviceName = serviceName;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String userName) {
        this.username = userName;
    }

    public Double getOptionAvg() {
        return optionAvg;
    }

    public void setOptionAvg(Double point) {
        this.optionAvg = point;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "Rating{" +
                "id=" + id +
                ", serviceid=" + serviceid +
                ", serviceName=" + serviceName + '\'' +
                ", userName='" + username + '\'' +
                ", point=" + optionAvg +
                ", Comment='" + comment + '\'' +
                ", Date=" + date +
                '}';
    }
}
