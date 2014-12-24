package com.Home.DA;

import java.util.Date;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.jndi.JndiObjectFactoryBean;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.Home.Designation;
import com.Home.Employee;


public class JDBCDAOImpl  implements DAInterface{
	
	private NamedParameterJdbcTemplate namedParameterJdbcTemplate;
	
	/*@Autowired(required=true)
	public void setnamedParameterJdbcTemplate(JndiObjectFactoryBean jndiObjectFactoryBean)
	{
		namedParameterJdbcTemplate=new NamedParameterJdbcTemplate((DataSource) jndiObjectFactoryBean.getObject());
	}*/
	public JDBCDAOImpl() {
		setnamedParameterJdbcTemplate();
	}
	public void setnamedParameterJdbcTemplate()
	{
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext("Database.xml");
		DataSource driverManagerDataSource=(DataSource) applicationContext.getBean("driverManagerDataSource");
		namedParameterJdbcTemplate=new NamedParameterJdbcTemplate(driverManagerDataSource);
		((ConfigurableApplicationContext)applicationContext).close();
	}
	
	@Transactional(propagation=Propagation.REQUIRED,timeout=10, rollbackFor=Exception.class)
	public boolean createEmployee(Employee employee) throws Exception {
		// TODO Auto-generated method stub
		boolean employeeCreated=false;
		String insertQuery1="INSERT INTO official_details (EMP_ID,USERNAME,PASSWORD,DESIGNATION,JOINING_DATE,COMPANY_EMAIL_ID,PASSWORD_CHANGE_STATUS,MANAGER_ID) VALUES (:EMP_ID,:USERNAME,:PASSWORD,:DESIGNATION,:JOINING_DATE,:COMPANY_EMAIL_ID,:PASSWORD_CHANGE_STATUS,:MANAGER_ID)";
		String insertQuery2="INSERT INTO personal_details (EMP_ID,FIRST_NAME,LAST_NAME,PERSONAL_EMAIL_ID,CONTACT_NUMBER,PHOTO) VALUES (:EMP_ID,:FIRST_NAME,:LAST_NAME,:PERSONAL_EMAIL_ID,:CONTACT_NUMBER,:PHOTO)";
		Map <String, Object> params=new HashMap<String,Object>();
		System.out.println(employee.toString());
		params.put("EMP_ID",employee.getEmpID());
		params.put("FIRST_NAME",employee.getPersonalDetails().getFirstName());
		params.put("LAST_NAME",employee.getPersonalDetails().getLastName());
		params.put("PERSONAL_EMAIL_ID",null);
		params.put("CONTACT_NUMBER",0);
		params.put("PHOTO",null);		
		params.put("USERNAME",employee.getOfficialDetails().getUsername());
		params.put("PASSWORD",employee.getOfficialDetails().getPassword());		
		params.put("JOINING_DATE",employee.getOfficialDetails().getJoiningDate());
		params.put("DESIGNATION",employee.getOfficialDetails().getDesignation().toString());
		params.put("COMPANY_EMAIL_ID",employee.getOfficialDetails().getCompanyEmailID());
		params.put("PASSWORD_CHANGE_STATUS","FALSE");
		params.put("MANAGER_ID",employee.getOfficialDetails().getManagerID());	
		try
		{
		namedParameterJdbcTemplate.update(insertQuery1, params);
		namedParameterJdbcTemplate.update(insertQuery2, params);
		employeeCreated=true;
		}catch(Exception e)		
		{
			deleteEmployee(employee.getEmpID(), null, null, null, null, null, null, null);
			e.printStackTrace();
			System.out.println("Roll back done due to exception");
			
		}	
			return employeeCreated;
		
		
	}

