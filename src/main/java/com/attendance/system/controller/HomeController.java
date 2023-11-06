package com.attendance.system.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import jakarta.servlet.http.HttpSession;

@Controller
public class HomeController {

	@Autowired
	HttpSession session;

	@RequestMapping("/home")
	public String home() {
		if (session.getAttribute("admin") == null && session.getAttribute("faculty") == null)
			return "redirect:/login";
		return "index";
	}

	@RequestMapping("/")
	public String index() {
		return "redirect:/home";
	}

}
