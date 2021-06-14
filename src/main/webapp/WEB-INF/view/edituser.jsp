<%@page import="com.akash.app.dao.User"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="spr" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Edit Profile</title>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/css/bootstrap.min.css" integrity="sha384-TX8t27EcRE3e/ihU7zmQxVncDAy5uIKz4rEkgIXeMed4M0jlfIDPvg6uqKI2xXr2" crossorigin="anonymous">

<style>
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

table td a{
	color: yellow;
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
	
	<% 
		User user = (User)request.getAttribute("user");
	%>
	
	<div id="tableouter">
	<div id="table">
	
	<spr:form action="updateuser" method="post" modelAttribute="userdto" >
	<table class="table-borderless" style="text-align: left " >
		
		<tr>
			<td>
				User ID:
			</td>
			<td>
				<%-- <spr:input path="id" value="<%=user.getId()%>" disabled/> --%>
				<spr:input path="id" readonly="true"/>
			</td>
		</tr>
		<tr>
			<td>
				NAME:
			</td>
			<td>
				<spr:input path="name"/>
			</td>
		</tr>
		<tr>
			<td>
				EMAIL:
			</td>
			<td>
				<spr:input path="email" readonly="true"/>  
			</td>
		</tr>
		<tr>
			<td>
				MOBILE:
			</td>
			<td>
 				<spr:input path="mobile" />
			</td>
		</tr>
 		<tr>
			<td>
				<a href="my_ads.htm" >Back</a>
			</td>
			<td>
				<input type="submit" value="Update" >
			</td>
		</tr>
	</table>
	</spr:form>
	</div>
	</div>
</body>
</html>