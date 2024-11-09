package com.group.an.dataLibrary.repositories;
import org.springframework.data.mongodb.repository.MongoRepository;
import com.group.an.dataLibrary.models.TestPojo;

public interface TestPojoRepository extends MongoRepository<TestPojo,String>{

}
