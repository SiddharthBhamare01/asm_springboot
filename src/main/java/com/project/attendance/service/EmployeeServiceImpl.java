package com.project.attendance.service;

import java.util.List;
import java.util.Optional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
//import com.ibm.springboot.demo.exception.EmployeeNotFoundException;
//import com.ibm.springboot.demo.model.Employee;
//import com.ibm.springboot.demo.repository.EmployeeRepository;
import com.project.attendance.exception.EmployeeNotFoundException;
import com.project.attendance.repository.EmployeeRepository;
import com.project.attendance.model.Employee;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	private final Logger LOG = LoggerFactory.getLogger(this.getClass());

	@Autowired
	EmployeeRepository employeeRepository;

	@Override
	public List<Employee> getAllEmployees() {
		LOG.info("getAllEmployees");
		List<Employee> empList=employeeRepository.findAll();
		if (empList.isEmpty()) {
			String errorMessage = "The EmployList is empty";
			LOG.warn(errorMessage);
			throw new EmployeeNotFoundException(errorMessage);
		}
		else {
			return empList;
		}
		
	}

	@Override
	public Employee getEmployeeById(String employeeId) {
		Optional<Employee> empOptional = employeeRepository.findById(employeeId);
		if (empOptional.isEmpty()) {
			String errorMessage = "Employee with the id " + employeeId + " is not found!";
			LOG.warn(errorMessage);
			throw new EmployeeNotFoundException(errorMessage);
		} else
			return empOptional.get();
	}

	@Override
	public List<Employee> getEmployeeByFirstName(String employeeName) {
		LOG.info(employeeName);
		List<Employee> empList = employeeRepository.findByEmployeeName(employeeName);
		if (empList.isEmpty()) {
			String errorMessage = "Employee with empName " + employeeName + " is not found!";
			LOG.warn(errorMessage);
			throw new EmployeeNotFoundException(errorMessage);
		}
		return empList;
	}

	@Override
	public Employee addEmployee (Employee employee) {
		// any better code is needed? 
		LOG.info(employee.toString());
		
		return employeeRepository.save(employee);
	}

	@Override
	public Employee updateEmployee(Employee employee) {
		LOG.info(employee.toString());
		this.getEmployeeById(employee.getEmployeeId());
		// better code is needed? 
		return employeeRepository.save(employee);
	}

	@Override
	public Employee deleteEmployee(String employeeId) {
		LOG.info(employeeId);
		Employee employeeToBeDeleted = this.getEmployeeById(employeeId);
		employeeRepository.deleteById(employeeId);
		return employeeToBeDeleted;
	}

	@Override 
	public List<Employee> getEmployeesByManagerId(String employeeManagerId) {
		
		List<Employee> employeeList = employeeRepository.findByEmployeeManagerId(employeeManagerId);
		if (employeeList.isEmpty()) {
			String errorMessage = "Employee with employeeName " + employeeManagerId + " is not found!";
			LOG.warn(errorMessage);
			throw new EmployeeNotFoundException(errorMessage);
		}
		return employeeList;

	}
	
	@Override
	public List<Employee> getEmployeesByTeamId(String employeeTeamId) {
		
		List<Employee> employeeList = employeeRepository.findByEmployeeTeamId(employeeTeamId);
		if (employeeList.isEmpty()) {
			String errorMessage = "Employee with employeeName " + employeeTeamId + " is not found!";
			LOG.warn(errorMessage);
			throw new EmployeeNotFoundException(errorMessage);
		}
		return employeeList;

	}
	
	@Override
	public List<Employee> getEmployeesByTeamName(String employeeTeamName) {
		LOG.info(employeeTeamName);
		List<Employee> empList = employeeRepository.findByEmployeeTeamName(employeeTeamName);
		if (empList.isEmpty()) {
			String errorMessage = "Employee with empTeamName " + employeeTeamName + " is not found!";
			LOG.warn(errorMessage);
			throw new EmployeeNotFoundException(errorMessage);
		}
		return empList;
	}
}

//package com.ibm.springboot.demo.service;
//
//import java.util.List;
//
//import org.bson.types.ObjectId;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//import com.ibm.springboot.demo.model.Employee;
//import com.ibm.springboot.demo.repository.EmployeeRepository;
//
//@Service
//public class EmployeeServiceImpl implements EmployeeService {
//
//	private final Logger LOG = LoggerFactory.getLogger(this.getClass());
//
//	@Autowired
//	EmployeeRepository employeeRepository;
//
//	@Override
//	public List<Employee> getAllEmployees() {
//		LOG.info("getAllEmployees");
//		return employeeRepository.findAll();
//	}
//
//	@Override
//	public Employee getEmployeeById(String objectId) {
//		// what of the eid does not exist 
//		LOG.info(objectId.toString());
//		return employeeRepository.findById(objectId).get();
//	}
//
//	@Override
//	public List<Employee> getEmployeeByFirstName(String firstName) {
//		LOG.info(firstName);
//		return employeeRepository.findByFirstName(firstName);
//	}
//
//	@Override
//	public Employee addEmployee(Employee employee) {
//		LOG.info(employee.toString());
//		return employeeRepository.save(employee);
//	}
//
//	@Override
//	public Employee updateEmployee(Employee employee) {
//		LOG.info(employee.toString());
//		return employeeRepository.save(employee);
//	}
//
//	@Override
//	public Employee deleteEmployee(String employeeId) {
//		LOG.info(employeeId.toString());
//		employeeRepository.deleteById(employeeId);
//		return null;
//	}
//
//}

//package com.ibm.springboot.demo.service;
//
//import java.util.ArrayList;
//import java.util.Arrays;
//import java.util.List;
//
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.stereotype.Service;
//
//import com.ibm.springboot.demo.model.Employee;
//
//@Service
//public class EmployeeServiceImpl implements EmployeeService {
//
//	private final Logger LOG = LoggerFactory.getLogger(this.getClass());
//
//	private List<Employee> empList = new ArrayList<>(
//			Arrays.asList(new Employee(101, "Sonu", (double) 90000), new Employee(102, "Monu", (double) 99000),
//					new Employee(103, "Tonu", (double) 2000), new Employee(104, "Gonu", (double) 89000)));
//
//	@Override
//	public Employee getEmployeeById(Integer employeeId) {
//		LOG.info(employeeId.toString());
////		LOG.warn(employeeId.toString());
////		LOG.error(employeeId.toString());
//		return empList.stream().filter(emp -> emp.getEmployeeId().equals(employeeId)).findFirst().orElse(null);
//	}
//
//	@Override
//	public List<Employee> getAllEmployees() {
//		LOG.info("getAllEmployees");
//		return empList;
//	}
//
//	@Override
//	public Employee addEmployee(Employee employee) {
//		LOG.info(employee.toString());
//		empList.add(employee);
//		return employee;
//	}
//
//	@Override
//	public Employee updateEmployee(Employee employee) {
//		LOG.info(employee.toString());
//		return empList.set(empList.indexOf(getEmployeeById(employee.getEmployeeId())), employee);
//	}
//
//	@Override
//	public Employee deleteEmployee(Integer employeeId) {
//		LOG.info(employeeId.toString());
//		Employee empToDelete = getEmployeeById(employeeId);
//		empList.remove(empToDelete);
//		return empToDelete;
//	}
//
//}