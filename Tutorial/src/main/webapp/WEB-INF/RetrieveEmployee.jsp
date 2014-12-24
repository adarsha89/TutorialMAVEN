<%@taglib uri="http://www.springframework.org/tags/form"  prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="t"%>
	<%@ page import="com.Home.Employee" %>
    <%@ page import="java.util.List" %>
    <%@ page import="java.util.Map" %>
    <%@ page import="java.text.DateFormat" %>
<%@ page import="java.text.SimpleDateFormat" %>
<%@ page import="java.util.Calendar" %>
<!DOCTYPE html>
<html>
<head>
<script src="http://ajax.googleapis.com/ajax/libs/jquery/1/jquery.min.js"></script>
<script src="http://cdnjs.cloudflare.com/ajax/libs/jquery-form-validator/2.1.47/jquery.form-validator.min.js"></script>
<script>
$(document).ready(function(){  
  $.validate();
});



function clickSubmit()
{
	$("#Enter").click();
	}
//var ajax_request;
function user()
{	
	var empid=null;
	var username=null;
	var password=null;
	var designation=null;
	var joiningdate=null;
	var companyemailid=null;
	var managerid=null;
	var firstname=null;
	var lastname=null;
	
	if($("#EmpID").val()!=null)
		{
		empid=$("#EmpID").val();
		}
	
	if($("#Username").val()!=null)
	{
		username=$("#Username").val();
	}
	if($("#Password").val()!=null)
	{
		password=$("#Password").val();
	}
	if($("#Designation").val()!=null)
	{
		designation=$("#Designation").val();
	}
	if($("#JoiningDate").val()!=null)
	{
		joiningdate=$("#JoiningDate").val();
	}
	if($("#CompanyEmailID").val()!=null)
	{
		companyemailid=$("#CompanyEmailID").val();
	}
	if($("#ManagerID").val()!=null)
	{
		managerid=$("#ManagerID").val();
	}
	if($("#FirstName").val()!=null)
	{
		firstname=$("#FirstName").val();
	}
	if($("#LastName").val()!=null)
	{
		lastname=$("#LastName").val();
	}
	/* $.ajax({
		  type: "GET",
		  url: "EmployeeRetrievalController",
		  data: {EmpID: empid, Username:username, Password: password, Designation: designation, JoiningDate: joiningdate, CompanyEmailID:companyemailid, ManagerID:managerid, FirstName: firstname, LastName: lastname},
		  statusCode: {
		    404: function() {
		      alert( "page not found" );
		    }
		  },
          success: function(data){
              // we have the response
             // var  list1='${employees.ListOfEmployees}';
			//alert('Success: ' + data);
			var table2= $(data).find('#info');
			$('#info').empty().html(table2);
			document.getElementById("EmpID").value =empid;
			document.getElementById("Username").value =username;
			document.getElementById("Password").value =password;
			document.getElementById("FirstName").value =firstname;
			document.getElementById("LastName").value =lastname;
			document.getElementById("Designation").value =designation;
			document.getElementById("JoiningDate").value =joiningdate;
			document.getElementById("CompanyEmailID").value =companyemailid;
			document.getElementById("ManagerID").value =managerid;
          },
          error: function(e){
              alert('Error: ' + e);
          } 
		}); */
		/* if(ajax_request)
		{
		ajax_request.abort();
		} */
		/* ajax_request= */$.ajax({
        type: "GET",
        timeout:3000,
        url:  "./EmployeeRetrieveJSON",
        dataType: "json",
        contentType: 'application/json',
        data:  {EmpID: empid, Username:username, Password: password, Designation: designation, JoiningDate: joiningdate, CompanyEmailID:companyemailid, ManagerID:managerid, FirstName: firstname, LastName: lastname},
        statusCode: {
		    404: function() {
		    	console.log("ajax request failed");
		    }
		  },
        success: function(data){
            
        	console.log("ajax request completed successfully");
        	$("#tbody1").empty();
        	for( k=0; k< data.length; k++)
        		{
				var tr=$('<tr class="rowsEntered"></tr>');        
                $('<td class="columnsEntered">'+data[k].empID+'</td>').appendTo(tr);
                $('<td class="columnsEntered">'+data[k].username+'</td>').appendTo(tr);
                $('<td class="columnsEntered">'+data[k].password+'</td>').appendTo(tr);
                $('<td class="columnsEntered">'+data[k].firstName+'</td>').appendTo(tr);
                $('<td class="columnsEntered">'+data[k].lastName+'</td>').appendTo(tr); 
                $('<td class="columnsEntered">'+data[k].designation+'</td>').appendTo(tr);
                $('<td class="columnsEntered">'+data[k].joiningDate+'</td>').appendTo(tr);
                $('<td class="columnsEntered">'+data[k].companyEmailID+'</td>').appendTo(tr);
                $('<td class="columnsEntered">'+data[k].managerID+'</td>').appendTo(tr);
                                              
                tr.appendTo('#tbody1');
        		}
        	
        	/* $.each(data, function(key, val) {
                var tr=$('<tr class="dataEntered"></tr>');
                
                
                $('<td>'+v+'</td>').appendTo(tr);
                tr.appendTo('#table1');
            });  */         
        },

        });
}
</script>


