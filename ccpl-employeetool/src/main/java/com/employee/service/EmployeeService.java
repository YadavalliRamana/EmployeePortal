package com.employee.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
import com.employee.entity.Employee;
import com.employee.entity.Employee.EMPLOYEESTATUS;
import com.employee.entity.Employee.TYPE;
import com.employee.entity.EmployeeAttendance;
import com.employee.entity.EmployeeAttendance.DAY;
import com.employee.entity.EmployeeLeaves;
import com.employee.entity.EmployeeLeaves.TYPEOFLEAVE;
import com.employee.entity.EmployeeTimeSheet;
import com.employee.entity.ProjectDetails;
import com.employee.entity.ProjectDetails.CLIENTSTATUS;
import com.employee.repo.EmpAttendanceRepo;
import com.employee.repo.EmployeeLeavesRepo;
import com.employee.repo.EmployeeRepo;
import com.employee.repo.ProjectDetailsRepo;
import com.employee.repo.TimeSheetRepo;
import com.employee.security.signature.ISignatureService;


@Service
public class EmployeeService implements IEmployeeService {
	
	@Autowired
	private EmployeeRepo employeeRepo;
	@Autowired
	private EmpAttendanceRepo empAttendanceRepo;
	@Autowired
	private EmployeeLeavesRepo employeeLeavesRepo;
	@Autowired
	private ISignatureService iSignatureService;
	@Autowired
	private TimeSheetRepo timeSheetRepo;
    @Autowired
    private ProjectDetailsRepo projectDetailsRepo;
    
    
    //Post Method for Employee
    
    
	@Override
	public EmployeeResponseDto onbordEmployee(EmployeeRequestDto employeeRequestDto) {

		Employee employeeEntity = employeeRepo.findByEmployeeId(employeeRequestDto.getEmployeeId());

		if (employeeEntity == null) {
			employeeEntity = new Employee();
			employeeEntity.setFirstName(employeeRequestDto.getFirstName());
			employeeEntity.setLastName(employeeRequestDto.getLastName());
			employeeEntity.setEmail(employeeRequestDto.getEmail());
			employeeEntity.setJoiningDate(employeeRequestDto.getJoiningDate());
			employeeEntity.setAddress(employeeRequestDto.getAddress());
			employeeEntity.setMobileNumber(employeeRequestDto.getMobileNumber());
			employeeEntity.setEmergencyNumber(employeeRequestDto.getEmergencyNumber());
			employeeEntity.setDesignation(employeeRequestDto.getDesignation());
			employeeEntity.setGender(employeeRequestDto.getGender());
			employeeEntity.setType(TYPE.valueOf(employeeRequestDto.getType()));
			employeeEntity.setEmployeeId(employeeRequestDto.getEmployeeId());
			employeeEntity.setSalt(UUID.randomUUID().toString() + UUID.randomUUID().toString().substring(0, 10));
			String password = iSignatureService.hashPassword(employeeRequestDto.getPassword(), employeeEntity.getSalt());
			employeeEntity.setEmployeeStatus(EMPLOYEESTATUS.valueOf(employeeRequestDto.getEmployeeStatus()));
			employeeEntity.setPassword(password);
			employeeEntity.setExperience(employeeRequestDto.getExperience());
			employeeRepo.save(employeeEntity);
		} else {
			throw new RuntimeException();
		}

		EmployeeResponseDto employeeResponseDto = new EmployeeResponseDto();
		employeeResponseDto.setId(employeeEntity.getId());
		employeeEntity.setEmployeeId(employeeEntity.getEmployeeId());

		return employeeResponseDto;
	}
     
	
	 //Inquire Method for Employee
	
	
	@Override
	public EmployeeResponseDto getEmployee(int id) {

		Optional<Employee> optional = employeeRepo.findById(id);

		EmployeeResponseDto employeeResponseDto = null;
		if (optional.isPresent()) {
			Employee employeeEntity = optional.get();
			employeeResponseDto = new EmployeeResponseDto();
			employeeResponseDto.setFirstName(employeeEntity.getFirstName());
			employeeResponseDto.setLastName(employeeEntity.getLastName());
			employeeResponseDto.setEmail(employeeEntity.getEmail());
			employeeResponseDto.setJoiningDate(employeeEntity.getJoiningDate());
			employeeResponseDto.setEmployeeStatus(employeeEntity.getEmployeeStatus().toString());
			employeeResponseDto.setAddress(employeeEntity.getAddress());
			employeeResponseDto.setMobileNumber(employeeEntity.getMobileNumber());
			employeeResponseDto.setEmergencyNumber(employeeEntity.getEmergencyNumber());
			employeeResponseDto.setDesignation(employeeEntity.getDesignation());
			employeeResponseDto.setGender(employeeEntity.getGender());
			employeeResponseDto.setEmployeeId(employeeEntity.getEmployeeId());
			employeeResponseDto.setId(employeeEntity.getId());
			employeeResponseDto.setType(employeeEntity.getType().toString());
			employeeResponseDto.setExperience(employeeEntity.getExperience());
		} else {
			throw new RuntimeException();
		}

		return employeeResponseDto;
	}
	
