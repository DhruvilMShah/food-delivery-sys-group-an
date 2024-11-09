package com.group.an.dataLibrary.repositories;

import com.group.an.dataLibrary.models.Admin;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface AdminRepository extends MongoRepository <Admin, Integer> {

    Admin findByAdminId(int adminId);

}
