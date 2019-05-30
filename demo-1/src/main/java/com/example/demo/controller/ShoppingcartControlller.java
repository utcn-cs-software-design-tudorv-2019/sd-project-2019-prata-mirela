package com.example.demo.controller;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;
import javax.transaction.Transactional;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.example.demo.bussiness.CartTicketService;
import com.example.demo.bussiness.ShoppingcartService;
import com.example.demo.bussiness.TicketService;
import com.example.demo.bussiness.UserService;
import com.example.demo.observer.Observable;
import com.example.demo.observer.Observer;
import com.example.demo.persistence.entity.CartTicket;
import com.example.demo.persistence.entity.Shoppingcart;
import com.example.demo.persistence.entity.Ticket;
import com.example.demo.persistence.entity.User;

@Controller
@RequestMapping(value = "/shoppingcart")
public class ShoppingcartControlller implements Observable{
	@Inject
	UserService userService;
	
	@Inject
	ShoppingcartService shoppingcartService;
	
	@Inject
	CartTicketService cartTicketService;
	
	@Inject
	TicketService ticketService;
	private Observer observer = shoppingcartService;
	
	@RequestMapping(value = "/{iduser}", method = RequestMethod.GET)
	public String getAll(Model model, @PathVariable int iduser) {
		User user=userService.findById(iduser);
		model.addAttribute(user);
		
		Shoppingcart shoppingcart=shoppingcartService.findByUser(user);
		
		model.addAttribute(shoppingcart);
		List<CartTicket> carttickets=cartTicketService.findCartTicketsByShoppingcart(shoppingcart);
		List<Ticket> tickets=new ArrayList<Ticket>();
		for(CartTicket cartticket: carttickets)
		{
			tickets.add(cartticket.getTicket());
		}
		model.addAttribute("tickets",tickets);
		model.addAttribute("carttickets",carttickets);
		return "shoppingcart_view";
	}
	@Transactional
	@GetMapping("/{iduser}/{idshoppingcart}/remove/{idcarttickets}")
	public String remove(Model model,@PathVariable int idshoppingcart,@PathVariable int idcarttickets,CartTicket cartticket )
	{
		
		Shoppingcart shoppingcart=shoppingcartService.findById(idshoppingcart);
		cartticket.setIdcarttickets(idcarttickets);
		Ticket ticket=cartTicketService.findById(idcarttickets).getTicket();
		
		addObserver(shoppingcartService);
		 notifyObservers(shoppingcart.getIdshoppingcart(),(-1)*ticket.getPrice());
		//cartTicketService.deleteCartTicket(cartTicketService.findByTicket(ticketService.findById(idticket)));
		cartTicketService.deleteCartTicket(cartticket);
		//int total=cartticket.getTicket().getPrice();
		
		List<CartTicket> carttickets=cartTicketService.findCartTicketsByShoppingcart(shoppingcart);
		List<Ticket> tickets=new ArrayList<Ticket>();
		
		for(CartTicket cartticket1: carttickets)
		{
			tickets.add(cartticket1.getTicket());
			
		}
		model.addAttribute("tickets",tickets);
		
		// notifyObservers(shoppingcart.getIdshoppingcart(),(-1)*total);
		//
		return "redirect:/shoppingcart/{iduser}";
	}
	
	@Transactional
	@GetMapping("/{iduser}/{idshoppingcart}/buy")
	public String buy(Model model,@PathVariable int idshoppingcart,CartTicket cartticket )
	{
	
		Shoppingcart shoppingcart=shoppingcartService.findById(idshoppingcart);
		
		List<CartTicket> carttickets=cartTicketService.findCartTicketsByShoppingcart(shoppingcart);
		
		
		for(CartTicket cartticket1: carttickets)
		{
			Ticket ticket=cartticket1.getTicket();
			
			ticketService.deleteTicket(cartticket1.getTicket());
			
			cartTicketService.deleteCartTicket(cartticket1);
			
		}
		shoppingcart.setTotalprice(0);
		shoppingcartService.updateShoppingcart(shoppingcart);
		
		
		
		return "redirect:/shoppingcart/{iduser}";
	}
	@Override
	public void addObserver(Observer o) {
		// TODO Auto-generated method stub
		this.observer = o;
		
	}
	@Override
	public void removeObserver(Observer o) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void notifyObservers(int id, int total) {
		// TODO Auto-generated method stub
		shoppingcartService.update(id,total);
	}
	
	
	
}