	//Put Method For Employee
	
	
	@Override
	public EmployeeResponseDto updateEmployee(EmployeeRequestDto employeeRequestDto) {

		Employee employeeEntity = employeeRepo.findByEmployeeId(employeeRequestDto.getEmployeeId());

		if (employeeEntity == null) {

			throw new RuntimeException();
		} else {

			if(employeeRequestDto.getFirstName()!=null) {
				employeeEntity.setFirstName(employeeRequestDto.getFirstName());
			}
			if(employeeRequestDto.getLastName()!=null) {
				employeeEntity.setLastName(employeeRequestDto.getLastName());
			}
			if(employeeRequestDto.getEmail()!=null) {
				employeeEntity.setEmail(employeeRequestDto.getEmail());
			}
			if(employeeRequestDto.getAddress()!=null) {
				employeeEntity.setAddress(employeeRequestDto.getAddress());
			}
			if(employeeRequestDto.getMobileNumber()!=null) {
			employeeEntity.setMobileNumber(employeeRequestDto.getMobileNumber());
			}
			if(employeeRequestDto.getEmergencyNumber()!=null) {
			employeeEntity.setEmergencyNumber(employeeRequestDto.getEmergencyNumber());
			}
			if(employeeRequestDto.getDesignation()!=null) {
			employeeEntity.setDesignation(employeeRequestDto.getDesignation());
			}
			if(employeeRequestDto.getGender()!=null) {
			employeeEntity.setGender(employeeRequestDto.getGender());
			}
			if(employeeRequestDto.getType()!=null) {
				employeeEntity.setType(TYPE.valueOf(employeeRequestDto.getType()));
				}
			if(employeeRequestDto.getJoiningDate()!=null) {
				employeeEntity.setJoiningDate(employeeRequestDto.getJoiningDate());
				}
			if(employeeRequestDto.getExperience()!=null) {
				employeeEntity.setExperience(employeeRequestDto.getExperience());
			}

			employeeRepo.save(employeeEntity);
		}
	
	EmployeeResponseDto employeeResponseDto = new EmployeeResponseDto();
	employeeResponseDto.setId(employeeEntity.getId());
	employeeEntity.setEmployeeId(employeeEntity.getEmployeeId());

	return employeeResponseDto;
	}
	
	//Post method For Attendance
	
	
		@Override
		public AttendanceResponceDto attendanceEmployee(AttendanceRequestDto attendanceRequestDto) {

			Employee employeeEntity=	employeeRepo.findByEmployeeId(attendanceRequestDto.getEmployeeId());
		      //need to verify the user 	
	           EmployeeAttendance empAttendanceEntity=new EmployeeAttendance();
				empAttendanceEntity.setStartTime(attendanceRequestDto.getStartTime());
				empAttendanceEntity.setEndTime(attendanceRequestDto.getEndTime());
				empAttendanceEntity.setDay(DAY.valueOf(attendanceRequestDto.getDay()));
				empAttendanceEntity.setEmployeeId(employeeEntity.getEmployeeId());
				empAttendanceRepo.save(empAttendanceEntity);
				

			
			AttendanceResponceDto attendanceResponceDto=new AttendanceResponceDto();
			attendanceResponceDto.setId(empAttendanceEntity.getId());
				return attendanceResponceDto;
			}
		
	
    //Post Method for LogIn
		
		
	@Override
	public EmployeeResponseDto verifyUser(EmployeeRequestDto employeeRequestDto) {
		EmployeeResponseDto employeeResponseDto = null;
		Employee employeeEntity = employeeRepo.findByEmployeeId(employeeRequestDto.getEmployeeId());
		if (employeeEntity == null) {
			throw new RuntimeException();
		} else {
			String password = iSignatureService.hashPassword(employeeRequestDto.getPassword(), employeeEntity.getSalt());
			if (employeeEntity.getPassword().equals(password)) {
				employeeResponseDto = new EmployeeResponseDto();
				employeeResponseDto.setId(employeeEntity.getId());
				employeeResponseDto.setEmployeeId(employeeEntity.getEmployeeId());
				employeeResponseDto.setType(employeeEntity.getType().toString());
			} else {
				throw new RuntimeException();
			}
		
		return employeeResponseDto;
	}

	}
	
