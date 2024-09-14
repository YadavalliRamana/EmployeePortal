package com.employee.service;

import java.util.List;

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


public interface IEmployeeService {
    System
    .out.println("2");
public EmployeeResponseDto onbordEmployee(EmployeeRequestDto employeeRequestDto);
public EmployeeResponseDto verifyUser(EmployeeRequestDto employeeRequestDto);
public EmployeeResponseDto updateEmployee(EmployeeRequestDto employeeRequestDto);


public AttendanceResponceDto attendanceEmployee(AttendanceRequestDto attendenceRequestDto);
public List<AttendanceResponceDto> getEmployeeAttendance(int id);
public LeavesResponseDto employeeLeaves(LeavesRequestDto leavesRequestDto);
public EmployeeResponseDto getEmployee(int id);
public List<LeavesResponseDto> getEmployeeLeaves(int id);
public List<EmployeeResponseDto> getAllEmployees();
public List<TimeSheetResponseDto> getEmployeeTimeSheet(int id);
public TimeSheetResponseDto employeeTimeSheet(TimeSheetRequestDto timesheetRequestDto);
public List<LeavesResponseDto> getAllEmployeesLeaves();
public ProjectDetailsResponseDto getProjectDetails(int id);
public ProjectDetailsResponseDto projectDetails(ProjectDetailsRequestDto projectDetailsRequestDto);
public List<EmployeeResponseDto> getEmployeeStatus(String employeeStatus);
public List<ProjectDetailsResponseDto> getAllprojectDetails();
public ProjectDetails updateproject(ProjectDetails projectDetails);
 







}
