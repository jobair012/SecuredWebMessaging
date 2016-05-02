<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>SWMS - Keys</title>
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
					<table>
						<tr>
							<td>N:</td>
							<td><c:out value="${userKeys.key_N}"></c:out></td>
						</tr>
						<tr>
							<td>E:</td>
							<td><c:out value="${userKeys.key_E}"></c:out></td>
						</tr>
						<tr>
							<td>D:</td>
							<td><c:out value="${userKeys.key_D}"></c:out></td>
						</tr>


					</table>
				</div>
			</div>
		</div>
		<!-- /#page-content-wrapper -->

	</div>




</body>
</html>