<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>Login</title>
</head>
<body>
		<br>
		<br>
	<div class="container">
		<div class="row">
			<div class="col-md-8">
				<div class="card">
				<div class="card-header">
					<div class="col-md-8">
						<center>
							<font size="3"><b>LOGIN</b></font>
						</center>
					</div>
				</div>
					
					<div class="card-body">
						<form:form class="form" modelAttribute="userLogin"  action="/controller/login/userLogin" method="POST">

							<div class="form-col">
								<div class="row mb-3 mt-4">
									<div class="col-md-2">
										<form:label path="username">Username </form:label>
									</div>
									<div class="col-md-5">
										<form:input path="username" class="form-control" />
									</div>
									<div class="col-md-5">
										<font color="red"><form:errors path="username"/></font>
									</div>
								</div>

								<div class="row mb-3">
									<div class="col-md-2">
										<form:label path="password">Password </form:label>
									</div>
									<div class="col-md-5">
										<form:password path="password" class="form-control" />
									</div>
									<div class="col-md-5">
										<font color="red"><form:errors path="password"/></font>
									</div>
								</div>
								
								<div class="row mb-7">
									<div class="col-md-2">
									</div>
									<div class="col">
										<button class="btn btn-info" type="submit">Log In</button>
									</div>
								</div>
								<div class="row">
									<div class="col-md-5">
									</div>
									<div class="col-md-7">
										<a href="/controller/forgotPassword/goForgotResetPasswordForm"><font size="1" color="blue">Forgot Password</font> </a>
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