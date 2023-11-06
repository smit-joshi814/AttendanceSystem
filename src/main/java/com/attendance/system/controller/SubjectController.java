package com.attendance.system.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.attendance.system.model.Subject;
import com.attendance.system.service.SubjectService;

import jakarta.servlet.http.HttpSession;

@RestController
@RequestMapping("subjects")
public class SubjectController {

	@Autowired
	HttpSession session;

	@Autowired
	SubjectService subjectService;

	@RequestMapping
	public ModelAndView subject() {
		if (session.getAttribute("admin") == null && session.getAttribute("faculty") == null)
			return new ModelAndView("redirect:/login");
		return new ModelAndView("subjects").addObject("subjectList", subjectService.getAllSubjects().getBody());
	}

	@PostMapping("add")
	public ResponseEntity<String> addSubject(Subject subject) {
		return subjectService.addSubject(subject);
	}

	@GetMapping("get")
	public ResponseEntity<List<Subject>> getAllSubjects() {
		return subjectService.getAllSubjects();
	}

	@GetMapping("get/{sid}")
	public ResponseEntity<Subject> getSubject(@PathVariable("sid") Integer sid) {
		return subjectService.getSubject(sid);
	}

	@PutMapping("update/{sid}")
	public ResponseEntity<String> updateSubject(@PathVariable("sid") Integer sid,
			@RequestParam("updSubject") String subjectName) {
		return subjectService.updateSubject(sid, subjectName);
	}

	@DeleteMapping("delete/{sid}")
	public ResponseEntity<Integer> deleteSubject(@PathVariable("sid") Integer sid) {
		return subjectService.deleteSubject(sid);
	}
}
