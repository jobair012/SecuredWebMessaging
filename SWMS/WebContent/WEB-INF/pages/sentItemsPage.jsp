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

<title>SWMS - Sent Items</title>

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


<title>SWMS - Sent Items</title>
</head>
<body>




	<div id="wrapper">

		<jsp:include page="header.jsp" />

		<div id="page-wrapper">
			<div class="row">
				<div class="col-lg-12">
					<h1 class="page-header">Sent Items</h1>


					<table class="table table-hover">
						<tr>
							<th><c:out value="To"></c:out></th>
							<th><c:out value="Subject"></c:out></th>
							<th><c:out value="Date"></c:out></th>
						</tr>
						<c:forEach var="message" items="${messages}">
							<tr>
								<td><c:out value="${message.receiver}"></c:out></td>
								<td><c:out value="${message.subject}"></c:out></td>
								<td><c:out value="${message.time}"></c:out></td>
								<td><a
									href="${pageContext.request.contextPath}/home/sent/viewSentItemsDetails?mid=${message.messageId}&receiver=${message.receiver}">View
										Details</a></td>
							</tr>
						</c:forEach>
					</table>

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