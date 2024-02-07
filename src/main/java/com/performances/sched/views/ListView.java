package com.performances.sched.views;

import com.performances.sched.entity.Event;
import com.performances.sched.service.DataService;
import com.performances.sched.service.LoginService;
import com.performances.sched.views.forms.LoginForm;
import com.performances.sched.views.forms.SignUpForm;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.dependency.CssImport;
import com.vaadin.flow.component.dialog.Dialog;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.html.Span;
import com.vaadin.flow.component.orderedlayout.FlexComponent;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.data.value.ValueChangeMode;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;

@PageTitle("Schedule")
@Route(value = "")
@CssImport("./my-styles/styles.css")
public class ListView extends VerticalLayout{
    
    Grid<Event>grid = new Grid<>(Event.class);
    TextField filterText = new TextField();
    DataService service;
    private final LoginService loginService;

    public ListView(DataService service, LoginService loginService){
        this.service = service;
        this.loginService = loginService;

        LoginForm loginForm = new LoginForm(loginService);
        loginForm.addLoginSuccessListner(this::loginHandler);

        addClassName("list-view");

        setSizeFull();
        gridConfig();

        add(mainBar(), getfilterBar(),grid);
        updateFilter();
    }

    private void gridConfig() {
        grid.addClassName("grid-view");
        grid.setSizeFull();
        grid.setColumns("restaurantName", "address", "artistName", "date", "startingTime");
        grid.getColumns().forEach(col ->col.setAutoWidth(true));
    }

    private HorizontalLayout mainBar() {
        addClassName("main-bar");
        H1 label = new H1("Restaurant Performance Schedules");
        Button loginButton = new Button("Login");
        Button signupButton = new Button("Sign Up");
        

        loginButton.addClickListener(event -> {
            Dialog dialog = new Dialog();
            dialog.addClassName("dialog-form");
            LoginForm loginForm = new LoginForm(null);
            dialog.add(loginForm);
            dialog.open();
        });

        signupButton.addClickListener(event -> {
            Dialog dialog = new Dialog();
            dialog.addClassName("dialog-form");
            SignUpForm signUpForm = new SignUpForm();
            dialog.add(signUpForm);
            dialog.open();
        });

        HorizontalLayout layout = new HorizontalLayout();
        layout.setWidthFull();
        layout.setAlignItems(Alignment.CENTER);

        layout.add(label, new Span(), loginButton, signupButton);
        layout.setFlexGrow(1, label);
        
        return layout;
    }
    
    private HorizontalLayout getfilterBar() {
        filterText.setPlaceholder("Find The Gig For You...");
        filterText.addClassName("filter-field");
        filterText.setClearButtonVisible(true);
        filterText.setValueChangeMode(ValueChangeMode.LAZY);
        filterText.addValueChangeListener(e -> updateFilter());

        var filterBar = new HorizontalLayout(filterText);
        filterBar.setAlignItems(FlexComponent.Alignment.END);
        filterBar.addClassName("filter-bar");
        filterBar.setWidthFull();
        filterBar.setJustifyContentMode(FlexComponent.JustifyContentMode.CENTER);
        return filterBar;
    }

    private void updateFilter() {
        if (service != null) {
            grid.setItems(service.findAllEvents(filterText.getValue()));
        }else{
            System.err.println("service is null");
        }
    }

}
