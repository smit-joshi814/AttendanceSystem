package com.attendance.system.controller;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.attendance.system.service.LoginService;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@Controller
@RequestMapping("login")
public class LoginController {
	@Autowired
	HttpSession session;

	@Autowired
	LoginService loginService;

	@RequestMapping
	public String login() {
		return "login";
	}

	@RequestMapping("logout")
	public String logOut() {
		session.removeAttribute("admin");
		session.invalidate();
		return "redirect:/login";
	}

	@RequestMapping("auth")
	public String authenticate(@RequestParam("email") String email, @RequestParam("password") String password,
			@RequestParam("loginType") String loginType, HttpServletRequest request, HttpServletResponse response) {
		String res = loginService.authenticate(email, password, loginType, request, response);
		if (res == null) {
			return "redirect:/login?error=true";
		}
		return "redirect:/" + res;
	}
}
