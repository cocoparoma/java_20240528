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
		<form action="<c:url value="/post/update"/>" method="post" enctype="multipart/form-data"> 
			<!-- 타이틀 -->
			<div class="form-group">
				<label for="name">제목:</label>
				<input type="text" class="form-control" id="name" name="name" value="${post.po_name }">
			</div>
			
			<!-- 내용 : 서머노트-->
			<div class="form-group">
				<label for="content">내용:</label>
				<textarea class="form-control" id="content" name="content">${post.po_content }</textarea>
			</div>
		
			<!-- 첨부파일 -->
			<div class="form-group attachment-box">
				<label for="content">첨부파일:</label>
				<c:if test="${fileList.size() == 0 }">
					<div class="form-control">첨부파일 없음</div>
				</c:if>
				<c:if test="${fileList.size() != 0 }">
					<c:forEach items="${fileList}" var="file">
						<div class="form-control">
						<span>${file.fi_ori_name}</span>
						<span class="btn-del" style="cursor: pointer;" data-id="${file.fi_id }">x</span>
						</div>
					</c:forEach>
					<c:forEach begin="1" end="${3 - fileList.size() }">
						<input type="file" class="form-control" name="fileList">
					</c:forEach>
					
				</c:if>
			</div>

			<button type="submit" class="btn btn-outline-success col-12">등록</button>
			<input type="hidden" name="po_id" value="${post.po_id}">
		
		</form>
	
	
	</div>
    <script>
	      $('#content').summernote({
	        placeholder: '게시글을 작성해 주세요',
	        tabsize: 2,
	        height: 400
	      });
	      
	      
	      $('.btn-del').click(function(){
	    	var inputFile = `<input type="file" class="form-control" name="fileList">`;
	    	var fi_id = $(this).data('id');
	    	var inputHidden =`<input type="hidden" name="fi_id" value="\${fi_id}"`;
	    	
	    	$('.attachment-box'.append(inputFile);
			$(this).parent().remove();
	    	  
		});
	      
	      
	      
   </script>						
	
	
</body>
</html>