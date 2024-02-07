package com.performances.sched.views.forms;

import org.springframework.beans.factory.annotation.Autowired;

import com.performances.sched.service.LoginService;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.button.ButtonVariant;
import com.vaadin.flow.component.dependency.CssImport;
import com.vaadin.flow.component.dialog.Dialog;
import com.vaadin.flow.component.formlayout.FormLayout;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.textfield.PasswordField;
import com.vaadin.flow.component.textfield.TextField;

@CssImport("./my-styles/styles.css")
public class LoginForm extends FormLayout {
    // Access services
    LoginService loginService;

    // Intantiate the text field variables
    TextField userName = new TextField ("Username:");
    PasswordField password = new PasswordField("Password:");
    
    // Initiate the Buttons for loging in or signing up 
    Button loginButton = new Button("Login");
    Button signupButton = new Button("Sign Up");

    @Autowired
    public LoginForm(LoginService loginService) {
        this.loginService = loginService;
        //Add a Class name for CSS editing
        addClassName("login-form");

        // Set Required fields
        userName.setRequired(true);
        userName.setRequiredIndicatorVisible(true);
        password.setRequired(true);
        password.setRequiredIndicatorVisible(true);

        // Create the login function to allow a user to login 
        loginProcess();

        // Add the components to the Form
        add(userName,
        password,
        buttons());
    }

    private void loginProcess() {
        loginButton.addClickListener(event -> {
            String user = userName.getValue();
            String pwd = password.getValue();
            if(user != null && pwd != null){
                String loginResult = loginService.login(user, pwd);
                loginHandler(loginResult);
            } else {
                Notification.show("Fill in the Required fields");
            }
        });
    }

    private HorizontalLayout buttons() {
        // Configure the Buttons to be next to each other
        // Configure the themes of the Buttons
        loginButton.addThemeVariants(ButtonVariant.LUMO_PRIMARY);
        signupButton.addThemeVariants(ButtonVariant.LUMO_TERTIARY);

        // Sign Up form access
        signupButton.addClickListener(event -> {
            // Close parent Dialog
            getUI().ifPresent(ui -> ((Dialog) getParent().get()).close());
            // Open Sign Up Dialog
            Dialog dialog = new Dialog();
            dialog.addClassName("dialog-form");
            SignUpForm signUp = new SignUpForm();
            dialog.add(signUp);
            dialog.open();    
        });

        // Return the buttons
        return new HorizontalLayout(loginButton, signupButton);

    }

    private void loginHandler(String loginResult) {
        switch(loginResult) {
            case "admin":
                getUI().ifPresent(ui -> ui.navigate("/admin"));
                break;
            case "customer":
                getUI().ifPresent(ui -> ui.navigate("/customer"));
                break;
            case "invalid":
                Notification.show("Enter Correct details");
                break;
            case "error":
                Notification.show("An Error Occured, Try Again");
                break;
            default:
                System.err.println("Error");
                break;   
        }
    }
}
