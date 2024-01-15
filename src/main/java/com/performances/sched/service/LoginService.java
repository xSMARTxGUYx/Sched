package com.performances.sched.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.performances.sched.repository.AdminRepository;
import com.performances.sched.repository.CustomerRepository;
import com.vaadin.flow.component.UI;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.spring.annotation.UIScope;

@Service
@UIScope
public class LoginService {
    // Access the Repository
    private final AdminRepository adminRepository;
    private final CustomerRepository customerRepository; 
    private final UI ui;

    @Autowired
    public LoginService(AdminRepository adminRepository, CustomerRepository customerRepository, UI ui) {
        this.adminRepository = adminRepository;
        this.customerRepository = customerRepository;
        this.ui = ui;

        System.err.println("Initiated");
    }

    public void login(String username, String password){
        try{
            if(adminRepository.allowAdmin(username, password) != null) {
                ui.navigate("/admin");
            }else if(customerRepository.allowCustomer(username, password) != null) {
                ui.navigate("/customer");
            }else{
                Notification.show("Enter the Correct Details");
            }

        }catch(Exception e){
            System.err.println("Exception" + e.getMessage());
        }
    }
}
