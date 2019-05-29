package com.example.demo.bussiness;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.example.demo.observer.Observer;
import com.example.demo.persistence.entity.Shoppingcart;
import com.example.demo.persistence.entity.Shoppingcart;
import com.example.demo.persistence.entity.User;
import com.example.demo.persistence.repo.ShoppingcartRepository;

@Service()
public class ShoppingcartService implements Observer {
	
	@Inject
	ShoppingcartRepository shoppingcartRepository;
	public Shoppingcart addShoppingcart(Shoppingcart shoppingcart)
	{
		return shoppingcartRepository.save(shoppingcart);
	}
	
	public void deleteShoppingcart(Shoppingcart shoppingcart)
	{
		 shoppingcartRepository.delete(shoppingcart);
	}
	public List<Shoppingcart> findAllShoppingcarts()
	{
		return shoppingcartRepository.findAll();
	}
	public Shoppingcart updateShoppingcart(Shoppingcart shoppingcart)
	{
		return shoppingcartRepository.save(shoppingcart);
	}
	

	public Shoppingcart findByUser(User user)
	{
		return shoppingcartRepository.findByUser(user);
	}
	public Shoppingcart findById(Integer id) {
		// TODO Auto-generated method stub
		return shoppingcartRepository.findByIdshoppingcart(id);
	}
	private int finaltotal;
	@Override
	public void update(int id, int total) {
		// TODO Auto-generated method stub
		
		finaltotal+=total;
	
		Shoppingcart shoppingcart = shoppingcartRepository.findByIdshoppingcart(id);
		shoppingcart.setTotalprice(finaltotal);
		shoppingcartRepository.save(shoppingcart);
	}
	
	
	
	
}
