package com.json.serviceClasses;


import javax.annotation.Nullable;



public class UpdateEmployee {
	
    protected String empID;
	@Nullable
    protected String password;
	@Nullable
    protected String managerID;
	@Nullable
    protected String designation;

	public UpdateEmployee(String empID,String password,String managerID,String designation) {
		// TODO Auto-generated constructor stub
		this.empID=empID;
		this.password=password;
		this.managerID=managerID;
		this.designation=designation;
	}
	public UpdateEmployee() {
		// TODO Auto-generated constructor stub
	}
	public String toString() {

        return new StringBuffer(" EMP_ID : ").append(this.empID).toString();

    }
    public String getEmpID() {
        return empID;
    }

    public void setEmpID(String value) {
        this.empID = value;
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
}
