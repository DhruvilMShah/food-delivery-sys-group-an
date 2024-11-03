// Importing package in this code module 
package com.group.an.restaurantService;
// Importing required classes 
import com.group.an.dataService.models.MenuItem;
import com.group.an.dataService.models.Restaurants;
import com.group.an.dataService.repositories.RestaurantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

// Annotation 
@RestController
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

	@GetMapping("/restaurants/{restaurantId}/menu")
	public ResponseEntity<List<MenuItem>> getAllRestaurants(@PathVariable("restaurantId") Integer restaurantId) {
		Optional<Restaurants> restaurant = restaurantRepository.findById(restaurantId);
		if (restaurant.isPresent()) {
			return ResponseEntity.ok(restaurant.get().getMenus());
		} else {
			return ResponseEntity.notFound().build();
		}
	}

	@PostMapping("/restaurants/{restaurantId}/menu")
	public ResponseEntity<Restaurants> addItemToMenuOfRestaurant(@RequestBody MenuItem item, @PathVariable("restaurantId") Integer restaurantId) {
		// ToDo: Validate if restaurantId on the endpoint and the restaurantId of the logged in RestaurantOwner is same
		Optional<Restaurants> restaurant = restaurantRepository.findById(restaurantId);
		if (restaurant.isPresent()) {
			List<MenuItem> existingMenuItems = restaurant.get().getMenus();
			if(existingMenuItems == null) {
				existingMenuItems = new ArrayList<>();
			}
			existingMenuItems.add(item);
			restaurant.get().setMenus(existingMenuItems);
			restaurantRepository.save(restaurant.get());
			return ResponseEntity.ok(restaurant.get());
		} else {
			return ResponseEntity.notFound().build();
		}
	}
}
