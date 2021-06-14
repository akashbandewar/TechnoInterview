<%@page import="com.akash.app.dao.Userdto"%>
<%@page import="com.akash.app.dao.User"%>
<%@page import="com.akash.app.dao.MyUserDetails"%>
<%@page import="java.util.List"%> 
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%-- <%@ include file="cache_control.jsp" %> --%>
 
<%-- <% 
	MyUserDetails user =(MyUserDetails)request.getAttribute("session");
	if(user !=null){
%> --%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>All Users</title>

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
		<h1>All Users</h1>
	</div>
	<table class="table-hover" align="center">
		<tr >
			<th >
				Id
			</th>
			<th>
				Name
			</th>
			<th>
				Email Id
			</th>
			<th>
				Mobile
			</th>
			<th>
				Role
			</th>
			<th></th>
			<th></th>
		</tr>
		<% 
		List<User> users = (List<User>)request.getAttribute("userlist");
		for(User list : users){
		%>
		<tr>
			<td>
				<%=list.getId()%>
			</td>
			<td>
				<%=list.getName()%>
			</td>
			<td>
				<%=list.getEmail()%>
			</td>
			<td>
				<%=list.getMobile()%>
			</td>
			<td>
				<%="USER"%>
			</td>
			<th>
				<a  href="deleteuser?email=<%=list.getEmail()%>" >Delete</a>
			</th>
			<td>
				<a  href="edituser?email=<%=list.getEmail()%>" >Update</a>
			</td> 
		</tr>
		<% } %>
				
	</table>
	</div>
	</div>
</body>
</html>
<%-- <%
	}else
		response.sendRedirect("homepage.jsp");
%> --%>