	//GetBySTATUS for EMPLOYEE
	
	@Override
	public List<EmployeeResponseDto> getEmployeeStatus(String employeeStatus) {

		List<EmployeeResponseDto> employeeResponseDtos=new ArrayList<>();
		List<Employee> billingEmployees = employeeRepo.findByemployeeStatus(employeeStatus);
		if(!billingEmployees.isEmpty()) {
			for(Employee employeeEntity:billingEmployees) {
			EmployeeResponseDto employeeResponseDto=new EmployeeResponseDto();
			employeeResponseDto = new EmployeeResponseDto();
			employeeResponseDto.setFirstName(employeeEntity.getFirstName());
			employeeResponseDto.setLastName(employeeEntity.getLastName());
			employeeResponseDto.setEmail(employeeEntity.getEmail());
			employeeResponseDto.setAddress(employeeEntity.getAddress());
			employeeResponseDto.setMobileNumber(employeeEntity.getMobileNumber());
	 		employeeResponseDto.setEmergencyNumber(employeeEntity.getEmergencyNumber());
			employeeResponseDto.setDesignation(employeeEntity.getDesignation());
			employeeResponseDto.setGender(employeeEntity.getGender());
			employeeResponseDto.setEmployeeId(employeeEntity.getEmployeeId());
			employeeResponseDtos.add(employeeResponseDto);
			}
			
		}
		
		
		return employeeResponseDtos;
	}
	
	//GetById for Attendance

	@Override
	public List<AttendanceResponceDto> getEmployeeAttendance(int id) {
		Employee employeeEntity=	employeeRepo.findById(id).orElseThrow(()->new RuntimeException());
		List<AttendanceResponceDto> attendanceResponceDtos=new ArrayList<>();
		List<EmployeeAttendance> empAttendanceEntities=employeeEntity.getEmpAttendanceEntity();
		if(empAttendanceEntities.isEmpty()) {
			throw new RuntimeException();
		}
		else {
			for(EmployeeAttendance attendanceEntity:empAttendanceEntities) {
				AttendanceResponceDto attendanceResponceDto=new AttendanceResponceDto();
				attendanceResponceDto.setEmployeeId(attendanceEntity.getEmployeeId());
				attendanceResponceDto.setDay(attendanceEntity.getDay().toString());
				attendanceEntity.setStartTime(attendanceEntity.getStartTime());
				attendanceEntity.setEndTime(attendanceEntity.getEndTime());
				attendanceResponceDtos.add(attendanceResponceDto);
			}
		}
		return attendanceResponceDtos;
	}
	
	//Post Method for Leaves

	@Override
	public LeavesResponseDto employeeLeaves(LeavesRequestDto leavesRequestDto) {
	Employee employeeEntity= employeeRepo.findByEmployeeId(leavesRequestDto.getEmployeeId());

	List<EmployeeLeaves> employeeEntityLeaves=new ArrayList<>();
	if (employeeEntity == null) {
	throw new RuntimeException();
	}

	else {
	     
	for(int i=1; i <= leavesRequestDto.getNumberOfLeaves();i++) {
	EmployeeLeaves employeeEntityLeave= new EmployeeLeaves();
	
	employeeEntityLeave.setEmployeeId(leavesRequestDto.getEmployeeId());
	employeeEntityLeave.setTypeOfLeave(TYPEOFLEAVE.valueOf(leavesRequestDto.getTypeOfLeave()));
	employeeEntityLeave.setNumberOfLeaves(leavesRequestDto.getNumberOfLeaves());
	employeeEntityLeaves.add(employeeEntityLeave);

	}

	employeeLeavesRepo.saveAll(employeeEntityLeaves);

	}
	LeavesResponseDto leavesResponseDto =new LeavesResponseDto();
	leavesRequestDto.setId(employeeEntity.getId());
	return leavesResponseDto;
	}
	
