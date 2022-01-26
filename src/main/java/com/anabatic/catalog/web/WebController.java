package com.anabatic.catalog.web;

import org.springframework.web.servlet.ModelAndView;

public class WebController {
	
	
	public ModelAndView index() {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("index");
		return modelAndView;
	}
}
