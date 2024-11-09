// Importing package in this code module 
package com.group.an.restaurantService;
// Importing required classes 
import com.group.an.dataLibrary.models.MenuItem;
import com.group.an.dataLibrary.models.Restaurant;
import com.group.an.dataLibrary.repositories.RestaurantRepository;
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
	public List<Restaurant> getAllRestaurants() {
		return restaurantRepository.findAll();
	}

	@PostMapping("/restaurants")
	public Restaurant addRestaurant(@RequestBody Restaurant restaurant) {
		return restaurantRepository.save(restaurant);
	}

	@GetMapping("/restaurants/{restaurantId}/menu")
	public ResponseEntity<List<MenuItem>> getAllRestaurant(@PathVariable("restaurantId") Integer restaurantId) {
		Optional<Restaurant> restaurant = restaurantRepository.findById(restaurantId);
		if (restaurant.isPresent()) {
			return ResponseEntity.ok(restaurant.get().getMenus());
		} else {
			return ResponseEntity.notFound().build();
		}
	}

	@PostMapping("/restaurants/{restaurantId}/menu")
	public ResponseEntity<Restaurant> addItemToMenuOfRestaurant(@RequestBody MenuItem item, @PathVariable("restaurantId") Integer restaurantId) {
		// ToDo: Validate if restaurantId on the endpoint and the restaurantId of the logged in RestaurantOwner is same
		Optional<Restaurant> restaurant = restaurantRepository.findById(restaurantId);
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

	@PostMapping("/restaurants/{restaurantId}/menu/{menuItemId}")
	public ResponseEntity<Restaurant> updateMenuItemOfRestaurant(@RequestBody MenuItem item,
																  @PathVariable("restaurantId") Integer restaurantId,
																  @PathVariable("menuItemId") Integer menuItemId) {
		// ToDo: Validate if restaurantId on the endpoint and the restaurantId of the logged in RestaurantOwner is same
		Optional<Restaurant> restaurant = restaurantRepository.findById(restaurantId);
		if (restaurant.isPresent()) {
			List<MenuItem> existingMenuItems = restaurant.get().getMenus();

			if(existingMenuItems == null) {
				existingMenuItems = new ArrayList<>();
				existingMenuItems.add(item);
			}
			else {
				existingMenuItems = replaceExistingItem(existingMenuItems, menuItemId,item);
			}
			restaurant.get().setMenus(existingMenuItems);
			restaurantRepository.save(restaurant.get());
			return ResponseEntity.ok(restaurant.get());
		} else {
			return ResponseEntity.notFound().build();
		}
	}

	private List<MenuItem> replaceExistingItem(List<MenuItem> existingMenuItems, Integer menuItemId, MenuItem item) {
		for(MenuItem existingItem : existingMenuItems) {
			if(existingItem.getMenuItemId() == menuItemId) {
				existingMenuItems.remove(existingItem);
				existingMenuItems.add(item);
				break;
			}
		}
		return existingMenuItems;
	}

	@DeleteMapping("/restaurants/{restaurantId}/menu/{menuItemId}")
	public ResponseEntity<Restaurant> deleteMenuItemOfRestaurant(@PathVariable("restaurantId") Integer restaurantId,
																  @PathVariable("menuItemId") Integer menuItemId) {
		// ToDo: Validate if restaurantId on the endpoint and the restaurantId of the logged in RestaurantOwner is same
		Optional<Restaurant> restaurant = restaurantRepository.findById(restaurantId);
		if (restaurant.isPresent()) {
			List<MenuItem> existingMenuItems = restaurant.get().getMenus();

			if(existingMenuItems == null || existingMenuItems.isEmpty()) {
				return ResponseEntity.notFound().build();
			}
			else {
				for(MenuItem existingItem : existingMenuItems) {
					if(existingItem.getMenuItemId() == menuItemId) {
						existingMenuItems.remove(existingItem);
						break;
					}
				}
			}
			restaurant.get().setMenus(existingMenuItems);
			restaurantRepository.save(restaurant.get());
			return ResponseEntity.ok(restaurant.get());
		} else {
			return ResponseEntity.notFound().build();
		}
	}
}