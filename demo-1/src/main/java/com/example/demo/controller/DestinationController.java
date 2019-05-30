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

@Controller
@RequestMapping(value = "/destinations")
public class DestinationController {
	@Inject
	DestinationService destinationService;
	@Inject
	TicketService ticketService;
	
	
	
	@RequestMapping(value = "", method = RequestMethod.GET)
	public String getAll(Model model) {
		
		model.addAttribute("destinations",destinationService.findAllDestinations());
		return "destination_view";
	}
	
	@RequestMapping(value = "/findDestination/{iddestination}", method = RequestMethod.GET)
    public Destination findDestinationByID(@PathVariable int id) {
        return destinationService.findById(id);
    }
	
	@GetMapping("/addDestination")
    public String showSignUpForm(Destination destination) {
        return "add_destination";
    }
	  @PostMapping("/create")
	public String create(Destination destination,Model model) {
		destinationService.addDestination(destination);
		model.addAttribute("destinations", destinationService.findAllDestinations());
		return "redirect:/destinations";
	}
	
	@GetMapping("/edit/{iddestination}")
	public String showUpdateForm(@PathVariable("iddestination") int id, Model model) {
	    Destination destination = destinationService.findById(id);
	
	     
	    model.addAttribute("destination", destination);
	    return "update_destination";
	}
	
	@PostMapping("/update/{iddestination}")
	public String update(@PathVariable("iddestination") int id,Destination destination,Model model) {
		destination.setIddestination(id);
		destinationService.updateDestination(destination);
		model.addAttribute("destinations", destinationService.findAllDestinations());
		return "redirect:/destinations";
	}
	@Transactional
	@GetMapping("/delete/{iddestination}")
	public String delete(@PathVariable(value = "iddestination")int id,Model model) {
		ticketService.deleteTicket(ticketService.findByDestination(destinationService.findById(id)));
		destinationService.deleteById(id);
		model.addAttribute("destinations", destinationService.findAllDestinations());
		return "redirect:/destinations";
	}
	
	

	

}
