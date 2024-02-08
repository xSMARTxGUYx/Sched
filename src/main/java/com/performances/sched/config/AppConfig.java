package com.performances.sched.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.performances.sched.repository.AdminRepository;
import com.performances.sched.repository.CustomerRepository;
import com.performances.sched.service.LoginService;
import com.performances.sched.views.forms.LoginForm;

@Configuration
public class AppConfig {
    @Bean
    public LoginForm loginForm(LoginService loginService) {
        return new LoginForm(loginService);
    }

    @Bean
    public LoginService loginService(AdminRepository adminRep, CustomerRepository customerRep){
        return new LoginService(adminRep, customerRep);
    }
}
