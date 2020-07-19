<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>Login</title>
</head>
<body>
	<div class="container">
		<div class="row">
			<div class="col-md-8 ">

				<div class="row">
					<div class="col-md-8">
						<hr>
						<center>
							<font size="3"><b>YOUR EMAIL</b></font>
						</center>
					</div>
				</div>
					<div class="card">
					<div class="card-body">
						<form:form class="form" modelAttribute="passwordForgotDto"  action="/controller/forgotPassword/resetForgotPassword" method="POST">
							
							 <div class="form-col">
								<div class="row mb-3 mt-4">
									<div class="col-md-2">
										<form:label path="email">Email :</form:label>
									</div>
									<div class="col-md-5">
										<form:input path="email" class="form-control" />
									</div>
									<div class="col-md-5">
										<font color="red"><form:errors path="email" /></font>
									</div>
								</div>


								<div class="row mb-7">
									<div class="col-md-2"></div>
									<div class="col">
										<button class="btn btn-info" type="submit">Send Reset
											Token</button>
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