</head>
<body>
<h1>Retrieve Employee Details</h1>
<br>
<div id="info" >
<form method="GET" name="Myform" id="myform" action="javascript:user();">
<table border="1"  style="border-color:aqua"   id="table1">
<tr>
<th>EmployeeID</th>
<th>Username</th>
<th>Password</th>
<th>FirstName</th>
<th>LastName</th>
<th>Designation</th>
<th>JoiningDate</th>
<th>CompanyEmailID</th>
<th>ManagerID</th>
</tr>
<tr>
<td><input type="text" name="EmpID" id="EmpID"    data-validation="custom" data-validation-regexp="^([M,E]{1}_[0-9]+)$"  onkeyup="clickSubmit()"   data-validation-help="Starts with M or E."    data-validation-optional="true"   data-validation-error-msg="Wrong value for EmpID"    >
</td><td><input type="text"  name="Username" id="Username"    data-validation="alphanumeric"   data-validation-length="8-15" onkeyup="clickSubmit()"   data-validation-optional="true"   data-validation-error-msg="Wrong value for UserName"    >
</td><td><input type="text"  name="Password" id="Password"   data-validation="alphanumeric"   data-validation-length="8-15"   data-validation-optional="true" onkeyup="clickSubmit()"   data-validation-error-msg="Wrong value for Password"   >
</td>
<td><input type="text"  name="FirstName" id="FirstName" onkeyup="clickSubmit()"    data-validation="custom" data-validation-regexp="^([A-Z]{1}[a-z]+)$"    data-validation-length="4-10"   data-validation-optional="true"   data-validation-error-msg="Wrong value for FirstName" >
</td><td><input type="text"  name="LastName" id="LastName"  onkeyup="clickSubmit()"  data-validation="custom" data-validation-regexp="^([A-Z]{1}[a-z]+)$"    data-validation-length="4-10"   data-validation-optional="true"   data-validation-error-msg="Wrong value for LastName"  >
</td>
<td><select    id="Designation"       name="Designation"   onkeyup="clickSubmit()" onclick="clickSubmit()"  >
  <option value="ASSOCIATE"  >ASSOCIATE</option>
  <option value="SENIOR_ASSOCIATE">SENIOR ASSOCIATE</option>
  <option value="MANAGER">MANAGER</option>
  <option value="SENIOR_MANAGER">SENIOR MANAGER</option>
  <option value="DIRECTOR">DIRECTOR</option>
  <option value="VP">VP</option>
  <option value="CEO">CEO</option>
  <option value=""></option>
</select>
</td><td><input type="date"  name="JoiningDate" id="JoiningDate" onkeyup="clickSubmit()" onchange="clickSubmit()"   data-validation="date"   data-validation-optional="true" data-validation-format="yyyy-mm-dd" data-validation-help="yyyy-mm-dd" >
</td><td><input type="email"  name="CompanyEmailID" id="CompanyEmailID"  data-validation="email" onkeyup="clickSubmit()"   data-validation-optional="true"  >
</td><td><input type="text"  name="ManagerID" id="ManagerID"  onkeyup="clickSubmit()"   data-validation="custom" data-validation-regexp="^([M]{1}_[0-9]+)$"   data-validation-optional="true"   data-validation-help="Starts with M or E."   data-validation-error-msg="Wrong value for ManagerID"  >
</td><td><input type="submit" name="Enter" id="Enter" >
</td>
</tr>


<c:forEach items="${employees.ListOfEmployees}" var="emp">
<tr>
<td>
${emp.empID}
</td>
<td>
${emp.username}
</td>
<td>
${emp.password}
</td>
<td>
${emp.firstName}
</td>
<td>
${emp.lastName}
</td>
<td>
${emp.designation}
</td>
<td>
${emp.joiningDate}
</td>
<td>
${emp.companyEmailID}
</td>
<td>
${emp.managerID}
</td>
</tr>
</c:forEach>
<tbody id="tbody1">
</tbody>
</table>
</form>
</div>
<a href="/User" id="Go to Admin Home Page" >Go to Admin Home Page</a>
</body>
</html>