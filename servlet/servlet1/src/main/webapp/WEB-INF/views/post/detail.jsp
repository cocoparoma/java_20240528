<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시글 등록</title>
<style type="text/css">
	.comment-list{
		list-style: none;
		padding: 0;
		
	}
	.comment-list > .comment-item {
		margin-bottom: 20px;
	}
	
	.comment-list > .comment-item.reply {
		margin-left: 50px;
	}
	


</style>
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
	
	<div class="row">
	  <div class="col-sm-10"></div>
	  
	  <div class="col-sm-2">
	  		
    		<div class="btn-group right">
				 <a href="#" data-state="1" type="button" class="btn-up btn btn<c:if test="${re.re_state ne 1}">-outline</c:if>-info" >추천(<span>${post.po_up}</span>)</a>
				 <a href="#" data-state="-1" type="button" class="btn-down btn btn<c:if test="${re.re_state ne -1}">-outline</c:if>-danger" >비추천(<span>${post.po_down}</span>)</a>
			</div>
	  
	  
	  </div>
	</div>
		
	
	<div class="form-group">
		<label for="content">내용:</label>
		<div class="form-control" style="min-height: 400px">${post.po_content }</div>
	</div>
	
	
	<!-- 다운로드 -->
	<div class="form-group">
		<label for="content">첨부파일:</label>
		<c:if test="${fileList.size() == 0 }">
			<div class="form-control">첨부파일 없음</div>
		</c:if>
		<c:if test="${fileList.size() != 0 }">
			<c:forEach items="${fileList}" var="file">
				<a class="form-control" 
					href="<c:url value="/download?fileName=${file.fi_name}"/>"
					download="${file.fi_ori_name}">${file.fi_ori_name}</a>
			</c:forEach>
		</c:if>
	</div>
	
	
	
	<hr>
	
	
	<div class="form-group container">
	<h3>댓글 목록</h3>
		<ul class="comment-list">
			<li class="comment-item ">
				<div>작성자 아이디(시간)</div>
				<div>댓글 내용</div>
			</li>
			
			<li class="comment-item relpy">
				<div>작성자 아이디(시간)</div>
				<div>대댓글 내용</div>
			</li>

		</ul>
		
		<div class="comment-pagination"></div>
		
		<div class="comment-insert-box">
			<textarea rows="" cols="" class="col-12 input-comment-insert"></textarea>
			
			<div class="row">
				<div class="col-sm-10"></div>
				<div class="col-sm-2">
					<button class="btn btn-success btn-comment-insert">등록</button>
				</div>
			</div>
		</div>
			
		</div>
	
	
	
	
	<a href="<c:url value="/post/list?co_id=${post.po_co_id }"/>" class="btn btn-outline-primary">목록</a>
	
	<c:if test="${user ne null && post.po_me_id eq user.me_id}">
	<a href="<c:url value="/post/update?po_id=${post.po_id }"/>" class="btn btn-outline-warning">수정</a>
	<a href="<c:url value="/post/delete?po_id=${post.po_id }"/>" class="btn btn-outline-danger">삭제</a>
	</c:if>
	
	
</div>


<script type="text/javascript">
var cri = {
		po_id : '${post.po_id}',
		page : 1
	}

$('.btn-up, .btn-down').click(function(e){
	e.preventDefault();
	
	if(!checklogin()){
		return;
	}
	
	let state = $(this).data('state');
	let po_id = '${post.po_id}';
	$.ajax({
		url : '<c:url value="/post/recommend"/>',
		method : "get", //원하는 방식 선택
		data : { //보낸 데이터를 객체로
			re_state : state,
			po_id : po_id
		},
		success : function(data){
			console.log(data);
			let res = data.result;
			if(res == 1){
				alert('추천 했습니다.');
			}else if(res == -1){
				alert('비추천 했습니다.');
			}else{
				alert(`\${state == 1?'추천':'비추천'}을 취소했습니다.`);
			}
			checkRecommendBtns(res);
			let post = JSON.parse(data.post);
			$('.btn-up span').text(post.po_up);
			$('.btn-down span').text(post.po_down);
		}, 
		error : function(xhr, status, error){
			//xhr : XHLHttpRequest 객체, 요청과 관련된 정보를 제공
			//status :HTTP 상태 코드, 요청이 실패한 원인
			//error : 에러에 대한 추가 정보
			console.log("error");
		}
	});
});

