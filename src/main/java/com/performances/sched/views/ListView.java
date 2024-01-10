package com.performances.sched.views;

import com.performances.sched.entity.Event;
import com.performances.sched.service.DataService;
import com.vaadin.flow.component.orderedlayout.FlexComponent;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.data.value.ValueChangeMode;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;

@PageTitle("Schedule")
@Route(value = "")
public class ListView extends VerticalLayout{
    
    Grid<Event>grid = new Grid<>(Event.class);
    TextField filterText = new TextField();
    DataService service;

    public ListView(DataService service){
        this.service = service;
        addClassName("list-view");
        setSizeFull();
        gridConfig();
        add(getfilterBar() ,grid);
        updateFilter();
    }

    private void gridConfig() {
        grid.addClassName("grid-view");
        grid.setSizeFull();
        grid.setColumns("restaurantName", "address", "artistName", "date", "startingTime");
        grid.getColumns().forEach(col ->col.setAutoWidth(true));
    }
    
    private HorizontalLayout getfilterBar() {
        filterText.setPlaceholder("Filter by...");
        filterText.setClearButtonVisible(true);
        filterText.setValueChangeMode(ValueChangeMode.LAZY);
        filterText.addValueChangeListener(e -> updateFilter());

        var filterBar = new HorizontalLayout(filterText);
        filterBar.setAlignItems(FlexComponent.Alignment.END);
        filterBar.addClassName("filter-bar");
        filterBar.setWidthFull();
        filterBar.setJustifyContentMode(FlexComponent.JustifyContentMode.END);
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
