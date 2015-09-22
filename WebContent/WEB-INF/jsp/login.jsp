<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<title>Insert title here</title>
</head>
<body>
	<h1>login</h1>
	<br />
	<form:form modelAttribute="user" method="POST"
		action="/SpringmvcMessagebox/login">
		<table>
			<tr>
				<td>title:</td>
				<td><form:input path="username" /></td>
				<%-- Show errors for firstName field --%>
				<td><form:errors path="username" /></td>
			</tr>
			<tr>
				<td>Content:</td>
				<td><form:input path="password" type="password"/></td>
				<%-- Show errors for lastName field --%>
				<td><form:errors path="password" /></td>
			</tr>
			<tr>
				<td colspan="3"><input type="submit" value="submit" /></td>
			</tr>
		</table>
	</form:form>
</body>
</html>