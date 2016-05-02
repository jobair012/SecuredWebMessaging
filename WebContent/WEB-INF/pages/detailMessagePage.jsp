<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>SWMS - Message Details</title>
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/resources/bootstrap/css/bootstrap.css" />
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/resources/customeStyle/style.css" />
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
		<jsp:include page="sidebar.jsp"></jsp:include>
		<div id="page-content-wrapper">
			<div class="container-fluid">
				<div class="row">
					<h3>
						<c:out value="From"></c:out>
					</h3>
					<c:out value="${message.sender}"></c:out>
					<hr />


					<h3>
						<c:out value="Subject"></c:out>
					</h3>
					<c:out value="${message.subject}"></c:out>
					<hr />

					<h3>
						<c:out value="Date"></c:out>
					</h3>
					<c:out value="${message.date}"></c:out>
					<hr />

					<h3>
						<c:out value="Message"></c:out>
					</h3>
					<div style="word-wrap: break-word;">
						<pre>${message.message}</pre>
					</div>

					<br />


					<form:form
						action="${pageContext.request.contextPath}/home/inbox/decryptMessage"
						method="post" commandName="message">

						<form:hidden path="sender" value="${message.sender}" />
						<form:hidden path="subject" value="${message.subject}" />
						<form:hidden path="date" value="${message.date}" />
						<form:hidden path="message" value="${message.message}" />

						<form:button>Decrypt</form:button>

					</form:form>

				</div>
			</div>
		</div>
		<!-- /#page-content-wrapper -->

	</div>


</body>
</html>