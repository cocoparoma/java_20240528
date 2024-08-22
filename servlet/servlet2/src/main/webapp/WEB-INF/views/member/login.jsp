<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Login</title>
<jsp:include page="/WEB-INF/views/common/cdn.jsp"></jsp:include>
</head>
<body><jsp:include page="/WEB-INF/views/common/navbar.jsp"></jsp:include>
<div class=container style="min-height: calc(100vh - 240px);">
	<h1 style="margin-bottom: 10px; margin-top: 10px;">로그인</h1>
	<p>설명 입력해주면 좀 멋있음</p>
	<form action="<c:url value="/login"/>"  method="post">
		<div class="form-group">
		    <label for=""id"">아이디:</label>
		    <input type="text" class="form-control" id="id" name="me_id">
	    </div>
	    <div class="form-group">
		    <label for="pw">비밀번호:</label>
		    <input type="password" class="form-control" id="pw" name="me_pw">
	    </div>
	    
   		 <div class="d-flex flex-row-reverse">
	   		<button type="submit" class="btn bg-primary p-2 btn-login">로그인</button>
		 </div>
	    
	    
	</form>

</div>
<jsp:include page="/WEB-INF/views/common/jumbotron.jsp"></jsp:include>
</body>
</html>