package com.employee.repo;

	import org.springframework.data.repository.PagingAndSortingRepository;

import com.employee.dto.ProjectDetailsRequestDto;
import com.employee.entity.ProjectDetails;

	public interface ProjectDetailsRepo extends PagingAndSortingRepository<ProjectDetails,Integer> {

	public ProjectDetails findByEmployeeId(String employeeId);

	public ProjectDetails findByEmployeeId(int employeeId);

	public void save(ProjectDetailsRequestDto projectDetailsRequestDto);


	}

