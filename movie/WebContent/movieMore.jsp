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
	
	<div class="container row">
		<div class="col-4 pt-5">
			<img class="img-fluid" src="images/${more.poster}">
		</div>
	
		<div class="container col-8">
			<h3>영화 상세 페이지</h3>
			<form method="post" action="add.do" enctype="multipart/form-data">
				<label class="form-label">영화제목</label>
				<input class="form-control" type="text" name="title" value="${more.title}">
				<label class="form-label">가격</label>
				<input class="form-control" type="text" name="price" value="${more.price}">
				<label class="form-label">감독</label>
				<input class="form-control" type="text" name="director" value="${more.director}">
				<label class="form-label">배우</label>
				<input class="form-control" type="text" name="actor" value="${more.actor}">
				<label class="form-label">영화 설명</label>
				<textarea class="form-control" rows="5" name="synopsis">${more.synopsis}</textarea>
				
				<div class="py-3">
					<input class="btn btn-primary" type="submit" value="수정">
					<input class="btn btn-danger" type="submit" value="삭제" onclick="">
					<input class="btn btn-primary" type="button" value="목록" onclick="location.href='list.do'">
				</div>
				
			</form>
		</div>
	</div>
</body>
</html>