package com.jaxb.test;

import javax.xml.bind.JAXBException;

import com.jaxb.classes.JaxbClient;
import com.jaxb.deleteEmployee.DeleteEmployee;
import com.jaxb.retrieveEmployee.RetrieveEmployee;

public class DeleteEmployeeMarshalTest {

	public static void main(String[] args) throws JAXBException {
		// TODO Auto-generated method stub
		DeleteEmployee deleteEmployee=new DeleteEmployee();
		deleteEmployee.setEmpID("E_123");
		JaxbClient.MarshalDeleteEmployee("D:/EclipseWorkspace/Tutorial/DeleteEmployee.xml",deleteEmployee);
	}

}
