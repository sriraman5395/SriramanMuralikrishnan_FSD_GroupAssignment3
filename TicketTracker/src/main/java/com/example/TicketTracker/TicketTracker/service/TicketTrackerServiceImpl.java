package com.example.TicketTracker.TicketTracker.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.TicketTracker.TicketTracker.model.TicketTracker;
import com.example.TicketTracker.TicketTracker.repository.TicketTrackerRepository;

import jakarta.transaction.Transactional;


@Service
public class TicketTrackerServiceImpl implements TicketTrackerService {
    
	@Autowired
	TicketTrackerRepository ticketRepository;
	
	@Override
	public List<TicketTracker> findAll() {
		// TODO Auto-generated method stub
		return ticketRepository.findAll();
	}

	@Override
	public TicketTracker findById(int theId) {
		Optional<TicketTracker> result = ticketRepository.findById(theId);
		TicketTracker ticket = null;
		if(result.isPresent())
			ticket = result.get();
		else
			throw new RuntimeException("Book is not present with given id +" + theId);
		return ticket;
	}

	@Override
	public void save(TicketTracker theTracker) {
		ticketRepository.save(theTracker);
		
	}
    
	
	@Override
	public void deleteById(int theId) {
		ticketRepository.deleteById(theId);
		
	}
	
	 @Override
	    public List<TicketTracker> findByKeyword(String keyword) {
	        return ticketRepository.findByKeyword(keyword);
	    }

	

}
