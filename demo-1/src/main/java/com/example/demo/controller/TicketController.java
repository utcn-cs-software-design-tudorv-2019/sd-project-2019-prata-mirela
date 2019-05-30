package com.example.demo.controller;

import javax.inject.Inject;
import javax.transaction.Transactional;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.example.demo.bussiness.DestinationService;
import com.example.demo.bussiness.TicketService;
import com.example.demo.persistence.entity.Destination;
import com.example.demo.persistence.entity.Ticket;

@Controller
@RequestMapping(value = "/tickets")
public class TicketController {
	@Inject
	TicketService ticketService;
	@Inject
	DestinationService destinationService;
	
	@RequestMapping(value = "", method = RequestMethod.GET)
	public String getAll(Model model) {
		
		model.addAttribute("tickets",ticketService.findAllTickets());
		model.addAttribute("destinations",destinationService.findAllDestinations());
		return "ticket_view";
	}
	
	
	
	@GetMapping("/addTicket")
    public String showSignUpForm(Ticket ticket,Model model) {
		model.addAttribute("destinations",destinationService.findAllDestinations());
        return "add_ticket";
    }
	  @PostMapping("/create")
	public String create(Ticket ticket,Model model) {
		
		ticketService.addTicket(ticket);
		model.addAttribute("tickets", ticketService.findAllTickets());
		model.addAttribute("destinations",destinationService.findAllDestinations());
		return "redirect:/tickets";
	}
	
	@GetMapping("/edit/{idticket}")
	public String showUpdateForm(@PathVariable("idticket") int id, Model model) {
	    Ticket ticket = ticketService.findById(id);
	
	    model.addAttribute("destinations",destinationService.findAllDestinations());
	    model.addAttribute("ticket", ticket);
	    return "update_ticket";
	}
	
	@PostMapping("/update/{idticket}")
	public String update(@PathVariable("idticket") int id,Ticket ticket,Model model) {
		ticket.setIdticket(id);
		ticketService.updateTicket(ticket);
		model.addAttribute("tickets", ticketService.findAllTickets());
		model.addAttribute("destinations",destinationService.findAllDestinations());
		return "redirect:/tickets";
	}
	@Transactional
	@GetMapping("/delete/{idticket}")
	public String delete(@PathVariable(value = "idticket")int id,Model model) {
	
		ticketService.deleteTicket(ticketService.findById(id));
		model.addAttribute("tickets", ticketService.findAllTickets());
		return "redirect:/tickets";
	}
	
	
	
	
	
	
	

}
