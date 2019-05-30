package com.example.demo.bussiness;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.example.demo.persistence.entity.Destination;
import com.example.demo.persistence.repo.DestinationRepository;

@Service()
public class DestinationService {
	@Inject
	DestinationRepository destinationRepository;
	
	public Destination addDestination(Destination destination)
	{
		return destinationRepository.save(destination);
	}
	public Destination findById(int id)
	{
		return destinationRepository.findByIddestination(id);
	}
	
	public void deleteById(int id)
	{
		destinationRepository.deleteByIddestination(id);
	}
	
	public Destination updateDestination(Destination destination)
	{
		return destinationRepository.save(destination);
	}
	
	public void deleteDestination(Destination destination)
	{
		destinationRepository.delete(destination);
	}
	
	public List<Destination> findAllDestinations()
	{
		return destinationRepository.findAll();
	}
}
