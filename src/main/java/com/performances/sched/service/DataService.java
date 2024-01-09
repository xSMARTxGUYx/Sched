package com.performances.sched.service;

import java.util.List;
import org.springframework.stereotype.Service;
import com.performances.sched.entity.Event;
import com.performances.sched.repository.EventRepository;

@Service
public class DataService {
    
    private final EventRepository eventRepository;

    public DataService(EventRepository eventRepository) {
        this.eventRepository = eventRepository;
    }

    public List<Event> findAllEvents(String stringFilter) {
        if (stringFilter == null || stringFilter.isEmpty()) {
            return eventRepository.findAll();
        }else {
            return eventRepository.search("%" + stringFilter.toLowerCase() + "%");
        }
    }
}
