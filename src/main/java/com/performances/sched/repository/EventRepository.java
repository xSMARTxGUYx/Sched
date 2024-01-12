package com.performances.sched.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import com.performances.sched.entity.Event;

public interface EventRepository extends JpaRepository<Event, String> {
    @Query("SELECT e FROM Event e " + 
    "WHERE LOWER(e.RestaurantName) LIKE LOWER(concat('%', :searchTerm, '%')) " +
    "OR LOWER(e.Address) like LOWER(concat('%', :searchTerm, '%'))" + 
    "OR LOWER(e.ArtistName) LIKE LOWER(concat('%', :searchTerm, '%'))")
    List<Event> search(@Param("searchTerm") String searchTerm);
} 
