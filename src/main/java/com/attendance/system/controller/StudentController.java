package com.attendance.system.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.attendance.system.model.Mapping;
import com.attendance.system.model.Student;
import com.attendance.system.service.StudentService;

import jakarta.servlet.http.HttpSession;

@RestController
@RequestMapping("student")
public class StudentController {
	
	@Autowired
	HttpSession session;
	
	@Autowired
	StudentService studentService;
	
	@RequestMapping
	public ModelAndView student() {
		if (session.getAttribute("admin") == null && session.getAttribute("faculty") == null)
			return new ModelAndView("redirect:/login");
		return new ModelAndView("student").addObject("studentWrapper", studentService.getAll().getBody());
	}
	
	@PostMapping("add")
	public ResponseEntity<String> addStudent(Student student){
		return studentService.addStudent(student);
	}
	
	@GetMapping("auth/{email}/{pass}")
	public ResponseEntity<Student> authenticateStudent(@PathVariable("email") String email,@PathVariable("pass") String password){
		return studentService.authenticate(email,password);
	}
	
	@GetMapping("getDivisions")
	public ResponseEntity<List<String>> getDivisions(){
		return studentService.getDivisons();
	}
	
	@GetMapping("isSession/{sid}")
	public ResponseEntity<Mapping> isSession(@PathVariable("sid") Integer sid){
		return studentService.isSession(sid);	
				
	}
	
	

}
