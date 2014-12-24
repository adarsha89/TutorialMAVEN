package com.jaxb.test;

import java.sql.Date;

import javax.xml.bind.JAXBException;
import javax.xml.datatype.XMLGregorianCalendar;

import com.jaxb.classes.JaxbClient;
import com.jaxb.createEmployee.CreateEmployee;



public class CreateEmployeeMarshallerTest {

	public static void main(String args[]) throws JAXBException
	{
		CreateEmployee createEmployee=new CreateEmployee();
		createEmployee.setEmpID("E_123");
		createEmployee.setFirstName("Adarsha");
		createEmployee.setLastName("Shetty");
		createEmployee.setCompanyEmailID("ashet1@sapient.com");
		createEmployee.setDesignation("ASSOCIATE");		
		Date joiningDate=Date.valueOf(createEmployee.getJoiningDate().getYear()+"-"+createEmployee.getJoiningDate().getMonth()+"-"+createEmployee.getJoiningDate().getDay());
		createEmployee.setPassword("as23");
		createEmployee.setUsername("adrt2");
		JaxbClient.MarshalCreateEmployee("D:/EclipseWorkspace/Tutorial/CreateEmployee.xml", createEmployee);
	}
}
