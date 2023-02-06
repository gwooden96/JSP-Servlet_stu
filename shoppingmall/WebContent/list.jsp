<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>  
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>상품목록</h1>
	<table border=1>
		<tr>
			<th>번호</th>
			<th>이름</th>
			<th>가격</th>
			<th>설명</th>
			<th>수정</th>
			<th>삭제</th>
		</tr>
		<c:forEach var="product" items="${products}">
			<tr>
				<td>${product.code}</td>
				<td>${product.name}</td>
				<td>${product.price}</td>
				<td>${product.description}</td>
				<td>
					<a href="update.do">수정</a>
				</td>
				<td>
					<a href="delete.do">삭제</a>
				</td>
			</tr>
		</c:forEach>
	</table>
	<a href="addProduct.jsp">상품등록페이지</a>
</body>
</html>