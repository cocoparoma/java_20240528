<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>community</title>
<jsp:include page="/WEB-INF/views/common/head.jsp"/>
<style type="text/css">
	.list-community{
		list-style: none; display: flex; flex-wrap: wrap;
	}
	.item-community{
		width: 33.33%; box-sizing: border-box; padding: 10px;
	}
	.link-community{
		display: block; border: 1px solid black; box-sizing: border-box;
		text-align: center; text-align:center; line-height: 40px;
		text-decoration: none; color: black; padding-bottom: 10px;
	}
	.link-community:hover{
		text-decoration: none; color: white; background-color: tomato;
	}
	.inner-community{
		display: block;
	}
	
</style>

</head>
<body>	<jsp:include page="/WEB-INF/views/common/header.jsp"/>

	<div class="container">
		<h1>커뮤니티 목록</h1>
	</div>
		
	<div class="container" style="background-color: lightblue;">
		<ul class="list-community">
		<c:forEach items="${list}" var="community">
			<li class="item-community">
				<span class="link-community">
					<span class="inner-community">${community.co_name}</span>
					<button class="btn btn-outline-danger btn-update" data-id="${community.co_id }">수정</button>
					<a class="btn btn-outline-dark btn-del" href="<c:url value="/admin/community/delete?co_id=${community.co_id }"/>">삭제</a>
				</span>
			</li>
		</c:forEach>
		</ul>
		
	<form class="input-group mb-3"  action="<c:url value="/admin/community/insert"/>" method="post" id="form-insert">
		<input type="text" class="form-control" name="co_name">
		<div class="input-group-append">
			<button type="submit" class="btn btn-outline-success">등록</button>
		</div>
	</form>
	</div>	
		
<script type="text/javascript">

	$('.btn-del').click(function (e) {
		if(!confirm("해당 커뮤니티를 삭제하시겠습니까?")){
			e.preventDefault();
			return;
		}
	});

	$('.btn-update').click(function (e) {
		$('#form-update').remove();
		
		var name = $(this).prev().text();
		var co_id = $(this).data('community.co_id');
		var str = `
			<form class="input-group mb-3"  action="<c:url value="/admin/community/update"/>" method="post" id="form-update">
			<input type="text" class="form-control" name="\${name}">
			<div class="input-group-append">
				<button type="submit" class="btn btn-outline-success">수정</button>
			</div>
			<input type="hidden" name="co_id" value = "\${co_id}">
			</form>`;
		
		$('#form-insert').hide();
		$('#form-insert').after(str);
		
	});




</script>
		
</body>
</html>


