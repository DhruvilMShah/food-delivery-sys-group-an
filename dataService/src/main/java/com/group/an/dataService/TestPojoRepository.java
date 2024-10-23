package com.group.an.dataService;
import org.springframework.data.mongodb.repository.MongoRepository;
import com.group.an.dataService.TestPojo;

public interface TestPojoRepository extends MongoRepository<TestPojo,String>{

}
