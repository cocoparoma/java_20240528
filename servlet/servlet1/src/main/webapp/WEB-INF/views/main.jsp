<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>메인</title>
	<style>
		#container{
			background-color: red;
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
	</div>
</body>
</html>