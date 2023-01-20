package com.employee.dto;

public class LeavesRequestDto {
	private int id;
	private String employeeId;
	private String typeOfLeave;
	private int numberOfLeaves;
	
	
   
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
	


	public String getTypeOfLeave() {
		return typeOfLeave;
	}
	public void setTypeOfLeave(String typeOfLeave) {
		this.typeOfLeave = typeOfLeave;
	}
	public int getNumberOfLeaves() {
		return numberOfLeaves;
	}
	public void setNumberOfLeaves(int numberOfLeaves) {
		this.numberOfLeaves = numberOfLeaves;
	}

	


}
