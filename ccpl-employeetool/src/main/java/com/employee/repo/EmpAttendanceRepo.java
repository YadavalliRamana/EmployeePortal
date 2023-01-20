package com.employee.repo;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.employee.entity.EmployeeAttendance;

@Repository
public interface EmpAttendanceRepo extends PagingAndSortingRepository<EmployeeAttendance, Integer> {

	public EmployeeAttendance findByEmployeeId(String employeeId);

}



