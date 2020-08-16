package com.student.information.db.repository;

import com.student.information.db.entity.Admin;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

@Component
public interface AdminJpaRepository extends JpaRepository<Admin, Long> {

    Admin findAdminByUsername(String username);
}
