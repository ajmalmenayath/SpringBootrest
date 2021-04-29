package com.Ajmal.Rest.Controller;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.context.ApplicationContext;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.Ajmal.Rest.Model.restModel;
import com.Ajmal.Rest.Service.restService;


@RestController
public class restController {
	
	
    private static final Logger LOGGER = LogManager.getLogger(ApplicationContext.class);

	
	@Autowired 
	private restService rs;
	
	 @GetMapping("/")
	    public ModelAndView showLoginPage(restModel rm) {
		 
		 
		 LOGGER.info("Info level log message");
		 
		/* 	System.out.print("hello");

	        rm.setName("ajmal");
	        rm.setAddress("menayath");
	        int b=rs.count();
	        System.out.println("count"+b);*/
	        return new ModelAndView("welcome");
	

	 }
	 @RequestMapping("loginForm")
	 public void login()	 
	 {
		 
		 
		 
	 }
	 
	 @RequestMapping("/ajmal")
	 public ModelAndView show(restModel rm)
	 {
		 rm.setId(12);
		 	rm.setAddress("hello");
		 	rm.setName("ajmal");
		 return new ModelAndView("hello");
	 }
	 
	 @RequestMapping("/save")
	 public ModelAndView save(restModel rm)
	 {
		 	//rm.setId(12);
		 	rm.setAddress("abcd");
		 	rm.setName("ajmal2");
		 	
		 	int a=rs.save(rm);
		 	if(a==1)
		 	{
		 		System.out.print("inserted");
		 		System.out.println("Hello World");
		 	}
		 	else
		 	{
		 		System.out.print("failed");

		 	}
		 return new ModelAndView("hello");
	 }
	 
	 
	 
	@RequestMapping(method = RequestMethod.POST, value="/select_id/{regdNum}",produces = "application/json")
	 @ResponseBody
	 public void Select_id(@PathVariable("regdNum") String regdNum) {
	 //System.out.println("In deleteStudentRecord");
	 	int id=Integer.parseInt(regdNum);
	 	restModel rm=rs.select_id(id);
	 	System.out.println(rm.getId());

	 	System.out.println(rm.getName());

	 	System.out.println(rm.getAddress());
	
		// return rs.select_id(id);
		 
	 	
	   //  return StudentRegistration.getInstance().deleteStudent(regdNum);
	 }
	
	@RequestMapping("/getWithoutRequestParam")
	public void getWithoutRequestParam(restModel rm) {
	
	 	System.out.println(rm.getName());
	}
	
	

	 
	 
 
	 
 
}