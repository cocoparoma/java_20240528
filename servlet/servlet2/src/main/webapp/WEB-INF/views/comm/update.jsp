<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Page Modify</title>


<jsp:include page="/WEB-INF/views/common/cdn.jsp"></jsp:include>
<link href="https://cdn.jsdelivr.net/npm/summernote@0.8.18/dist/summernote-bs4.min.css" rel="stylesheet">
<script src="https://cdn.jsdelivr.net/npm/summernote@0.8.18/dist/summernote-bs4.min.js"></script>
</head>
<body>
<jsp:include page="/WEB-INF/views/common/navbar.jsp"></jsp:include>
<div class=container style="min-height: calc(100vh - 240px); margin-bottom: 16px">
	 


<div class="container mt-3">
  <h1>${co.co_name } 게시판 게시글 수정</h1>
	<form action="<c:url value="/comm/update"/>" method="post">
	
	
	<!-- input 히든 -->
	<input type="hidden" name="co_id" value="${co.co_id }">
	<input type="hidden" name="po_id" value="${po.po_id }">	
	
	
	    <div class="input-group mb-3 input-group-lg">
	      <div class="input-group-prepend">
	        <span class="input-group-text">제목</span>
	      </div>
	      <input type="text" class="form-control" name="name" value="${po.po_name }">
	    </div>
    
    
    <div class="form-group">
      <label for="comment">내용:</label>
      <!-- 서머 노트 -->
      <textarea class="form-control" id="content" name="content" >${po.po_content }</textarea>
    </div>
    
  	<div class="d-flex justify-content-center mb-3">
	   	 <button type="submit" class="btn badge-danger badge badge-pill" style="font-size: 30px;">수정</button>
    </div>
    
    
  </form>
</div>







</div> <!-- Main Container -->
<jsp:include page="/WEB-INF/views/common/jumbotron.jsp"></jsp:include>
<!--  script  -->	
<script type="text/javascript">

$('#content').summernote({
	placeholder: '내용을 작성해 주세요.',
	tabsize: 2,
	height: 400
});



</script>

	
</body>
</html>