<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>SWMS - Signup</title>
</head>
<body>
	<table>
		<form:form action="register" method="post" commandName="user">
			<h2>Fill the following form please!</h2>
			<tr>
				<td>Name:</td>
				<td><form:input path="name" placeholder="Ex. Jobair Hossain"
						required="required" /></td>
			</tr>
			<tr>
				<td>Username:</td>
				<td><form:input path="username" placeholder="Ex. jobair012"
						required="required" /></td>
			</tr>
			<tr>
				<td>Password:</td>
				<td><form:password path="password" placeholder="*******"
						required="required" /></td>
			</tr>
			<tr>
				<td>Confirm Password:</td>
				<td><form:password path="" required="required" /></td>
			</tr>
			<tr>
				<td>Email:</td>
				<td><form:input type="email" path="email"
						placeholder="ex. jobair012@gmail.com" required="required" /></td>
			</tr>
			<tr>
				<td></td>
				<td><form:checkbox path="" value="agree" required="required" /><a
					href="${pageContext.request.contextPath}/tandc">I agree to the
						terms &amp; condition</a></td>
			</tr>
			<tr>
				<td><input type="reset" value="Reset" /></td>
				<td><form:button>Signup</form:button></td>
			</tr>
			<tr>
		</form:form>
	</table>
</body>
</html>