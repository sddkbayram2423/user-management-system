<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Employee</title>
</head>
<body>



	<div class="col nav justify-content-center mt-3">
		<font color="black" size="4">EMPLOYEE LIST</font>
	</div>
	<c:if test="${empty employees}">
  	<h3>There are any employee!!!</h3>
  </c:if>  
  
  <c:if test="${not empty employees}">        
  <hr> 
  <table  class="table table-responsive ">
    <thead>
      <tr>
        <th>ID</th>
        <th>FISTNAME</th>
        <th>LASTNAME</th>
        <th>EMAIL</th>
        <th>PHONENUMBER</th>
        <th>SALARY</th>
        <th>HIRE DATE</th>
      </tr>
    </thead>
    <c:forEach items="${employees}" var="employee">
    <tbody>
      <tr>
        <td>${employee.id}</td>
        <td>${employee.firstName}</td>
        <td>${employee.lastName}</td>
        <td>${employee.email}</td>
        <td>${employee.phoneNumber}</td>
        <td>${employee.salary}</td>
        <td>${employee.hireDate}</td>
        <td><a href="/controller/employee/detailsEmployee?id= <c:out value="${employee.id}"/> "> <i>Details</i></a></td>
        <td><a href="/controller/employee/editEmployee?id= <c:out value="${employee.id}"/> "> <i>Edit</i></a></td>
        <td><a href="/controller/employee/deleteEmployee?id= <c:out value="${employee.id}"/> "> <i>Delete</i></a></td>
      </tr>
    </tbody>
    </c:forEach>
  </table>
  </c:if>
   <hr> <a href="/controller/employee/addNewEmployee">Add Employee</a>


</body>
</html>