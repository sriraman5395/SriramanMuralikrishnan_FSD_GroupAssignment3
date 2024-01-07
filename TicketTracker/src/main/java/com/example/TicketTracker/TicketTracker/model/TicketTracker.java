package com.example.TicketTracker.TicketTracker.model;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;


@Entity
public class TicketTracker {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String TicketTitle;
	private String TicketDescription;
	private String TicketContent;
	private LocalDate selectedDate;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTicketTitle() {
		return TicketTitle;
	}
	public void setTicketTitle(String ticketTitle) {
		TicketTitle = ticketTitle;
	}
	public String getTicketDescription() {
		return TicketDescription;
	}
	public void setTicketDescription(String ticketDescription) {
		TicketDescription = ticketDescription;
	}
	public LocalDate getSelectedDate() {
		return selectedDate;
	}
	public void setSelectedDate(LocalDate selectedDate) {
		this.selectedDate = selectedDate;
	}
	public String getTicketContent() {
		return TicketContent;
	}
	public void setTicketContent(String ticketContent) {
		TicketContent = ticketContent;
	}
	
	public TicketTracker( String ticketTitle, String ticketDescription, LocalDate selectedDate ,String ticketContent) {
		super();
		
		TicketTitle = ticketTitle;
		TicketDescription = ticketDescription;
		this.selectedDate = selectedDate;
		TicketContent=ticketContent;
	}
	public TicketTracker() {
		super();
	}
	@Override
	public String toString() {
		return "TicketTracker [id=" + id + ", TicketTitle=" + TicketTitle + ", TicketDescription=" + TicketDescription
				+ ", selectedDate=" + selectedDate + "]";
	}

	

}
