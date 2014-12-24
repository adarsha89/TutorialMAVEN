package com.Home.controllers;

import java.io.IOException;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.Nullable;
import javax.annotation.security.PermitAll;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.Home.Employee;
import com.Home.DA.DAInterface;
import com.Home.DA.JDBCDAOImpl;
import com.json.serviceClasses.CreateEmployee;
import com.json.serviceClasses.DeleteEmployee;
import com.json.serviceClasses.ListOfRetrievedEmployees;
import com.json.serviceClasses.RetrieveEmployee;
import com.json.serviceClasses.RetrievedEmployee;
import com.json.serviceClasses.UpdateEmployee;

@Controller
public class JSONRESTServices {

	@RequestMapping(value="/getEmployees", method = RequestMethod.POST)
	public @ResponseBody ListOfRetrievedEmployees getEmployees( @RequestBody RetrieveEmployee retrieveEmployee)
	{
		System.out.println("Hi");
		System.out.println("HI"+ "In the webservice");
		
		RetrievedEmployee retrievedEmployee;
		ListOfRetrievedEmployees listofRetrievedEmployees1=new ListOfRetrievedEmployees();
		List<RetrievedEmployee> listofRetrievedEmployees=new ArrayList<RetrievedEmployee>();
 		//JaxbClient.MarshalRetrieveEmployee("D:/RetrieveEmployee.xml", retrieveEmployee);
 		@Nullable
		Date joiningDate=null;
		@Nullable
 		String empID=null;
		@Nullable
 		String username=null;
		@Nullable
 		String password=null;
		@Nullable
 		String designation=null;
		@Nullable
 		String companyEmailID=null;
		@Nullable
 		String managerID=null;
		@Nullable
 		String firstName=null;
		@Nullable
 		String lastName=null;
		empID=retrieveEmployee.getEmpID();
 		 username=retrieveEmployee.getUsername();
		 password=retrieveEmployee.getPassword();
		 designation=retrieveEmployee.getDesignation();
		 companyEmailID=retrieveEmployee.getCompanyEmailID();
		 managerID=retrieveEmployee.getManagerID();
		 firstName=retrieveEmployee.getFirstName();
		 lastName=retrieveEmployee.getLastName();			 	
 		ApplicationContext applicationContext = new ClassPathXmlApplicationContext("Database.xml");
		DAInterface daInterface = new JDBCDAOImpl();
		@Nullable
		List<Employee> listOfEmployees;   		 
   		listOfEmployees=daInterface.retrieveEmployee(empID, username, password, designation, joiningDate, companyEmailID, managerID, firstName, lastName);
	 	for(Employee empl:listOfEmployees)
   	 	{
   	 	System.out.println(empl.getEmpID()+empl.getOfficialDetails().getUsername());
   	 	}   	 
	    if(listOfEmployees!=null)
	    {	int index=0;
	    	for(Employee employee:listOfEmployees)
	    	{	System.out.println(employee.getEmpID()+employee.getOfficialDetails().getUsername());
	    		retrievedEmployee=new RetrievedEmployee();
	    		retrievedEmployee.setEmpID(employee.getEmpID());
	    		retrievedEmployee.setUsername(employee.getOfficialDetails().getUsername());
	    		retrievedEmployee.setPassword(employee.getOfficialDetails().getPassword());
	    		retrievedEmployee.setDesignation(employee.getOfficialDetails().getDesignation().getDesignationValue());
	    		retrievedEmployee.setJoiningDate(employee.getOfficialDetails().getJoiningDate().toString());
	    		retrievedEmployee.setCompanyEmailID(employee.getOfficialDetails().getCompanyEmailID());
	    		retrievedEmployee.setManagerID(employee.getOfficialDetails().getManagerID());
	    		retrievedEmployee.setFirstName(employee.getPersonalDetails().getFirstName());
	    		retrievedEmployee.setLastName(employee.getPersonalDetails().getLastName());
	    		//JaxbClient.MarshalRetrievedEmployee("D:/RetrievedEmployee.xml", retrievedEmployee);
	    		listofRetrievedEmployees.add(index++,retrievedEmployee);
	    	}
	    	
		}
	    listofRetrievedEmployees1.setListOfRetrievedEmployees(listofRetrievedEmployees);
	    return listofRetrievedEmployees1;
	
	}
	
