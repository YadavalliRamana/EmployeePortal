package com.employee.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.employee.entity.EmployeeAttendance.DAY;

@Entity
@Table(name = "TimeSheet")
public class EmployeeTimeSheet implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@Column(name = "totalhours")
	private int totalhours;
	@Column(name = "emp_id")
	private String employeeId;
	@Column(name = "projectId")
	private String projectId;
	@Column(name = "projectName")
	private String projectName;
	@Column(name = "day")
	@Enumerated(EnumType.STRING)
	private DAY day;
	
	
	public String getEmployeeId() {
		return employeeId;
	}
	public void setEmployeeId(String employeeId) {
		this.employeeId = employeeId;
	}
	public DAY getDay() {
		return day;
	}
	public void setDay(DAY day) {
		this.day = day;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getTotalhours() {
		return totalhours;
	}
	public void setTotalhours(int totalhours) {
		this.totalhours = totalhours;
	}

	
	public String getProjectId() {
		return projectId;
	}
	public void setProjectId(String projectId) {
		this.projectId = projectId;
	}
	public String getProjectName() {
		return projectName;
	}
	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}
}
