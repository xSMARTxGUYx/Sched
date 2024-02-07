package com.performances.sched.service;

import org.springframework.stereotype.Service;
import com.performances.sched.repository.AdminRepository;
import com.performances.sched.repository.CustomerRepository;
import com.vaadin.flow.component.UI;
import com.vaadin.flow.spring.annotation.UIScope;

@Service
@UIScope
public class LoginService {
    // Access the Repository
    private final AdminRepository adminRepository;
    private final CustomerRepository customerRepository; 

    public LoginService(AdminRepository adminRepository, CustomerRepository customerRepository, UI ui) {
        this.adminRepository = adminRepository;
        this.customerRepository = customerRepository;
        
        if(this.adminRepository == null || this.customerRepository == null) {
            throw new IllegalArgumentException("Repositories are null");
        }
    }

    public String login(String username, String password){
        try {
            if (adminRepository.allowAdmin(username, password) != null) {
                return "admin";
            }else if (customerRepository.allowCustomer(username, password) != null) {
                return "customer";
            }else{
                return "invalid";
            }
        } catch (Exception e) {
            return "error";
       }
    }
}
