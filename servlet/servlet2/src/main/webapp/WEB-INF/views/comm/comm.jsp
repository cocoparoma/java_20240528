<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>아카이브</title>
<jsp:include page="/WEB-INF/views/common/cdn.jsp"></jsp:include>
<!-- list 랑 colist를 이미 뿌려주었음 사용하면 됨 리스트 객체라 따로 담아야 함 -->
<style type="text/css">
	.atag{
		text-decoration: none;
	}
</style>

</head>
<body><jsp:include page="/WEB-INF/views/common/navbar.jsp"></jsp:include>
<div class=container style="min-height: calc(100vh - 240px);">



	<div class="container mt-3">
		<h2>아카이브 리스트</h2>
		<p>들어가고 싶은 커뮤니티 제목을 눌러주세요. 왼쪽은 총 게시글 수 입니다.</p>
			<ul class="list-group append-comm-list">
	
				<!-- colist 들어갈 곳 -->

			</ul>
	</div>


</div>
<!-- JSTL -->









<jsp:include page="/WEB-INF/views/common/jumbotron.jsp"></jsp:include>

<script type="text/javascript">

var str = `
<c:forEach var="co" items="${coList}">
	<li class="list-group-item d-flex justify-content-between align-items-center">
		<a style="text-decoration: none;" href="<c:url value="/comm/list?co_id=${co.co_id}"/>">${co.co_name}</a>
		<span class="badge badge-primary badge-pill">${co.co_postCounter}</span>
	</li>
</c:forEach>
`


Main();
function Main() {
	$('.append-comm-list').after(str);
	console.log(str);
}





</script>





</body>
</html>