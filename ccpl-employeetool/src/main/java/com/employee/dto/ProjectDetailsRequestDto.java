package com.employee.dto;

public class ProjectDetailsRequestDto {

    private int id;
	private String clientName;
	private String projectName;
	private String statementOfWork;
	private String projectStatus;
	private String projectStartingDate;
	private String projectEndingDate;
	private String clientStatus;
	private String billingType;
	private String comments;
	private String employeeId;
	
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
	public String getClientName() {
		return clientName;
	}
	public void setClientName(String clientName) {
		this.clientName = clientName;
	}
	public String getProjectName() {
		return projectName;
	}
	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}
	public String getStatementOfWork() {
		return statementOfWork;
	}
	public void setStatementOfWork(String statementOfWork) {
		this.statementOfWork = statementOfWork;
	}
	public String getProjectStatus() {
		return projectStatus;
	}
	public void setProjectStatus(String projectStatus) {
		this.projectStatus = projectStatus;
	}
	public String getProjectStartingDate() {
		return projectStartingDate;
	}
	public void setProjectStartingDate(String projectStartingDate) {
		this.projectStartingDate = projectStartingDate;
	}
	public String getProjectEndingDate() {
		return projectEndingDate;
	}
	public void setProjectEndingDate(String projectEndingDate) {
		this.projectEndingDate = projectEndingDate;
	}
	public String getClientStatus() {
		return clientStatus;
	}
	public void setClientStatus(String clientStatus) {
		this.clientStatus = clientStatus;
	}
	public String getBillingType() {
		return billingType;
	}
	public void setBillingType(String billingType) {
		this.billingType = billingType;
	}
	public String getComments() {
		return comments;
	}
	public void setComments(String comments) {
		this.comments = comments;
	}
	
	
	
}
