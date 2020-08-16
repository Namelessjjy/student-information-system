package com.student.information.db.entity;

import lombok.Data;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;

@Entity
@Table(name = "student")
@DynamicInsert
@DynamicUpdate
@Data
public class Student {

    @Id
    @GeneratedValue
    @Column
    private int id;

    @Column
    private String number;

    @Column
    private String name;

    @Column
    private String sex;

    @Column
    private int classNum;

    @Column
    private String birthday;

    @Column
    private String phoneNum;

    @Column
    private String address;

}
