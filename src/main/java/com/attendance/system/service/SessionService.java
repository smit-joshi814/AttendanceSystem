package com.attendance.system.service;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import org.springframework.stereotype.Service;

import com.attendance.system.enums.SessionStatus;
import com.attendance.system.model.Session;

@Service
public class SessionService {
	private Map<String, Session> sessions = new ConcurrentHashMap<>();

	public boolean createSession(String course_id, String subject_id, String sem_id, String division,
			String facultyId) {
		String sessionId = course_id + "-" + subject_id + "-" + sem_id + "-" + division + "-" + facultyId;
		Session session = new Session(sessionId, course_id, subject_id, sem_id, division, facultyId,
				SessionStatus.STARTED);
		sessions.put(sessionId, session);
		System.out.println("Session Startedfor: " + sessionId);
		return true;
	}

	public boolean stopSession(String course_id, String subject_id, String sem_id, String division, String facultyId) {
		String sessionId = course_id + "-" + subject_id + "-" + sem_id + "-" + division + "-" + facultyId;
		Session session = sessions.get(sessionId);
		if (session != null && session.getStatus() == SessionStatus.STARTED) {
			System.out.println("Session Stopedfor: " + sessionId);
			session.setStatus(SessionStatus.STOPPED);
			return true;
		}
		return false;
	}

	public boolean isSessionAvailable(String course_id, String subject_id, String sem_id, String division,
			String facultyId) {
		return sessions.values().stream()
				.anyMatch(session -> session.getCourse_id().equals(course_id)
						&& session.getSubject_id().equals(subject_id) && session.getSem_id().equals(sem_id)
						&& session.getDivision().equals(division) && session.getFacultyId().equals(facultyId));
	}
}
