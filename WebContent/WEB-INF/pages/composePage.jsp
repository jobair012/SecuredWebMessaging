<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page import="com.ckeditor.CKEditorConfig"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://ckeditor.com" prefix="ckeditor"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>SWMS - Compose</title>

<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/resources/bootstrap/css/bootstrap.css" />
<link
	href="${pageContext.request.contextPath}/resources/summernote/summernote.css"
	rel="stylesheet">
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/resources/customeStyle/style.css" />


<script
	src="${pageContext.request.contextPath}/resources/jquery/jquery-2.2.2.min.js"></script>
<script
	src="${pageContext.request.contextPath}/resources/bootstrap/js/bootstrap.js"></script>
<script
	src="${pageContext.request.contextPath}/resources/summernote/summernote.js"></script>
<script
	src="${pageContext.request.contextPath}/resources/scripts/scripts.js"></script>

</head>


<body>
	<form action="${pageContext.request.contextPath}/logout" method="post"
		id="logoutForm">
		<input type="hidden" name="${_csrf.parameterName}"
			value="${_csrf.token}" />
	</form>

	<c:if test="${pageContext.request.userPrincipal.name != null}">
		<p>
			<span>Hi, ${pageContext.request.userPrincipal.name}</span> | <a
				href="javascript:formSubmit()"> Logout</a>
		</p>
	</c:if>

	Hello, I'm logged in :-)

	<hr>

	<div id="wrapper">

		<!-- Sidebar -->
		<jsp:include page="sidebar.jsp" />
		
		<div id="page-content-wrapper">
			<div class="container-fluid">
				<div class="row">
					<form:form class="form-horizontal"
						action="${pageContext.request.contextPath}/home/push"
						method="post" commandName="message">

						<form:hidden path="sender"
							value="${pageContext.request.userPrincipal.name}" />
						<form:hidden path="date" value="${date}" />
						<fieldset>

							<!-- Form Name -->
							<legend>Compose Message</legend>

							<!-- Text input-->
							<div class="form-group">
								<label class="col-md-4 control-label" for="receiver">To</label>
								<div class="col-md-5">
									<form:input path="receiver" required="required" id="receiver"
										name="receiver" placeholder="Receiver Username"
										class="form-control input-md" />

								</div>
							</div>

							<!-- Text input-->
							<div class="form-group">
								<label class="col-md-4 control-label" for="subject">Subject</label>
								<div class="col-md-5">
									<form:input path="subject" id="subject" name="subject"
										placeholder="Subject" class="form-control input-md" />

								</div>
							</div>


							<!-- Textarea -->
							<div class="form-group">
								<label class="col-md-4 control-label" for="message">Message</label>
								<div class="col-md-5">
									<form:textarea path="message" id="textAreaForMessage"
										class="form-control" required="required" />
								</div>
							</div>


							<!-- Button (Double) -->
							<div class="form-group">
								<label class="col-md-4 control-label" for="button1id"></label>
								<div class="col-md-8">
									<input type="submit" name="submission" id="button1id"
										class="btn btn-primary" value="Send" /> <input type="submit"
										name="submission" id="button1id" class="btn btn-default"
										value="Encrypt" />
								</div>
							</div>

						</fieldset>
					</form:form>

				</div>
			</div>
		</div>

		<!-- /#page-content-wrapper -->


	</div>

</body>
</html>