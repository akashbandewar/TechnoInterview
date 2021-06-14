<%@page import="com.akash.app.dao.User"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%-- <c:set var="contextPath" value="${pageContext.request.contextPath}"/> --%>

<!DOCTYPE html>
<html lang="en">
  <head>
      <meta charset="utf-8">
      <title>Edit Profile</title>
	  <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/css/bootstrap.min.css" integrity="sha384-TX8t27EcRE3e/ihU7zmQxVncDAy5uIKz4rEkgIXeMed4M0jlfIDPvg6uqKI2xXr2" crossorigin="anonymous">	
<%--       <link href="${contextPath}/resources/css/bootstrap.min.css" rel="stylesheet">
      <link href="${contextPath}/resources/css/common.css" rel="stylesheet"> --%>
  </head>
  
 	<% 
		User user = (User)request.getAttribute("user");
	%>
  
  <body>

    <div class="container">

        <form:form method="POST" modelAttribute="userForm" class="form-signin">
            <h2 class="form-signin-heading">EDIT Profile</h2>
            <spring:bind path="id">
                <div class="form-group ${status.error ? 'has-error' : ''}">
                    ID: <form:input type="text" path="id" class="form-control" value="<%=user.getId()%>" 
                                autofocus="true" readonly="true" />
                    <form:errors path="id"></form:errors>
                </div>
            </spring:bind>
            
            <spring:bind path="name">
                <div class="form-group ${status.error ? 'has-error' : ''}">
                    NAME: <form:input type="text" path="name" class="form-control" placeholder="<%=user.getName()%>"
                                autofocus="true"></form:input>
                    <form:errors path="name"></form:errors>
                </div>
            </spring:bind>
            
            <spring:bind path="email">
                <div class="form-group ${status.error ? 'has-error' : ''}">
                    EMAIL: <form:input type="text" path="email" class="form-control" value="<%=user.getEmail()%>"
                                autofocus="true" readonly="true" />
                    <form:errors path="email"></form:errors>
                </div>
            </spring:bind>
            
            <spring:bind path="mobile">
                <div class="form-group ${status.error ? 'has-error' : ''}">
                    MOBILE: <form:input type="text" path="mobile" class="form-control" placeholder="<%=user.getMobile()%>"
                                autofocus="true"></form:input>
                    <form:errors path="mobile"></form:errors>
                </div>
            </spring:bind>

            <button class="btn btn-lg btn-primary btn-block" type="submit">UPDATE</button>
        </form:form>

    </div>

    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
    <script src="${contextPath}/resources/js/bootstrap.min.js"></script>
  </body>
</html>