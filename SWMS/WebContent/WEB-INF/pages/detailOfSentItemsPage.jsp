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

<title>SWMS - Decrypted Message</title>
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


<title>SWMS - Inbox</title>

</head>
<body>
	<div id="wrapper">

		<jsp:include page="header.jsp" />

		<div id="page-wrapper">
			<div class="row">
				<div class="col-lg-12">
					<h1 class="page-header">Message Details</h1>

					<div class="row">
						<h3>
							<c:out value="To"></c:out>
						</h3>
						<c:out value="${message.receiver}"></c:out>
						<hr />


						<h3>
							<c:out value="Subject"></c:out>
						</h3>
						<c:out value="${message.subject}"></c:out>
						<hr />

						<h3>
							<c:out value="Date"></c:out>
						</h3>
						<c:out value="${message.time}"></c:out>
						<hr />

						<h3>
							<c:out value="Message"></c:out>
						</h3>
						<div style="word-wrap: break-word;">
							<pre>${message.message}</pre>
						</div>

						<br />

					</div>


					<!-- /.col-lg-12 -->
				</div>

				<!-- /#page-wrapper -->
			</div>

		</div>


		<!-- /#page-content-wrapper -->

	</div>


	<jsp:include page="footer.jsp" />

</body>
</html>