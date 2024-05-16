package com.project.attendance.repository;

import java.util.List;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.project.attendance.model.Employee;
	


	@Repository
	public interface EmployeeRepository extends MongoRepository<Employee, String> {

	
//		public abstract List<Employee> findByFirstName(String empName);
		public abstract List<Employee> findByEmployeeName(String employeeName);
		public abstract List<Employee> findByEmployeeManagerId(String employeeManagerId);
		public abstract List<Employee> findByEmployeeTeamId(String employeeTeamId);
		public abstract List<Employee> findByEmployeeTeamName(String employeeTeamName);
		
		


}
