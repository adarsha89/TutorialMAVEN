package com.Home.AdminModule;

import java.sql.Date;
import java.util.List;
import java.util.Map;

import com.Home.Employee;

public interface EmployeeBusinessInterface {

	public void createEmployee(Employee employee);
	public void updateEmployee(String employeeID,String password,String designation,String managerID);
	public void deleteEmployee(String empID,String username, String designation, Date joiningDate, String companyEmailID, String managerID,String firstName, String lastName);
	public List<Employee> retrieveEmployee(String empID,String username, String password, String designation, Date joiningDate, String companyEmailID, String managerID,String firstName, String lastName); 		

}
