package com.example.TicketTracker.TicketTracker.controller;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.TicketTracker.TicketTracker.model.TicketTracker;
import com.example.TicketTracker.TicketTracker.service.TicketTrackerService;

@Controller
@RequestMapping("/tickets")
public class TicketController {
	
	@Autowired
	TicketTrackerService ticketService ;
	
	@GetMapping("/list")
	public String findAll(Model model){
		List<TicketTracker> tickettracker = ticketService.findAll();
		model.addAttribute("tickettracker",tickettracker);
		
		
		return "tickets/tickettracker";
		
	}
	
	@GetMapping("/showTicketFormForAdd")
	public String showTicketFormForAdd(Model model) {
		model.addAttribute("tickets", new TicketTracker());
		return "tickets/ticket-form";
		
	}
	
	@PostMapping("/savetickets")
	public String saveBook(Model model, @ModelAttribute("tickettracker") TicketTracker tickets) {
	    tickets.setSelectedDate(LocalDate.now()); // Set the selectedDate first
	    ticketService.save(tickets);
	    return "redirect:/tickets/list";
	}
	

	@GetMapping("/delete/{id}")
	public String delete(Model model,@PathVariable("id") int id){
		ticketService.deleteById(id);
		
		return "redirect:/tickets/list";
		
	}
	
	@GetMapping("/showTicketFormForEdit/{id}")
	public String showTicketFormForEdit(Model model,@PathVariable("id") int id){
		TicketTracker tickets = ticketService.findById(id);
		model.addAttribute("tickets", tickets);
		 System.out.println("Retrieved Ticket: " + tickets);
		
		return "tickets/ticket-form";
		
	}
	
	
	 @GetMapping("/search")
	    public String searchByKeyword(@RequestParam("keyword") String keyword, Model model) {
	        List<TicketTracker> searchResults = ticketService.findByKeyword(keyword);
	        model.addAttribute("searchResults", searchResults);
	        return "tickets/tickettracker"; // Assuming your view name is "tickets/tickettracker"
	    }
	 
	    @GetMapping("/viewTicketDetails/{id}")
	    public String viewTicketDetails(@PathVariable int id, Model model) {
	        
	    	TicketTracker tickets = ticketService.findById(id);
	        model.addAttribute("tickets", tickets);
	        return "tickets/view-ticket-details"; 
	    }


	

	
	
	
}
