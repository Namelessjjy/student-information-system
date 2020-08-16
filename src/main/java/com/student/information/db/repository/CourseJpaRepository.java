package com.student.information.db.repository;

import com.student.information.db.entity.Course;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

@Component
public interface CourseJpaRepository extends JpaRepository<Course, Long> {

    Course findById(int id);
}
