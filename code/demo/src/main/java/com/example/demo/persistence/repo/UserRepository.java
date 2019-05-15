package com.example.demo.persistence.repo;


import org.springframework.data.jpa.repository.JpaRepository;
import com.example.demo.persistence.entity.User;
public interface UserRepository extends JpaRepository<User,Integer>{
	
}
