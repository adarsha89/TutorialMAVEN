package com.json.serviceClasses;


import javax.annotation.*;

public class CreateEmployee {

	
	protected String empID;
	
    protected String firstName;
	@Nullable
    protected String lastName;
	
    protected String username;
	
    protected String password;
    @Nullable
    protected String managerID;
    
    protected String designation;
    
    protected String companyEmailID;
    
    protected String joiningDate;
    public CreateEmployee() {
		// TODO Auto-generated constructor stub
	}
    public CreateEmployee(String empID,String firstName,String lastName,String username,String password,String managerID,String designation,String companyEmailID,String joiningDate)
    {
    	this.empID=empID;
    	this.firstName=firstName;
    	this.password=password;
    	this.lastName=lastName;
    	this.username=username;
    	this.managerID=managerID;
    	this.designation=designation;
    	this.companyEmailID=companyEmailID;
    	this.designation=designation;
    	this.joiningDate=joiningDate;
    }
    public String toString() {

        return new StringBuffer(" First Name : ").append(this.firstName).append(" Last Name : ").append(this.lastName).append(" EMP_ID : ").append(this.empID).toString();

    }
    public String getEmpID() {
        return empID;
    }  
	
    public void setEmpID(String value) {
        this.empID = value;
    }

    public String getFirstName() {
        return firstName;
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

    public String getManagerID() {
        return managerID;
    }

   
    public void setManagerID(String value) {
        this.managerID = value;
    }

    public String getDesignation() {
        return designation;
    }

    public void setDesignation(String value) {
        this.designation = value;
    }

    public String getCompanyEmailID() {
        return companyEmailID;
    }

    public void setCompanyEmailID(String value) {
        this.companyEmailID = value;
    }

    public String getJoiningDate() {
        return joiningDate;
    }

    public void setJoiningDate(String value) {
        this.joiningDate = value;
    }
}
