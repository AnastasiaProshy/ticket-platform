package com.java.platform.model;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

@Entity
@Table(name = "ticket_conditions")
public class TicketCondition 
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@NotNull
	@NotEmpty
	@Column(name = "ticket_condition", nullable = false)
	private String ticketCondition;
	
	
	
	@OneToMany (mappedBy = "ticketCondition")
	private List<Ticket> tickets;	// created ticket concept to connect to, so TicketCondition has a ticket he is connected to 
	//	+ getter & setter



	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public List<Ticket> getTickets() {
		return tickets;
	}
	public void setTickets(List<Ticket> tickets) {
		this.tickets = tickets;
	}
	public String getTicketCondition() {
		return ticketCondition;
	}
	public void setTicketCondition(String ticketCondition) {
		this.ticketCondition = ticketCondition;
	}

}
