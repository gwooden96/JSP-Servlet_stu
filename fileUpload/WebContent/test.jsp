<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form method="post" action="upload.do" enctype="multipart/form-data">
		이름 : <input type="text" name="name"><br>
		제목 : <input type="text" name="title"><br>
		<ul style="list-style: none">
			<li >
				<input type="file" name="upload">
			</li>
			<li>
				<input type="submit" value="업로드">
			</li>
		</ul>
		
	</form>
</body>
</html>