<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

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
					<h1 class="page-header">Inbox</h1>


					<table class="table table-hover">
						<tr>
							<th><c:out value="From"></c:out></th>
							<th><c:out value="Subject"></c:out></th>
							<th><c:out value="Date"></c:out></th>
						</tr>
						<c:forEach var="message" items="${messages}">
							<tr>
								<td><c:out value="${message.sender}"></c:out></td>
								<td><c:out value="${message.subject}"></c:out></td>
								<td><c:out value="${message.time}"></c:out></td>
								<td><a
									href="${pageContext.request.contextPath}/home/inbox/viewDetails?mid=${message.messageId}&from=${message.sender}">View
										Details</a></td>
							</tr>
						</c:forEach>
					</table>
				</div>
			</div>

		</div>


		<!-- /#page-content-wrapper -->

	</div>


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