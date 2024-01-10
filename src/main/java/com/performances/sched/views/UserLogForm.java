package com.performances.sched.views;

import com.vaadin.flow.component.Key;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.button.ButtonVariant;
import com.vaadin.flow.component.formlayout.FormLayout;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.textfield.TextField;

public class UserLogForm extends FormLayout {

    // Intantiate the text field variables
    TextField firstName = new TextField ("First Name:");
    TextField lastName = new TextField("Last Name:");
    TextField userName = new TextField ("Username:");
    TextField email = new TextField ("Email:");
    
    // Initiate the Buttons for loging in or signing up 
    Button loginButton = new Button("Login");
    Button signupButton = new Button("Sign Up");

    public UserLogForm() {
        //Add a Class name for CSS editing
        addClassName("login-form");

        // Add the components to the Form
        add(firstName,
        lastName,
        userName,
        email,
        buttons());
    }

    private HorizontalLayout buttons() {
        // Configure the Buttons to be next to each other
        // Configure the themes of the Buttons
        loginButton.addThemeVariants(ButtonVariant.LUMO_PRIMARY);
        signupButton.addThemeVariants(ButtonVariant.LUMO_TERTIARY);

        // Add shortcut key function to Buttons
        loginButton.addClickShortcut(Key.ENTER);

        // Return the buttons
        return new HorizontalLayout(loginButton, signupButton);

    }
    
    
    
}