	//GetByID for leaves

	@Override
	public List<LeavesResponseDto> getEmployeeLeaves(int id) {
		Employee employeeEntity=	employeeRepo.findById(id).orElseThrow(()->new RuntimeException());
		
		List<LeavesResponseDto> leavesResposeDtos=new ArrayList<>();
		List<EmployeeLeaves> employeeleaves=employeeEntity.getEmployeeLeaves();
		if(employeeleaves.isEmpty()) {
			throw new RuntimeException();
		}
		else {
			for(EmployeeLeaves leavesEntity:employeeleaves) {
				LeavesResponseDto leavesResponseDto=new LeavesResponseDto();	
				leavesResponseDto.setEmployeeId(leavesEntity.getEmployeeId());
				leavesResponseDto.setTypeOfLeave(leavesEntity.getTypeOfLeave().toString());
				leavesResponseDto.setNumberOfLeaves(leavesEntity.getNumberOfLeaves());
				leavesResposeDtos.add(leavesResponseDto);
			}
		}
		
		return leavesResposeDtos;
	}

    //TimeStamp for Employee
	
	
	@Override
	public TimeSheetResponseDto employeeTimeSheet(TimeSheetRequestDto timeSheetRequestDto) {

		Employee employeeEntity=	employeeRepo.findByEmployeeId(timeSheetRequestDto.getEmployeeId());
	       EmployeeTimeSheet employeeTimeSheet=new EmployeeTimeSheet();
           employeeTimeSheet.setProjectId(timeSheetRequestDto.getProjectId());
           employeeTimeSheet.setProjectName(timeSheetRequestDto.getProjectName());
           employeeTimeSheet.setTotalhours(timeSheetRequestDto.getTotalhours());
           employeeTimeSheet.setEmployeeId(employeeEntity.getEmployeeId());
           employeeTimeSheet.setDay(timeSheetRequestDto.getDay());
           timeSheetRepo.save(employeeTimeSheet);
			
		
        TimeSheetResponseDto timeStampResponceDto=new TimeSheetResponseDto();
        timeStampResponceDto.setId(employeeTimeSheet.getId());
			return timeStampResponceDto;
		
	}
	
	
	//Get For Employees

	@Override
	public List<EmployeeResponseDto> getAllEmployees() {
		List<EmployeeResponseDto> employeeResponseDtos=new ArrayList<>();
		Iterable<Employee> employeeIt = employeeRepo.findAll();
		if(!((List<Employee>) employeeIt).isEmpty()) {
			for(Employee emp:employeeIt) {
				EmployeeResponseDto employeeResponseDto=new EmployeeResponseDto();
				employeeResponseDto = new EmployeeResponseDto();
				employeeResponseDto.setFirstName(emp.getFirstName());
				employeeResponseDto.setLastName(emp.getLastName());
				employeeResponseDto.setEmail(emp.getEmail());
				employeeResponseDto.setAddress(emp.getAddress());
				employeeResponseDto.setMobileNumber(emp.getMobileNumber());
				employeeResponseDto.setEmergencyNumber(emp.getEmergencyNumber());
				employeeResponseDto.setDesignation(emp.getDesignation());
				employeeResponseDto.setGender(emp.getGender());
				employeeResponseDto.setEmployeeId(emp.getEmployeeId());
				employeeResponseDto.setId(emp.getId());
				employeeResponseDto.setJoiningDate(emp.getJoiningDate());
				employeeResponseDto.setType(emp.getType().toString());
				employeeResponseDto.setEmployeeStatus(emp.getEmployeeStatus().toString());
				employeeResponseDto.setExperience(emp.getExperience());
				employeeResponseDtos.add(employeeResponseDto);

}
       }
		return employeeResponseDtos;
}
	
	
	//GetById for TimeSheet

