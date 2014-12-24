
<!DOCTYPE html >
<html>
<head>
<script src="http://ajax.googleapis.com/ajax/libs/jquery/1/jquery.min.js"></script>
<script src="http://cdnjs.cloudflare.com/ajax/libs/jquery-form-validator/2.1.47/jquery.form-validator.min.js"></script>
<title>Login Page</title>
<script>
$(document).ready(function(){  
  $.validate();
});
var CONTEXT_ROOT = '<%= request.getContextPath() %>';
</script>
</head>
<body>
<form method="POST" action="./User">
<p id="username">UserName<input required type="text" name="username"  autocomplete="on"   autofocus="autofocus"   /></p>
<p id="password">Password<input required type="password"  name="password"   /></p>
<input name="submit" type="submit" value="submit" />
<input name="reset" type="reset" />
</form>
</body>
</html>