package com.spring.controller;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
public class PageController 
{		
   private static final Logger logger2 = Logger.getLogger(PageController.class);
	
   @RequestMapping(value="/")
   public String hello()
   { 
		if(logger2.isDebugEnabled())
		{
	 		logger2.debug("App Started !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
		}
	   return "index1";
   }
}