	@Transactional(propagation=Propagation.REQUIRED,timeout=10, rollbackFor=Exception.class)
	public int updateEmployee(String employeeID, String password,
			String designation, String managerID) throws Exception {
		// TODO Auto-generated method stub
		StringBuilder updateQuery1=new StringBuilder();
		updateQuery1.append("UPDATE official_details SET"); 
		
				if( password!=null && password!="")
				{
					updateQuery1.append(" , PASSWORD=:PASSWORD");
					
				}
				if( managerID!=null && managerID!="")
				{
					updateQuery1.append(" , MANAGER_ID=:MANAGER_ID");
					System.out.println(2);
				}
				if(designation!=null && designation!="")
				{
					updateQuery1.append(" , DESIGNATION=:DESIGNATION");
				}		
				Map <String, Object> params=new HashMap<String,Object>();
				updateQuery1.append(" WHERE EMP_ID=:EMP_ID");
		params.put("PASSWORD",password);				
		params.put("DESIGNATION",designation);
		params.put("MANAGER_ID",managerID);
		params.put("EMP_ID",employeeID);
		String updateQuery2=updateQuery1.toString().replaceFirst(",", " ");
		System.out.println(updateQuery2.toString());
		int status=namedParameterJdbcTemplate.update(updateQuery2, params);
		System.out.println(status);
		return status;
		
	}

	@Transactional(propagation=Propagation.REQUIRED,timeout=10, rollbackFor=Exception.class)
	public int deleteEmployee(String empID,String username, String designation, Date joiningDate, String companyEmailID, String managerID,String firstName, String lastName) {
		// TODO Auto-generated method stub
		StringBuilder deleteQuery1=new StringBuilder();
		deleteQuery1.append("DELETE FROM official_details WHERE ");
		
		if(empID!=null && empID!="")
		{
			deleteQuery1.append(" AND EMP_ID=:EMP_ID");
		}
		if(username!=null && username!="")
		{
			deleteQuery1.append(" AND USERNAME=:USERNAME");
		}
		if(designation!=null && designation!="")
		{
			deleteQuery1.append(" AND DESIGNATION=:DESIGNATION");
		}
		if(joiningDate!=null)
		{
			deleteQuery1.append(" AND JOINING_DATE=:JOINING_DATE");
		}
		if(companyEmailID!=null && companyEmailID!="")
		{
			deleteQuery1.append(" AND COMPANY_EMAIL_ID=:COMPANY_EMAIL_ID");
		}
		if(managerID!=null && managerID!="")
		{
			deleteQuery1.append(" AND MANAGER_ID=:MANAGER_ID");
		}
		if(firstName!=null && firstName!="")
		{
			if(lastName!=null && lastName!="")
			{
				deleteQuery1.append(" AND official_details.EMP_ID IN(SELECT EMP_ID FROM personal_details WHERE FIRST_NAME=:FIRST_NAME AND LAST_NAME=:LAST_NAME)");
			}
			else
			{
				deleteQuery1.append(" AND official_details.EMP_ID IN(SELECT EMP_ID FROM personal_details WHERE FIRST_NAME=:FIRST_NAME) ");
			}
		}
		else if(lastName!=null && lastName!="")
		{
			deleteQuery1.append(" AND official_details.EMP_ID IN(SELECT EMP_ID FROM personal_details WHERE LAST_NAME=:LAST_NAME )");
		}
		
		String deleteQuery2=deleteQuery1.toString().replaceFirst("AND", " ");
		
		Map <String, Object> params=new HashMap<String,Object>();
		if(empID!=null && empID!="")
		{
			params.put("EMP_ID", empID);
		}
		if(username!=null && username!="")
		{
			params.put("USERNAME", username);
		}
		if(designation!=null && designation!="")
		{
			params.put("DESIGNATION", designation);
		}
		if(joiningDate!=null)
		{
			params.put("JOINING_DATE", joiningDate);
		}
		if(companyEmailID!=null && companyEmailID!="")
		{
			params.put("COMPANY_EMAIL_ID", companyEmailID);
		}
		if(managerID!=null && managerID!="")
		{
			params.put("MANAGER_ID", managerID);
		}
		if(firstName!=null && firstName!="")
		{
			params.put("FIRST_NAME", firstName);
		}
		if(lastName!=null && lastName!="")
		{
			params.put("LAST_NAME", lastName);
		}		
		return namedParameterJdbcTemplate.update(deleteQuery2, params);		
	}

	
	
