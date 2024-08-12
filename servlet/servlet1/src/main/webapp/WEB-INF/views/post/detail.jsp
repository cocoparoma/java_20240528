<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시글 등록</title>
<jsp:include page="/WEB-INF/views/common/head.jsp"/>
</head>
<body>
<jsp:include page="/WEB-INF/views/common/header.jsp"/>
<div class="container">
	<h1>게시글 상세</h1>
	<div class="form-group">
		<label for="title">제목:</label>
		<input type="text" class="form-control" value="${post.po_name}" readonly>
	</div>
	<div class="form-group">
		<label for="title">작성자:</label>
		<input type="text" class="form-control" value="${post.po_me_id}" readonly>
	</div>
	<div class="form-group">
		<label for="title">작성일:</label>
		<input type="text" class="form-control" value="<fmt:formatDate value="${post.po_date}" pattern="yyyy-MM-dd HH:mm:ss" />" readonly>
	</div>
	<div class="form-group">
		<label for="title">조회수:</label>
		<input type="text" class="form-control" value="${post.po_view}" readonly>
	</div>
	<div class="form-group">
		<label for="content">내용:</label>
		<div class="form-control" style="min-height: 400px">${post.po_content }</div>
	</div>
	<a href="<c:url value="/post/list?co_id=${post.po_co_id }"/>" class="btn btn-outline-primary">목록</a>
	
	<c:if test="${user ne null && post.po_me_id eq user.me_id}">
	<a href="<c:url value="/post/update?po_id=${post.po_id }"/>" class="btn btn-outline-warning">수정</a>
	<a href="<c:url value="/post/delete?po_id=${post.po_id }"/>" class="btn btn-outline-danger">삭제</a>
	</c:if>
	
	
</div>
</body>
</html>