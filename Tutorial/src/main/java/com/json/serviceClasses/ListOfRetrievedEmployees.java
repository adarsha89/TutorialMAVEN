package com.json.serviceClasses;

import java.util.List;

public class ListOfRetrievedEmployees {

	private List<RetrievedEmployee> listOfRetrievedEmployees;
	public List<RetrievedEmployee> getListOfRetrievedEmployees()
	{
		return listOfRetrievedEmployees;
	}
	public void setListOfRetrievedEmployees( List<RetrievedEmployee> listOfRetrievedEmployees)
	{
		this.listOfRetrievedEmployees=listOfRetrievedEmployees;
	}
	
}
