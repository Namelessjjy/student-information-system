package com.student.information.db.entity;

import lombok.Data;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;

@Entity
@Table(name = "score")
@DynamicInsert
@DynamicUpdate
@Data
public class Score {

    @Id
    @GeneratedValue
    @Column
    private int id;

    @Column
    private int courseId;

    @Column
    private int score;

    @Column
    private String studentNum;

}
