package com.Home.DA;

import java.util.Date;
import java.util.List;

import com.Home.Employee;

public interface DAInterface {

	public boolean createEmployee(Employee employee) throws Exception;
	public int updateEmployee(String employeeID,String password,String designation,String managerID) throws Exception;
	public int deleteEmployee(String empID,String username, String designation, Date joiningDate, String companyEmailID, String managerID,String firstName, String lastName);
	public List<Employee> retrieveEmployee(String empID,String username, String password, String designation, Date joiningDate, String companyEmailID, String managerID,String firstName, String lastName); 		

}
