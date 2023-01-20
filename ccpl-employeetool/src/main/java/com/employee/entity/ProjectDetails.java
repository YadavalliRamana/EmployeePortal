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

	@Entity
	@Table(name="ProjectDetails")
	public class ProjectDetails implements Serializable{
		
		/**
		 * 
		 */
		private static final long serialVersionUID = 1L;
		public static enum CLIENTSTATUS{
			ACTIVE, INACTIVE;
		}

		
		@Id
		@GeneratedValue(strategy = GenerationType.IDENTITY)
		private int id;
		@Column(name="client_name")
		private String clientName;
		@Column(name="project_name")
		private String projectName;
		@Column(name="statementOf_work")
		private String statementOfWork;
		@Column(name="project_status")
		private String projectStatus;
		@Column(name="project_starting_date")
		private String projectStartingDate;
		@Column(name="project_ending_date")
		private String projectEndingDate;
		@Column(name="billing_type")
		private String billingType;
		@Column(name="comments")
		private String comments;
		@Column(name="client_status")
		@Enumerated(EnumType.STRING)
		private CLIENTSTATUS clientStatus;
		public String getEmployeeId() {
			return employeeId;
		}
		public void setEmployeeId(String employeeId) {
			this.employeeId = employeeId;
		}
		@Column(name="emp_Id")
		private String employeeId;
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
		
		public CLIENTSTATUS getClientStatus() {
			return clientStatus;
		}
		public void setClientStatus(CLIENTSTATUS clientStatus) {
			this.clientStatus = clientStatus;
		}
		
		
		
	}

	

	