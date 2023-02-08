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
	
	<div class="container row">
		<div class="col-4 pt-5">
			<img class="img-fluid" src="images/${mv.poster}">
		</div>
	
		<div class="container col-8">
			<h3>영화 정보 수정</h3>
			<form method="post" action="update.do" enctype="multipart/form-data">
				<label class="form-label">영화제목</label>
				<input class="form-control" type="text" name="title" value="${mv.title}"><br>
				<label class="form-label">가격</label>
				<input class="form-control" type="text" name="price" value="${mv.price}"><br>
				<label class="form-label">감독</label>
				<input class="form-control" type="text" name="director" value="${mv.director}"><br>
				<label class="form-label">배우</label>
				<input class="form-control" type="text" name="actor" value="${mv.actor}"><br>
				<label class="form-label">영화 설명</label>
				<textarea class="form-control" rows="6" name="synopsis">${mv.synopsis}</textarea><br>
				<label class="form-label">포스터</label>
				<input class="form-control" type="file" name="poster">
				
				<input type="hidden" name="code" value="${mv.code}">
				
				
				<div class="py-3">
					<input class="btn btn-primary" type="submit" value="수정" >
					<input class="btn btn-danger" type="button" value="삭제" onclick="location.href='delete.do?code=${mv.code}'">
					<input class="btn btn-primary" type="button" value="목록" onclick="location.href='list.do'">
				</div>
		
			</form>
		</div>
	</div>
</body>
</html>