package com.example.demo.persistence.repo;
import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.persistence.entity.Destination;
public interface DestinationRepository extends JpaRepository<Destination,Integer>{
	public Destination findByIddestination(Integer id);
	public void deleteByIddestination(int id);
}
