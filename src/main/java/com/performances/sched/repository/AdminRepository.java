package com.performances.sched.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.performances.sched.entity.Admin;

public interface AdminRepository extends JpaRepository<Admin, Integer>{
    Admin findByUsernameAndPassword(String username, String password);
}
