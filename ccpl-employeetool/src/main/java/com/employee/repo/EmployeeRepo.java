package com.employee.repo;





import java.util.List;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.employee.entity.Employee;
import com.employee.entity.ProjectDetails;

@Repository
public interface EmployeeRepo extends PagingAndSortingRepository<Employee, Integer>{

public	Employee findByEmployeeId(String employeeId);

public List<Employee> findByemployeeStatus(String employeeStatus);

public ProjectDetails findByEmployeeId(int employeeId);



}
