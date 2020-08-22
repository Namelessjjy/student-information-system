package com.student.information.db.repository;


import com.student.information.db.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Component
public interface StudentJpaRepository extends JpaRepository<Student, Long>, JpaSpecificationExecutor<Student> {

    Student findStudentByNumber(String number);

    Student findStudentByName(String name);

    void deleteByNumber(String number);

    @Query("select classNum from Student group by classNum")
    List<Integer> getAllClassNum();
}
