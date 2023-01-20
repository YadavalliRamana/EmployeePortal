package com.employee.dto;

import com.employee.entity.EmployeeAttendance.DAY;

public class TimeSheetResponseDto {
	
	private int id;
	private int totalhours;
	private String employeeId;
	private String projectId;
	private String projectName;
	private DAY day;
	
	public String getEmployeeId() {
		return employeeId;
	}
	public void setEmployeeId(String employeeId) {
		this.employeeId = employeeId;
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
	public  void setProjectId(String projectId) {
		this.projectId = projectId;
	}
	public String getProjectName() {
		return projectName;
	}
	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}
	public DAY getDay() {
		return day;
	}
	public void setDay(DAY day) {
		this.day = day;
	}

}
