// Importing package in this code module 
package com.group.an.restaurantService;
// Importing required classes 
import com.group.an.dataService.models.MenuItem;
import com.group.an.dataService.models.Restaurant;
import com.group.an.dataService.repositories.RestaurantRepository;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.springframework.security.access.prepost.PreAuthorize;

// Annotation
@RestController
@RequestMapping("/restaurants")
@SecurityRequirement(name = "jwtAuth")
public class RestaurantController {

	@Autowired
	private RestaurantRepository restaurantRepository;

	@Autowired
	private RestaurantService restaurantService;

	@GetMapping
	public ResponseEntity<List<Restaurant>> getAllRestaurants() {
		List<Restaurant> allRestaurants = restaurantService.getAllRestaurants();
		return new ResponseEntity<>(allRestaurants, HttpStatus.OK);
	}

	@PostMapping
	@PreAuthorize("hasRole('ADMIN')")
	public ResponseEntity<Restaurant> addRestaurant(@RequestBody Restaurant restaurant) {
		Restaurant newRestaurant = restaurantService.addRestaurant(restaurant);
		return new ResponseEntity<>(newRestaurant, HttpStatus.CREATED);
	}

	@GetMapping("/{restaurantId}/menu")
	public ResponseEntity<List<MenuItem>> getAllRestaurant(@PathVariable("restaurantId") Integer restaurantId) {
		List<MenuItem> existingMenu = restaurantService.getAllRestaurant(restaurantId);
		return new ResponseEntity<>(existingMenu, HttpStatus.OK);
	}

	@PostMapping("/{restaurantId}/menu")
	@PreAuthorize("hasRole('ADMIN') or hasRole('RESTAURANT_OWNER')")
	public ResponseEntity<Restaurant> addItemToMenuOfRestaurant(@RequestBody MenuItem item, @PathVariable("restaurantId") Integer restaurantId) {
		Restaurant restaurant = restaurantService.addItemToMenuOfRestaurant(item, restaurantId);
		return new ResponseEntity<>(restaurant, HttpStatus.OK);
	}

	@PostMapping("/{restaurantId}/menu/{menuItemId}")
	@PreAuthorize("hasRole('ADMIN') or hasRole('RESTAURANT_OWNER')")
	public ResponseEntity<Restaurant> updateMenuItemOfRestaurant(@RequestBody MenuItem item,
																  @PathVariable("restaurantId") Integer restaurantId,
																  @PathVariable("menuItemId") Integer menuItemId) {
		Restaurant restaurant = restaurantService.updateMenuItemOfRestaurant(item, restaurantId, menuItemId);
		return new ResponseEntity<>(restaurant, HttpStatus.OK);
	}

	@DeleteMapping("/{restaurantId}/menu/{menuItemId}")
	@PreAuthorize("hasRole('ADMIN') or hasRole('RESTAURANT_OWNER')")
	public ResponseEntity<Restaurant> deleteMenuItemOfRestaurant(@PathVariable("restaurantId") Integer restaurantId,
																  @PathVariable("menuItemId") Integer menuItemId) {
		Restaurant restaurant = restaurantService.deleteMenuItemOfRestaurant(restaurantId, menuItemId);
		return new ResponseEntity<>(restaurant, HttpStatus.OK);
	}
}