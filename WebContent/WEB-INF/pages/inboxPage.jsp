<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/resources/bootstrap/css/bootstrap.css" />
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/resources/customeStyle/style.css" />
<script
	src="${pageContext.request.contextPath}/resources/scripts/scripts.js"></script>
<title>SWMS - Inbox</title>
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
					<table class="table table-hover">
						<tr>
							<th><c:out value="From"></c:out></th>
							<th><c:out value="Subject"></c:out></th>
							<th><c:out value="Date"></c:out></th>
						</tr>
						<c:forEach var="messages" items="${messages}">
							<tr
								href="${pageContext.request.contextPath}/home/inbox/viewDetails?mid=${messages.messageId}&from=${messages.sender}">

								<td><c:out value="${messages.sender}"></c:out></td>
								<td><c:out value="${messages.subject}"></c:out></td>
								<td><c:out value="${messages.date}"></c:out></td>
								<td><a
									href="${pageContext.request.contextPath}/home/inbox/viewDetails?mid=${messages.messageId}&from=${messages.sender}">View
										Details</a></td>
							</tr>
						</c:forEach>
					</table>
				</div>
			</div>
		</div>
		<!-- /#page-content-wrapper -->

	</div>

</body>
</html>