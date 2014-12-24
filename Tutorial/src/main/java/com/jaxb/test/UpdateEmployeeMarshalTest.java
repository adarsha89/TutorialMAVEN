package com.jaxb.test;

import javax.xml.bind.JAXBException;

import com.jaxb.classes.JaxbClient;
import com.jaxb.updateEmployee.UpdateEmployee;

public class UpdateEmployeeMarshalTest {

	public static void main(String[] args) throws JAXBException {
		// TODO Auto-generated method stub
		UpdateEmployee updateEmployee=new UpdateEmployee();
		updateEmployee.setEmpID("E_123");
		JaxbClient.MarshalUpdateEmployee("D:/EclipseWorkspace/Tutorial/UpdateEmployee.xml",updateEmployee);
	}

}
