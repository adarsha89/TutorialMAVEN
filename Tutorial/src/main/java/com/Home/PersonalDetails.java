package com.Home;

public class PersonalDetails
{
	private String firstName;
	private String lastName;
	private int phoneNumber;
	private String personalEmailID;
  
  
  public void setFirstName(String firstName)
  {
    this.firstName = firstName;
  }

  public String getFirstName()
  {
    return this.firstName;
  }

  public void setLastName(String lastName)
  {
    this.lastName = lastName;
  }

  public String getLastName()
  {
    return this.lastName;
  } 
  public void setPhoneNumber(int phoneNumber)
  {
    this.phoneNumber = phoneNumber;
  }

  public int getPhoneNumber()
  {
    return this.phoneNumber;
  } 
  public void setPersonalEmailID(String personalEmailID)
  {
    this.personalEmailID = personalEmailID;
  }

  public String getPersonalEmailID()
  {
    return this.personalEmailID;
  }
  public PersonalDetails(String firstName, String lastName)
  {
	  this.firstName=firstName;
	  this.lastName=lastName;
	  
  }
}

