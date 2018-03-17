package com.sj.ldap.controller;

import java.security.Principal;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class SecController {
	
	HttpSession Session=null;

	@RequestMapping("/index11.html")
	public ModelAndView index11(Principal principal,HttpServletRequest request) {
		Session=request.getSession();
		Session.setAttribute("username", principal.getName());
		System.err.println("inside index11 "+Session.getAttribute("username"));
		return new ModelAndView("redirect:/home.html");
	}

	@RequestMapping(value="/home")
	@PreAuthorize("hasRole('home_view_Y')")
	public ModelAndView home(){
		return new ModelAndView("home");
	}
	
	@RequestMapping(value="/login")
	public ModelAndView login(){
		System.out.println("inside login");
		return new ModelAndView("login");
	}
	
	@RequestMapping(value="/failtologin")
	public ModelAndView failtologin(){
		System.out.println("fail to login");
		return new ModelAndView("login");
	}
	
	@RequestMapping("/logout")
	public ModelAndView logout(HttpServletRequest request){
		HttpSession session=request.getSession(false);
		SecurityContextHolder.clearContext();
		if(session!=null){
			session.invalidate();
		}
		return new ModelAndView("login");
		
	}
	
	
	@RequestMapping(value="/403")
	public ModelAndView accessDenied(){
		System.err.println("access denied");
		
		return new ModelAndView("403");
	}
	
	
	
	
	
}
