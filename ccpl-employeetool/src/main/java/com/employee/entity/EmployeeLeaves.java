package com.employee.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "Leaves")
public class EmployeeLeaves implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public static enum TYPEOFLEAVE {
	    SICK,CASUAL,MENSTRUAL;
	}
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@Column(name = "emp_id")
	private String employeeId;
	@Column(name="type_of_leaves")
	@Enumerated(EnumType.STRING)
	private TYPEOFLEAVE typeOfLeave;
	@Column(name = "NumberOfLeaves")
	private int numberOfLeaves;
		
	@Column(name="inserted_time_stamp")
	@Temporal(TemporalType.TIMESTAMP)
	private Date insertedTimeStamp=new Date();
	@Column(name="modified_time_stamp")
	@Temporal(TemporalType.TIMESTAMP)
	private Date modifiedTimeStamp=new Date();

	public Date getInsertedTimeStamp() {
		return insertedTimeStamp;
	}
	public void setInsertedTimeStamp(Date insertedTimeStamp) {
		this.insertedTimeStamp = insertedTimeStamp;
	}
	public Date getModifiedTimeStamp() {
		return modifiedTimeStamp;
	}
	public void setModifiedTimeStamp(Date modifiedTimeStamp) {
		this.modifiedTimeStamp = modifiedTimeStamp;
	}
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
	

	public int getNumberOfLeaves() {
		return numberOfLeaves;
	}
	public void setNumberOfLeaves(int numberOfLeaves) {
		this.numberOfLeaves = numberOfLeaves;
	}
	public TYPEOFLEAVE getTypeOfLeave() {
		return typeOfLeave;
	}
	public void setTypeOfLeave(TYPEOFLEAVE typeOfLeave) {
		this.typeOfLeave = typeOfLeave;
	}
		
		
	}

