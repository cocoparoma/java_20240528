<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html>
<html>
	<head>
	<meta charset="UTF-8">
	<title>list</title>
	<jsp:include page="/WEB-INF/views/common/cdn.jsp"></jsp:include>
	</head>
	<body>
	<jsp:include page="/WEB-INF/views/common/navbar.jsp"></jsp:include>
	<div class=container style="min-height: calc(100vh - 240px);">
	
	
		<div class="container mt-3">
		  <h2>${co.co_name }</h2>
		  <p>${co.co_name } 게시판 리스트 (여기다가 user state 띄워도 좋을 듯)</p>

<!--  -->

		  <div class="list-group">
				
				<div class="list-group-item d-flex justify-content-between align-items-center">
					제목
				      <span class="">
				      
				      		<span class="badge badge-info badge-pill">년월일자</span>
				   			<span class="badge badge-success badge-pill">작성자</span>
				   			<span class="badge badge-danger badge-pill">추천</span>
				      		<span class="badge badge-primary badge-pill">조회수</span>
				      </span>
				</div>
		    	<div class="list-group-item list-append" style="border-left: 0px; border-right: 0px"></div>
		    	
<!-- 리스트 추가 위치 -->
		    	
		        <a class="list-group-item d-flex justify-content-between align-items-center list-group-item-action" href="#">
				      
					게시글 제목이 있을 위치
				      
				      <span class="">
				      
				      		<span class="badge badge-info badge-pill">
				      		
				      		<fmt:formatDate value=""/>
				      		년월일자
				      		
				      		</span>
				   			<span class="badge badge-success badge-pill">작성자</span>
				   			<span class="badge badge-danger badge-pill">추천</span>
				      		<span class="badge badge-primary badge-pill">12</span>
				      </span>
			    </a>
		    
		  	</div>
		  	
		</div>


</div><!-- container done -->
	

<!-- 검색창 아래 위치하도록 만들었음 -->

		<div class="container mt-3">
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
	    <li class="page-item"><a class="page-link" href="javascript:void(0);">Previous</a></li>
	    <li class="page-item active"><a class="page-link" href="javascript:void(0);">1</a></li>
	    <li class="page-item"><a class="page-link" href="javascript:void(0);">2</a></li>
	    <li class="page-item"><a class="page-link" href="javascript:void(0);">Next</a></li>
	  </ul>
	</div>
	


<!-- jumbotron -->
<jsp:include page="/WEB-INF/views/common/jumbotron.jsp"></jsp:include>


<!-- 스크립트 -->

<script type="text/javascript">
//변수 선언 부
let co_id = `${co.co_id}`;
let searchType = "all"; // 타입(디폴트 전체)
let searchText = ""; // 찾는 문구 (기본 없음)
let searchTerm = ""; // 기간(디폴트 전체기간)
const tmp = $('.search-bounds').text();

var str = ``




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
	search();
});

//함수 선언 부
function search() {
	//ajax 로 searchType, searchText만 일단 보내주자 (기간 아직 안만듬)
	//get으로 넘겨줘 버린듯?
	//Mapper 까지 넘겨서 sql로 list걸러서 가져오게 해주면 됨
	console.log(co_id)
	console.log(searchType)
	console.log(searchText)
	window.location.href = `<c:url value="/comm/list?co_id=\${co_id}&type=\${searchType}&q=\${searchText}"/>`;
}

function postMaker() {
	
}

function pageMaker() {
	
}

</script>






</body>
</html>