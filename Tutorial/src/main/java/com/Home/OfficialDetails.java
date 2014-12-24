package com.Home;

import java.sql.Date;

public class OfficialDetails
{
  private String username;
  private String password;
  public Designation designation;
  private Date joiningDate;
  private String companyEmailID;
  private String managerID;
  private boolean passwordChangeStatus;

  public void setUsername(String username)
  {
    this.username = username;
  }

  public String getUsername() {
    return this.username;
  }

  public void setPassword(String password) {
    this.password = password;
  }

  public String getPassword() {
    return this.password;
  }

  public void setJoiningDate(Date joiningDate) {
    this.joiningDate = joiningDate;
  }

  public Date getJoiningDate() {
    return this.joiningDate;
  }

  public void setCompanyEmailID(String companyEmailID) {
    this.companyEmailID = companyEmailID;
  }

  public String getCompanyEmailID() {
    return this.companyEmailID;
  }

  public void setManagerID(String managerID) {
    this.managerID = managerID;
  }

  public String getManagerID() {
    return this.managerID;
  }

  public void setPasswordChangeStatus(boolean passwordChangeStatus) {
    this.passwordChangeStatus = passwordChangeStatus;
  }

  public boolean getPasswordChangeStatus() {
    return this.passwordChangeStatus;
  }

  public void setDesignation(Designation designation) {
    this.designation = designation;
  }

  public Designation getDesignation() {
    return this.designation;
  }
  public OfficialDetails(String username, String password, String designation, Date joiningDate2, String companyEmailID, String managerID)
  {
	  this.username=username;
	  this.password=password;
	  this.designation=Designation.valueOf(designation);
	  this.joiningDate=joiningDate2;
	  this.companyEmailID=companyEmailID;
	  this.managerID=managerID;
	  
  }
}