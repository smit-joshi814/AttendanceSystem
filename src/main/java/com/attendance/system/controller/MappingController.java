package com.attendance.system.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.attendance.system.model.Mapping;
import com.attendance.system.model.MappingWrapper;
import com.attendance.system.service.MappingService;

import jakarta.servlet.http.HttpSession;

@RestController
@RequestMapping("mapping")
public class MappingController {

	@Autowired
	HttpSession session;

	@Autowired
	MappingService mappingService;

	@RequestMapping
	public ModelAndView manage() {
		if (session.getAttribute("admin") == null && session.getAttribute("faculty") == null)
			return new ModelAndView("redirect:/login");
		return new ModelAndView("mapping").addObject("mappingList", mappingService.getAll().getBody());
	}
	
	@GetMapping("get")
	public ResponseEntity<MappingWrapper> getMappingsList(){
		return mappingService.getAll();
	}

	@PostMapping("add")
	public ResponseEntity<String> addMapping(Mapping mapping) {
		return mappingService.addMapping(mapping);

	}

	@DeleteMapping("delete/{mid}")
	public ResponseEntity<Integer> deleteMapping(@PathVariable("mid") Integer mid) {

		return mappingService.deleteMapping(mid);

	}
}
