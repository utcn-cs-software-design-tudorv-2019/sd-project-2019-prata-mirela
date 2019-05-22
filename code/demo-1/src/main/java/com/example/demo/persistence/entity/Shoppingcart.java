package com.example.demo.persistence.entity;

import java.util.List;

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
	 private List<Ticket> tickets;
	 
	 @OneToOne(fetch = FetchType.LAZY)
	 @JoinColumn(name = "iduser", nullable = false)
	 private User user;

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

}
