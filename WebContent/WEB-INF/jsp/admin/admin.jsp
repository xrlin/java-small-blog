<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<title>Insert title here</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<jsp:include page="header.jsp"></jsp:include>

<h1>Write Your Post</h1>
<br />
<form:form modelAttribute="post" method="POST"
	action="/SpringmvcMessagebox/admin/addpost">
	<table>
		<tr>
			<td>title:</td>
			<td><form:input path="title" /></td>
			<%-- Show errors for firstName field --%>
			<td><form:errors path="title" /></td>
		</tr>
		<tr>
			<td>Content:</td>
			<td><form:textarea path="content" /></td>
			<%-- Show errors for lastName field --%>
			<td><form:errors path="content" /></td>
		</tr>
		<tr>
			<td colspan="3"><input type="submit" value="submit" /></td>
		</tr>
	</table>
</form:form>
</body>
</html>