$(document).on('click', 'pagination .page-item', function () {
	if($(this).hasClass('disabled')){
		return;
	}
	let page = $(this).data('page');
	cri.page = page;
	geCommentList(cri);
});


function checkRecommendBtns(state) {
	$('.btn-up').removeClass('btn-info');
	$('.btn-up').addClass('btn-outline-info');
	$('.btn-down').removeClass('btn-danger');
	$('.btn-down').addClass('btn-outline-danger');
	if(state != 0){
		$(state == 1 ? '.btn-up' : '.btn-down').removeClass(state == 1 ? 'btn-outline-info' : 'btn-outline-danger');
		$(state == 1 ? '.btn-up' : '.btn-down').addClass(state == 1 ? 'btn-info' : 'btn-danger');
	}
	console.log('do btn');
}	

getCommentList(cri);
function getCommentList(cri) {
	console.log(cri);
	
	$.ajax({
		url : '<c:url value="/comment/list"/>',
		method : "post", //원하는 방식 선택
		data : cri,
		success : function(data){
			//서버에서 보낸 값이 객체인 경우 JSON.parse를 통해 josn 문자열을 객체로 변환
			let list = data.list;
			console.log(data)
			displayCommentList(list);
			let pm = JSON.parse(data.pm);
			console.log(pm);
			displayPagination(pm);
			
			console.log(data);
			//서버에서 보낸 값이 리스트인 경우 바로 사용 가능
		}, 
		error : function(xhr, status, error){
			console.log("에러 발생");
			console.log(xhr.responseText);
			//xhr : XHLHttpRequest 객체, 요청과 관련된 정보를 제공
			//status :HTTP 상태 코드, 요청이 실패한 원인
			//error : 에러에 대한 추가 정보
		}
	});
	
	
}

function displayPagination(pm){
	if(pm.totalCount == 0){
		return;
	}
	str = `
	<ul class="pagination justify-content-center">`;
	var disabled = pm.prev ? '' : 'disabled'
	str +=
	    `<li class="page-item \${disabled}" data-page="\${pm.startPage-1}">
	    	<a class="page-link" href="javascript:void(0);">이전</a>
	    </li>`;
	
	for(var i = pm.startPage; i<=pm.endPage; i++){
		var active = pm.cri.page == i ? 'active' : '';

		str +=		
	    `<li class="page-item \${active}"  data-page="\${i}">
	    	<a class="page-link" href="javascript:void(0);">\${i}</a>
	    </li>`;
	}
	var disabled = pm.next ? '' : 'disabled'
	str +=		
	    `<li class="page-item  \${disabled}"  data-page="\${pm.endPage+1}">
	    	<a class="page-link" href="javascript:void(0);">다음</a>
	    </li>`;
	
  	str += 
  	`</ul>`;
	$('.comment-pagination').html(str);
}

	

function displayCommentList(list){
	var str = '';
	console.log(list)
	if(list.length == 0){
		str = `<li>등록된 댓글이 없습니다.</li>`;
		$('.comment-list').html(str);
		return;
	}
	
	for(co of list){
		
		if(co.cm_me_id == '${user.me_id}'){
			if(co.cm_id == co.cm_ori_id){
				str += `
					<li class="comment-item ">
						<div>\${co.cm_me_id}(\${co.cm_date})
							<button class="btn btn-delete-commend" data-id="\${co.cm_id}">삭제</button>
							<button class="btn btn-update-commend" data-id="\${co.cm_id}">수정</button>
						</div>
						<div class="cm_content">\${co.cm_content}</div>
					</li>
					`;
				
				
			} else {
				str += `
					<li class="comment-item relpy">
						<div>\${co.cm_me_id}(\${co.cm_date})
							<button class="btn btn-delete-commend" data-id="\${co.cm_id}">삭제</button>
							<button class="btn btn-update-commend" data-id="\${co.cm_id}">수정</button>
						</div>
						<div class="cm_content">\${co.cm_content}</div>
					</li>
					`;
			}		
		} else {
			if(co.cm_id == co.cm_ori_id){
				str += `
					<li class="comment-item ">
						<div>\${co.cm_me_id}(\${co.cm_date})</div>
						<div>\${co.cm_content}</div>
					</li>
					`;
				
				
			} else {
				str += `
					<li class="comment-item relpy">
						<div>\${co.cm_me_id}(\${co.cm_date})</div>
						<div>\${co.cm_content}</div>
					</li>
					`;
			}		
		}
		
		

		
	}
	$('.comment-list').html(str);
		
}
$(document).on("click", ".btn-update-commend", function(){	
	$('.comment-update-box').remove();
	
	console.log("수정버튼 진입");
	
	let cm_id = $(this).data('id');
	let cm_content = $(this).parent().next().text(); 
	
	var str = `
	<div class="comment-update-box">
		<textarea rows="" cols="" class="col-12 input-comment-update">\${cm_content}</textarea>
		
		<div class="row">
			<div class="col-sm-10"></div>
			<div class="col-sm-2">
				<button class="btn btn-info btn-complete-comment-update" data-id="\${co.cm_id}">수정 완료</button>
			</div>
		</div>
	</div>
	`
	$('.comment-insert-box').after(str);
	$('.comment-insert-box').hide();
	
});

