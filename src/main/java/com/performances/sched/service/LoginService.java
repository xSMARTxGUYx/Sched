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
    
    public String login(String username, String password){
        if (username == null || password == null) {
            return "Username or password cannot be null";
        }

        boolean isAdmin = adminRep.findByUsernameAndPassword(username, password) != null;
        boolean isCustomer = customerRep.findByUsernameAndPassword(username, password) != null;

        if (isAdmin) {
            return "Admin";
        } else if (isCustomer) {
            return "Customer";
        } else {
            return "Invalid";
        }
    }

}
