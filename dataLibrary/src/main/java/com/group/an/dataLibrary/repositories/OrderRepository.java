package com.group.an.dataLibrary.repositories;

import com.group.an.dataLibrary.models.DeliveryStatus;
import com.group.an.dataLibrary.models.Order;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface OrderRepository extends MongoRepository <Order,Integer> {

    List<Order> findByCustomerId(int customerId);

    Order findByOrderId(int orderId);

    List<Order> findByRestaurantId(int restaurantId);

    List<Order> findByDeliveryStatus(DeliveryStatus deliveryStatus);

}
