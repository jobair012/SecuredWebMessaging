<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>SWMS - ENCRYPTED MESSAGE</title>

<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta name="description" content="">
<meta name="author" content="">

<title>SWMS - Inbox</title>

<script
	src="${pageContext.request.contextPath}/resources/scripts/scripts.js"></script>

<!-- Bootstrap Core CSS -->
<link
	href="${pageContext.request.contextPath}/resources/startbootstrap/bower_components/bootstrap/dist/css/bootstrap.min.css"
	rel="stylesheet">

<!-- MetisMenu CSS -->
<link
	href="${pageContext.request.contextPath}/resources/startbootstrap/bower_components/metisMenu/dist/metisMenu.min.css"
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
				<div class="col-lg-12">
					<h1 class="page-header">Encryption Process</h1>

					<form:form
						action="${pageContext.request.contextPath}/home/compose/push/send"
						method="post" commandName="message">

						<form:hidden path="" name="plainMessage" value="${plainMessage}" />

						<form:hidden path="sender" value="${message.sender}" />
						<form:hidden path="receiver" value="${message.receiver}" />
						<form:hidden path="message" value="${message.message}" />
						<form:hidden path="subject" value="${message.subject}" />

						<table class="table table-hover">
							<tr>
								<td>Receiver ID:</td>
								<td><c:out value="${message.receiver}" /></td>
							</tr>
							<tr>
								<td>Subject:</td>
								<td><c:out value="${message.subject}" /></td>
							</tr>
							<tr>
								<td>Message:</td>
								<td style="word-wrap: break-word;"><c:out
										value="${message.message}" /></td>
							</tr>
							<tr>
								<td></td>
								<td><input type="submit" name="submission" value="Send" /></td>
							</tr>
						</table>
					</form:form>
				</div>
			</div>
		</div>
	</div>

	<jsp:include page="footer.jsp" />
</body>
</html>