	@Override
	public List<TimeSheetResponseDto> getEmployeeTimeSheet(int id) {
		Employee employeeEntity=employeeRepo.findById(id).orElseThrow(()->new RuntimeException());
		List<TimeSheetResponseDto> timeSheetResponceDtos=new ArrayList<>();
		List<EmployeeTimeSheet> empTimeSheet=employeeEntity.getEmpTimeSheet();
		if(empTimeSheet.isEmpty()) {
			throw new RuntimeException();
		}
		else {
			for(EmployeeTimeSheet TimeSheet:empTimeSheet) {
				TimeSheetResponseDto timeSheetResponseDto = new TimeSheetResponseDto();
				timeSheetResponseDto.setProjectId(TimeSheet.getProjectId());
		     	timeSheetResponseDto.setProjectName(TimeSheet.getProjectName());
		        timeSheetResponseDto.setTotalhours(TimeSheet.getTotalhours());
		        timeSheetResponseDto.setEmployeeId(TimeSheet.getEmployeeId());
		        timeSheetResponseDto.setDay(TimeSheet.getDay());
				timeSheetResponceDtos.add(timeSheetResponseDto);
		
		}
			return timeSheetResponceDtos;
		}
	}

        //GetAll for Leaves


	@Override
	public List<LeavesResponseDto> getAllEmployeesLeaves() {
		List<LeavesResponseDto> leavesResponseDtos=new ArrayList<>();
		Iterable<EmployeeLeaves> leavesIterable = employeeLeavesRepo.findAll();
		if(!((List<EmployeeLeaves>) leavesIterable).isEmpty()) {
			for(EmployeeLeaves leaves:leavesIterable) {
				LeavesResponseDto leavesResponseDto=new LeavesResponseDto();
				leavesResponseDto.setId(leaves.getId());
				leavesResponseDto.setEmployeeId(leaves.getEmployeeId());
				leavesResponseDto.setNumberOfLeaves(leaves.getNumberOfLeaves());
				leavesResponseDto.setTypeOfLeave(leaves.getTypeOfLeave().toString());
				leavesResponseDtos.add(leavesResponseDto);
			}
			}
		return leavesResponseDtos;
	}
	
	

 // Post Method for Project
	
	@Override

	
	
	public ProjectDetailsResponseDto projectDetails(ProjectDetailsRequestDto projectDetailsRequestDto) {
		
		List<String> EmployeeId=new ArrayList<>();
		
		    ProjectDetails projectDetails = new ProjectDetails();
		    
		    for(int i=1; i<=4; i++) {
			projectDetails.setId(projectDetailsRequestDto.getId());
			projectDetails.setClientName(projectDetailsRequestDto.getClientName());
			projectDetails.setProjectName(projectDetailsRequestDto.getProjectName());
			projectDetails.setStatementOfWork(projectDetailsRequestDto.getStatementOfWork());
			projectDetails.setProjectStatus(projectDetailsRequestDto.getProjectStatus());
			projectDetails.setProjectStartingDate(projectDetailsRequestDto.getProjectStartingDate());
			projectDetails.setProjectEndingDate(projectDetailsRequestDto.getProjectEndingDate());
			projectDetails.setClientStatus(CLIENTSTATUS.valueOf(projectDetailsRequestDto.getClientStatus()));
			projectDetails.setBillingType(projectDetailsRequestDto.getBillingType());
			projectDetails.setComments(projectDetailsRequestDto.getComments());
			
			for(int i=1; i< EmployeeId.size();i++) {
		   
			projectDetails.setEmployeeId(EmployeeId.get(i));
		    }
		    }
		    
		ProjectDetailsResponseDto projectDetailsResponseDto = new ProjectDetailsResponseDto();
		projectDetailsRepo.save(projectDetails);
		projectDetailsResponseDto.setId(projectDetails.getId());

		
		return projectDetailsResponseDto;
	}

		
	
	//GetById for Project
	
