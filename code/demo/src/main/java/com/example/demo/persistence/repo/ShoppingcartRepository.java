package com.example.demo.persistence.repo;
import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.persistence.entity.Shoppingcart;
public interface ShoppingcartRepository extends JpaRepository<Shoppingcart,Integer>{

}
