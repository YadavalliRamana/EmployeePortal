package com.employee.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "employees")
public class Employee implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public static enum EMPLOYEESTATUS {
	    BILLING, BENCH;
	}
	
	public static enum TYPE {
	    ADMIN, EMPLOYEE,INTERN;
	}
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@Column(name = "first_name")
	private String firstName;
	@Column(name = "last_name")
	private String lastName;
	@Column(name = "email")
	private String email;
	@Column(name="joining_date")
	private String joiningDate;
	@Column(name = "address")
	private String address;
	@Column(name = "mb_no")
	private String mobileNumber;
	@Column(name = "emcy_no")
	private String emergencyNumber;
	@Column(name = "desig")
	private String designation;
	@Column(name = "gen")
	private String gender;
	@Column(name = "employee_id")
	private String employeeId;
	@Column(name = "password")
	private String password;
	@Column(name = "salt")
	private String salt;
    @Column(name = "Employee_status")
	@Enumerated(EnumType.STRING)
	private EMPLOYEESTATUS employeeStatus;
	@Column(name = "type")
	@Enumerated(EnumType.STRING)
	private TYPE type;
	@Column(name="inserted_time_stamp")
	@Temporal(TemporalType.TIMESTAMP)
	private Date insertedTimeStamp=new Date();
	@Column(name="modified_time_stamp")
	@Temporal(TemporalType.TIMESTAMP)
	private Date modifiedTimeStamp=new Date();
	@Column(name="experience")
	private String experience;

	
	public String getExperience() {
		return experience;
	}
	public void setExperience(String experience) {
		this.experience = experience;
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
	public String getJoiningDate() {
		return joiningDate;
	}
	public void setJoiningDate(String joiningDate) {
		this.joiningDate = joiningDate;
	}
	@OneToMany(targetEntity=EmployeeAttendance.class,cascade=CascadeType.ALL)
	@JoinColumn(name="emp_id",referencedColumnName="employee_id")
	private List<EmployeeAttendance> empAttendanceEntity ;
	
	@OneToMany(targetEntity=EmployeeLeaves.class,cascade=CascadeType.ALL)
	@JoinColumn(name="emp_id",referencedColumnName="employee_id")
	private List<EmployeeLeaves> employeeLeaves ;
	
	
	@OneToMany(targetEntity=ProjectDetails.class,cascade=CascadeType.ALL)
	@JoinColumn(name="emp_id",referencedColumnName="employee_id")
	private List<ProjectDetails> projectdetails ;
	
	@OneToMany(targetEntity=EmployeeTimeSheet.class,cascade=CascadeType.ALL)
	@JoinColumn(name="emp_id",referencedColumnName="employee_id")
	private List<EmployeeTimeSheet> employeeTimeSheet ;
	
	public List<EmployeeTimeSheet> getEmployeeTimeStamp() {
		return employeeTimeSheet;
	}
		
	public void setEmployeeLeaves(List<EmployeeLeaves> employeeLeaves) {
		this.employeeLeaves = employeeLeaves;
	}
	public void setEmployeeTimeStamp(List<EmployeeTimeSheet> employeeTimeSheet) {
		this.employeeTimeSheet = employeeTimeSheet;
	}
	public List<EmployeeLeaves> getEmployeeLeaves() {
		return employeeLeaves;
	}
	public List<EmployeeAttendance> getEmpAttendanceEntity() {
		return empAttendanceEntity;
	}
	public void setEmpAttendanceEntity(List<EmployeeAttendance> empAttendanceEntity) {
		this.empAttendanceEntity = empAttendanceEntity;
	}
	
	public String getSalt() {
		return salt;
	}
	public void setSalt(String salt) {
		this.salt = salt;
	}

	public TYPE getType() {
		return type;
	}
	public void setType(TYPE type) {
		this.type = type;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getMobileNumber() {
		return mobileNumber;
	}
	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
	}
	public String getEmergencyNumber() {
		return emergencyNumber;
	}
	public void setEmergencyNumber(String emergencyNumber) {
		this.emergencyNumber = emergencyNumber;
	}
	public String getDesignation() {
		return designation;
	}
	public void setDesignation(String designation) {
		this.designation = designation;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getEmployeeId() {
		return employeeId;
	}
	public void setEmployeeId(String employeeId) {
		this.employeeId = employeeId;
	}
	
	public List<EmployeeTimeSheet> getEmpTimeSheet() {
		return employeeTimeSheet;
	}
	public EMPLOYEESTATUS getEmployeeStatus() {
		return employeeStatus;
	}
	public void setEmployeeStatus(EMPLOYEESTATUS employeeStatus) {
		this.employeeStatus = employeeStatus;
	}

	
	}

	

