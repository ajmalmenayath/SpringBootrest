package com.Ajmal.Rest.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
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

import ch.qos.logback.core.net.SyslogOutputStream;

@RestController
public class restController {
	
	@Autowired 
	private restService rs;
	
	 @GetMapping("/")
	    public ModelAndView showLoginPage(restModel rm) {
		 	System.out.print("hello");

	        rm.setName("ajmal");
	        rm.setAddress("menayath");
	        int b=rs.count();
	        System.out.println("count"+b);
	        return new ModelAndView("welcomePage");
	

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
		 	}
		 	else
		 	{
		 		System.out.print("failed");

		 	}
		 return new ModelAndView("hello");
	 }
	 @RequestMapping(method = RequestMethod.POST, value="/all", produces = "application/json")
	 
	 @ResponseBody
	 public List<restModel> fechall()
	 {
		 List<restModel> ob=rs.fechall();
		 
		 
		 return ob;
		/* 
		 for (restModel restModel : ob) {
			 
			 System.out.println(restModel.getAddress());
			 System.out.println(restModel.getName());

			
		}
		 */
	 }
	 
	 
	 @RequestMapping(method = RequestMethod.POST, value="/select_id/{regdNum}")
	 @ResponseBody
	 public String deleteStudentRecord(@PathVariable("regdNum") String regdNum) {
	 System.out.println("In deleteStudentRecord");
	 	
	 	
	   //  return StudentRegistration.getInstance().deleteStudent(regdNum);
	 }

	 
	 
 
	 
 
}