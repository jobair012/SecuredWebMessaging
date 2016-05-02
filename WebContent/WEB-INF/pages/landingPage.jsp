<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>


<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Secured Web Messaging</title>
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/resources/bootstrap/css/bootstrap.css" />
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/resources/customeStyle/style.css" />
</head>

<body onload="document.loginForm.userName.focus();"
	class="langingPageBody">

	<c:if test="${pageContext.request.userPrincipal.name != null}">
		<jsp:forward page="homePage.jsp"></jsp:forward>
		
		
	</c:if>

	<c:if test="${not empty error}">
		<div class="error">${error}</div>
	</c:if>

	<div class="container">
		<div class="row">
			<div class="col-md-4 col-md-offset-7">
				<div class="panel panel-default">
					<div class="panel-heading">
						<strong class="">Login</strong>

					</div>
					<div class="panel-body">
						<form class="form-horizontal" role="form" name="loginForm"
							action="<c:url value="/login" />" method="POST">
							<div class="form-group">
								<label for="inputEmail3" class="col-sm-3 control-label">Username</label>
								<div class="col-sm-9">
									<input class="form-control" id="inputEmail3" name="username"
										placeholder="Username" required="" type="text">
								</div>
							</div>
							<div class="form-group">
								<label for="inputPassword3" class="col-sm-3 control-label">Password</label>
								<div class="col-sm-9">
									<input class="form-control" id="inputPassword3" name="password"
										placeholder="Password" required="" type="password">
								</div>
							</div>
							<div class="form-group">
								<div class="col-sm-offset-3 col-sm-9">
									<div class="checkbox">
										<label class=""> <input class="" type="checkbox"
											name="remember-me">Remember me
										</label>
									</div>
								</div>
							</div>
							<div class="form-group last">
								<div class="col-sm-offset-3 col-sm-9">
									<button type="submit" class="btn btn-primary btn-sm">Sign
										in</button>
									<button type="reset" class="btn btn-default btn-sm">Reset</button>
								</div>
							</div>
							<input type="hidden" name="${_csrf.parameterName}"
								value="${_csrf.token}" />
						</form>
					</div>
					<div class="panel-footer">
						Not Registered? <a
							href="${pageContext.request.contextPath}/signup" class="">Register
							here</a>
					</div>
				</div>
			</div>
		</div>
	</div>
</body>
</html>