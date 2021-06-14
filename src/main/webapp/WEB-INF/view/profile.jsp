<%@page import="com.akash.app.dao.User"%>
<%@page import="org.springframework.security.core.Authentication"%>
<%@page import="com.akash.app.dao.User"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>My Profile</title>

<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/css/bootstrap.min.css" integrity="sha384-TX8t27EcRE3e/ihU7zmQxVncDAy5uIKz4rEkgIXeMed4M0jlfIDPvg6uqKI2xXr2" crossorigin="anonymous">
<style >
body{
	background: url("1.jpg");
	background-position: center;
	background-repeat: none;
}
#header{
	display: flex;
	justify-content: space-between;
	padding: 0 5vh 0 5vh;
}
h2{
	color: #FE044B;
	font-size: 230%;
}

#header div h2 a{
	color: #FE044B;
}
button{
	margin: 1vh 0 1vh 0;
}

#tableouter{
	display: flex;
	justify-content: center;
	margin-top: 5vh;
}

#table{
	background-color: rgba(0,0,0,0.5);
	padding: 2vh 5vh 2vh 5vh;
	border-radius: 20px;
	color: white;
	border: 1px solid yellow;
	text-align: center;
}

a{
	color: yellow;
}

#table div{
	margin: 2vh 0 4vh 0;
	color: tomato;
}
</style>
</head>


<body>
	<div id="header">
		<div>
			<h2>
				<a href="homepage" >Home</a>
			</h2>
		</div>
		<div>
			<button type="button" class="btn btn-warning">
				<a href="logout">Log Out</a>
			</button>
		</div>
	</div>
	
	<div id="tableouter">
	<div id="table">
	<div>
		<h1>My Profile</h1>
	</div>
	
	<% 
		User user = (User)request.getAttribute("user");
	%>
		
	<table class="table-hover" align="center">
		<tr>
			<td>
				USER ID
			</td>
			<td>
				<%=user.getId()%>
			</td>
		</tr>
		<tr>
			<td>
				NAME
			</td>
			<td>
				<%=user.getName()%>
			</td>
		</tr>
		<tr>
			<td>
				EMAIL
			</td>
			<td>
				<%=user.getEmail()%>
			</td>
		</tr>
		<tr>
			<td>
				MOBILE NUMBER
			</td>
			<td>
				<%=user.getMobile()%>
			</td>
		</tr>
		<tr>
			<td>
				ROLE
			</td>
			<td>
				<%=user.getRole().getRole()%>
			</td>
		</tr>
		<tr></tr>
		<tr>
			<a  href="edituser?email=<%=user.getEmail()%>" >Edit Profile</a>
		</tr>
				
	</table>
	</div>
	</div>
</body>
</html>