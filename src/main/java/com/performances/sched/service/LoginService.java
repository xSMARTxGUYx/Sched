package com.performances.sched.service;

import org.springframework.stereotype.Service;

import com.performances.sched.repository.AdminRepository;
import com.performances.sched.repository.CustomerRepository;

@Service
public class LoginService {
    private final AdminRepository adminRep;
    private final CustomerRepository customerRep;

    public LoginService(AdminRepository adminRep, CustomerRepository customerRep) {
        this.adminRep = adminRep;
        this.customerRep = customerRep;
    }

}
