<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>메인</title>
	<style>
		#container{
			background-color: lightblue;
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
	<div>
		<br><a href="<%=request.getContextPath()%>/login">로그인 페이지로 이동</a>
		
		<br><a href="<%=request.getContextPath()%>/signup">회원가입 페이지로 이동</a>
	</div>
	

	${user}
</body>
</html>