package com.performances.sched.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import com.performances.sched.entity.Admin;

public interface AdminRepository extends JpaRepository<Admin, Integer> {
    @Query("SELECT a FROM Admin a WHERE a.username = :username AND a.password = :password")
    List<Admin> allowAdmin(@Param("username") String username, @Param("password") String password);
    
}
