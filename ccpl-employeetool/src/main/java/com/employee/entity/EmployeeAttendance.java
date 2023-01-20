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
@Table(name = "Attendance")
public class EmployeeAttendance implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public static enum DAY {
	    SUNDAY,MONDAY,TUESDAY,WEDNESDAY,THURSDAY,FRIDAY,SATURADAY;
	}

    @Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    private int Id;
	@Column(name="start_time")
	private String startTime;
	@Column(name="end_time")
	private String endTime;
	
	@Column(name="inserted_time_stamp")
	@Temporal(TemporalType.TIMESTAMP)
	private Date insertedTimeStamp=new Date();
	@Column(name="modified_time_stamp")
	@Temporal(TemporalType.TIMESTAMP)
	private Date modifiedTimeStamp=new Date();
	@Column(name="emp_id")
	private String employeeId;
	
	@Column(name = "day")
	@Enumerated(EnumType.STRING)
	private DAY day;
	
	
	
	
	public String getEmployeeId() {
		return employeeId;
	}
	public void setEmployeeId(String employeeId) {
		this.employeeId = employeeId;
	}
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
	
	public DAY getDay() {
		return day;
	}
	public void setDay(DAY day) {
		this.day = day;
	}
	public int getId() {
		return Id;
	}
	public void setId(int id) {
		this.Id = id;
	}
	public String getStartTime() {
		return startTime;
	}
	public void setStartTime(String startTime) {
		this.startTime = startTime;
	}
	public String getEndTime() {
		return endTime;
	}
	public void setEndTime(String endTime) {
		this.endTime = endTime;
	}


}
