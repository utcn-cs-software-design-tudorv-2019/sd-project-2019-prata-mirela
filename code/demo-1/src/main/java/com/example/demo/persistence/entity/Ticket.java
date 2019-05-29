package com.example.demo.persistence.entity;
import java.sql.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
	@Entity
	@Table(name = "ticket")
	public class Ticket {

	    @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
		private Integer idticket;

	    @Column
	    private Date departuredata;
	    
	    @Column
	    private Date arrivaldata;
	    
	    @Column
	    private String seat;
	    
	    @Column
	    private Integer price;
	    
	    
	    @ManyToOne
	    @JoinColumn(name = "iddestination")
	    @NotNull
	    private Destination destination;
	    

	  
	    @OneToMany(mappedBy = "ticket", fetch = FetchType.LAZY)
		 private List<CartTicket> cartTickets;

	    


		@Override
		public String toString() {
			return "ticket[" + idticket + "] " + departuredata+ " " +arrivaldata +" "+seat + " "+price+" ---> " + destination; 
		}



		public Integer getIdticket() {
			return idticket;
		}



		public void setIdticket(Integer idticket) {
			this.idticket = idticket;
		}



		public Date getDeparturedata() {
			return departuredata;
		}



		public void setDeparturedata(Date departuredata) {
			this.departuredata = departuredata;
		}



		public Date getArrivaldata() {
			return arrivaldata;
		}



		public void setArrivaldata(Date arrivaldata) {
			this.arrivaldata = arrivaldata;
		}



		public String getSeat() {
			return seat;
		}



		public void setSeat(String seat) {
			this.seat = seat;
		}



		public Integer getPrice() {
			return price;
		}



		public void setPrice(Integer price) {
			this.price = price;
		}



		public Destination getDestination() {
			return destination;
		}



		public void setDestination(Destination destination) {
			this.destination = destination;
		}



		

	    
	    
	    
	}

