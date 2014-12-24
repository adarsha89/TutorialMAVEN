package com.jaxb.test;

import javax.xml.bind.JAXBException;

import com.jaxb.classes.JaxbClient;
import com.jaxb.createEmployee.CreateEmployee;

public class CreateEmployeeUnmarshallerTest {
	public static void main(String args[]) throws JAXBException
	{		
		CreateEmployee createEmployee=JaxbClient.UnMarshalCreateEmployee("D:/EclipseWorkspace/Tutorial/CreateEmployee.xml");
		System.out.println(createEmployee.getEmpID()+createEmployee.getFirstName()+createEmployee.getLastName());
		
		
	}
}
