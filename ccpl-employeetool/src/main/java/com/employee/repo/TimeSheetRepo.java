package com.employee.repo;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.employee.entity.EmployeeTimeSheet;

@Repository
public interface TimeSheetRepo extends PagingAndSortingRepository<EmployeeTimeSheet, Integer>{
	
	public EmployeeTimeSheet findByEmployeeId(int employeeId);

}
