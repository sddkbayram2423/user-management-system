<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<html>
<head>
<title>ADD USER FORM</title>
</head>
<body>
	<div class="container-fluid">
		<div class="row">
			<div class="col-md-8">
				<div class="card">
					<div class="card-body">
						<form:form class="form" modelAttribute="userDto" method="post" action="/controller/user/saveUserForAdmin">

							<div class="form-col">

								<div class="row mb-3">
									<div class="col alert alert-info nav justify-content-center mb-3">
										<font color="black">ADD USER FORM</font>
									</div>
								</div>
								
								<div class="row mb-3">
									<div class="col-md-8">
										<form:input path="fistname" class="form-control" placeHolder="User Firstname" />
									</div>
									<div class="col-md-4">
										<font color="red"><form:errors path="fistname"/></font>
									</div>
								</div>

								<div class="row mb-3">
									<div class="col-md-8">
										<form:input path="lastname" class="form-control" placeHolder="User Lastname" />
									</div>
									<div class="col-md-4">
										<font color="red"><form:errors path="lastname"/></font>
									</div>
								</div>
								<div class="row mb-3">
									<div class="col-md-8">
										<form:input path="username" class="form-control" placeHolder="User Username" />
									</div>
									<div class="col-md-4">
										<font color="red"><form:errors path="username"/></font>
									</div>
								</div>
								
								<div class="row mb-3">
									<div class="col-md-8">
										<form:input path="email" class="form-control" placeHolder="User Email" />
									</div>
									<div class="col-md-4">
										<font color="red"><form:errors path="email"/></font>
									</div>
								</div>
								
								<div class="row mb-3">
									<div class="col-md-8">
										<form:password path="password" class="form-control" placeHolder="User Password" />
									</div>
									<div class="col-md-4">
										<font color="red"><form:errors path="password"/></font>
									</div>
								</div>
								
								<div class="row mb-3">
									<div class="col-md-8">
										<form:password path="matchingPassword" class="form-control" placeHolder="Repeat User Password" />
									</div>
									<div class="col-md-4">
										<font color="red"><form:errors path="matchingPassword"/></font>
									</div>
								</div>
							</div>
							<div class="row mb-3">
								<div class="col">
									<button class="btn btn-block btn-outline-danger" type="submit">Save</button>
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
