<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html>
<html>
	<head>
	<meta charset="UTF-8">
	<title>Page List</title>
	<jsp:include page="/WEB-INF/views/common/cdn.jsp"></jsp:include>
	</head>
	<body>
	<jsp:include page="/WEB-INF/views/common/navbar.jsp"></jsp:include>
	<div class=container style="min-height: calc(100vh - 240px);">
	
	
		<div class="container mt-3">
		
<!-- title -->
			<h2>${co.co_name }</h2>
		  	
		  	<c:choose>
		  		
		  		
		  		<c:when test="${user != null}">
		  			<p>${co.co_name } 게시판 입니다. ${user.me_id} 님 반갑습니다.</p>
		  		</c:when>
		  		
		  		
		  		<c:otherwise>
		  			<p>${co.co_name } 게시판 입니다. 로그인 되지 않았습니다. 로그인 후 이용해 주세요</p>
		  		</c:otherwise>
		  		
		  		
		  	</c:choose>
		  

			
<!-- test -->



<!--  -->

		  <div class="list-group">
				
				<div class="list-group-item d-flex justify-content-between align-items-center">
					게시글 제목
				      <span class="">
				      
				      		<span class="badge badge-info badge-pill">년월일자</span>
				   			<span class="badge badge-success badge-pill">작성자</span>
				   			<span class="badge badge-danger badge-pill">추천</span>
				      		<span class="badge badge-primary badge-pill">조회수</span>
				      </span>
				</div>
		    	<div class="list-group-item list-add" style="border-left: 0px; border-right: 0px"></div>
		    	
		    	
<!-- 리스트 추가 위치 + 추가 되었음-->
		    	
		    
		  	</div>
		  	
		</div>


</div><!-- container done -->
	
<!-- insert butten -->	
	
	
<div class="container">
	<div class="d-flex justify-content-between mb-3">
		<div class="btn btn-insertPost badge badge-danger badge-pill" style="font-size: 25px;">게시글 작성</div>
		<div class="btn btn-back badge badge-info badge-pill" style="font-size: 25px;">뒤로</div>
	</div>
</div>
	
	
	
	

<!-- 검색창 아래 위치하도록 만들었음 -->

		<div class="container">
			<form>
				<div class="input-group mt-3 mb-3">
					<div class="input-group-prepend">
						<button type="button"
							class="btn btn-outline-secondary dropdown-toggle search-bounds"
							data-toggle="dropdown">검색 범위 : 전체</button>
						<div class="dropdown-menu">
							<a value="all" class="dropdown-item search-bounds-all" href="javascript:void(0);">전체</a> 
							<a class="dropdown-item search-bounds-title" href="javascript:void(0);">제목</a> 
							<a class="dropdown-item search-bounds-name" href="javascript:void(0);">작성자</a>
						</div>
					</div>
					<input type="text" class="form-control search-text" placeholder="search">
					<button type="button" class="btn btn-outline-primary btn-search">go</button>

				</div>
			</form>
		</div>


<!-- 페이지 네이션! -->
		
	<div class="container">
	  <ul class="pagination justify-content-center">
	  
	  
	  

	  
	  
	  
	  
	  </ul>
	</div>
	


<!-- jumbotron -->
<jsp:include page="/WEB-INF/views/common/jumbotron.jsp"></jsp:include>


<!-- 스크립트 -->

<script type="text/javascript">
//변수 선언 부
let co_id;
let searchType = "all"; // 타입(디폴트 전체)
let searchText = ""; // 찾는 문구 (기본 없음)
let searchTerm = ""; // 기간(디폴트 전체기간)
let page = "";
const tmp = $('.search-bounds').text();

var str = `
<c:forEach var="po" items="${list}">




    <a class="list-group-item d-flex justify-content-between align-items-center list-group-item-action"
    href="<c:url value="/comm/detail?co_id=${co.co_id}&po_id=${po.po_id}"/>">
    
	${po.po_name}

	<span class="">
      
      		<span class="badge badge-info badge-pill">
      		
      		<fmt:formatDate value="${po.po_date}" pattern="yyyy-MM-dd HH:mm:ss"/>
      		
      		</span>
   			<span class="badge badge-success badge-pill">${po.po_me_id}</span>
   			<span class="badge badge-danger badge-pill">${po.po_up}</span>
      		<span class="badge badge-primary badge-pill">${po.po_view}</span>
      		
      </span>
</a>
</c:forEach>
<c:if test="${list.size() == 0 }">
<a class="list-group-item d-flex flex-column-reverse align-items-center list-group-item-action"
    href="javascript:void(0);">
    
	<span class="p-2 bg-info badge badge-info badge-pill">게시글이 없습니다!</span>

</a>
</c:if>
`

var pageBar = `

	<li class="page-item page-after-point disabled"><a class="page-link" href="javascript:void(0);">이전</a></li>
	  
  	<c:forEach begin="${pm.startPage }" end="${pm.endPage }" var="i">
  
   		<li class="page-item"><a class="page-link btn-page" href="<c:url value="/comm/list?co_id=${co_id}&type=${searchType}&q=${searchText}&page=${i}"/>">${i }</a></li>
  
  	</c:forEach>
  
    <li class="page-item"><a class="page-link" href="javascript:void(0);">이후</a></li>

`







//이벤트 리스너
$('.search-bounds-all').click(function (e) {
	$('.search-bounds').text('검색 범위 : 전체');
	searchType = "all";
	console.log(searchType);
});

$('.search-bounds-title').click(function (e) {
	$('.search-bounds').text('검색 범위 : 제목');
	searchType = "title";
	console.log(searchType);
});

$('.search-bounds-name').click(function (e) {
	$('.search-bounds').text('검색 범위 : 작성자');
	searchType = "name";
	console.log(searchType);
});
$('.btn-search').click(function (e) {
	searchText = $('.search-text').val();
	co_id = `${co.co_id}`;
	search();
});
$('.btn-back').click(function (e) {
	window.location.href = `<c:url value="/comm"/>`;
})
$('.btn-insertPost').click(function (e) {
	window.location.href = `<c:url value="/comm/insert?co_id=${co.co_id}"/>`;
})
$(document).on('click', '.btn-page', function (e) {
    e.stopImmediatePropagation();
    
})

/*
$(document).on('click', '.page-item',function(e) {
    e.stopImmediatePropagation();
    page = $('this').val();
    alert(page);
 }); 
*/

//함수 선언 부
function search() {
	window.location.href = `<c:url value="/comm/list?co_id=\${co_id}&type=\${searchType}&q=\${searchText}&page=1"/>`;
}
postMaker();
function postMaker() {
	$('.list-add').after(str);
}
pageMaker();
function pageMaker() {
	$('.pagination').append(pageBar);
}

</script>






</body>
</html>