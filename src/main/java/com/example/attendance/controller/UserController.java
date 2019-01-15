package com.example.attendance.controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController 
{
    
	private String  msg="Register form";
	
	
	
	
	
	
	
	//now this method if admin you are authorised to rest end point
	
	@PreAuthorize("hasAnyRole('ADMIN')")
	@GetMapping("/secured/register")
	private String welcome()
	{
		//(Model model)
		//model.addAttribute("headerMsg", this.msg);
		
		return "register";
	}
	
	@GetMapping("/hi")
	private String hi()
	{
		return "hi";
	}
		
}