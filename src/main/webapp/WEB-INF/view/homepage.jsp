<%@page import="org.springframework.security.core.Authentication"%>
<%@page import="org.springframework.security.core.context.SecurityContextHolder"%>
<%@page import="org.springframework.security.core.Authentication"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<html>
<head>
<meta charset="ISO-8859-1">
<title>HomePage</title>

<link href="dashboard.css" rel="stylesheet" type="text/css">
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/css/bootstrap.min.css" integrity="sha384-TX8t27EcRE3e/ihU7zmQxVncDAy5uIKz4rEkgIXeMed4M0jlfIDPvg6uqKI2xXr2" crossorigin="anonymous">
</head>
<body>
	<h1>Homepage</h1>
	<div>
		<button type="button" class="btn btn-light">
			<a href="/register">Register</a>
		</button>
	</div>
	<% 
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		String role = authentication.getAuthorities().toString();
		String role1 = role.substring(1,role.length() - 1);
	%>
	role1
	<%
	System.out.println(role1.equals("ADMIN")+" JSP");
		if(role1.equals("ADMIN")){
	%>
	<div>
		<button type="button" class="btn btn-light">
			<a href="/allusers">All Users</a>
		</button>
	</div>
	<% 
		}
	%>
	<div>
		<button type="button" class="btn btn-light">
			<a href="/profile">My Profile</a>
		</button>
	</div>
</body>
</html>