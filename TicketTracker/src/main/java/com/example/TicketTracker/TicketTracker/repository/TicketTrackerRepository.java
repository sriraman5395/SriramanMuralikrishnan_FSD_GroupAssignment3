package com.example.TicketTracker.TicketTracker.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.TicketTracker.TicketTracker.model.TicketTracker;

public interface TicketTrackerRepository extends JpaRepository<TicketTracker,Integer> {
	 @Query(value = "SELECT * FROM ticket_tracker t WHERE t.ticket_title LIKE %:keyword% OR t.ticket_description LIKE %:keyword%", nativeQuery = true)
	    List<TicketTracker> findByKeyword(@Param("keyword") String keyword);
}
