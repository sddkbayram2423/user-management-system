<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>EDIT USER</title>
</head>
<body>


	<div class="container">
		<div class="col nav justify-content-center mb-3">
			<font color="black" size="6">EDIT USER</font>
		</div>
		<hr>
		<form:form method="post" action="/controller/user/updateUser" modelAttribute="user">
			
			<table class="table table-responsive ">
				<form:hidden path="id" />
				<tbody>
					<tr>
						<td>Firstname</td>
						<td>: <form:input path="fistname" /></td>
						<td><font color="red"><form:errors path="fistname"/></font></td>
					</tr>
					<tr>
						<td>Lastname</td>
						<td>: <form:input path="lastname" /></td>
						<td><font color="red"><form:errors path="lastname"/></font></td>
					</tr>
					<tr>
						<td>Username</td>
						<td>: <form:input path="username" /></td>
						<td><font color="red"><form:errors path="username"/></font></td>
					</tr>
					<tr>
						<td>Email</td>
						<td>: <form:input path="email" /></td>
						<td><font color="red"><form:errors path="email"/></font></td>
					</tr>
					<tr>
						<td>Role</td>
						<td>: 
							<form:select path="role.name">
      							<form:option value="ADMIN" label="ADMIN"/>
     							<form:option value="USER" label="USER"/>
 							</form:select>
						</td>
						<td><font color="red"><form:errors path="role.name"/></font></td>
					</tr>

					<tr>
						<td>ENABLED</td>
						<td>: 
							<form:select path="enabled">
      							<form:option value="false" label="False"/>
     							<form:option value="true" label="True"/>
 							</form:select>
						</td>
						<td><font color="red"><form:errors path="enabled"/></font></td>
					</tr>

					<tr>
						<td>ACCOUNT NONEXPİRED</td>
						<td>: 
							<form:select path="accountNonExpired">
      							<form:option value="false" label="False"/>
     							<form:option value="true" label="True"/>
 							</form:select>
						</td>
						<td><font color="red"><form:errors path="accountNonExpired"/></font></td>
					</tr>

					<tr>
						<td>ACCOUNT NONLOCKED</td>
						<td>: 
							<form:select path="accountNonLocked">
      							<form:option value="false" label="False"/>
     							<form:option value="true" label="True"/>
 							</form:select>
						</td>
						<td><font color="red"><form:errors path="accountNonLocked"/></font></td>
					</tr>
					<tr>
						<td>CREDENTIALS NONEXPİRED</td>
						<td>: 
							<form:select path="credentialsNoneExpired">
      							<form:option value="false" label="False"/>
     							<form:option value="true" label="True"/>
 							</form:select>
						</td>
						<td><font color="red"><form:errors path="credentialsNoneExpired"/></font></td>
					</tr>


					<tr>
						<td></td>
						<td><button class="btn btn-info" type="submit">Update</button></td>
					</tr>
				</tbody>
				
			</table>
		</form:form>
	</div>


</body>
</html>