package com.example.demo.controller;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.example.demo.bussiness.CartTicketService;
import com.example.demo.bussiness.DestinationService;
import com.example.demo.bussiness.ShoppingcartService;
import com.example.demo.bussiness.TicketService;
import com.example.demo.bussiness.UserService;
import com.example.demo.bussiness.WeatherService;
import com.example.demo.observer.Observable;
import com.example.demo.observer.Observer;
import com.example.demo.persistence.entity.CartTicket;
import com.example.demo.persistence.entity.Destination;
import com.example.demo.persistence.entity.Shoppingcart;
import com.example.demo.persistence.entity.Ticket;
import com.example.demo.persistence.entity.User;
import com.example.demo.weather.WeatherSummary;
import com.example.demo.weather.Weather;
import com.example.demo.weather.WeatherEntry;
import com.example.demo.weather.WeatherForecast;

@Controller
@RequestMapping(value = "user/{iduser}/shop")
public class CartTicketController implements Observable {
	@Inject 
	UserService userService;
	
	@Inject 
	DestinationService destinationService;
	
	@Inject
	TicketService ticketService;
	
	@Inject
	ShoppingcartService shoppingcartService;
	
	@Inject
	CartTicketService cartticketService;
	
	@Inject
	WeatherService weatherService;
	private Observer observer = shoppingcartService;
	
	@RequestMapping(value = "", method = RequestMethod.GET)
	public String getAll(Model model, @PathVariable int iduser,Shoppingcart shoppingcart) {
		User user=userService.findById(iduser);
		
		if (shoppingcartService.findByUser(user)==null)
		{
			shoppingcart.setUser(userService.findById(iduser));
			shoppingcartService.addShoppingcart(shoppingcart);
			
		}
		
		model.addAttribute("user",user);
		model.addAttribute("destinations",destinationService.findAllDestinations());
		model.addAttribute("shoppingcart",shoppingcart);
		return "destinationuser_view";
	}
	
	@RequestMapping(value = "/viewWeather/{iddestination}", method = RequestMethod.GET)
	public String viewWeather(@PathVariable int iduser,@PathVariable int iddestination,Model model)
	{
		User user=userService.findById(iduser);
		model.addAttribute("user",user);
		 Destination destination=destinationService.findById(iddestination);
		 Weather weather=weatherService.getWeather(destination.getCountry(),destination.getCity());
		 WeatherSummary ws=new WeatherSummary(destination.getCountry(),destination.getCity(),weather);
		 model.addAttribute("ws",ws);
		 
		 List<WeatherSummary> wss= new ArrayList<WeatherSummary>();
		 
		 WeatherForecast wf=weatherService.getWeatherForecast(destination.getCountry(),destination.getCity());
		 for(int i=0;i< 16;i++) {
			 WeatherEntry w=wf.getEntries().get(i);
			 Weather ww=new Weather();
			 ww.setName(wf.getName());
			 ww.setWeatherIcon(w.getWeatherIcon());
			 ww.setWeatherId(w.getWeatherId());
			 ww.setTemperature(w.getTemperature());
			 ww.setTimestamp1(w.getTimestamp());
			 wss.add(new WeatherSummary(destination.getCountry(),wf.getName(),ww));
		 }
		
	
		 model.addAttribute("wss",wss);
		 return "weather";
	}
	
	@RequestMapping(value = "/findTickets/{iddestination}", method = RequestMethod.GET)
    public String findTicketsByDestination(@PathVariable int iduser,@PathVariable int iddestination,Model model) {
       model.addAttribute("tickets", ticketService.findTicketsByDestination(destinationService.findById(iddestination)));
       User user=userService.findById(iduser);
       Destination destination=destinationService.findById(iddestination);
       model.addAttribute("destination",destination);
       model.addAttribute("user",user);
       return "ticketuser_view";
    }
	
	@GetMapping(value="findTickets/addTicketCart/{idticket}")
	public String addToShoppingCart(@PathVariable int iduser,@PathVariable int idticket,CartTicket cartticket,Model model)
	{
		Ticket ticket =ticketService.findById(idticket);
		Shoppingcart shoppingcart=shoppingcartService.findByUser(userService.findById(iduser));
		cartticket.setTicket(ticket);
		cartticket.setShoppingcart(shoppingcart);
		model.addAttribute("cartticket",cartticket);
		cartticketService.addCartTicket(cartticket);
		int total=ticket.getPrice();
		
		addObserver(shoppingcartService);
		 notifyObservers(shoppingcart.getIdshoppingcart(),total);
		 
		 
		return "redirect:/user/{iduser}/shop";
	}

	@Override
	public void addObserver(Observer observer) {
		// TODO Auto-generated method stub
		 this.observer = observer;
	}

	@Override
	public void removeObserver(Observer o) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void notifyObservers(int id, int total) {
		// TODO Auto-generated method stub
		shoppingcartService.update(id,total);
	}
	
	
	
}
