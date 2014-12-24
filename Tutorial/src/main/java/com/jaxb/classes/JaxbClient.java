package com.jaxb.classes;


import java.io.File;
import java.math.BigDecimal;
import java.math.BigInteger;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import javax.xml.bind.Marshaller;
import javax.xml.datatype.Duration;
import javax.xml.datatype.XMLGregorianCalendar;
import javax.xml.namespace.QName;



import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.Locale;
import java.util.TimeZone;

import com.jaxb.createEmployee.*;
import com.jaxb.deleteEmployee.DeleteEmployee;
import com.jaxb.retrieveEmployee.RetrieveEmployee;
import com.jaxb.retrievedEmployee.RetrievedEmployee;
import com.jaxb.retrievedEmployeesList.RetrievedEmployeesList;
import com.jaxb.updateEmployee.*;

public class JaxbClient {
	public static void MarshalCreateEmployee(String pathofxmlfile,CreateEmployee createEmployee) throws JAXBException
	{
		JAXBContext jAXBContext=JAXBContext.newInstance(com.jaxb.createEmployee.ObjectFactory.class);
		Marshaller marshaller= jAXBContext.createMarshaller();		
		marshaller.marshal(createEmployee, new File(pathofxmlfile));
	}
	public static CreateEmployee UnMarshalCreateEmployee(String pathname) throws JAXBException
	{
		JAXBContext jAXBContext=JAXBContext.newInstance(com.jaxb.createEmployee.ObjectFactory.class);
		Unmarshaller unmarshaller= jAXBContext.createUnmarshaller();	
		return (CreateEmployee)unmarshaller.unmarshal(new File(pathname));
	}
	public static void MarshalUpdateEmployee(String pathofxmlfile,UpdateEmployee updateEmployee) throws JAXBException
	{
		JAXBContext jAXBContext=JAXBContext.newInstance(com.jaxb.updateEmployee.ObjectFactory.class);
		Marshaller marshaller= jAXBContext.createMarshaller();		
		marshaller.marshal(updateEmployee, new File(pathofxmlfile));
	}
	public static UpdateEmployee UnMarshalUpdateEmployee(String pathname) throws JAXBException
	{
		JAXBContext jAXBContext=JAXBContext.newInstance(com.jaxb.updateEmployee.ObjectFactory.class);
		Unmarshaller unmarshaller= jAXBContext.createUnmarshaller();	
		return (UpdateEmployee)unmarshaller.unmarshal(new File(pathname));
	}
	public static void MarshalRetrieveEmployee(String pathofxmlfile,RetrieveEmployee retrieveEmployee) throws JAXBException
	{
		JAXBContext jAXBContext=JAXBContext.newInstance(com.jaxb.retrieveEmployee.ObjectFactory.class);
		Marshaller marshaller= jAXBContext.createMarshaller();		
		marshaller.marshal(retrieveEmployee, new File(pathofxmlfile));
	}
	public static RetrieveEmployee UnMarshalRetrieveEmployee(String pathname) throws JAXBException
	{
		JAXBContext jAXBContext=JAXBContext.newInstance(com.jaxb.retrieveEmployee.ObjectFactory.class);
		Unmarshaller unmarshaller= jAXBContext.createUnmarshaller();	
		return (RetrieveEmployee)unmarshaller.unmarshal(new File(pathname));
	}
	public static void MarshalDeleteEmployee(String pathofxmlfile,DeleteEmployee deleteEmployee) throws JAXBException
	{
		JAXBContext jAXBContext=JAXBContext.newInstance(com.jaxb.deleteEmployee.ObjectFactory.class);
		Marshaller marshaller= jAXBContext.createMarshaller();		
		marshaller.marshal(deleteEmployee, new File(pathofxmlfile));
	}
	public static DeleteEmployee UnMarshalDeleteEmployee(String pathname) throws JAXBException
	{
		JAXBContext jAXBContext=JAXBContext.newInstance(com.jaxb.deleteEmployee.ObjectFactory.class);
		Unmarshaller unmarshaller= jAXBContext.createUnmarshaller();	
		return (DeleteEmployee)unmarshaller.unmarshal(new File(pathname));
	}
	public static RetrievedEmployeesList UnMarshalRetrievedEmployeesList(String pathname) throws JAXBException
	{
		JAXBContext jAXBContext=JAXBContext.newInstance(RetrievedEmployeesList.class);
		Unmarshaller unmarshaller= jAXBContext.createUnmarshaller();	
		return (RetrievedEmployeesList)unmarshaller.unmarshal(new File(pathname));
	}
	public static void MarshalRetrievedEmployeesList(String pathofxmlfile,RetrievedEmployeesList retrievedEmployeesList) throws JAXBException
	{
		JAXBContext jaxbContext = JAXBContext.newInstance(RetrievedEmployeesList.class);
	    Marshaller jaxbMarshaller = jaxbContext.createMarshaller();
	 
	    jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
	 
	    jaxbMarshaller.marshal(retrievedEmployeesList,new File(pathofxmlfile));
	}
	public static RetrievedEmployee UnMarshalRetrievedEmployee(String pathname) throws JAXBException
	{
		JAXBContext jAXBContext=JAXBContext.newInstance(RetrievedEmployee.class);
		Unmarshaller unmarshaller= jAXBContext.createUnmarshaller();	
		return (RetrievedEmployee)unmarshaller.unmarshal(new File(pathname));
	}
	public static void MarshalRetrievedEmployee(String pathofxmlfile,RetrievedEmployee retrievedEmployee) throws JAXBException
	{
		JAXBContext jaxbContext = JAXBContext.newInstance(RetrievedEmployee.class);
	    Marshaller jaxbMarshaller = jaxbContext.createMarshaller();
	 
	    jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
	 
	    jaxbMarshaller.marshal(retrievedEmployee,new File(pathofxmlfile));
	}
}

