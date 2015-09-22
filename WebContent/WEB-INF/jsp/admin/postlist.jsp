<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<title>Insert title here</title>
</head>
<body>
<jsp:include page="header.jsp"></jsp:include>
<table border="1">
	<tr style="background-color:gray;">
		<td>id</td><td>title</td><td>content</td><td></td>
	</tr>
	<c:forEach items="${posts }" var="post">
		<tr>
		<td>${post.id}</td><td>${post.title }</td><td>${post.content }</td><td><a href="/SpringmvcMessagebox/admin/delete/post/${post.id }">删除</a>&nbsp;<a href="/SpringmvcMessagebox/admin/edit/post/${post.id }">编辑</</a></td>
		</tr>
	</c:forEach>
</table>
</body>
</html>
