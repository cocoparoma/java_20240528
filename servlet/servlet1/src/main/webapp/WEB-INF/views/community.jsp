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
		width: 33.33%; height: 65px; box-sizing: border-box; padding: 10px;
	}
	.link-community{
		display: block; border: 1px solid black; box-sizing: border-box;
		height: 100%; text-align: center; text-align:center;
		text-decoration: none; color: black;
	}
	.link-community:hover{
		text-decoration: none; color: white; background-color: tomato;
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
				<c:url var="url" value="/post/list"> 
					<c:param name="co_id" value="${community.co_id}"/> 
				</c:url>
				<a class="nav-link link-community" href="${url}">${community.co_name}</a>
			</li>
		</c:forEach>
		</ul>
		
	</div>
</body>
</html>


