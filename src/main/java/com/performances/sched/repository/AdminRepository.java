package com.performances.sched.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.performances.sched.entity.Admin;

public interface AdminRepository extends JpaRepository<Admin, Integer>{
    @Query("SELECT a FROM Admin a WHERE a.username = ?1 AND a.password = ?2")
    Admin findByUsernameAndPassword(String username, String password);
}
