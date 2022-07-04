package com.java.RateSystem.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.UUID;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
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
    private Integer id;
    @Column(name = "serviceid")
    private Integer serviceid;
    private String username;
    private Double optionAvg;
    private String comment;
    private LocalDate date;
    private String serviceName;
    private Integer optionid;

    public Rating(Integer id, Integer serviceid, Integer optionid, String serviceName, String username, Double optionAvg, String comment, LocalDate date) {
        this.id = id;
        this.serviceid = serviceid;
        this.serviceName = serviceName;
        this.username = username;
        this.optionAvg = optionAvg;
        this.comment = comment;
        this.date = date;
        this.optionid = optionid;
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
