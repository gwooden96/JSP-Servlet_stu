<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ include file="header.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>환영합니다</h1>
		<c:if test="${loginUser.id != null}">
			<h2><strong style="color: red">${loginUser.name}</strong>님  환영합니다.</h2>
		</c:if>
		
		<c:if test="${loginUser.id == null}">
			<h2><strong style="color: red">비회원님</strong>님  환영합니다.</h2>
		</c:if>

</body>
</html>