package com.example.demo.controller;

import org.springframework.ui.Model;
import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.demo.bussiness.AdminService;
import com.example.demo.bussiness.LoginService;
import com.example.demo.bussiness.UserService;
import com.example.demo.persistence.entity.Admin;
import com.example.demo.persistence.entity.User;
import com.example.demo.persistence.repo.AdminRepository;
import com.example.demo.persistence.repo.UserRepository;

@Controller

public class LoginController {
	@Inject
	LoginService loginService;
	
	@Inject
	private UserService userService;

	@Inject
	private AdminService adminService;
	
	private String email;
	
	
	@RequestMapping(value="/")
	public String login()
	{
	return "login_view";
	}
	
	
	
	 @RequestMapping(value="/login",method=RequestMethod.GET)
	public String getLoginStatus(Model model,@RequestParam String email, @RequestParam String password) { 
		if (loginService.getUser(email,password).equals("user"))
		{
			
			User user = userService.findByEmail(email);
			model.addAttribute("user",user);
			//showUser(user);
			return "redirect:/user/"+user.getIduser();
		}
		
		if (loginService.getUser(email,password).equals("admin"))
		{
			
			Admin admin=adminService.findByEmail(email);
			model.addAttribute("admin",admin);
			//ShowAdmin();
			return "admin";
		}
		return "";
		}
	@RequestMapping(value="/user/{iduser}/myProfile",method=RequestMethod.GET)
	public String myProfile(Model model, @PathVariable int iduser)
	{
		User user = userService.findById(iduser);
		model.addAttribute("user",user);
	return "userProfile";
	}
	
	@RequestMapping(value="/user/{iduser}")
	public String showUser(User user)
	{
	return "user";
	}
	
	@RequestMapping(value="/adminhome")
	public String ShowAdmin()
	{
	return "admin";
	}


	
	
}
				

	


