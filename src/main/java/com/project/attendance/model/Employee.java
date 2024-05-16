package com.project.attendance.model;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;


@Document("employees")
public class Employee {
		
		@Id
		private String employeeId;
		private String employeeName;
		private Double employeeSalary;
		private String employeeTeamId;
		private String employeeManagerName;
		private String employeeManagerId;
		private String employeeRole;
		private String employeePhone;
		private String employeeTeamName;
		private Boolean employeeIsAdmin;
		
		
		
		public Employee() {
			super();
			// TODO Auto-generated constructor stub
		}
				
		public String getEmployeeId() {
			return employeeId;
		}



		public void setEmployeeId(String employeeId) {
			this.employeeId = employeeId;
		}



		public String getEmployeeName() {
			return employeeName;
		}
		public void setEmployeeName(String employeeName) {
			this.employeeName = employeeName;
		}
		
		public Double getEmployeeSalary() {
			return employeeSalary;
		}
		public void setEmployeeSalary(Double employeeSalary) {
			this.employeeSalary = employeeSalary;
		}
	
		
		public String getEmployeePhone() {
			return employeePhone;
		}

		public void setEmployeePhone(String employeePhone) {
			this.employeePhone = employeePhone;
		}		
		public String getEmployeeTeamId() {
			return employeeTeamId;
		}
		public void setEmployeeTeamId(String employeeTeamId) {
			this.employeeTeamId = employeeTeamId;
		}
		
		public String getEmployeeManagerName() {
			return employeeManagerName;
		}
		public void setEmployeeManagerName(String employeeManagerName) {
			this.employeeManagerName = employeeManagerName;
		}
		
		public String getEmployeeManagerId() {
			return employeeManagerId;
		}
		public void setEmployeeManagerId(String employeeManagerId) {
			this.employeeManagerId = employeeManagerId;
		}
		public String getEmployeeRole() {
			return employeeRole;
		}
		public void setEmployeeRole(String employeeRole) {
			this.employeeRole = employeeRole;
		}
		public String getEmployeeTeamName() {
			return employeeTeamName;
		}
		public void setEmployeeTeamName(String employeeTeamName) {
			this.employeeTeamName = employeeTeamName;
		}
		public Boolean getEmployeeIsAdmin() {
			return employeeIsAdmin;
		}
		public void setEmployeeIsAdmin(Boolean employeeIsAdmin) {
			this.employeeIsAdmin = employeeIsAdmin;
		}

		@Override
		public String toString() {
			return "Admin [employeeName=" + employeeName + ", employeeSalary=" + employeeSalary + ", employeePhone=" + employeePhone
					+ ", employeeTeamId=" + employeeTeamId + ", employeeManagerName=" + employeeManagerName + ", employeeManagerId="
					+ employeeManagerId + ", employeeRole=" + employeeRole + ", employeeTeamName=" + employeeTeamName + ", employeeIsAdmin="
					+ employeeIsAdmin + "]";
		}

		
	

}