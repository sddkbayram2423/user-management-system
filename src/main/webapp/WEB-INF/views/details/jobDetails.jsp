<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form"  prefix="form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Employee</title>
</head>
<body>
<div class="container">
	<div class="col nav justify-content-center mb-3">
		<font color="black" size="6">Job Details</font>
	</div>
    <hr>
		<table>
			<tbody>
				<tr>
					<td>ID</td>
					<td>: ${job.id}
					</td>
				</tr>
				<tr>
					<td>Job Title</td>
					<td>: ${job.title}
					</td>
				</tr>
				<tr>
					<td>Max Salary</td>
					<td>: ${job.maxSalary}
					</td>
				</tr>
				<tr>
					<td>Min Salary</td>
					<td>: ${job.minSalary}
					</td>
				</tr>
			</tbody>
		</table>
	</div>
<div class="container">
  <c:if test="${empty job.employees}">
  	<h3>There are any employee!!!</h3>
  </c:if>  
  
  <c:if test="${not empty job.employees}">   
  <hr>
  <div class="col nav justify-content-center mb-3">
		<font color="black" size="4">Employees</font>
	</div>
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
    <c:forEach items="${job.employees}" var="employee">
    <tbody>
      <tr>
        <td>${employee.id}</td>
        <td>${employee.firstName}</td>
        <td>${employee.lastName}</td>
        <td>${employee.email}</td>
        <td>${employee.phoneNumber}</td>
        <td>${employee.salary}</td>
        <td>${employee.hireDate}</td>
      </tr>
    </tbody>
    </c:forEach>
  </table>
  </c:if>
</div>


</body>
</html>