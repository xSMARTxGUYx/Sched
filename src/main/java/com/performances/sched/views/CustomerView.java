package com.performances.sched.views;

import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;

@PageTitle("Customer")
@Route("/customer")
public class CustomerView extends VerticalLayout {
    
    public CustomerView(){
        add(new H1("Hello Customer!!!"));
    }
}
