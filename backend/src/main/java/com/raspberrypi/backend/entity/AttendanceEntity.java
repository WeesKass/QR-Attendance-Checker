package com.raspberrypi.backend.entity;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "attendance")
public class AttendanceEntity implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "attendence_id")
    private Integer id;

    @Column(name = "`datetime`", nullable = false)
    private String datetime;


    @Column(name = "id_card", nullable = false)
    private String idCard;

    public AttendanceEntity() {
    }

    public AttendanceEntity(Integer id, String datetime, String idCard) {
        this.id = id;
        this.datetime = datetime;
        this.idCard = idCard;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDatetime() {
        return datetime;
    }

    public void setDatetime(String datetime) {
        this.datetime = datetime;
    }

    public String getStudentId() {
        return idCard;
    }

    public void setStudentId(String idCard) {
        this.idCard = idCard;
    }

}