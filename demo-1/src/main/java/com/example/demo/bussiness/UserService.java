package com.example.demo.bussiness;

import java.util.List;
import java.util.Optional;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.example.demo.persistence.entity.User;
import com.example.demo.persistence.repo.UserRepository;

@Service()
public class UserService {
	@Inject
	UserRepository userRepository;
	
	public User addUser(User user) {
		return userRepository.save(user);
	}
	
	public User findByEmail(String email) {
		return userRepository.findByEmail(email);
	}
	
	public void deleteUser(User user) {
		 userRepository.delete(user);
	}
	
	public User findById(int id){
		return userRepository.findByIduser(id);
	}
	
	public User updateUser(User user) {
		return userRepository.save(user);
	}
	
	public List<User> findAllUsers(){
		return userRepository.findAll();
	}
	

}
