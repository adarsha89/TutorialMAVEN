package com.jaxb.test;

import javax.xml.bind.JAXBException;

import com.jaxb.classes.JaxbClient;
import com.jaxb.retrieveEmployee.RetrieveEmployee;

public class RetrieveEmployeeMarshalTest {

	public static void main(String[] args) throws JAXBException {
		// TODO Auto-generated method stub
		RetrieveEmployee retrieveEmployee=new RetrieveEmployee();
		retrieveEmployee.setEmpID("E_123");
		JaxbClient.MarshalRetrieveEmployee("D:/EclipseWorkspace/Tutorial/RetrieveEmployee.xml",retrieveEmployee);
	}

}
