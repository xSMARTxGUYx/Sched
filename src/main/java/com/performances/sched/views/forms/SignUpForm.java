package com.performances.sched.views.forms;

import com.vaadin.flow.component.Key;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.button.ButtonVariant;
import com.vaadin.flow.component.dependency.CssImport;
import com.vaadin.flow.component.dialog.Dialog;
import com.vaadin.flow.component.formlayout.FormLayout;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.textfield.EmailField;
import com.vaadin.flow.component.textfield.PasswordField;
import com.vaadin.flow.component.textfield.TextField;

@CssImport("./my-styles/styles.css")
public class SignUpForm extends FormLayout {
    //Initialize the Components for a Sign Up Form
    TextField firstName = new TextField ("First Name:");
    TextField lastName = new TextField("Last Name:");
    TextField username = new TextField ("Username:");    
    EmailField email = new EmailField("Email:");
    PasswordField password = new PasswordField ("Password:");
    
    // Initialize the Buttons to sign up
    Button signUp = new Button("Sign Up");
    Button login = new Button("Login");

    
    public SignUpForm() {
        // Add CSS class name
        addClassName("signup-form");
        setResponsiveSteps(
            new ResponsiveStep("0",1)
        );

        // Add Components to the page 
        add(firstName,
        lastName,
        username,
        email,
        password,
        buttons());
    }

    private HorizontalLayout buttons() {
        // Configure button layout and themes
        signUp.addThemeVariants(ButtonVariant.LUMO_PRIMARY);
        login.addThemeVariants(ButtonVariant.LUMO_TERTIARY);

        // Add the ability to go back to login
        login.addClickListener(event -> {
            // Close parent Dialog 
            getUI().ifPresent(ui ->((Dialog) getParent().get()).close());
            // Open new login Dialog
            Dialog dialog = new Dialog();
            dialog.addClassName("dialog-form");
            LoginForm login = new LoginForm(null);
            dialog.add(login);
            dialog.open();
        });

        // Add shortcut to SignUp button
        signUp.addClickShortcut(Key.ENTER);

        return new HorizontalLayout(signUp, login);
    }
    

}
