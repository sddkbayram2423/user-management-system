<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<html>
<head>
<title>Spring Tiles Contact Form</title>
</head>
<body>
	<div class="container-fluid">
		<div class="row">
			<div class="col-md-8">
				<div class="card">
					<div class="card-body">
						<form:form class="form" modelAttribute="userDto" method="post" action="/controller/verificationToken/veriVicationTokenForNewUser">

							<div class="form-col">

								<div class="row mb-3">
									<div class="col alert alert-info nav justify-content-center mb-3">
										<font color="black">REGISTER FORM</font>
									</div>
								</div>

								<div class="row mb-3">
									<div class="col-md-8">
										<form:input path="fistname" class="form-control" placeHolder="Your Firstname" />
									</div>
									<div class="col-md-4">
										<font color="red"><form:errors path="fistname"/></font>
									</div>
								</div>

								<div class="row mb-3">
									<div class="col-md-8">
										<form:input path="lastname" class="form-control" placeHolder="Your Lastname" />
									</div>
									<div class="col-md-4">
										<font color="red"><form:errors path="lastname"/></font>
									</div>
								</div>
								<div class="row mb-3">
									<div class="col-md-8">
										<form:input path="username" class="form-control" placeHolder="Your Username" />
									</div>
									<div class="col-md-4">
										<font color="red"><form:errors path="username"/></font>
									</div>
								</div>
								
								<div class="row mb-3">
									<div class="col-md-8">
										<form:input path="email" class="form-control" placeHolder="Your Email" />
									</div>
									<div class="col-md-4">
										<font color="red"><form:errors path="email"/></font>
									</div>
								</div>
								
								<div class="row mb-3">
									<div class="col-md-8">
										<form:password path="password" class="form-control" placeHolder="Your Password" />
									</div>
									<div class="col-md-4">
										<font color="red"><form:errors path="password"/></font>
									</div>
								</div>
								
								<div class="row mb-3">
									<div class="col-md-8">
										<form:password path="matchingPassword" class="form-control" placeHolder="Repeat Your Password" />
									</div>
									<div class="col-md-4">
										<font color="red"><form:errors path="matchingPassword"/></font>
									</div>
								</div>
							</div>
							<div class="row mb-3">
								<div class="col">
									<button class="btn btn-block btn-outline-danger" type="submit">Sign Up</button>
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
