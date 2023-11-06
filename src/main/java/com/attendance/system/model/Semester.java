package com.attendance.system.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Semester {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private Integer semesterId;
	private String semesterName;
}
