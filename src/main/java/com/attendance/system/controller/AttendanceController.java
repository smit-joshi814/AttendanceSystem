package com.attendance.system.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.attendance.system.model.Attendance;
import com.attendance.system.service.AttendanceService;

import jakarta.servlet.http.HttpSession;

@RestController
@RequestMapping("attendance")
public class AttendanceController {

	@Autowired
	HttpSession session;

	@Autowired
	AttendanceService attendanceService;

	@RequestMapping
	public ModelAndView attendance() {
		if (session.getAttribute("admin") == null && session.getAttribute("faculty") == null)
			return new ModelAndView("redirect:/login");
		return new ModelAndView("attendance");
	}

	@GetMapping("session/start/{course}/{subject}/{sem}/{div}/{fid}")
	public ResponseEntity<String> startSession(@PathVariable("course") String course_id,@PathVariable("subject") String subject_id,@PathVariable("sem") String sem_id,@PathVariable("div") String division,@PathVariable("fid") String facultyId) {
		return attendanceService.startSession(course_id,subject_id,sem_id,division,facultyId);
	}
	@GetMapping("session/stop/{course}/{subject}/{sem}/{div}/{fid}")
	public ResponseEntity<String> stopSession(@PathVariable("course") String course_id,@PathVariable("subject") String subject_id,@PathVariable("sem") String sem_id,@PathVariable("div") String division,@PathVariable("fid") String facultyId) {
		return attendanceService.stopSession(course_id,subject_id,sem_id,division,facultyId);
	}

	@PutMapping("update/{aid}/{isPresent}")
	public ResponseEntity<String> updateAttendance(@PathVariable("aid") Integer aid,
			@PathVariable("isPresent") Boolean isPresent) {
		return attendanceService.updateAttendance(aid, isPresent);
	}
	
	@GetMapping("get/{aid}")
	public ResponseEntity<Attendance> getAttendance(@PathVariable("aid") Integer aid){
		return attendanceService.getAttendance(aid);
	}
	
	@GetMapping("fill/{mid}/{sid}")
	public ResponseEntity<Boolean> fillAttendance(@PathVariable("mid") Integer mid,@PathVariable("sid") Integer sid){
		return attendanceService.fillAttendance(mid,sid);
	}
}
