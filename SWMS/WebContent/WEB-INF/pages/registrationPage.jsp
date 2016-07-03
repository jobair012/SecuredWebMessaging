<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Registration Form</title>
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/resources/bootstrap/css/bootstrap.css" />
</head>
<body>
	<div class="container">
		<form:form action="${pageContext.request.contextPath}/doRegister"
			method="post" commandName="user" class="form-horizontal">
			<fieldset>

				<!-- Form Name -->
				<legend>User Registration</legend>

				<!-- Text input-->
				<div class="form-group">
					<label class="col-md-4 control-label" for="name">Name</label>
					<div class="col-md-6">
						<form:input id="name" name="name" placeholder="Your name"
							path="name" class="form-control input-md" required="" type="text" />
						<form:errors path="name" cssClass="alert-danger" />
					</div>
				</div>

				<!-- Text input-->
				<div class="form-group">
					<label class="col-md-4 control-label" for="email">Email</label>
					<div class="col-md-6">
						<form:input id="email" name="email" placeholder="Your email"
							path="email" class="form-control input-md" required=""
							type="text" />
						<form:errors path="email" cssClass="alert-danger" />
					</div>
				</div>

				<!-- Multiple Radios (inline) -->
				<div class="form-group">
					<label class="col-md-4 control-label" for="radios">Gender</label>
					<div class="col-md-4">
						<form:radiobuttons path="gender" items="${genders}" name="radios"
							id="radios" />

					</div>
					<form:errors path="gender" cssClass="alert-danger" />
				</div>

				<!-- Text input-->
				<div class="form-group">
					<label class="col-md-4 control-label" for="username">Username</label>
					<div class="col-md-6">
						<form:input id="username" name="username"
							placeholder="Your username" path="username"
							class="form-control input-md" required="" type="text" />
						<form:errors path="username" cssClass="alert-danger" />
					</div>
				</div>

				<!-- Password input-->
				<div class="form-group">
					<label class="col-md-4 control-label" for="password">Password</label>
					<div class="col-md-6">
						<form:input id="password" name="password" placeholder="* * * * *"
							path="password" class="form-control input-md" required=""
							type="password" />
						<form:errors path="password" cssClass="alert-danger" />
					</div>
				</div>

				<!-- Password input-->
				<div class="form-group">
					<label class="col-md-4 control-label" for="confirmPassword">Confirm
						Password</label>
					<div class="col-md-6">
						<form:input id="confirmPassword" name="confirmPassword"
							placeholder="" path="" class="form-control input-md" required=""
							type="password" />

					</div>
				</div>

				<!-- Multiple Checkboxes (inline) -->
				<div class="form-group">
					<label class="col-md-4 control-label" for="agreement"></label>
					<div class="col-md-4">
						<form:checkbox path="" value="agree" required="required" />
						<a href="${pageContext.request.contextPath}/tandc">I agree to
							the terms &amp; condition</a>
					</div>
				</div>

				<!-- Button (Double) -->
				<div class="form-group">
					<label class="col-md-4 control-label" for="submit"></label>
					<div class="col-md-8">
						<button type="submit" class="btn btn-primary btn-sm">Submit</button>
						<button type="reset" class="btn btn-default btn-sm">Reset</button>
						&nbsp;&nbsp;&nbsp;Already Registered? <a
							href="${pageContext.request.contextPath}/login" class="">Login
							here</a>
					</div>
				</div>

			</fieldset>
		</form:form>

	</div>
</body>
</html>