

package com.jaxb.retrievedEmployeesList;



import java.util.List;

import javax.xml.bind.annotation.*;

import com.jaxb.retrievedEmployee.*;

@XmlRootElement(name = "retrievedEmployeesList")
@XmlAccessorType (XmlAccessType.FIELD)
public class RetrievedEmployeesList {

	@XmlElement(name = "retrievedEmployee")
    private List<RetrievedEmployee> retrievedEmployeesList = null;
 
    public List<RetrievedEmployee> getRetrievedEmployees() {
        return retrievedEmployeesList;
    }
    public RetrievedEmployeesList(RetrievedEmployeesList retrievedEmployeesList) {
		// TODO Auto-generated constructor stub
    	
    	this.retrievedEmployeesList=retrievedEmployeesList.getRetrievedEmployees();
	}
    public RetrievedEmployeesList() {
		// TODO Auto-generated constructor stub
	}
    public void setRetrievedEmployees(RetrievedEmployeesList retrievedEmployeesList) {
        this.retrievedEmployeesList = retrievedEmployeesList.getRetrievedEmployees();
    }
    public void setRetrievedEmployees(List<RetrievedEmployee> employees) {
        this.retrievedEmployeesList = employees;
    }
}
