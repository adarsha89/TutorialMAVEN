package com.json.serviceClasses;



import java.sql.Date;

import javax.annotation.Nullable;

public class RetrievedEmployee {

	
    protected String empID;
	
    protected String username;
	
    protected String password;
    protected String firstName;
    @Nullable
    protected String lastName;
    protected String designation;
    protected String joiningDate;
    protected String companyEmailID;
    @Nullable
    protected String managerID;

    
    public RetrievedEmployee(String empID,String username,String password,String firstName,String lastName,String designation, String joiningDate, String companyEmailID,String managerID) {
		// TODO Auto-generated constructor stub
    	this.empID=empID;
    	this.username=username;
    	this.password=password;
    	this.firstName=firstName;
    	this.lastName=lastName;
    	this.designation=designation;
    	this.joiningDate=joiningDate;
    	this.companyEmailID=companyEmailID;
    	this.managerID=managerID;
	}
    public RetrievedEmployee()
    {
    	
    }
    public String getEmpID() {
        return empID;
    }

    public void setEmpID(String value) {
        this.empID = value;
    }
    public String getUsername() {
        return username;
    }
    public void setUsername(String value) {
        this.username = value;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String value) {
        this.password = value;
    }

   
    public String getFirstName() {
        return firstName;
    }

    public String toString() {

        return new StringBuffer(" First Name : ").append(this.firstName).append(" Last Name : ").append(this.lastName).append(" EMP_ID : ").append(this.empID).toString();

    }
   
    public void setFirstName(String value) {
        this.firstName = value;
    }

    public String getLastName() {
        return lastName;
    }

    
    public void setLastName(String value) {
        this.lastName = value;
    }

   
    public String getDesignation() {
        return designation;
    }

   
    public void setDesignation(String value) {
        this.designation = value;
    }

   
    public String getJoiningDate() {
        return joiningDate;
    }

    public void setJoiningDate(String value) {
        this.joiningDate = value;
    }

    public String getCompanyEmailID() {
        return companyEmailID;
    }

    public void setCompanyEmailID(String value) {
        this.companyEmailID = value;
    }

    public String getManagerID() {
        return managerID;
    }
    public void setManagerID(String value) {
        this.managerID = value;
    }

}
