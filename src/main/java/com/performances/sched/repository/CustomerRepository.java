package com.performances.sched.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import com.performances.sched.entity.Customer;

public interface CustomerRepository extends JpaRepository<Customer, Integer> {
    
    @Query("SELECT c FROM Customer c WHERE c.username = :username AND c.password = :password")
    List<Customer> allowCustomer(@Param("username") String username, @Param("password") String password);
}
