package com.example.demo.persistence.repo;
import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.persistence.entity.Ticket;
public interface TicketRepository extends JpaRepository<Ticket,Integer>{

}
