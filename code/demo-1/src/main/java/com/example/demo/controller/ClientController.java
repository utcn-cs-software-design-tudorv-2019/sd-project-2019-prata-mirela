package com.example.demo.controller;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.example.demo.bussiness.DestinationService;
import com.example.demo.bussiness.ShoppingcartService;
import com.example.demo.bussiness.TicketService;
import com.example.demo.bussiness.UserService;
import com.example.demo.persistence.entity.Destination;
import com.example.demo.persistence.entity.Shoppingcart;
import com.example.demo.persistence.entity.Ticket;
import com.example.demo.persistence.entity.User;

@Controller
@RequestMapping(value = "user/{iduser}/shop")
public class ClientController {
	@Inject 
	UserService userService;
	
	@Inject 
	DestinationService destinationService;
	
	@Inject
	TicketService ticketService;
	
	@Inject
	ShoppingcartService shoppingcartService;
	
	
	@RequestMapping(value = "", method = RequestMethod.GET)
	public String getAll(Model model, @PathVariable int iduser) {
		User user=userService.findById(iduser);
		Shoppingcart shoppingcart=new Shoppingcart();
		shoppingcart.setUser(userService.findById(iduser));
		shoppingcartService.addShoppingcart(shoppingcart);
		model.addAttribute("user",user);
		model.addAttribute("destinations",destinationService.findAllDestinations());
		model.addAttribute("shoppingcart",shoppingcart);
		return "destinationuser_view";
	}
	
	@RequestMapping(value = "/findTickets/{iddestination}", method = RequestMethod.GET)
    public String findTicketsByDestination(@PathVariable int iduser,@PathVariable int iddestination,Model model) {
       model.addAttribute("tickets", ticketService.findTicketsByDestination(destinationService.findById(iddestination)));
       User user=userService.findById(iduser);
       model.addAttribute("user",user);
       return "ticketuser_view";
    }
	
	@GetMapping(value="findTickets/addShoppingcart/{idticket}")
	public String addToShoppingCart(@PathVariable int iduser,@PathVariable int idticket,Model model)
	{
		Ticket ticket =ticketService.findById(idticket);
		System.out.println(ticket);
		ticket.setShoppingcart(shoppingcartService.findByUser(userService.findById(iduser)));
		ticketService.updateTicket(ticket);
		model.addAttribute("ticket",ticket);
		return "redirect:/user/{iduser}/shop";
	}
	
	
}
