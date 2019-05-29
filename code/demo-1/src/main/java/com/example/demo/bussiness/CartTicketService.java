package com.example.demo.bussiness;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.example.demo.persistence.entity.CartTicket;
import com.example.demo.persistence.entity.Shoppingcart;
import com.example.demo.persistence.entity.Ticket;
import com.example.demo.persistence.repo.CartTicketRepository;

@Service()
public class CartTicketService  {

	@Inject
	CartTicketRepository cartTicketRepository;
	
	public CartTicket addCartTicket(CartTicket cartTicket)
	{
		return cartTicketRepository.save(cartTicket);
	}
	public CartTicket findById(int idcarttickets)
	{
		return cartTicketRepository.findByIdcarttickets(idcarttickets);
	}
	public CartTicket findByTicket(Ticket ticket)
	{
		return cartTicketRepository.findByTicket(ticket);
	}
	public List<CartTicket> findCartTicketsByShoppingcart(Shoppingcart shoppingcart)
	{
		return cartTicketRepository.findCartTicketsByShoppingcart(shoppingcart);
	}
	
	public CartTicket updateCartTicket(CartTicket cartTicket)
	{
		return cartTicketRepository.save(cartTicket);
	}
	
	public void deleteCartTicket(CartTicket cartTicket)
	{
		cartTicketRepository.delete(cartTicket);
	}
	
	public List<CartTicket> findAllCartTickets()
	{
		return cartTicketRepository.findAll();
	}
}
