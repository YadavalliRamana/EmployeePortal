package com.employee.repo;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.employee.entity.EmployeeLeaves;

@Repository

public interface EmployeeLeavesRepo extends PagingAndSortingRepository<EmployeeLeaves, Integer> {

	
	public EmployeeLeaves findByEmployeeId(int employeeId);


}
