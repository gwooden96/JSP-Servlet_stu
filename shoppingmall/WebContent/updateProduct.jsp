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
	<h1>상품수정</h1>
	<c:if test="${empty product.pictureurl}">
		<h3>등록된 이미지가 없습니다.</h3>
	</c:if>
	<c:if test="${!empty product.pictureurl}">
		<img src="upload/${product.pictureurl}" width="100px" height="100px">
	</c:if>
	<form method="post" action="update.do" enctype="multipart/form-data">
		상품명 : <input type="text" name="name" value="${product.name}"><br>
		가격 : <input type="text" name="price" value="${product.price}"><br>
		사진 : <input type="file" name="pictureurl"><br>
		설명 : <textarea rows="5" cols="50" name="description">${product.description}</textarea><br>
		<input type="hidden" name="code" value="${product.code}">
		<input type="submit" value="수정">
		<input type="button" value="목록" onclick="location.href='list.do'">
	</form>

		<h3>${msg}</h3>
</body>
</html>