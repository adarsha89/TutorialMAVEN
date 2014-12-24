<%@taglib uri="http://www.springframework.org/tags/form"  prefix="form"%>


<!DOCTYPE html >
<html>
<head>

<script src="http://ajax.googleapis.com/ajax/libs/jquery/1/jquery.min.js"></script>
<script src="http://cdnjs.cloudflare.com/ajax/libs/jquery-form-validator/2.1.47/jquery.form-validator.min.js"></script>


<script>
 
 
	$(document).ready(function(){  
		  $.validate();
		});
	function user(){  
	  console.log("Hi");
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
		$.ajax({
	        type: "GET",
	        url:  "./EmployeeAdditionJSON",
	        dataType: "json",
	        //timeout:3000,
	        contentType: 'application/json',
	        data:  {EmpID: empid, Username:username, Password: password, Designation: designation, JoiningDate: joiningdate, CompanyEmailID:companyemailid, ManagerID:managerid, FirstName: firstname, LastName: lastname},
	        statusCode: {
			    404: function() {
			    	console.log("ajax request failed");
			    }
			  },
	        success: function(data){
	            
	        	console.log("ajax request completed successfully");
	        	document.getElementById("SuccessState").innerHTML =data.addEmployeeSuccessState;	        	 	
	        	/* $.each(data, function(key, val) {
	                var tr=$('<tr class="dataEntered"></tr>');
	                
	                
	                $('<td>'+v+'</td>').appendTo(tr);
	                tr.appendTo('#table1');
	            });  */         
	        },

	        });
	  
	}; 

	
	
	
	
	
</script>
<title>AddEmployee</title>

</head>
<body>



<h1>Add Employee Details</h1>
<h2 id="SuccessState" ></h2>
<p>
<form id="form" action="javascript:user();" >
<p id="empid">EmpID<input type="text" name="EmpID" id="EmpID" autofocus="autofocus"  data-validation="custom" data-validation-regexp="^([M,E]{1}_[0-9]+)$"     data-validation-help="Starts with M or E"   data-validation-error-msg="Wrong value for EmpID" ></p>
<br>
<p id="firstname">FirstName<input type="text"  id="FirstName" name="FirstName" data-validation="custom" data-validation-regexp="^([A-Z]{1}[a-z]+)$"    data-validation-length="4-10"   data-validation-error-msg="Wrong value for FirstName" ></p>
<br>
<p id="lastname">LastName(Optional)<input type="text"  id="LastName" name="LastName"   data-validation="custom" data-validation-regexp="^([A-Z]{1}[a-z]+)$"    data-validation-length="4-10"   data-validation-optional="true"   data-validation-error-msg="Wrong value for LastName" ></p>
<br>
<p id="username">Username<input type="text"  id="Username" name="Username"    data-validation="alphanumeric"   data-validation-length="8-15"   data-validation-error-msg="Wrong value for UserName" ></p>
<br>
<p id="password">Password<input type="text"  id="Password" name="Password"     data-validation="alphanumeric"   data-validation-length="8-15"   data-validation-error-msg="Wrong value for Password" ></p>
<br>
<p id="managerid">ManagerID(Optional)<input type="text"  id="ManagerID" name="ManagerID"   data-validation="custom" data-validation-regexp="^([M]{1}_[0-9]+)$"   data-validation-optional="true"   data-validation-error-msg="Wrong value for ManagerID" ></p>
<br>
<p id="designation">Designation
<select    id="Designation"       name="Designation"          >
  <option value="ASSOCIATE"  >ASSOCIATE</option>
  <option value="SENIOR_ASSOCIATE">SENIOR ASSOCIATE</option>
  <option value="MANAGER">MANAGER</option>
  <option value="SENIOR_MANAGER">SENIOR MANAGER</option>
  <option value="DIRECTOR">DIRECTOR</option>
  <option value="VP">VP</option>
    <option value="CEO">CEO</option>
</select>
</p>
<p id="companyemailid">CompanyEmailID<input type="email"  id="CompanyEmailID" name="CompanyEmailID"   data-validation="email"   ></p>
<p id="joiningdate">JoiningDate <input type="date"  id="JoiningDate" name="JoiningDate" data-validation-format="yyyy-mm-dd"     data-validation="date"  data-validation-help="yyyy-mm-dd" ></p>
<!--  Photo <input type="file" id="file" name="file[]" height="200px" width="150px" content editable="true" draggable="true" style="outline-color: green;background-color: orange;" multiple />-->
<input id="submit" type="submit" name="submit" >
</form>
<br>
<a href="/User" id="Go to Admin Home Page" >Go to Admin Home Page</a>


</body>
</html>