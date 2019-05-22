package com.example.demo.persistence.repo;
import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.persistence.entity.Shoppingcart;
import com.example.demo.persistence.entity.User;
public interface ShoppingcartRepository extends JpaRepository<Shoppingcart,Integer>{

	public Shoppingcart findByIdshoppingcart(Integer idshoppingcart);
	public Shoppingcart findByUser(User user);
}
