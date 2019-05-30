package com.example.demo.controller;

import javax.inject.Inject;
import javax.transaction.Transactional;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.example.demo.bussiness.UserService;
import com.example.demo.persistence.entity.User;

@Controller
@RequestMapping(value = "/users")
public class UserController {
	@Inject
	private UserService userService;
	@RequestMapping(value = "", method = RequestMethod.GET)
	public String getAll(Model model) {
		
		model.addAttribute("users",userService.findAllUsers());
		return "user_view";
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public User getUserById(@PathVariable("id") int id) {
		return userService.findById(id);
	}
	@GetMapping("/addUser")
    public String showSignUpForm(User user) {
        return "add_user";
    }
	  @PostMapping("/create")
	public String create(User user,Model model) {
		userService.addUser(user);
		model.addAttribute("users", userService.findAllUsers());
		return "redirect:/users";
	}
	
	@GetMapping("/edit/{iduser}")
	public String showUpdateForm(@PathVariable("iduser") int id, Model model) {
	    User user = userService.findById(id);
	
	     
	    model.addAttribute("user", user);
	    return "update_user";
	}
	
	@PostMapping("/update/{iduser}")
	public String update(@PathVariable("iduser") int id,User user,Model model) {
		user.setIduser(id);
		userService.updateUser(user);
		model.addAttribute("users", userService.findAllUsers());
		return "redirect:/users";
	}
	@Transactional
	@GetMapping("/delete/{iduser}")
	public String delete(@PathVariable(value = "iduser")int id,Model model) {
	
		userService.deleteUser(userService.findById(id));
		model.addAttribute("users", userService.findAllUsers());
		return "redirect:/users";
	}
	
	

	
	
	
	

}