	@Override
	public ProjectDetailsResponseDto getProjectDetails(int id) {


	Optional<ProjectDetails> optional = projectDetailsRepo.findById(id);

	ProjectDetailsResponseDto pdResponseDto = null;
	if (optional.isPresent()) {
	ProjectDetails projectDetails = optional.get();
	pdResponseDto = new ProjectDetailsResponseDto();
	pdResponseDto.setId(projectDetails.getId());
	pdResponseDto.setClientName(projectDetails.getClientName());
	pdResponseDto.setProjectName(projectDetails.getProjectName());
	pdResponseDto.setStatementOfWork(projectDetails.getStatementOfWork());
	pdResponseDto.setProjectStatus(projectDetails.getProjectStatus());
	pdResponseDto.setProjectStartingDate(projectDetails.getProjectName());
	pdResponseDto.setProjectEndingDate(projectDetails.getProjectEndingDate());
	pdResponseDto.setClientStatus(projectDetails.getProjectStatus().toString());
	pdResponseDto.setBillingType(projectDetails.getBillingType());
	pdResponseDto.setComments(projectDetails.getComments());
	pdResponseDto.setEmployeeId(projectDetails.getEmployeeId());

	} else {
	throw new RuntimeException();
	}
	return pdResponseDto;
	}

	//GetAll for Project
	
	@Override
	public List<ProjectDetailsResponseDto> getAllprojectDetails() {
		List<ProjectDetailsResponseDto> projectDetailsResponseDtos=new ArrayList<>();
		Iterable<ProjectDetails> projectIterable = projectDetailsRepo.findAll();
		if(!((List<ProjectDetails>) projectIterable).isEmpty()) {
			for(ProjectDetails project:projectIterable) {
				ProjectDetailsResponseDto projectDetailsResponseDto=new ProjectDetailsResponseDto();
				projectDetailsResponseDto.setBillingType(project.getBillingType());
				projectDetailsResponseDto.setClientName(project.getClientName());
				projectDetailsResponseDto.setClientStatus(project.getClientStatus().toString());
				projectDetailsResponseDto.setComments(project.getComments());
				projectDetailsResponseDto.setProjectEndingDate(project.getProjectEndingDate());
				projectDetailsResponseDto.setProjectName(project.getProjectName());
				projectDetailsResponseDto.setProjectStartingDate(project.getProjectStartingDate());
				projectDetailsResponseDto.setEmployeeId(project.getEmployeeId());
				projectDetailsResponseDto.setProjectStatus(project.getProjectStatus());
				projectDetailsResponseDto.setStatementOfWork(project.getStatementOfWork());
				projectDetailsResponseDto.setId(project.getId());
				projectDetailsResponseDtos.add(projectDetailsResponseDto);
			}
		}
		return projectDetailsResponseDtos;
	}
	
	//UpdateById for Project
	
	@Override
	public ProjectDetails updateproject(ProjectDetails projectDetails) {
		ProjectDetails project1 = projectDetailsRepo.findByEmployeeId(projectDetails.getEmployeeId());
		
		if (project1 == null) {

			throw new RuntimeException();
		} else {
			
			if(projectDetails.getBillingType()!=null) {
				project1.setBillingType(projectDetails.getBillingType());
		}
			if(projectDetails.getClientName()!=null) {
				project1.setClientName(projectDetails.getClientName());
			}
			if(projectDetails.getClientStatus()!=null) {
				project1.setClientStatus(projectDetails.getClientStatus());
			}
			if(projectDetails.getComments()!=null) {
				project1.setComments(projectDetails.getComments());
			}
			if(projectDetails.getProjectEndingDate()!=null) {
				project1.setProjectEndingDate(projectDetails.getProjectStartingDate());
			}
			if(projectDetails.getProjectName()!=null) {
				project1.setProjectName(projectDetails.getProjectName());
			}
			if(projectDetails.getProjectStartingDate()!=null) {
				project1.setProjectStartingDate(projectDetails.getProjectStartingDate());
			}
			if(projectDetails.getProjectStatus()!=null) {
				project1.setProjectStatus(projectDetails.getProjectStatus());				
			}
			if(projectDetails.getStatementOfWork()!=null) {
				project1.setStatementOfWork(projectDetails.getStatementOfWork());
			}
			projectDetailsRepo.save(projectDetails);
		}
		
		ProjectDetails project2= new ProjectDetails();
			project1.setEmployeeId(projectDetails.getEmployeeId());
			project1.setEmployeeId(projectDetails.getEmployeeId());

		return project2;
	}



}
	
	




