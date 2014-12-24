<%@taglib uri="http://www.springframework.org/tags/form"  prefix="form"%>
<!DOCTYPE html >
<html>
<head>
<title>AdminHomePage</title>
</head>
<body>
<h1>AdminHomePage</h1>
<br>
<form action=" ./EmployeeAddingController">
<input type="submit" value="AddEmployee" >
<br>
</form>
<form action=" ./EmployeeUpdatingController">
<input type="submit" value="UpdateEmployee" >
</form>
<br>

<form action="./EmployeeDeletingController">
<input type="submit" value="DeleteEmployee" >
</form>
<br>
<form action="./EmployeeRetrievingController">
<input type="submit" value="RetrieveEmployee" >
</form>
<form action=" ./EmployeeLogout">
<input type="submit" value="Logout" >
</form>
</body>
</html>