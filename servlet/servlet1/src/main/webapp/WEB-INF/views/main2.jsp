<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>메인</title>
	<style>
		#container{
			background-color: lightblue;
			margin: 0 auto;
			text-align: center;
			width: 2000px;
		}
		#test{
			color: blue;
		}
	</style>
<script></script>
</head>
<body>
	<div id="container">
		<h1 id="test"> 반갑송 </h1>
		<p>안녕하세용? 제 이름은 ${name}입니다.</p>
		<p>만나서 반갑습니다~ 제 이름은 ${person.name}이고, 나이는 ${person.age}살 입니다.</p>
		<a href="<%=request.getContextPath()%>?name=홍길동&age=21" style="text-decoration-line: none">이름은 홍길동, 나이는 21</a>
	</div>
	
	<c:choose>
		<c:when test="${user == null}">
		<div>
			<br><a href="<c:url value="/login"/>">로그인 페이지로 이동</a>
			<br><a href="<c:url value="/signup"/>">회원가입 페이지로 이동</a>
		</div>
		</c:when>
		
		
		<c:otherwise>
		<div>
			<br><a href="<c:url value="/logout"/>">로그아웃 페이지로 이동</a>
		</div>
		</c:otherwise>
	</c:choose>


	<br>

	<c:if test="${user == null}">
		<div>
			<br><a href="<c:url value="/login"/>">로그인 페이지로 이동</a>
			<br><a href="<c:url value="/signup"/>">회원가입 페이지로 이동</a>
		</div>
	</c:if>
	
	<c:if test="${user != null}">
		<div>
			<br><a href="<c:url value="/logout"/>">로그아웃 페이지로 이동</a>
		</div>
	</c:if>



	<c:forEach items="${list}" var="member" varStatus="vs">
		<p>${vs.count}, ${vs.index}, 아이디 : ${member.me_id}, 비번 : ${member.me_pw}</p>
	</c:forEach>
	
	<c:url var="url" value="/board/list">
		<c:param name="page" value="1"/>
		<c:param name="search" value="제목"/>		
	</c:url>
	<a href="${url}">게시글 리스트로 이동</a>
	<br>${url}
	
	<hr>
	
	<c:set var="grade" value="1"/>
	${grade}
	
</body>
</html>