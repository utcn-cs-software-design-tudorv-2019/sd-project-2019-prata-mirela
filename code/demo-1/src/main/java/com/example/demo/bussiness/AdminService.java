package com.example.demo.bussiness;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.example.demo.persistence.entity.Admin;
import com.example.demo.persistence.repo.AdminRepository;

@Service()
public class AdminService {
	@Inject
	AdminRepository adminRepository;
	
	public Admin findByEmail(String email) {
		return adminRepository.findByEmail(email);
	}
	
	
}
