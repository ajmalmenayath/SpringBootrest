package com.Ajmal.Rest.Controller;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.Ajmal.Rest.Model.restModel;
import com.Ajmal.Rest.Service.restService;

@RestController
public class RestCont {
	
	 private static final Logger logger = LogManager.getLogger(RestCont.class);
	
	
	@Autowired 
	private restService rs;
	
	@RequestMapping(value = "/user/{id}", method = RequestMethod.GET)
    public void getUser(@PathVariable("id") int id) {
        logger.info("Fetching User with id {}", id);
        restModel user = rs.select_id(id);
        System.out.println("Adresssssssssssssssssssssssssss"+user.getAddress());
       System.out.println("addreeeee"+user.getAddress());
       System.out.println("addreeeee"+user.getName());
        
    }
	
	
	 @PostMapping("/empsave")
	 public void newEmployee(@RequestBody restModel newEmployee) {
	    int a= rs.save(newEmployee);
	  }
	
	

}
