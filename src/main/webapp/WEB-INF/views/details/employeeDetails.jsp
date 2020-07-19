<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    <%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<title>Profile</title>
</head>
<body>

	<div class="container-fluid">
		<div class="row">
			<div class="col-md-8">
				<div class="card">
					<div class="card-header">
						<center>
							<font size="4">Employee Detail</font>
						</center>
					</div>


					<div class="card-body">
						<div class="row">
							<div class="col-md-5">
								<div>
									<label>ID </label>
								</div>
							</div>
							<div class="col-md-7 ">
								<div class="col">
									<label>: ${employee.id}</label>
								</div>
							</div>
						</div>
						
						<div class="row">
							<div class="col-md-5">
								<div>
									<label>FIRSTNAME </label>
								</div>
							</div>
							<div class="col-md-7 ">
								<div class="col">
									<label>: ${employee.firstName}</label>
								</div>
							</div>
						</div>

						<div class="row">
							<div class="col-md-5">
								<div>
									<label>LASTNAME </label>
								</div>
							</div>
							<div class="col-md-7">
								<div class="col">
									<label>: ${employee.lastName} </label>
								</div>
							</div>
						</div>
						
						<div class="row">
							<div class="col-md-5">
								<div>
									<label>EMAIL: </label>
								</div>
							</div>
							<div class="col-md-7">
								<div class="col">
									<label>: ${employee.email}</label>
								</div>
							</div>
						</div>
						
						<div class="row">
							<div class="col-md-5">
								<div>
									<label>SALARY </label>
								</div>
							</div>
							<div class="col-md-7">
								<div class="col">
									<label>: ${employee.salary}</label>
								</div>
							</div>
						</div>
						
						<div class="row">
							<div class="col-md-5">
								<div>
									<label>PHONENUMBER </label>
								</div>
							</div>
							<div class="col-md-7">
								<div class="col">
									<label>: ${employee.phoneNumber}</label>
								</div>
							</div>
						</div>
						
						<div class="row">
							<div class="col-md-5">
								<div>
									<label>HIREDATE </label>
								</div>
							</div>
							<div class="col-md-7">
								<div class="col">
									<label>: ${employee.hireDate}</label>
								</div>
							</div>
						</div>
						
						<div class="row">
							<div class="col-md-5 ">
								<div>
									<label>DEPARTMENT</label>
								</div>
							</div>
							<div class="col-md-7">
								<div class="col">
									<label>: ${employee.department.name}</label>
								</div>
							</div>
						</div>
						
						<div class="row">
							<div class="col-md-5">
								<div>
									<label>JOB </label>
								</div>
							</div>
							<div class="col-md-7">
								<div class="col">
									<label>: ${employee.job.title}</label>
								</div>
							</div>
						</div>
					
					</div>
				</div>
			</div>
		</div>
	</div>
</body>
</html>