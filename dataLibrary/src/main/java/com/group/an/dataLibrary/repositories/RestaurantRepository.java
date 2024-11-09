package com.group.an.dataLibrary.repositories;

import com.group.an.dataLibrary.models.Restaurant;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface RestaurantRepository extends MongoRepository <Restaurant, Integer> {

    Restaurant findByRestaurantId(int restaurantId);
}
