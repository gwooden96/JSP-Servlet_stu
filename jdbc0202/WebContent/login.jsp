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
	<div class="container mx-auto p-5">
		<form method="post" action="login.do">
			<div class="mb-3">
				<label class="form-label">아이디</label>
				<input class="form-control" type="text" name="id">
				
				<label class="form-label">비밀번호</label>
				<input class="form-control" type="password" name="pw">
			</div>
			<input type="checkbox" value="자동로그인">
			<input class="btn btn-dark" type="submit" value="로그인">
		</form>
	<c:if test="${!empty msg}">
		<div class="alert alert-danger mt-3">
			${msg}
		</div>
	</c:if>
	</div>
</body>
</html>