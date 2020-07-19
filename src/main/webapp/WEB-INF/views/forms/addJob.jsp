<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>ADD JOB</title>
</head>
<body>


	<div class="container">
		<div class="col nav justify-content-center mb-3">
			<font color="black" size="6">ADD JOB</font>
		</div>
		<hr>
		<div class="row">
			<div class="col-md-8">
				<form:form method="post" action="/controller/job/addNewJob" modelAttribute="job">
					<table class="table">
						<tbody>
							<tr>
								<td>Job Title</td>
								<td> <form:input class="form-control" path="title" /></td>
								<td> <font color="red"><form:errors path="title"/></font></td>
							</tr>
							<tr>
								<td>Max Salary</td>
								<td> <form:input class="form-control" path="maxSalary" /></td>
								<td> <font color="red"><form:errors path="maxSalary"/></font></td>
							</tr>
							<tr>
								<td>Min Salary</td>
								<td> <form:input class="form-control" path="minSalary" /></td>
								<td> <font color="red"><form:errors path="minSalary"/></font></td>
							</tr>
							<tr>
								<td></td>
								<td><button class="btn btn-info" type="submit">Save</button></td>
							</tr>
						</tbody>
					</table>
				</form:form>
			</div>
		</div>
	</div>


</body>
</html>