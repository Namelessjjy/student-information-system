package com.student.information.db.entity;

import lombok.Data;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;

@Entity
@Table(name = "admin")
@DynamicInsert
@DynamicUpdate
@Data
public class Admin {

    @Id
    @GeneratedValue
    @Column
    private int id;

    @Column
    private String username;

    @Column
    private String password;
}