$(document).on("click", ".btn-complete-comment-update", function(){
	console.log("수정 수정 버튼 진입");
	let cm_id = $(this).data('id');
	let cm_content = $('.input-comment-update').val();
	
	console.log(cm_id +" / / "+ cm_content);
	
	let obj = {
		cm_id : cm_id + 1,
		cm_content : cm_content
	};
	
	
	$.ajax({
		url : '<c:url value="/comment/update"/>',
		method : "post", //원하는 방식 선택
		data : obj,
		success : function(data){
			if(data.result){
				alert('수정 성공')
				getCommentList(cri);
			} else {
				alert('수정 실패')
			}
			$('.comment-insert-box').show();
			$('.comment-update-box').remove();
		}, 
		error : function(xhr, status, error){
			console.log(xhr);
			console.log("error");
		}
	});
	
	
	
	
	
	
	
	
	
});

$(document).on("click", ".btn-delete-commend", function(){

	
	let po_id = '${post.po_id}';
	let me_id = '${user.me_id}';
	let cm_id = $(this).data('id');
	
	
	if(!checklogin()){
		return;	
	}
	let obj = {
		po_id : po_id,
		me_id : me_id,
		cm_id : cm_id
	};
	
	$.ajax({
		url : '<c:url value="/comment/delete"/>',
		method : "post", //원하는 방식 선택
		data : obj,
		success : function(data){
			if(data.result){
				alert('댓글 삭제 완료');
				cri.page = 1;
				getCommentList(cri);
			} else {
				alert('댓글 삭제 실패');
			}

		}, 
		error : function(xhr, status, error){
			console.log(xhr);
			console.log("error");
		}
	});
	
	
});




$('.btn-comment-insert').click(function (e) {
	// 로그인 확인
	if(!checklogin()){
		return;	
	}
	
	
	let content = $('.input-comment-insert').val();
	let cm_ori_id = 0;
	let po_id = '${post.po_id}';
	
	
	if(content.trim() == ''){
		alert('댓글을 입력하세요');
		$('.input-comment-insert').focus();
		return;
	}
	//

	
	console.log(content);
	
	//

	$.ajax({
		url : '<c:url value="/comment/insert"/>',
		method : "post", //원하는 방식 선택
		data : { //보낸 데이터를 객체로
			cm_content : content,
			cm_ori_id : cm_ori_id,
			cm_po_id : po_id
		},
		success : function(data){
			console.log(data);
			if(data.result){
				alert('댓글 등록 완료');
				cri.page = 1;
				getCommentList(cri);
			} else {
				alert('댓글 등록 실패');
			}
			$('.input-comment-insert').val('');
		}, 
		error : function(xhr, status, error){
			//xhr : XHLHttpRequest 객체, 요청과 관련된 정보를 제공
			//status :HTTP 상태 코드, 요청이 실패한 원인
			//error : 에러에 대한 추가 정보
			console.log("error");
			console.log(xhr);
		}
	});
	
	

});


function checklogin() {
	if('${user.me_id}' == ''){
		if(confirm('로그인이 필요한 서비스입니다.\n로그인 페이지로 이동하시겠습니까?')){
			location.href = '<c:url value="/login"/>';
			return false;
		}else{
			return false;
		}
	}
	return true;
}



</script>



</body>
</html>