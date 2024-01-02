package com.performances.sched.views;

import com.performances.sched.entity.Event;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;

@PageTitle("Schedule")
@Route(value = "")
public class ListView extends VerticalLayout{
    
    Grid<Event>grid = new Grid<>(Event.class);


    public ListView(){
        addClassName("list-view");
        setSizeFull();

        gridConfig();

        add(grid);
    }


    private void gridConfig() {
        grid.addClassName("grid-view");
        grid.setSizeFull();
        grid.setColumns("restaurantName", "address", "artistName", "date", "startingTime");
        grid.getColumns().forEach(col ->col.setAutoWidth(true));


    }
}
