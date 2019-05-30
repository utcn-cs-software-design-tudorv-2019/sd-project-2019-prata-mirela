package com.example.demo.persistence.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;

@Entity

@Table(name = "cart_tickets")
public class CartTicket {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idcarttickets;
	
	@ManyToOne
    @JoinColumn(name = "idshoppingcart")
   
    private Shoppingcart shoppingcart;
	
	@ManyToOne
    @JoinColumn(name = "idticket")
	private Ticket ticket;

	public Shoppingcart getShoppingcart() {
		return shoppingcart;
	}

	public void setShoppingcart(Shoppingcart shoppingcart) {
		this.shoppingcart = shoppingcart;
	}

	public Ticket getTicket() {
		return ticket;
	}

	public void setTicket(Ticket ticket) {
		this.ticket = ticket;
	}
	public int getTotal() {
		return ticket.getPrice();
	}

	public Integer getIdcarttickets() {
		return idcarttickets;
	}

	public void setIdcarttickets(Integer idcarttickets) {
		this.idcarttickets = idcarttickets;
	}
	
}
