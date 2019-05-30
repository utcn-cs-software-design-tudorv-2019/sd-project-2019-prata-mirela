package com.example.demo.bussiness;

import java.util.Objects;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

@Service()
public class LoginService {
	@Inject
	AdminService adminService;
	
	@Inject
	UserService userService;
	
	public String getUser(String email, String password) {
		System.out.println(adminService.findByEmail(email));
		if (!Objects.isNull(adminService.findByEmail(email)) ) {
			if(adminService.findByEmail(email).getPassword().equals(password))
			{
				return "admin";
			}
			else return "notuser";
		
		}
		else if(!Objects.isNull(userService.findByEmail(email)) )
		{
			
			if(userService.findByEmail(email).getPassword().equals(password))
			{
				return "user";
			}
			else return "notuser";
		}
	 return "notuser";
	}
	
}
