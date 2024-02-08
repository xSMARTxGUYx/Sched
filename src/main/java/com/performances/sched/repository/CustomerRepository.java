package com.performances.sched.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.performances.sched.entity.Customer;

public interface CustomerRepository extends JpaRepository<Customer, Integer>{
    @Query("SELECT c FROM Customer c WHERE c.username = ?1 AND c.password = ?2")
    Customer findByUsernameAndPassword(String username, String password);
}
