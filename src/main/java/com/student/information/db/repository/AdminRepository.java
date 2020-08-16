package com.student.information.db.repository;

import com.student.information.db.entity.Admin;
import com.student.information.util.Response;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;

@Repository
public class AdminRepository {

    @Resource
    private AdminJpaRepository adminJpaRepository;

    public Admin findAdmin(String username) {
        return adminJpaRepository.findAdminByUsername(username);
    }
}
