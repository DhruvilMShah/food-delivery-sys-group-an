// Importing package in this code module 
package com.group.an.restaurantService;
// Importing required classes 
import com.group.an.dataService.models.Restaurants;
import com.group.an.dataService.repositories.RestaurantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

// Annotation 
@Controller
// Main class 
public class RestaurantController { 

	@Autowired
	private RestaurantRepository restaurantRepository;

	@GetMapping("/restaurants")
	public List<Restaurants> getAllRestaurants() {
		return restaurantRepository.findAll();
	}

	@PostMapping("/restaurants")
	public Restaurants addRestaurant(@RequestBody Restaurants restaurant) {
		return restaurantRepository.save(restaurant);
	}
}
