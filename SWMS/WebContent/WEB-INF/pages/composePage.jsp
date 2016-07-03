<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>SWMS - Compose</title>

<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/resources/bootstrap/css/bootstrap.css" />

<link
	href="${pageContext.request.contextPath}/resources/summernote/summernote.css"
	rel="stylesheet">

<!-- Timeline CSS -->
<link
	href="${pageContext.request.contextPath}/resources/startbootstrap/dist/css/timeline.css"
	rel="stylesheet">

<!-- Custom CSS -->
<link
	href="${pageContext.request.contextPath}/resources/startbootstrap/dist/css/sb-admin-2.css"
	rel="stylesheet">

<!-- Morris Charts CSS -->
<link
	href="${pageContext.request.contextPath}/resources/startbootstrap/bower_components/morrisjs/morris.css"
	rel="stylesheet">

<!-- Custom Fonts -->
<link
	href="${pageContext.request.contextPath}/resources/startbootstrap/bower_components/font-awesome/css/font-awesome.min.css"
	rel="stylesheet" type="text/css">

<!-- MetisMenu CSS -->
<link
	href="${pageContext.request.contextPath}/resources/startbootstrap/bower_components/metisMenu/dist/metisMenu.min.css"
	rel="stylesheet">

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



	<div id="wrapper">

		<jsp:include page="header.jsp" />

		<div id="page-wrapper">
			<div class="row">

				<form:form class="form-horizontal"
					action="${pageContext.request.contextPath}/home/compose/push" method="post"
					commandName="message">

					<form:hidden path="sender"
						value="${pageContext.request.userPrincipal.name}" />
					<fieldset>

						<!-- Form Name -->
						<legend>Compose Message</legend>

						<!-- Text input-->
						<div class="form-group">
							<label class="col-md-2 control-label" for="receiver">To</label>
							<div class="col-md-8">
								<form:input path="receiver" required="required" id="receiver"
									name="receiver" placeholder="Receiver Username"
									class="form-control input-md" />

							</div>
							<form:errors path="receiver" cssClass="alert-danger" />
						</div>

						<!-- Text input-->
						<div class="form-group">
							<label class="col-md-2 control-label" for="subject">Subject</label>
							<div class="col-md-8">
								<form:input path="subject" id="subject" name="subject"
									placeholder="Subject" class="form-control input-md" />

							</div>
							<form:errors path="subject" cssClass="alert-danger" />
						</div>


						<!-- Textarea -->
						<div class="form-group">
							<label class="col-md-2 control-label" for="message">Message</label>
							<div class="col-md-8">
								<form:textarea path="message" id="textAreaForMessage"
									class="form-control" required="required" />
							</div>
							<form:errors path="message" cssClass="alert-danger" />
						</div>


						<!-- Button (Double) -->
						<div class="form-group">
							<label class="col-md-2 control-label" for="button1id"></label>
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

		<!-- /#page-content-wrapper -->


	</div>


	<!-- jQuery -->




	<!-- Metis Menu Plugin JavaScript -->
	<script
		src="${pageContext.request.contextPath}/resources/startbootstrap/bower_components/metisMenu/dist/metisMenu.min.js"></script>

	<!-- Morris Charts JavaScript -->
	<script
		src="${pageContext.request.contextPath}/resources/startbootstrap/bower_components/raphael/raphael-min.js"></script>
	<script
		src="${pageContext.request.contextPath}/resources/startbootstrap/bower_components/morrisjs/morris.min.js"></script>
	<script
		src="${pageContext.request.contextPath}/resources/startbootstrap/js/morris-data.js"></script>

	<!-- Custom Theme JavaScript -->
	<script
		src="${pageContext.request.contextPath}/resources/startbootstrap/dist/js/sb-admin-2.js"></script>
</body>
</html>