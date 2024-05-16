package com.project.attendance.service;



import java.util.List;

import com.project.attendance.model.Employee;

public interface EmployeeService {

	public abstract List<Employee> getAllEmployees();

	public abstract Employee getEmployeeById(String employeeId);

	public abstract List<Employee> getEmployeeByFirstName(String employeeName);

	public abstract Employee addEmployee(Employee employee);

	public abstract Employee updateEmployee(Employee employee);

	public abstract Employee deleteEmployee(String employeeId);
	
	public abstract List<Employee> getEmployeesByManagerId(String employeeManagerId);
	
	public abstract List<Employee> getEmployeesByTeamId(String employeeTeamId);

	public abstract List<Employee> getEmployeesByTeamName(String employeeTeamName);
	
//	public abstract List<Employee> getEmployeesByTeamName(String employeeTeamName);
}