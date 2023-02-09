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
	<div class="container mt-5">
		<form method="post" action="board?command=writeSaveBtn">
			<div class="mb-3">
				<label class="form-label">글 제목</label>
				<input class="form-control" type="text" name="title">
			</div>
			<div class="mb-3">
				<label class="form-label">글 내용</label>
				<textarea class="form-control" rows="5" name="content"></textarea>
			</div>
			<input type="hidden" name="id" value="${loginUser.id}">
			
			<input class="btn btn-outline-dark" type="submit" value="저장">
			<input class="btn btn-outline-dark" type="button" value="목록" onclick="location.href='board?command=list'">
		</form>
 	</div>
</body>
</html>