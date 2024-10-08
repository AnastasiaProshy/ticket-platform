package com.java.platform.model;

import java.util.List;
import java.util.Set;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "users")
public class User 
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@NotNull
	@NotEmpty
	@Size(min=4,max=255)
	@Column(name = "email", nullable = false)
	private String email;
	
	@NotNull
	@NotEmpty
	@Column(name = "password", nullable = false)
	private String password;
	
	@NotNull
	@NotEmpty
	@Size(min=3,max=255)
	@Column(name = "full_name", nullable = false)
	private String fullName;
	
	@ManyToMany(fetch = FetchType.EAGER)
	private Set<Role> roles;
	
	@ManyToOne
	@JoinColumn(name = "state_id", nullable = false)
	private UserStatus userStatus;
	
	@OneToMany (mappedBy = "user")
	private List<Ticket> tickets;	// created ticket concept to connect to, so User has a ticket he is connected to 
	//	+ getter & setter
	
	@OneToMany (mappedBy = "user")
	private List<Note> notes;

	
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public UserStatus getStatus() {
		return userStatus;
	}

	public void setStatus(UserStatus userStatus) {
		this.userStatus = userStatus;
	}

	public List<Ticket> getTickets() {
		return tickets;
	}

	public void setTickets(List<Ticket> tickets) {
		this.tickets = tickets;
	}

	public List<Note> getNotes() {
		return notes;
	}

	public void setNotes(List<Note> notes) {
		this.notes = notes;
	}

	public Set<Role> getRoles() {
		return roles;
	}

	public void setRoles(Set<Role> roles) {
		this.roles = roles;
	}
	
}
