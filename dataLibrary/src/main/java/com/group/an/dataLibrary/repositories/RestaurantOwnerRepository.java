package com.group.an.dataLibrary.repositories;

import com.group.an.dataLibrary.models.RestaurantOwner;
import org.springframework.data.mongodb.repository.MongoRepository;


public interface RestaurantOwnerRepository extends MongoRepository<RestaurantOwner, Integer> {

    RestaurantOwner findByOwnerId(int restaurantOwnerId);

}
