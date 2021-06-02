package com.satishlabs.controllers;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

public class HelloWorldController implements Controller{
	protected final Logger logger = Logger.getLogger(getClass());
	
	@Override
	public ModelAndView handleRequest(HttpServletRequest arg0, HttpServletResponse arg1) throws Exception {
		logger.info("returning hello view with Model data ");
		Map<String, Object> model = new HashMap<String, Object>();
		//populate some book list, generally this data comes from service layer
		List<String> books = new ArrayList<String>();
		books.add("Spring in Action");
		books.add("Hibernate in Action");
		books.add("Head First Java");
		
		//Add date and book information to model
		model.put("now", new Date());
		model.put("bookList", books);
		
		//returning ModelAndView(viewName,modelParameterName, modelParameterValue)
		return new ModelAndView("hello","model",model);
	}
	
}
