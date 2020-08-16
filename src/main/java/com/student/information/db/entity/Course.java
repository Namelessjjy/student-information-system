package com.student.information.db.entity;

import lombok.Data;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;

@Entity
@Table(name = "course")
@DynamicInsert
@DynamicUpdate
@Data
public class Course {

    @Id
    @GeneratedValue
    @Column
    private int id;

    @Column
    private String courseName;

}
