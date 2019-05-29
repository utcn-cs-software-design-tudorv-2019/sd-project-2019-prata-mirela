package com.example.demo.persistence.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "destination")
public class Destination {
	
	
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer iddestination;
	
    @Column
    private String country;
    
    @Column
    private String city;
	
    
    @OneToMany(mappedBy = "destination", fetch = FetchType.EAGER)
    private List<Ticket> tickets;






	@Override
	public String toString() {
		return "destination[" + iddestination + "] " + city ;
	}






	public Integer getIddestination() {
		return iddestination;
	}






	public void setIddestination(Integer iddestination) {
		this.iddestination = iddestination;
	}






	public String getCity() {
		return city;
	}






	public void setCity(String city) {
		this.city = city;
	}






	public List<Ticket> getTickets() {
		return tickets;
	}






	public void setTickets(List<Ticket> tickets) {
		this.tickets = tickets;
	}






	public String getCountry() {
		return country;
	}






	public void setCountry(String country) {
		this.country = country;
	}

   
    
    
}