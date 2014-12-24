/*package com.Employee.services;









import java.sql.Date;
import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.List;

import javax.annotation.security.PermitAll;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.xml.bind.JAXBException;
import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;


import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.Home.Employee;
import com.Home.DA.DAInterface;
import com.jaxb.createEmployee.CreateEmployee;
import com.jaxb.deleteEmployee.DeleteEmployee;
import com.jaxb.retrieveEmployee.RetrieveEmployee;
import com.jaxb.retrievedEmployee.RetrievedEmployee;
import com.jaxb.retrievedEmployeesList.RetrievedEmployeesList;
import com.jaxb.updateEmployee.UpdateEmployee;
@PermitAll
@Path("EmployeeWebservice")
public class EmployeeWebservice {
	
	@PermitAll
	@PUT
	@Path("CreateEmployee")
	@Produces(MediaType.TEXT_PLAIN)
public String createEmployee(CreateEmployee createEmployee ) throws JAXBException
 {
		//JaxbClient.MarshalCreateEmployee("D:/CreateEmployee.xml", createEmployee);
		System.out.println("Hi");
		String empID=createEmployee.getEmpID();
		String username=createEmployee.getUsername();
		String password=createEmployee.getPassword();
		String designation=createEmployee.getDesignation();
		
		Date joiningDate=Date.valueOf(createEmployee.getJoiningDate().getYear()+"-"+createEmployee.getJoiningDate().getMonth()+"-"+createEmployee.getJoiningDate().getDay());
		
		String companyEmailID=createEmployee.getCompanyEmailID();
		String managerID=createEmployee.getManagerID();
		String firstName=createEmployee.getFirstName();
		String lastName=createEmployee.getLastName();
		Employee employee=new Employee( empID,  username,  password,  designation,  joiningDate,  companyEmailID,  managerID,  firstName,  lastName );
	    
		ApplicationContext applicationContext= new ClassPathXmlApplicationContext("Employee.xml");
		EmployeeBusinessInterface employeeBusinessInterface = (EmployeeBusinessInterface) applicationContext.getBean("EmployeeBusinessServicesImpl");
		employeeBusinessInterface.createEmployee(employee);
		DAInterface daInterface= (DAInterface) applicationContext.getBean("JDBCDAOImpl");
		String addEmployeeSuccessState="Employee  added successfully";
		try
	    {
			daInterface.createEmployee(employee);
	    }catch(Exception e)
	    {
	    	e.printStackTrace();
	    	 addEmployeeSuccessState="Employee not added successfully ";
	    }
 		return  addEmployeeSuccessState;
 }
	@PermitAll
 	@PUT 	
 	@Path("UpdateEmployee")
 	@Produces(MediaType.TEXT_PLAIN)
public String updateEmployee(UpdateEmployee updateEmployee) throws JAXBException
 {
		//JaxbClient.MarshalUpdateEmployee("D:/UpdateEmployee.xml", updateEmployee);
		System.out.println("Hi");
		String empID=updateEmployee.getEmpID();
		String password=updateEmployee.getPassword();
		String designation=updateEmployee.getDesignation();
		String managerID=updateEmployee.getManagerID();
		ApplicationContext applicationContext= new ClassPathXmlApplicationContext("Employee.xml");
		    EmployeeBusinessInterface employeeBusinessInterface = (EmployeeBusinessInterface) applicationContext.getBean("EmployeeBusinessServicesImpl");
			employeeBusinessInterface.updateEmployee(employeeID, password, designation, managerID);
		    DAInterface updateEmployeeInterface = (DAInterface) applicationContext.getBean("JDBCDAOImpl");
		   	String updateEmployeeSuccessState=null;
		   
		    	 try
		 	    {
		    		 
		 	    	updateEmployeeInterface.updateEmployee( empID,  password, designation,  managerID);
		 	    }
		 	    
		 	    	
		
		    	 catch(Exception e)
		 	    {
		 	    	
		 	    	e.printStackTrace();
		 	    	
		 	    	updateEmployeeSuccessState="Employee not added successfully ";
		 	    }

		 	    if(updateEmployeeSuccessState==null)
		 	    {
		 	    	updateEmployeeSuccessState="Employee successfully added";
		 		    
		 	    }
		 	    	
 		return updateEmployeeSuccessState;
 }
	@PermitAll
 	@PUT 	
 	@Path("RetrieveEmployee")
 	@Produces(MediaType.APPLICATION_XML)
public RetrievedEmployeesList retrieveEmployee(RetrieveEmployee retrieveEmployee) throws JAXBException, DatatypeConfigurationException
 {
		RetrievedEmployee retrievedEmployee=null;
		List<RetrievedEmployee> listofRetrievedEmployees=new ArrayList<RetrievedEmployee>();
		RetrievedEmployeesList retrievedEmployeesList=new RetrievedEmployeesList();
 		//JaxbClient.MarshalRetrieveEmployee("D:/RetrieveEmployee.xml", retrieveEmployee);
 		Date joiningDate=null;
 		String empID=null;
 		String username=null;
 		String password=null;
 		String designation=null;
 		String companyEmailID=null;
 		String managerID=null;
 		String firstName=null;
 		String lastName=null;
 		try
 		{
 			 empID=retrieveEmployee.getEmpID();
 		
			 username=retrieveEmployee.getUsername();
			 password=retrieveEmployee.getPassword();
			 designation=retrieveEmployee.getDesignation();
		
			joiningDate=Date.valueOf(retrieveEmployee.getJoiningDate().getYear()+"-"+retrieveEmployee.getJoiningDate().getMonth()+"-"+retrieveEmployee.getJoiningDate().getDay());
			
		
			 companyEmailID=retrieveEmployee.getCompanyEmailID();
			 managerID=retrieveEmployee.getManagerID();
			 firstName=retrieveEmployee.getFirstName();
			 lastName=retrieveEmployee.getLastName();
 		}catch(NullPointerException exception)
 		{
 			
 		}
 		ApplicationContext applicationContext = new ClassPathXmlApplicationContext("Employee.xml");
		EmployeeBusinessInterface employeeBusinessInterface = (EmployeeBusinessInterface) applicationContext.getBean("EmployeeBusinessServicesImpl");
		employeeBusinessInterface.retrieveEmployee(empID, username, password, designation, joiningDate, companyEmailID, managerID, firstName, lastName);
		DAInterface retrieveEmployeeInterface = (DAInterface) applicationContext.getBean("JDBCDAOImpl");
		List<Employee> listOfEmployees=null;
   	 try
	    {
   		 
   		listOfEmployees=retrieveEmployeeInterface.retrieveEmployee(empID, username, password, designation, joiningDate, companyEmailID, managerID, firstName, lastName);
	    }catch(NullPointerException e)
	    {
	    	e.printStackTrace();
	    }
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
	    		
	    		GregorianCalendar c = new GregorianCalendar();
	    		c.setTime(employee.getOfficialDetails().getJoiningDate());
	    		XMLGregorianCalendar date2 = DatatypeFactory.newInstance().newXMLGregorianCalendar(c);
	    		
	    		
	    		
	    		retrievedEmployee.setJoiningDate(date2);
	    		retrievedEmployee.setCompanyEmailID(employee.getOfficialDetails().getCompanyEmailID());
	    		retrievedEmployee.setManagerID(employee.getOfficialDetails().getManagerID());
	    		retrievedEmployee.setFirstName(employee.getPersonalDetails().getFirstName());
	    		retrievedEmployee.setLastName(employee.getPersonalDetails().getLastName());
	    		//JaxbClient.MarshalRetrievedEmployee("D:/RetrievedEmployee.xml", retrievedEmployee);
	    		listofRetrievedEmployees.add(index++,retrievedEmployee);
	    	}
	    	retrievedEmployeesList.setRetrievedEmployees(listofRetrievedEmployees);
		}
	    //JaxbClient.MarshalRetrievedEmployeesList("D:/RetrievedEmployeesList.xml", retrievedEmployeesList);
	    return retrievedEmployeesList;
 }
 @PermitAll
	@PUT 	
	@Path("DeleteEmployee")
	@Produces(MediaType.TEXT_PLAIN)
public String deleteEmployee(DeleteEmployee deleteEmployee) throws JAXBException
{
		//JaxbClient.MarshalDeleteEmployee("D:/DeleteEmployee.xml", deleteEmployee);
		System.out.println("Hi");
		String empID=deleteEmployee.getEmpID();
		String username=deleteEmployee.getUsername();
		String designation=deleteEmployee.getDesignation();
		Date joiningDate=null;
		if(!(deleteEmployee.getJoiningDate()==null))
		{
			 joiningDate=Date.valueOf(deleteEmployee.getJoiningDate().getYear()+"-"+deleteEmployee.getJoiningDate().getMonth()+"-"+deleteEmployee.getJoiningDate().getDay());
		}
		
		String companyEmailID=deleteEmployee.getCompanyEmailID();
		String managerID=deleteEmployee.getManagerID();
		String firstName=deleteEmployee.getFirstName();
		String lastName=deleteEmployee.getLastName();
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext("Employee.xml");
		EmployeeBusinessInterface employeeBusinessInterface = (EmployeeBusinessInterface) applicationContext.getBean("EmployeeBusinessServicesImpl");
		employeeBusinessInterface.deleteEmployee(empID, username, designation, joiningDate, companyEmailID, managerID, firstName, lastName);
		DAInterface deleteEmployeeInterface = (DAInterface) applicationContext.getBean("JDBCDAOImpl");
		
		try
		{
			deleteEmployeeInterface.deleteEmployee(empID, username, designation, joiningDate, companyEmailID, managerID, firstName, lastName);;
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		

	    	String deleteEmployeeSuccessState="Employee deleted";
		return deleteEmployeeSuccessState;
}
 @PermitAll
	@GET	
	@Path("Welcome")
	@Produces(MediaType.TEXT_PLAIN)
public String Welcome() 
{
		return "Hi";
}
}*/