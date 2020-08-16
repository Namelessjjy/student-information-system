package com.student.information.db.repository;

import com.student.information.db.entity.Course;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;

@Repository
public class CourseRepository {

    @Resource
    private CourseJpaRepository courseJpaRepository;

    public Course getCourseByCourseId(int courseId) {
        return courseJpaRepository.findById(courseId);
    }
}