	@Transactional(propagation=Propagation.REQUIRED,readOnly=true ,timeout=10, rollbackFor=Throwable.class)
	public List<Employee> retrieveEmployee(String empID,String username, String password, String designation, Date joiningDate, String companyEmailID, String managerID,String firstName, String lastName) {
		// TODO Auto-generated method stub
		List<Employee> listOfEmployee=new ArrayList<Employee>();
		Employee employee=null;
		StringBuilder selectQuery1=new StringBuilder();
		selectQuery1.append("SELECT DISTINCT official_details.*,personal_details.FIRST_NAME,personal_details.LAST_NAME  FROM official_details,personal_details WHERE official_details.EMP_ID=personal_details.EMP_ID"); 
		if(empID!=null && empID!="")
		{
			selectQuery1.append(" AND official_details.EMP_ID=:EMP_ID");
		}
		if(username!=null && username!="")
		{
			selectQuery1.append(" AND official_details.USERNAME=:USERNAME");
		}
		if(designation!=null && designation!="")
		{
			selectQuery1.append(" AND official_details.DESIGNATION=:DESIGNATION");
		}
		if(joiningDate!=null)
		{
			selectQuery1.append(" AND official_details.JOINING_DATE=:JOINING_DATE");
		}
		if(companyEmailID!=null && companyEmailID!="")
		{
			selectQuery1.append(" AND official_details.COMPANY_EMAIL_ID=:COMPANY_EMAIL_ID");
		}
		if(managerID!=null && managerID!="")
		{
			selectQuery1.append(" AND official_details.MANAGER_ID=:MANAGER_ID");
		}
		if(firstName!=null && firstName!="")
		{
			selectQuery1.append(" AND personal_details.FIRST_NAME=:FIRST_NAME");
		}
		if(lastName!=null && lastName!="")
		{
			selectQuery1.append(" AND personal_details.LAST_NAME=:LAST_NAME");
		}
		String selectQuery2=selectQuery1.toString();
		Map <String, Object> params=new HashMap<String,Object>();
		params.put("EMP_ID", empID);
		params.put("USERNAME", username);
		params.put("JOINING_DATE", joiningDate);
		params.put("DESIGNATION", designation);
		params.put("COMPANY_EMAIL_ID", companyEmailID);
		params.put("MANAGER_ID", managerID);
		params.put("FIRST_NAME", firstName);
		params.put("LAST_NAME", lastName);
		List<Map<String, Object>> listofmap =namedParameterJdbcTemplate.queryForList(selectQuery2, params);
		
		for(Map<String, Object> mapOfEmployees:listofmap)
		{
			employee=Employee.getInstance();
			System.out.println(mapOfEmployees.keySet().toString());
			employee.setEmpID((String) mapOfEmployees.get("EMP_ID"));
			employee.getOfficialDetails().setUsername( (String) mapOfEmployees.get("USERNAME"));
			employee.getOfficialDetails().setPassword((String) mapOfEmployees.get("PASSWORD"));
			employee.getPersonalDetails().setFirstName((String) mapOfEmployees.get("FIRST_NAME"));
			try
			{
				employee.getPersonalDetails().setLastName((String) mapOfEmployees.get("LAST_NAME"));
				employee.getOfficialDetails().setManagerID((String) mapOfEmployees.get("MANAGER_ID"));
			}catch(NullPointerException e)
			{
				System.out.println(e.getStackTrace());
			}
			employee.getOfficialDetails().setDesignation(Designation.valueOf((String) mapOfEmployees.get("DESIGNATION")));
			employee.getOfficialDetails().setJoiningDate((java.sql.Date) mapOfEmployees.get("JOINING_DATE"));
			employee.getOfficialDetails().setCompanyEmailID((String) mapOfEmployees.get("COMPANY_EMAIL_ID"));
			System.out.println(employee.getEmpID()+employee.getOfficialDetails().getUsername());
			listOfEmployee.add( employee);
		}		
		return listOfEmployee;		
	}	
}
