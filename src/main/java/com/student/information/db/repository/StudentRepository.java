package com.student.information.db.repository;

import com.student.information.db.entity.Student;
import com.student.information.dto.GetStudentRequest;
import com.student.information.dto.UpdateStudentRequest;
import com.student.information.util.Response;
import com.student.information.util.ResponseStatusEnum;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.List;

@Repository
public class StudentRepository {

    @Resource
    private StudentJpaRepository studentJpaRepository;


    public Response addStudent(Student student) {
        try {
            Student stuInDb = studentJpaRepository.findStudentByNumber(student.getNumber());
            if (stuInDb != null) {
                return Response.valueOf(ResponseStatusEnum.ADD_REPEAT);
            }
            studentJpaRepository.saveAndFlush(student);
        } catch (Exception e) {
            return Response.valueOf(ResponseStatusEnum.ADD_FAILED);
        }
        return Response.valueOf(ResponseStatusEnum.ADD_SUCCESS);
    }

    public Response deleteStudent(String number) {

        if (number != null) {
            if (studentJpaRepository.findStudentByNumber(number) != null) {
                try {
                    studentJpaRepository.deleteByNumber(number);
                    return Response.valueOf(ResponseStatusEnum.DELETE_SUCCESS);
                } catch(Exception e) {
                    return Response.valueOf(ResponseStatusEnum.DELETE_FAIL);
                }
            }
        } else {
            return Response.valueOf(ResponseStatusEnum.DELETE_NULL);
        }

        return Response.valueOf(ResponseStatusEnum.DELETE_FAIL);
    }

    public List<Student> getStudentList(GetStudentRequest getStudentRequest) {
        List<Student> students = studentJpaRepository.findAll(new Specification<Student>() {
            @Override
            public Predicate toPredicate(Root<Student> root, CriteriaQuery<?> criteriaQuery, CriteriaBuilder criteriaBuilder) {
                List<Predicate> conditions = new ArrayList<>();
                if (getStudentRequest.getNumber() != null) {
                    conditions.add(criteriaBuilder.equal(root.get("number"), getStudentRequest.getNumber()));
                }
                if (getStudentRequest.getName() != null) {
                    conditions.add(criteriaBuilder.equal(root.get("name"), getStudentRequest.getName()));
                }
                if (getStudentRequest.getClassNum() > 0) {
                    conditions.add(criteriaBuilder.equal(root.get("classNum"), getStudentRequest.getClassNum()));
                }
                if (getStudentRequest.getPhoneNum() != null) {
                    conditions.add(criteriaBuilder.equal(root.get("phoneNum"), getStudentRequest.getPhoneNum()));
                }
                if (getStudentRequest.getSex() != null) {
                    conditions.add(criteriaBuilder.equal(root.get("sex"), getStudentRequest.getSex()));
                }

                Predicate[] predicates = new Predicate[conditions.size()];
                return criteriaQuery.where(conditions.toArray(predicates)).getRestriction();
            }
        });
        return students;
    }

    public List<Student> getAllStudent() {
        return studentJpaRepository.findAll();
    }

    public Response updateStudent(UpdateStudentRequest updateStudentRequest) {
        Student student = studentJpaRepository.findStudentByNumber(updateStudentRequest.getNumber());
        if (student == null) {
            return Response.valueOf(ResponseStatusEnum.UPDATE_NULL);
        }
        try {
            student.setName(updateStudentRequest.getName());
            student.setSex(updateStudentRequest.getSex());
            student.setAddress(updateStudentRequest.getAddress());
            student.setBirthday(updateStudentRequest.getBirthday());
            student.setPhoneNum(updateStudentRequest.getPhoneNum());
            student.setClassNum(updateStudentRequest.getClassNum());
            studentJpaRepository.saveAndFlush(student);
            return Response.valueOf(ResponseStatusEnum.UPDATE_SUCCESS);
        } catch (Exception e) {
            return Response.valueOf(ResponseStatusEnum.UPDATE_FAILED);
        }

    }

    public Student getStudentByNumber(String number) {
        return studentJpaRepository.findStudentByNumber(number);
    }

    public List<Integer> getAllClass() {
        return studentJpaRepository.getAllClassNum();
    }
}
