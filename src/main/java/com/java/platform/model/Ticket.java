package com.java.platform.model;

import java.time.LocalDate;
import java.util.List;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "tickets")
public class Ticket 
{
		@Id
		@GeneratedValue(strategy = GenerationType.IDENTITY)
		private Integer id;
		
		@NotNull
		@Size(min=2,max=255)
		private String title;
		
		@NotNull
		@NotEmpty
		@Size(min=5,max=255)
		private String description;
		
		@CreationTimestamp
		private LocalDate createdAt;
		
		@UpdateTimestamp
		private LocalDate updatedAt;
		
		@NotNull
		private String status;
		//@Enumerated(EnumType.STRING)  // To save enum as string in database
	    //private TicketStatus status;  // Enum field, no longer String
		
		@NotNull
		@ManyToOne
		@JoinColumn(name = "user_id", nullable = false)
		private User user;
		
		@OneToMany (mappedBy = "ticket", fetch = FetchType.EAGER, cascade = {CascadeType.REMOVE})
		private List<Note> notes;
		
		
		
		//public enum TicketStatus {
		//    TODO, COMPLETED, ONGOING, PENDING
		//}
		
		//public void setStatus(TicketStatus status) {
		//	this.status = status;
		//}
		public Integer getId() {
			return id;
		}
		public void setId(Integer id) {
			this.id = id;
		}
		public String getTitle() {
			return title;
		}
		public void setTitle(String title) {
			this.title = title;
		}
		public String getDescription() {
			return description;
		}
		public void setDescription(String description) {
			this.description = description;
		}
		public LocalDate getCreatedAt() {
			return createdAt;
		}
		public void setCreatedAt(LocalDate createdAt) {
			this.createdAt = createdAt;
		}
		public LocalDate getUpdatedAt() {
			return updatedAt;
		}
		public void setUpdatedAt(LocalDate updatedAt) {
			this.updatedAt = updatedAt;
		}
		public String getStatus() {
			return status;
		}
		public void setStatus(String status) {
			this.status = status;
		}
		public User getUser() {
			return user;
		}
		public void setUser(User user) {
			this.user = user;
		}
		public List<Note> getNotes() {
			return notes;
		}
		public void setNotes(List<Note> notes) {
			this.notes = notes;
		}
		
}
