package com.jaxb.test;

import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.List;
import java.sql.Date;

import javax.xml.bind.JAXBException;
import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;

import com.jaxb.classes.JaxbClient;
import com.jaxb.retrieveEmployee.RetrieveEmployee;
import com.jaxb.retrievedEmployee.RetrievedEmployee;
import com.jaxb.retrievedEmployeesList.RetrievedEmployeesList;

public class RetrievedEmployeesMarshalTest {

	public static void main(String[] args) throws JAXBException, DatatypeConfigurationException {
		// TODO Auto-generated method stub
		RetrievedEmployee retrievedEmployee=new RetrievedEmployee();
		RetrievedEmployeesList retrievedEmployeesList=new RetrievedEmployeesList();
		retrievedEmployee.setEmpID("M_12");
		retrievedEmployee.setFirstName("Manga");
		retrievedEmployee.setLastName("Da");
		retrievedEmployee.setUsername("sd2");
		retrievedEmployee.setPassword("pa");
		retrievedEmployee.setDesignation("ASSOCIATE");
		
		GregorianCalendar c = new GregorianCalendar();
		c.setTime(new Date(50000L));
		XMLGregorianCalendar date2 = DatatypeFactory.newInstance().newXMLGregorianCalendar(c);
		
		
		
		retrievedEmployee.setJoiningDate(date2);
		retrievedEmployee.setCompanyEmailID("ada@wq.com");
		
		List<RetrievedEmployee> listOfRetrieveEmployee=new ArrayList<RetrievedEmployee>();
		listOfRetrieveEmployee.add(retrievedEmployee);
		retrievedEmployee.setEmpID("M_13");
		retrievedEmployee.setFirstName("Manga");
		retrievedEmployee.setLastName("Daw");
		retrievedEmployee.setUsername("sed2");
		retrievedEmployee.setPassword("pea");
		retrievedEmployee.setDesignation("ASSOCIATE");
		
		c = new GregorianCalendar();
		c.setTime(new Date(50000L));
		date2 = DatatypeFactory.newInstance().newXMLGregorianCalendar(c);
		
		
		
		retrievedEmployee.setJoiningDate(date2);
		retrievedEmployee.setCompanyEmailID("ada@twq.com");
		listOfRetrieveEmployee.add(retrievedEmployee);
		retrievedEmployeesList.setRetrievedEmployees(listOfRetrieveEmployee);
		JaxbClient.MarshalRetrievedEmployeesList("D:/EclipseWorkspace/Tutorial/RetrievedEmployeesList.xml",retrievedEmployeesList);
	
	}

}
