<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시글 수정</title>
<jsp:include page="/WEB-INF/views/common/head.jsp"/>
<link href="https://cdn.jsdelivr.net/npm/summernote@0.8.18/dist/summernote-bs4.min.css" rel="stylesheet">
<script src="https://cdn.jsdelivr.net/npm/summernote@0.8.18/dist/summernote-bs4.min.js"></script>
<style type="text/css">




</style>
<script type="text/javascript">

</script>

</head>
<body>
	<jsp:include page="/WEB-INF/views/common/header.jsp"/>
	

	
	<div class="container">
		<h1>게시글 수정</h1>
		<form action="<c:url value="/post/update"/>" method="post"> 
			<div class="form-group">
				<label for="name">제목:</label>
				<input type="text" class="form-control" id="name" name="name" value="${post.po_name }">
			</div>
			
			<div class="form-group">
				<label for="content">내용:</label>
				<textarea class="form-control" id="content" name="content">${post.po_content }</textarea>
			</div>
			
			<button type="submit" class="btn btn-outline-success col-12">등록</button>
			<input type="hidden" name="po_id" value="${post.po_id}">
		
		</form>
	
	
	</div>
    <script>
	      $('#summernote').summernote({
	        placeholder: '게시글을 작성해 주세요',
	        tabsize: 6,
	        height: 400
	      });
   </script>						
	
	
</body>
</html>