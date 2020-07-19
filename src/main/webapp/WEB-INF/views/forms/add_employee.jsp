<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    <%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<title>Save Employee</title>
</head>
<body>

	<div class="container-fluid">
		<div class="row">
			<div class="col-md-8">
				<div class="card">
					<div class="card-header">
						<center>
							<font size="4">Save Employee</font>
						</center>
					</div>


					<div class="card-body">
					
					<form:form action="/controller/employee/saveEpmloyee" method="post" modelAttribute="employee">
						
						<div class="row">
							<div class="col-md-3">
								<div>
									<label>FIRSTNAME </label>
								</div>
							</div>
							<div class="col-md-5">
								<div class="col">
									<form:input path="firstName"/>
								</div>
							</div>
							<div class="col-md-4">
								<div class="col">
									<font color="red"><form:errors path="firstName"/></font>
								</div>
							</div>
						</div>

						<div class="row">
							<div class="col-md-3">
								<div>
									<label>LASTNAME </label>
								</div>
							</div>
							<div class="col-md-5">
								<div class="col">
									<form:input path="lastName"/>
								</div>
							</div>
							<div class="col-md-4">
								<div class="col">
									<font color="red"><form:errors path="lastName"/></font>
								</div>
							</div>
						</div>
						
						<div class="row">
							<div class="col-md-3">
								<div>
									<label>EMAIL </label>
								</div>
							</div>
							<div class="col-md-5">
								<div class="col">
									<form:input path="email"/>
								</div>
							</div>
							<div class="col-md-4">
								<div class="col">
									<font color="red"><form:errors path="email"/></font>
								</div>
							</div>
						</div>
						
						<div class="row">
							<div class="col-md-3">
								<div>
									<label>SALARY </label>
								</div>
							</div>
							<div class="col-md-5">
								<div class="col">
									<form:input path="salary"/>
								</div>
							</div>
							<div class="col-md-4">
								<div class="col">
									<font color="red"><form:errors path="salary"/></font>
								</div>
							</div>
						</div>
						
						<div class="row">
							<div class="col-md-3">
								<div>
									<label>PHONENUMBER </label>
								</div>
							</div>
							<div class="col-md-5">
								<div class="col">
									<form:input path="phoneNumber"/>
								</div>
							</div>
							<div class="col-md-4">
								<div class="col">
									<font color="red"><form:errors path="phoneNumber"/></font>
								</div>
							</div>
						</div>
						
						<div class="row">
							<div class="col-md-3">
								<div>
									<label>HIREDATE </label>
								</div>
							</div>
							<div class="col-md-5">
								<div class="col">
<%-- 									<form:input path="hireDate"/> --%>
								</div>
							</div>
							<div class="col-md-4">
								<div class="col">
									<font color="red"><form:errors path="hireDate"/></font>
								</div>
							</div>
						</div>
						
						<div class="row">
							<div class="col-md-3 ">
								<div>
									<label>DEPARTMENT</label>
								</div>
							</div>
							<div class="col-md-5">
								<div class="col">
									<form:select path="department.name">
										<form:option value="Bilisim" label="Bilişim" />
										<form:option value="Personel" label="Personel" />
										<form:option value="Insan Kaynaklari" label="İnsan Kaynakları" />
										<form:option value="Uretim" label="Üretim" />
										<form:option value="Pazarlama" label="Pazarlama" />
										<form:option value="Halkla Iliskiler" label="Halkla İşikiler" />
									</form:select>
								</div>
							</div>
							<div class="col-md-4">
								<div class="col">
									<font color="red"><form:errors path="department.name"/></font>
								</div>
							</div>
						</div>
						
						<div class="row">
							<div class="col-md-3">
								<div>
									<label>JOB </label>
								</div>
							</div>
							<div class="col-md-5">
								<div class="col">
									<form:select path="job.title">
										<form:option value="Kalite Kontrol" label="Kalite Kontrol" />
										<form:option value="Tester" label="Tester" />
										<form:option value="Driver" label="Driver" />
										<form:option value="Planlama" label="Planlama" />
									</form:select>
								</div>
							</div>
							<div class="col-md-4">
								<div class="col">
									<font color="red"><form:errors path="job.title"/></font>
								</div>
							</div>
						</div>
						<div class="row">
							<div class="col-md-4">
								<div>
							
								</div>
							</div>
								<div class="col-md-8"> 
								<div class="col">
										<button class="btn btn-info" type="submit">Save</button>
								</div>
							</div>
						</div>
					</form:form>
					</div>
				</div>
			</div>
		</div>
	</div>
</body>
</html>