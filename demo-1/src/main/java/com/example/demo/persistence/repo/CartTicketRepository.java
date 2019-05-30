package com.example.demo.persistence.repo;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.persistence.entity.CartTicket;
import com.example.demo.persistence.entity.Shoppingcart;
import com.example.demo.persistence.entity.Ticket;

public interface CartTicketRepository extends JpaRepository<CartTicket, Integer>{
	public CartTicket findByIdcarttickets(Integer idcarttickets);
	public CartTicket findByTicket(Ticket ticket);
	public CartTicket findByShoppingcart(Shoppingcart shoppingcart);
	public List<CartTicket> findCartTicketsByShoppingcart(Shoppingcart shoppingcart);
}
