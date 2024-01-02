package com.performances.sched.views;

import com.performances.sched.entity.Event;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.grid.Grid;
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

    public ListView(){
        addClassName("list-view");
        setSizeFull();

        gridConfig();

        add(getfilterBar(),grid);
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

        Button filterButton = new Button("Filter");

        var filterBar = new HorizontalLayout(filterText, filterButton);
        filterBar.addClassName("filter-bar");
        return filterBar;
    }
}
