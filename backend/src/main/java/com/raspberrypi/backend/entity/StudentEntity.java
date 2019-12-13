package com.raspberrypi.backend.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "students")
public class StudentEntity implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "student_id")
    private Integer id;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "surname", nullable = false)
    private String surname;

    @Column(name = "department", nullable = false)
    private String department;

    @Column(name = "`group`", nullable = false)
    private String group;

    @Column(name = "id_card", nullable = false)
    private String idCard;

    @OneToMany(cascade = CascadeType.REMOVE, fetch = FetchType.LAZY)
    @JoinColumn(name = "id_card", referencedColumnName = "id_card")
    private List<AttendanceEntity> attendanceList;

    public StudentEntity() {
    }


    public StudentEntity(String name, String surname, String department, String group, String idCard, List<AttendanceEntity> attendanceList) {
        this.name = name;
        this.surname = surname;
        this.department = department;
        this.group = group;
        this.idCard = idCard;
        this.attendanceList = attendanceList;

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

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getGroup() {
        return group;
    }

    public void setGroup(String group) {
        this.group = group;
    }

    public List<AttendanceEntity> getAttendanceList() {
        return attendanceList;
    }

    public void setAttendanceList(List<AttendanceEntity> attendanceList) {
        this.attendanceList = attendanceList;
    }

    public String getIdCard() {
        return idCard;
    }

    public void setIdCard(String idCard) {
        this.idCard = idCard;
    }
}