	@RequestMapping(value="/createEmployee", method = RequestMethod.POST)
	public @ResponseBody String createEmployee(@RequestBody CreateEmployee createEmployee)
	{
		//JaxbClient.MarshalCreateEmployee("D:/CreateEmployee.xml", createEmployee);
		System.out.println("Hi");
		String empID=createEmployee.getEmpID();
		String username=createEmployee.getUsername();
		String password=createEmployee.getPassword();
		System.out.println(password);
		String designation=createEmployee.getDesignation();
		
		String joiningDate=createEmployee.getJoiningDate();
		
		String companyEmailID=createEmployee.getCompanyEmailID();
		String managerID=createEmployee.getManagerID();
		String firstName=createEmployee.getFirstName();
		String lastName=createEmployee.getLastName();
		SimpleDateFormat simpleDateFormat= new SimpleDateFormat("yyyy-MM-dd");
		Employee employee=new Employee( empID,  username,  password,  designation,  Date.valueOf(simpleDateFormat.format(Date.valueOf(joiningDate))),  companyEmailID,  managerID,  firstName,  lastName );
		System.out.println(empID+username+password+designation+joiningDate+companyEmailID+managerID+firstName+lastName);
		
		/*EmployeeBusinessInterface employeeBusinessInterface = (EmployeeBusinessInterface) applicationContext.getBean("EmployeeBusinessServicesImpl");
		employeeBusinessInterface.createEmployee(employee);*/
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext("Database.xml");
		DAInterface daInterface = new JDBCDAOImpl();
		String addEmployeeSuccessState="Employee not added successfully";
		System.out.println("HI I am in WebService");
		try
	    {
			if(daInterface.createEmployee(employee)==true)
				{
				addEmployeeSuccessState="Employee added successfully";
				};
	    }catch(Exception e)
	    {
	    	e.printStackTrace();
	    	 addEmployeeSuccessState="Employee not added successfully ";
	    }
 		return  addEmployeeSuccessState;
	}
	@RequestMapping(value="/updateEmployee", method = RequestMethod.POST)
	public @ResponseBody String updateEmployee(@RequestBody UpdateEmployee updateEmployee) 
	{
		int numberOfRowsUpdated=0;
		//JaxbClient.MarshalUpdateEmployee("D:/UpdateEmployee.xml", updateEmployee);
				System.out.println("Hi");
				String empID=updateEmployee.getEmpID();
				String password=updateEmployee.getPassword();
				String designation=updateEmployee.getDesignation();
				String managerID=updateEmployee.getManagerID();
				ApplicationContext applicationContext = new ClassPathXmlApplicationContext("Database.xml");
				DAInterface daInterface = new JDBCDAOImpl();
				   	String updateEmployeeSuccessState=null;
				   
				    	 try
				 	    {
				    		 
				    		 numberOfRowsUpdated=daInterface.updateEmployee( empID,  password, designation,  managerID);
				 	    }
				 	    
				 	    	
				
				    	 catch(Exception e)
				 	    {
				 	    	
				 	    	e.printStackTrace();
				 	    	
				 	    	updateEmployeeSuccessState="Employees not updated successfully ";
				 	    }

				 	    if(updateEmployeeSuccessState!=null)
				 	    {
				 	    	updateEmployeeSuccessState=numberOfRowsUpdated + " employees successfully added";
				 		    
				 	    }
				 	    	
		 		return updateEmployeeSuccessState;
	}
	
	@RequestMapping(value="/deleteEmployee", method = RequestMethod.POST)
	public @ResponseBody String deleteEmployee(@RequestBody DeleteEmployee deleteEmployee) 
	{
		String deleteEmployeeSuccessState;
		int numberOfRowsDeleted=0;
		//JaxbClient.MarshalDeleteEmployee("D:/DeleteEmployee.xml", deleteEmployee);
		System.out.println("Hi");
		String empID=deleteEmployee.getEmpID();
		String username=deleteEmployee.getUsername();
		String designation=deleteEmployee.getDesignation();
		String joiningDate=null;
		if(!(deleteEmployee.getJoiningDate()==null))
		{
			 joiningDate=deleteEmployee.getJoiningDate();
		}
		
		String companyEmailID=deleteEmployee.getCompanyEmailID();
		String managerID=deleteEmployee.getManagerID();
		String firstName=deleteEmployee.getFirstName();
		String lastName=deleteEmployee.getLastName();
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext("Database.xml");
		DAInterface daInterface = new JDBCDAOImpl();
		SimpleDateFormat simpleDateFormat= new SimpleDateFormat("yyyy-MM-dd");
		try
		{
			numberOfRowsDeleted=daInterface.deleteEmployee(empID, username, designation, Date.valueOf(simpleDateFormat.format(Date.valueOf(joiningDate))), companyEmailID, managerID, firstName, lastName);;
			deleteEmployeeSuccessState=numberOfRowsDeleted+ "employees deleted";
		}catch(Exception e)
		{
			e.printStackTrace();
			deleteEmployeeSuccessState="employees not deleted";
		}	    	 
		return deleteEmployeeSuccessState;
	}
		
	@RequestMapping(value="/print", method = RequestMethod.GET)
public @ResponseBody Employee Welcome(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
{
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext("Database.xml");
		DAInterface daInterface = new JDBCDAOImpl();
		System.out.println(applicationContext.getBeanDefinitionNames());
		System.out.println("Hi User");
		Employee employee=Employee.getInstance();
		return employee;
}
}

