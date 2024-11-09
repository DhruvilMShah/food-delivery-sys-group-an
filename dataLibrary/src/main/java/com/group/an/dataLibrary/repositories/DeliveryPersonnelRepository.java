package com.group.an.dataLibrary.repositories;

import com.group.an.dataLibrary.models.DeliveryPersonnel;
import org.springframework.data.mongodb.repository.MongoRepository;


public interface DeliveryPersonnelRepository extends MongoRepository <DeliveryPersonnel, Integer> {

    DeliveryPersonnel findByPersonnelId(int personnelId);
}
