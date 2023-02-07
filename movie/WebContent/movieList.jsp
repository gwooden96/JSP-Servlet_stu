<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="header.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<div class="contanier">
		<table class="table text-center">
			<thead class="table-light">
				<tr>
					<th>제목</th>
					<th>감독</th>
					<th>배우</th>
					<th>가격</th>
				</tr>
			</thead>
			<c:forEach var="mv" items="${movie}">
			<tr>
				<td>${mv.title}</td>
				<td>${mv.director}</td>
				<td>${mv.actor}</td>
				<td>${mv.price}</td>
			</tr>
			</c:forEach>
		</table>
	</div>
</body>
</html>