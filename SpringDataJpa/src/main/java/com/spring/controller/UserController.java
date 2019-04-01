package com.spring.controller;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;


import java.util.concurrent.TimeoutException;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;



import com.spring.model.User;
import com.spring.service.UserServiceImpl;

@Controller
@RequestMapping("/User")
@EnableAsync
public class UserController 
{	
	private static final Logger logger1 = Logger.getLogger(UserController.class);
	
   @Autowired
   private UserServiceImpl userserviceimpl;
	
   @PostMapping("/ShowUserRecords")
   public String showall(Model model)
   {
	   
	   model.addAttribute("showallrecords",userserviceimpl.findAllRecords());
	   logger1.info("Show All Records Accessing");
	   return "showpage";
   }
   
   @PostMapping("/ShowUserRecordsSortByName")
   public String showallpagination(Model model)
   {
	   model.addAttribute("showallrecordssortbyname",userserviceimpl.findAllRecordsSortsWithName());
	   return "showpage";
   }
   
   @GetMapping("/ShowUserRecordsSortByNameGetMethods")
   public String showallpaginationwithpostmethod(Model model,@RequestParam(defaultValue="0") int i)
   {
	     model.addAttribute("showallrecordssortbynameget",userserviceimpl.findAllRecordsSortsWithNamegetmethod(i));
	     System.out.println(" Total Records : "+userserviceimpl.findAllRecordsSortsWithNamegetmethod(i).getTotalElements());
	    return "showpage";
   }
   
   
   @RequestMapping(value="/ShowOneRecord")
   public String showone(@ModelAttribute("one") User obj2,BindingResult bind,Model model) throws InterruptedException, ExecutionException, TimeoutException
   {
	   if(bind.hasErrors())
	   {
		   logger1.info("Error Created....");
		   return "errorpage";
	   }
	       User obj = userserviceimpl.findOneRecord(obj2.getUserid());
	 	   model.addAttribute("printonestudent",obj);
	   return "showpage";
   }
   
   @RequestMapping(value="/ShowOneMoreStudentRecords",method = RequestMethod.POST)
   public String findonemorerecords(Model model)
   {
	   List<Integer> list =  new ArrayList<Integer>();
	   list.add(1);
	   list.add(3);
	   List<User> li = userserviceimpl.findOneMoreRecord(list);
	   model.addAttribute("showoneplus",li);
	   return "showpage";
   }
   
   @RequestMapping(value="/InsertStudentRecord",method = RequestMethod.POST)
   public String insertstudent(@ModelAttribute("insert") User obj1,BindingResult bind,Model model)
   {
	   if(bind.hasErrors())
	   {
		   logger1.error("Error Created with Insertion Part...");
		   return "errorpage";
	   }
	   model.addAttribute("inserted",userserviceimpl.InserStudentRecords(obj1));
	   return "index1";
   }
   
   @RequestMapping(value="/DeleteStudentRecord",method = RequestMethod.POST)
   public String deletestudent(@ModelAttribute("delete") User obj2,BindingResult bind,Model model)
   {
	   if(bind.hasErrors())
	   {
		   logger1.error("Error Created at delete part...");
		   return "errorpage";
	   }
	   model.addAttribute("deleted",userserviceimpl.DeleteStudentRecord(obj2.getUserid()));
	   return "index1";
   }
   
   @RequestMapping(value="/UpdateStudentRecord",method = RequestMethod.POST)
   public String updatestudent(@ModelAttribute("update") User obj2,BindingResult bind,Model model)
   {
	   if(bind.hasErrors())
	   {
		   return "errorpage";
	   }
	   model.addAttribute("update",userserviceimpl.UpdateStudentRecords(obj2));
	   return "index1";
   }
   
   @RequestMapping(value="/FindStudentName",method = RequestMethod.POST)
   public String findstudent(@ModelAttribute("find") User obj2,BindingResult bind,Model model)
   {
	   if(obj2.getUsername().equals(null))
	   {
		   logger1.debug("Field is Empty"+bind);
	   }
	   else if(bind.hasErrors())
	   {
		   return "errorpage";
	   }
	   model.addAttribute("cheack22",userserviceimpl.findstudentwithname(obj2.getUsername()));
	   return "showpage";
   }
   
   @RequestMapping(value="/FindStudentNameWithPagination",method = RequestMethod.POST)
   public String findstudentpagination(@ModelAttribute("findp") User obj2,BindingResult bind,Model model)
   {
	   if(bind.hasErrors()) 
	   {
		   return "errorpage";
	   }
	       model.addAttribute("cheack223",
           userserviceimpl.findstudentwithnamepagination(obj2.getUsername(),new PageRequest(0,5,Direction.ASC,"userid")));
	       return "showpage";
   }
   

   @RequestMapping(value="/FindStudentWithNameAndAge",method = RequestMethod.POST)
   public String findstudentWithnameandage(@ModelAttribute("findnameage") User obj2,BindingResult bind,Model model)
   {
	   if(bind.hasErrors())
	   {
		   return "errorpage";
	   }
	   model.addAttribute("cheack23",userserviceimpl.findstudentNameandAge(obj2.getUsername(), obj2.getUserage()));
	   return "showpage";
   }
}
