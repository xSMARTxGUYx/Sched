package com.performances.sched.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.performances.sched.entity.Event;

public interface EventRepository extends JpaRepository<Event, String> {

    
} 
