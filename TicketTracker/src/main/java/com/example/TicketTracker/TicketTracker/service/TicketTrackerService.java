package com.example.TicketTracker.TicketTracker.service;

import java.util.List;

import com.example.TicketTracker.TicketTracker.model.TicketTracker;

public interface TicketTrackerService {
	
	public List<TicketTracker> findAll();
	public TicketTracker findById(int theId);
	public void save(TicketTracker theTracker);
	public void deleteById(int theId);
	List<TicketTracker> findByKeyword(String keyword);
	
	


}
