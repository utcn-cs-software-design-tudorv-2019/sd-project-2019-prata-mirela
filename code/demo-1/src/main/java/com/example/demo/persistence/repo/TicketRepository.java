package com.example.demo.persistence.repo;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.persistence.entity.Destination;
import com.example.demo.persistence.entity.Shoppingcart;
import com.example.demo.persistence.entity.Ticket;

public interface TicketRepository extends JpaRepository<Ticket,Integer>{
	public Ticket findByDestination(Destination destination );
	public List<Ticket> findTicketsByDestination(Destination destination );
	public List<Ticket> findTicketsByShoppingcart(Shoppingcart shoppingcart );
	public Ticket findByIdticket(Integer id);
}
