<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ include file="header.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<div class="container my-3 text-center">
		<table class="table table-striped">
			<thead class="table-dark">
				<tr>
					<th>번호</th>
					<th>제목</th>
					<th>작성자</th>
					<th>작성일자</th>
					<th>조회수</th>
				</tr>
			</thead>
			<!-- 향상된 for문 사용 -->
			<c:forEach var="board" items="${boards}">
				<tr>
					<td>${board.no}</td>
					<td><a href="showBoard.do?no=${board.no}">${board.title}</a></td>
					<td>${board.id}</td>
					<td>${board.postdate}</td>
					<td>${board.visitCount}</td>
				</tr>
			</c:forEach>
		</table>
		<!-- 일반적인 for문 사용 -->
			<c:forEach var='page' begin='1' end='${paging.totalPage}' step='1'>
				<c:choose >
					<c:when test="${page == paging.page}">
						<a class="btn btn-dark">${page}</a>
					</c:when>
					<c:otherwise>
						<!-- &search=${param.search} 추가로 해당 코르를 넣으면 검색했을때 다른 페이지로 이동했을때 초기화 되는 버그를 막아준다. -->
						<a class="btn btn-outline-dark" href="listAll.do?page=${page}&search=${param.search}">${page}</a>
					</c:otherwise>
				</c:choose>
			</c:forEach>
	</div>
</body>
</html>