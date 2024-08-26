<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Page Detail</title>
<jsp:include page="/WEB-INF/views/common/cdn.jsp"></jsp:include>
<style type="text/css">
/* css */



</style>
</head>
<body><jsp:include page="/WEB-INF/views/common/navbar.jsp"></jsp:include>
<div class=container style="min-height: calc(100vh - 240px);">
<!-- container -->

<!-- test -->

<!--  -->
<!-- 들어가야 할것추천+/- -->
<c:if test="${post != null }">
<c:if test="${post == null }">
	<h3>삭제되거나 등록되지 않은 게시글 입니다.</h3>
</c:if>


<div class="container mt-3 p-3">
  <h1>${post.po_name } </h1>
  <div class="p-2 d-flex flex-row-reverse">
	<small style="font-size: 18px;"><i class="badge badge-info badge-pill"> 작성일 : <fmt:formatDate value="${post.po_date}" pattern="yyyy-MM-dd HH:mm:ss"/>  </i></small>
  </div>
  <div class="p-2 d-flex flex-row-reverse">
	  <small style="font-size: 18px;"><i class="badge badge-primary badge-pill"> 조회수 : ${post.po_view}</i></small>
	  &ensp;
	  <small style="font-size: 18px;"><i class="btn btn-writer badge badge-success badge-pill">작성자 : ${post.po_me_id}</i></small>
	   &ensp;
	  <small style="font-size: 18px;"><i class="badge badge-danger badge-pill">추천 : ${post.po_up}</i></small>
  
  </div>
  
  
  
  
  <div class="media border p-3">
    <div class="media-body" style="min-height: 400px;">
      <p> ${post.po_content }</p>      
    </div>
  </div>
</div>




<div class="d-flex  mb-3">
	  	<button class="btn btn-modify badge badge-success badge-pill" style="font-size: 25px;">수정</button>
	  	<button class="btn btn-delete badge btn-outline-danger badge-pill" style="font-size: 25px;">삭제</button>
	    <button class="btn btn-back badge badge-info badge-pill ml-auto" style="font-size: 25px;">뒤로</button>
</div>


</c:if>
</div>
<jsp:include page="/WEB-INF/views/common/jumbotron.jsp"></jsp:include>
<!--  script  -->	
<script type="text/javascript">
/* 주석처리 할 내용

	<div>${po_id }</div>
	<div>${co_id }</div>
	<div>${post }</div>
	<div>${post.po_id }</div>
	 
 
 */

// var



// function



// Event
$('.btn-back').click(function (e) {
	window.location.href = `<c:url value="/comm/list?co_id=${co_id}"/>`;
})
$('.btn-writer').click(function (e) {
	window.location.href = `<c:url value="/comm/list?co_id=${co_id}&type=name&q=${post.po_me_id}"/>`;
})
$('.btn-modify').click(function (e) {
	if(${user.me_id == post.po_me_id}){
		window.location.href = `<c:url value="/comm/update?co_id=${co_id}&po_id=${post.po_id}"/>`;
	} else {
		alert("작성자가 아닙니다.")
	}
})
$('.btn-delete').click(function (e) {
	if(${user.me_id == post.po_me_id}){
		window.location.href = `<c:url value="/comm/delete?co_id=${co_id}&po_id=${post.po_id}"/>`;
	} else {
		alert("작성자가 아닙니다.")
	}
})




</script>

	
</body>
</html>