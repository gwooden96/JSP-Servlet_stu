<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-GLhlTQ8iRABdZLl6O3oVMWSktQOp6b7In1Zl3/Jr59b6EGGoI1aFkw7cmDA6j6gD"
	crossorigin="anonymous">
</head>
<body>

	<nav class="navbar navbar-dark bg-dark">
		<div class="container-fluid">
			<div>
				<a class="btn btn-outline-light" href="index.jsp">메인페이지</a>
				<a class="btn btn-outline-light" href="listAll.do">게시판</a>
				<a class="btn btn-outline-light" href="write.do">글작성</a>
			
				<c:if test="${empty loginUser}">
					<a class="btn btn-outline-light" href="login.jsp">로그인</a>
				</c:if>
				<c:if test="${!empty loginUser}">
					<a class="btn btn-outline-light" href="logout.do">로그아웃</a>
				</c:if>
			</div>
			<form class="d-flex" method="get" action="listAll.do">
				<input class="form-control me-2" type="search" name="search" placeholder="검색어 입력">
				<input class="btn btn-outline-success" type="submit" value="검색">
			</form>
		</div>
	</nav>

</body>
</html>