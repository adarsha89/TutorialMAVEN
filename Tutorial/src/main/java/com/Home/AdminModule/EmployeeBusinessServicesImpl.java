package com.Home.AdminModule;

import java.sql.Date;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.Home.Employee;
@Service
public class EmployeeBusinessServicesImpl implements EmployeeBusinessInterface {

	
	public void createEmployee(Employee employee) {
		// TODO Auto-generated method stub
		System.out.println("Inside Business layer");
	    
	}

	public void updateEmployee(String employeeID, String password,
			String designation, String managerID) {
		// TODO Auto-generated method stub
		System.out.println("Inside Business layer");

	}

	public void deleteEmployee(String empID, String username,
			String designation, Date joiningDate, String companyEmailID,
			String managerID, String firstName, String lastName) {
		// TODO Auto-generated method stub
		System.out.println("Inside Business layer");

	}

	public List<Employee> retrieveEmployee(String empID,
			String username, String password, String designation,
			Date joiningDate, String companyEmailID, String managerID,
			String firstName, String lastName) {
		// TODO Auto-generated method stub
		System.out.println("Inside Business layer");
		return null;
	}

}
