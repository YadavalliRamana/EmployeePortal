package com.employee.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.employee.dto.AttendanceRequestDto;
import com.employee.dto.AttendanceResponceDto;
import com.employee.dto.EmployeeRequestDto;
import com.employee.dto.EmployeeResponseDto;
import com.employee.dto.LeavesRequestDto;
import com.employee.dto.LeavesResponseDto;
import com.employee.dto.ProjectDetailsRequestDto;
import com.employee.dto.ProjectDetailsResponseDto;
import com.employee.dto.TimeSheetRequestDto;
import com.employee.dto.TimeSheetResponseDto;
import com.employee.entity.ProjectDetails;
import com.employee.security.ILoginService;
import com.employee.service.IEmployeeService;

@RestController
@RequestMapping("/api/v1/employees")
@CrossOrigin
public class EmployeeController { 
	@Autowired
	private IEmployeeService iEmployeeService;
	
	@Autowired
	private ILoginService iloginServiceFactory;
	
	private static final String ACCESS_TOKEN="ACCESS_TOKEN";
	
	//POST for Employee
	
	@PostMapping("/onboard")
	public EmployeeResponseDto onbordEmployee(@RequestBody(required = true)  EmployeeRequestDto employeeRequestDto) {
		EmployeeResponseDto employeeResponseDto=iEmployeeService.onbordEmployee(employeeRequestDto);
		return employeeResponseDto;
		
	}
	
	//GET for Employee

    @GetMapping("/getemployees/{id}")
	public EmployeeResponseDto getEmployeeById(@PathVariable(name = "id")int id){
      EmployeeResponseDto employeeResponseDto=iEmployeeService.getEmployee(id);
	     return employeeResponseDto;
	}
    
	//UPDATE for Employee

   	@PutMapping("/update")
	public EmployeeResponseDto updateEmployee(@RequestBody(required = true)  EmployeeRequestDto employeeRequestDto) {
		EmployeeResponseDto employeeResponseDto=iEmployeeService.updateEmployee(employeeRequestDto);
		return employeeResponseDto;
		
	}
   	
	//POST for login

	@PostMapping("/login")
	public ResponseEntity<EmployeeResponseDto> login(@RequestBody(required = true)  EmployeeRequestDto employeeRequestDto) {
		EmployeeResponseDto employeeResponseDto=iloginServiceFactory.login(employeeRequestDto);
		String token=employeeResponseDto.getAccessToken();
		employeeResponseDto.setAccessToken(null);
		return ResponseEntity.ok().header(ACCESS_TOKEN,token).body(employeeResponseDto);
		
	}
	
	//GET for Status

	 @GetMapping("/status")
	 public List<EmployeeResponseDto> getEmployeeStatus(String Employeestatus){
		 List<EmployeeResponseDto> employeeResponseDto=iEmployeeService.getEmployeeStatus(Employeestatus);
		     return employeeResponseDto;
		}
	
	@PostMapping("/attendance")
	public AttendanceResponceDto attendanceEmployee(@RequestBody(required = true)  AttendanceRequestDto attendanceRequestDto) {
		AttendanceResponceDto attendanceResponseDto=iEmployeeService.attendanceEmployee(attendanceRequestDto);
		return attendanceResponseDto;
		
	}
	 @GetMapping("/getattendance/{id}")
		public List<AttendanceResponceDto> getEmployeeAttendanceById(@PathVariable(name = "id")int id){
		 List<AttendanceResponceDto> attendanceResponceDto=iEmployeeService.getEmployeeAttendance(id);
		     return attendanceResponceDto;
		}
	 @PostMapping("/leaves")
		public LeavesResponseDto employeeLeaves(@RequestBody(required = true) LeavesRequestDto LeavesRequestDto) {
			LeavesResponseDto leavesResponseDto=iEmployeeService.employeeLeaves(LeavesRequestDto);
			return leavesResponseDto;
		}
	 @GetMapping("/getleaves/{id}")
		public List<LeavesResponseDto> getEmployeeLeavesById(@PathVariable(name = "id")int id){
		 List<LeavesResponseDto> leavesResponseDto=iEmployeeService.getEmployeeLeaves(id);
		     return leavesResponseDto;
		}
		 
	 @PostMapping("/timesheet")
		public TimeSheetResponseDto timeStampEmployee(@RequestBody(required = true)  TimeSheetRequestDto timesheetRequestDto) {
		 TimeSheetResponseDto timeSheetResponseDto=iEmployeeService.employeeTimeSheet(timesheetRequestDto);
			return timeSheetResponseDto;
			
		}
	 
	 @GetMapping("/getAll")
	 public List<EmployeeResponseDto> getAllEmployees(){
	     List<EmployeeResponseDto> list=iEmployeeService.getAllEmployees();
	     return list;
	     }
	 
	 @GetMapping("/gettimesheet/{id}")
		public List<TimeSheetResponseDto> getEmployeeTimeSheetById(@PathVariable(name = "id")int id){
		 List<TimeSheetResponseDto> timeSheetResponceDto=iEmployeeService.getEmployeeTimeSheet(id);
		     return timeSheetResponceDto;
		}
	
		  
	@GetMapping("/getallforleaves")
		public List<LeavesResponseDto> getAllEmployeesLeaves(){
		 List<LeavesResponseDto> leaves=iEmployeeService.getAllEmployeesLeaves();
			     return leaves;
			     }
		  
	@PostMapping("/projectdetails")
		public ProjectDetailsResponseDto projectDetails(@RequestBody(required = true)  ProjectDetailsRequestDto projectDetailsRequestDto) {
			ProjectDetailsResponseDto projectDetailsResponseDto=iEmployeeService.projectDetails(projectDetailsRequestDto);
				return projectDetailsResponseDto;
				
			}
		//get	
	@GetMapping("/getprojects/{id}")
		  public ProjectDetailsResponseDto getProjectById(@PathVariable(name = "id")int id){
		    ProjectDetailsResponseDto projectDetailsResponseDto=iEmployeeService.getProjectDetails(id);
		    	return projectDetailsResponseDto;
		  }
	  	  
		//get   	
	  @GetMapping("/getallforproject")
		 public List<ProjectDetailsResponseDto> getAllprojectDetails(){
		     List<ProjectDetailsResponseDto> project=iEmployeeService.getAllprojectDetails();
		     	return project;
		     }
	  
	  @PutMapping("/updateforproject/{id}")
		public ProjectDetails updateproject(@PathVariable(name = "id")int id,@RequestBody(required = true)  ProjectDetails projectDetails) {
			System.out.println("id");
  			return iEmployeeService.updateproject(projectDetails);
	  	}
}
	

