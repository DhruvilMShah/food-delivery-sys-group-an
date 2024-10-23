// Java Program to Illustrate DemoController File 

// Importing package in this code module 
package com.group.an.dataService;
// Importing required classes 
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping; 
import org.springframework.web.bind.annotation.ResponseBody; 
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import com.group.an.dataService.TestPojo;
import com.group.an.dataService.TestPojoRepository;

// Annotation 
@RestController
// Main class 
public class DataController { 

	@RequestMapping("/hello") 
	@ResponseBody

	// Method 
	public String helloFromData() 
	{ 
		return "helloFromData"; 
	} 

	@Autowired 
    private TestPojoRepository testPojoRepo;
    
    // Save method is predefine method in Mongo Repository
    // with this method we will save user in our database
    @PostMapping("/testPojo")
    public TestPojo addTestPojo(@RequestBody TestPojo testPojo) {
        return testPojoRepo.save(testPojo);
    }
    
    // findAll method is predefine method in Mongo Repository 
    // with this method we will all user that is save in our database
    @GetMapping("/testPojo")
    public List<TestPojo> getAllTestPojo(){
        return testPojoRepo.findAll(); 
    }
}
