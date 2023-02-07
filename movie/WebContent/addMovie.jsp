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
	<div class="container">
		<h3>영화 등록 페이지</h3>
		<form method="post" action="add.do" enctype="multipart/form-data">
			<label class="form-label">영화제목</label>
			<input class="form-control" type="text" name="title">
			<label class="form-label">가격</label>
			<input class="form-control" type="text" name="price">
			<label class="form-label">감독</label>
			<input class="form-control" type="text" name="director">
			<label class="form-label">배우</label>
			<input class="form-control" type="text" name="actor">
			<label class="form-label">영화 설명</label>
			<textarea class="form-control" rows="5" name="synopsis" ></textarea>
			<label class="form-label">영화 포스터</label>
			<input class="form-control" type="file" name="poster">
			
			<div class="py-3">
				<input class="btn btn-primary" type="submit" value="영화등록">
				<input class="btn btn-primary" type="button" value="목록" onclick="location.href='list.do'">
			</div>
			
		</form>
	</div>
</body>
</html>