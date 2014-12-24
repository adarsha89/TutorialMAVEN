package com.Home;

import java.sql.Date;

public class Employee
{
  private String empID;
  private OfficialDetails officialDetail;
  private PersonalDetails personalDetail;

  public void setOfficialDetails(OfficialDetails officialDetail)
  {
    this.officialDetail = officialDetail;
  }

  public OfficialDetails getOfficialDetails() {
    return this.officialDetail;
  }

  public void setPersonalDetails(PersonalDetails personalDetail) {
    this.personalDetail = personalDetail;
  }

  public PersonalDetails getPersonalDetails() {
    return this.personalDetail;
  }

  public void setEmpID(String empID) {
    this.empID = empID;
  }

  public String getEmpID() {
    return this.empID;
  }
 public String getUsername()
 {
	 return this.getOfficialDetails().getUsername();
 }
 public String getPassword()
	{
		return this.getOfficialDetails().getPassword();
	}
	public String getDesignation()
	{
		return this.getOfficialDetails().getDesignation().getDesignationValue();
	}
	public String getJoiningDate()
	{
		return this.getOfficialDetails().getJoiningDate().toString();
	}
	public String getCompanyEmailID()
	{
		return this.getOfficialDetails().getCompanyEmailID();
	}
	public String getManagerID()
	{
		return this.getOfficialDetails().getManagerID();
	}
	public String getFirstName()
	{
		return this.getPersonalDetails().getFirstName();
	}
	public String getLastName()
	{
		return this.getPersonalDetails().getLastName();
	}
	public int getPhoneNumber()
	{
		return this.getPersonalDetails().getPhoneNumber();
	}
	public String getPersonalEmailID()
	{
		return this.getPersonalDetails().getPersonalEmailID();
	}
 
  public  Employee(String empID, String username, String password, String designation, Date joiningDate, String companyEmailID, String managerID, String firstName, String lastName )
  {
	  this.empID=empID;
	  this.officialDetail=new  OfficialDetails( username,  password,  designation,  joiningDate,  companyEmailID,  managerID);
	  this.personalDetail= new PersonalDetails( firstName,  lastName);
  }
  
  public static Employee getInstance()
  {
	 return new Employee("E_123", "Ad", "Po", "ASSOCIATE", new Date(400L), "a", "M", "Ba", "da");
  }
 public String toString()
 {
	 String empID=this.empID;
	 String username=this.getOfficialDetails().getUsername();
	 String password=this.getOfficialDetails().getPassword();
	 String designation=this.getOfficialDetails().getDesignation().getDesignationValue();
	 String joiningDate=this.getOfficialDetails().getJoiningDate().toString();
	 String companyEmailID=this.getOfficialDetails().getCompanyEmailID();
	 String managerID=this.getOfficialDetails().getManagerID();
	 String firstName=this.getPersonalDetails().getFirstName();
	 String lastName=this.getPersonalDetails().getLastName();
	 int phoneNumber=this.getPersonalDetails().getPhoneNumber();
	 String personalEmailID=this.getPersonalDetails().getPersonalEmailID();
	 
	 String stringtoreturn=empID+" "+username+" "+password+" "+designation+" "+joiningDate+" "+companyEmailID+" "+managerID+" "+firstName+" "+lastName+" "+phoneNumber+" "+personalEmailID;
	 return stringtoreturn;
 }
}