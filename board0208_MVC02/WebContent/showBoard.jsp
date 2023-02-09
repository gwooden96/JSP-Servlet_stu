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
	<div class="container p-3">
		<div class="mb-3">
			<label class="from-laber">제목</label>
			<div class="form-control">${boardPost.title}</div>		
		</div>
		<div class="mb-3">
			<label class="from-laber">내용</label>
			<div class="form-control"><pre>${boardPost.content}<pre></div>		
		</div>
		<%-- <c:if test="${boardPost.id == loginUser.id}"> --%>
			<input class="btn btn-outline-dark" type="button" value="수정" onclick="location.href='update.do?l_id=${loginUser.id}&b_id=${boardPost.id}&no=${boardPost.no}'">
			<%-- <input class="btn btn-outline-dark" type="button" value="삭제" onclick="location.href='delete.do?no=${boardPost.no}'"> --%>
			<input class="btn btn-outline-dark" type="button" value="삭제" onclick="location.href='delete.do?l_id=${loginUser.id}&b_id=${boardPost.id}&no=${boardPost.no}'">
		<%-- </c:if> --%>
		<input class="btn btn-outline-dark" type="button" value="목록" onclick="location.href='listAll.do'">
		<c:if test="${!empty msg}">
			<div class="alert alert-danger mt-3">
				${msg}
			</div>
		</c:if>
	</div>
</body>
</html>