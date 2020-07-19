<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="ISO-8859-1"%>
 <%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

<div class="container">
	<div class="col nav justify-content-center mb-3">
		<font color="black" size="6">RESET PASSWORD</font>
	</div>
    <hr>
		<form:form method="post" action="/controller/forgotPassword/updatePasword" modelAttribute="newPasswordDto">
			<table class="table table-responsive ">
				<tbody>

					<tr>
						<td></td>
						<td><form:hidden path="userId" /></td>
					</tr>
					<tr>
						<td>NEW PASSWORD</td>
						<td>: <form:password path="newPassword" />
						</td>
						<td><font color="red"><form:errors path="newPassword" /></font></td>
					</tr>
					<tr>
						<td>REPEAT NEW PASSWORD</td>
						<td>: <form:password path="newMatchingPassword" />
						</td>
						<td><font color="red"><form:errors path="newMatchingPassword" /></font></td>
					</tr>
					<tr>
						<td></td>
						<td><button type="submit">Update</button></td>
					</tr>
				</tbody>
			</table>
		</form:form>
	</div>
	
	
	
	
	
	
	
	
	
	
</body>
</html>