<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Jobs</title>
</head>
<body>


	<div class="container">
		<div class="col nav justify-content-center mb-3">
			<font color="black" size="6">EDIT USER</font>
		</div>
		<hr>
		<form:form method="post" action="" modelAttribute="job">
			<form:hidden path="id" />
			<table>
				<tbody>
					<tr>
						<td>Job Title</td>
						<td>: <form:input path="title" /></td>
						<td><font color="red"><form:errors path="title" /></font></td>
					</tr>
					<tr>
						<td>Max Salary</td>
						<td>: <form:input path="maxSalary" /></td>
						<td><font color="red"><form:errors path="maxSalary" /></font></td>
					</tr>
					<tr>
						<td>Min Salary</td>
						<td>: <form:input path="minSalary" /></td>
						<td><font color="red"><form:errors path="minSalary" /></font></td>
					</tr>
					<tr>
						<td></td>
						<td><button type="submit">Delete</button></td>
					</tr>
				</tbody>
			</table>
		</form:form>
	</div>


</body>
</html>