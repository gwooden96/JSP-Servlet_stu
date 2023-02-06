<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>상품등록</h1>
	
	<form method="post" action="add.do" enctype="multipart/form-data">
		상품명 : <input type="text" name="name"><br>
		가격 : <input type="text" name="price"><br>
		사진 : <input type="file" name="pictureurl"><br>
		설명 : <textarea rows="5" cols="50" name="description"></textarea><br>
		<input type="submit" value="등록">
		<input type="button" value="목록" onclick="location.href='list.do'">
	</form>
</body>
</html>