<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Main Page</title>


<jsp:include page="/WEB-INF/views/common/cdn.jsp"></jsp:include>
</head>
<body>
	<jsp:include page="/WEB-INF/views/common/navbar.jsp"></jsp:include>
	<div class="container">
		<h1>코코파로마</h1>
		<button class="btn btn-outline-info btn-test">테스트버튼입니다</button>
	</div>

	<div class=container style="min-height: calc(100vh - 240px);">컨테이너 범위 설정 테스트 div</div>
	 
	<jsp:include page="/WEB-INF/views/common/jumbotron.jsp"></jsp:include>







<!--  script  -->	
<script type="text/javascript">
$(".btn-test").click(function(e) {
	alert("로그인 된 아이디 : ${user.me_id}");
});




</script>

	
</body>
</html>