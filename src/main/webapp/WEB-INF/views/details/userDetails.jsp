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

	<div class="container">
	<div class="row">
		<div class="col-md-6">
			<div class="row">
				<div class="col-md-6">
						<div></div>
				</div>
				<div class="col-md-6 ">
					<div class="col-mb-2">
						<a href="#"><font size="1"> Update Password</font></a>
						<font size="1"> / </font> 
						<a href="#"><font size="1"> EditProfile</font></a>
						<font size="1"> / </font> 
						<a href="#"><font size="1"> Logout</font> </a>
				</div>
				</div>
			</div>
		</div>
	</div>
	</div>


	<div class="container-fluid">
		<div class="row">
			<div class="col-md-6">
				<div class="card">
					<div class="card-body">

						<div class="row">
							<div class="col-md-4">

								<div class="row ">
									<div class="col">
										<center>
											<img src="../resources/images/profile.png" alt="profile.img"
												style="width: 100%; height: 90%">
												<font size="1">Status: </font>
										</center>
									</div>
								</div>

							</div>
							<div class="col-md-8">
								<div class="card-header">
									<div class="row">
										<div class="col">
											<center>
												<h4>
													<i>My Profile</i>
												</h4>
												<hr />
												<div class="row">
													<div class="col">
														<font size="1"> Date: </font> 
													</div>
												</div>
											</center>
										</div>
									</div>
								</div>
							</div>
						</div>
					</div>

					<div class="card-body">
						<div class="row">
							<div class="col-md-3">
								<div>
									<label>ROLE </label>
								</div>
							</div>
							<div class="col-md-9">
								<div class="col">
									<label>: ${user.role.name}</label>
								</div>
							</div>
						</div>

						<div class="row">
							<div class="col-md-3 ">
								<div>
									<label>ID </label>
								</div>
							</div>
							<div class="col-md-9">
								<div class="col">
									<label>: ${user.id}</label>
								</div>
							</div>
						</div>

						<div class="row">
							<div class="col-md-3">
								<div>
									<label>FIRSTNAME </label>
								</div>
							</div>
							<div class="col-md-9 ">
								<div class="col">
									<label>: ${user.fistname}</label>
								</div>
							</div>
						</div>

						<div class="row">
							<div class="col-md-3">
								<div>
									<label>LASTNAME: </label>
								</div>
							</div>
							<div class="col-md-9">
								<div class="col">
									<label>: ${user.lastname} </label>
								</div>
							</div>
						</div>

						<div class="row">
							<div class="col-md-3">
								<div>
									<label>USERNAME </label>
								</div>
							</div>
							<div class="col-md-9">
								<div class="col">
									<label>: ${user.username}</label>
								</div>
							</div>
						</div>

						<div class="row">
							<div class="col-md-3">
								<div>
									<label>EMAIL </label>
								</div>
							</div>
							<div class="col-md-9">
								<div class="col">
									<label>: ${user.email}</label>
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