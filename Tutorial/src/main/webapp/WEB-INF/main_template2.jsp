<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>    
<!DOCTYPE html>  
<html>  

<head>  
<style type="text/css">
body{
	background-color: silver; font-family: Arial, Verdana, sans-serif;  
}
h1{
	background-color: olive;
	font:sans-serif;
	text-align:center;
}
p{
	color:teal;
	text-align:center;
}

.header,.footer,.leftPane,.rightPane {  
border: 1px solid gray; 
}  
  
.header,.main,.footer {  
  
 color: #665544;  
 margin: 0px auto;  
 clear: both;  
}  
  
.leftPane,.rightPane {  
 float: left;  
 margin: auto;  
}  
  
.leftPane {  

 width: 15%;  
  height: 80%;  
}  
  
.rightPane {  
 width: 65%;
 height: 80%;  
}  
  
.leftMenu {  
 list-style: none;  
 padding: 0;  
 margin: auto;  
}  
</style>

</head>  
<body>  

<tiles:insertAttribute name="header" /> 
<tiles:insertAttribute  name="title"/> 
 <div class="main">  
   <tiles:insertAttribute name="body" />  
 </div> 
   <tiles:insertAttribute name="footer" />  
   
</body>  
</html>  