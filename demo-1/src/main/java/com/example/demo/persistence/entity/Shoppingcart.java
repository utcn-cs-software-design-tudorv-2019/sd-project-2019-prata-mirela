package com.example.demo.persistence.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.MapsId;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
@Entity
@Table(name = "shoppingcart")
public class Shoppingcart {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idshoppingcart;
	
	@OneToMany(mappedBy = "shoppingcart", fetch = FetchType.EAGER)
	 private List<CartTicket> cartTickets;
	 
	 @OneToOne(fetch = FetchType.LAZY)
	 @JoinColumn(name = "iduser", nullable = false)
	 private User user;

	 @Column
	 private Integer totalprice;
	 
	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Integer getTotalprice() {
		return totalprice;
	}

	public void setTotalprice(Integer totalprice) {
		this.totalprice = totalprice;
	}

	public List<CartTicket> getCartTickets() {
		return cartTickets;
	}

	public void setCartTickets(List<CartTicket> cartTickets) {
		this.cartTickets = cartTickets;
	}
	
	public void computeTotalprice() {
		int sum=0;
		for(CartTicket cartTicket:cartTickets) {
			sum +=cartTicket.getTotal();
		}
		this.totalprice=sum;
	}

	public Integer getIdshoppingcart() {
		return idshoppingcart;
	}

	public void setIdshoppingcart(Integer idshoppingcart) {
		this.idshoppingcart = idshoppingcart;
	}

}
