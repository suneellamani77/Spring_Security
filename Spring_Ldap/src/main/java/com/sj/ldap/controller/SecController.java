package com.sj.ldap.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class SecController {

	@RequestMapping(value="/home")
	public ModelAndView home(){
		return new ModelAndView("test");
	}
	
}
