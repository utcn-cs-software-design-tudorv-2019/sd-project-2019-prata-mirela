package com.example.demo.bussiness;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.example.demo.persistence.entity.Destination;
import com.example.demo.persistence.entity.Ticket;
import com.example.demo.persistence.repo.TicketRepository;
@Service()
public class TicketService {
	
	@Inject
	TicketRepository ticketRepository;
	
	public Ticket addTicket(Ticket ticket)
	{
		return ticketRepository.save(ticket);
	}
	
	
	public Ticket findByDestination(Destination destination)
	{
		return ticketRepository.findByDestination(destination);
	}
	
	public List<Ticket> findTicketsByDestination(Destination destination)
	{
		return ticketRepository.findTicketsByDestination(destination);
	}
	public Ticket updateTicket(Ticket ticket)
	{
		return ticketRepository.save(ticket);
	}
	
	public void deleteTicket(Ticket ticket)
	{
		ticketRepository.delete(ticket);
	}
	
	public List<Ticket> findAllTickets()
	{
		return ticketRepository.findAll();
	}


	public Ticket findById(Integer id) {
		// TODO Auto-generated method stub
		return ticketRepository.findByIdticket(id);
	}

}
