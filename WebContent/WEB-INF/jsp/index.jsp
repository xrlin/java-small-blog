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
	<%@ include file="header.jsp"%>
	<div class="container">
		<div>

			<div class="row">
				<c:forEach items="${posts}" var="post">
					<div class="col-sm-12 col-md-12">

						<div class="thumbnail">
							<!--  <img src="..." alt="...">-->
							<div class="caption">
								<h3>${post.title}</h3>
								<p>${post.content }</p>
								<!--  <p>
									<a href="#" class="btn btn-primary" role="button">Button</a> <a
										href="#" class="btn btn-default" role="button">Button</a>
								</p>
								-->
							</div>
						</div>

					</div>
				</c:forEach>
			</div>
			<nav>
			<ul class="pagination">
				<li><a
					href="index?page=${(currentPage - 1) ge 1 ? (currentPage - 1) : currentPage}"
					aria-label="Pre"> <span aria-hidden="true">&laquo;</span>
				</a></li>
				<c:forEach var="num" begin="1" end="${totalNum }" step="1">
					<c:choose>
						<c:when test="${currentPage eq num }">
							<li class="active"><a href="index?page=${num}">${num }</a></li>
						</c:when>
						<c:otherwise>
							<li><a href="index?page=${num}">${num }</a></li>
						</c:otherwise>
					</c:choose>

				</c:forEach>
				<li><a
					href="index?page=${(currentPage + 1) le totalNum ? (currentPage + 1) : currentPage}"
					aria-label="Next"> <span aria-hidden="true">&raquo;</span>
				</a></li>
			</ul>
			</nav>
		</div>
	</div>
</body>
</html>