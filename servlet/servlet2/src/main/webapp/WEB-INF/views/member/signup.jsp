<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원가입</title>
<jsp:include page="/WEB-INF/views/common/cdn.jsp"></jsp:include>

</head>
<body>
<jsp:include page="/WEB-INF/views/common/navbar.jsp"></jsp:include>
<div class=container style="min-height: calc(100vh - 240px);">
	<h1 style="margin-bottom: 10px; margin-top: 10px;">회원가입</h1>
	<p>설명 입력해주면 좀 멋있음</p>
	<form action="<c:url value="/signup"/>"  method="post" id="form">
		<div class="form-group">
		  <label for="id">아이디:</label>
		  <input type="text" class="form-control" id="id" name="me_id">
		  <div class="d-flex flex-row-reverse">
		 	 <button id="checker" class="p-2 btn btn-idcheck bg-primary" type="button" style="margin-top: 5px;">아이디 중복 체크</button>
		  </div>
		</div>
		<div class="form-group">
		  <label for="pw">비번:</label>
		  <input type="password" class="form-control" id="pw" name="me_pw">
		</div>
		<div class="form-group">
		  <label for="pw2">비번:</label>
		  <input type="password" class="form-control" id="pw2" name="me_pw2">
		</div>
		<div class="form-group">
		  <label for="email">이메일:</label>
		  <input type="text" class="form-control" id="email" name="me_email">
		</div>
		<input type="hidden" class="form-control" id="idcheck" name="id_ch">
		 <div class="d-flex flex-row-reverse">
	   		<button class="p-2 btn btn-signup bg-primary" type="submit">회원가입</button>
		 </div>
		
	</form>
	

</div>
<jsp:include page="/WEB-INF/views/common/jumbotron.jsp"></jsp:include>
	
<script>
		$('#form').validate({
			rules : {
				id : {
					required : true,
					regex : /^\w{6,13}$/
				},
				pw : {
					required : true,
					regex : /^[a-zA-Z0-9!@#$]{6,15}$/
				},
				pw2 : {
					equalTo : pw
				},
				email : {
					required : true,
					email : true
				}
			},
			/*
			messages : 유효성 검사가 맞지 않을 때 출력할 메세지들. 객체
				- 최대, 최소 글자의 값을 가져오려면 {0} 형태로 사용하면 됨
			 */
			messages : {
				id : {
					required : '필수 항목입니다.',
					regex : '아이디는 영어, 숫자만 가능하며, 6~13자이어야 합니다.'
				},
				pw : {
					required : '필수 항목입니다.',
					regex : '아이디는 영어, 숫자, 특수문자(!@#$)만 가능하며, 6~15자이어야 합니다.'
				},
				pw2 : {
					equalTo : '비번과 일치하지 않습니다.'
				},
				email : {
					required :'필수 항목입니다.',
					email : 'email 형식이 아닙니다'
				}
			},
			/*
			submitHandler : 유효성 검사에 성공하면 전송하기 전 확인할 작업을 처리하는 속성. 함수
			 */
			submitHandler : function() {

				return true;
			}
		});
		$.validator.addMethod('regex', function(value, element, regex) {
			var re = new RegExp(regex);
			return this.optional(element) || re.test(value);
		}, "정규표현식을 확인하세요.");

		

		
		</script>

<script type="text/javascript">
$('#checker').click(function (e) {
	
	var id = $('[name=me_id]').val();
	console.log(id);
	var regex = /^\w{6,13}$/;
	var res = false;

	
	if(!regex.test(id)){
		alert("아이디는 영어, 숫자만 가능하며, 6~13자 이어야 합니다.");
		return;
	}
	
	
	$.ajax({
		url:'<c:url value="/check/id"/>',
		async: false,
		data:{
			'me_id' : id
		},
		success: function(data) {
			
			res = data.result;
			
			if(res){
				call_confirm();
			} else {
				alert("중복된 아이디 입니다.")
				$('#id').val('');
			}
			
			console.log(data);
		},
		error: function(err) {
			console.log(err);
		}
	});
	
	
	

});


function call_confirm() {
	if(confirm("사용가능한 아아디 입니다. 이 아이디로 하시겠습니까?")){
		alert("아이디 중복 확인 성공.");
		document.getElementById('id').disabled = true;
		call_ajax_server_id_check();//아이디가 성공적으로 "중복이 아님" 을 확인하고, 사용자가 아이디 사용을 선택했다면
	}else{
		alert("사용할 다른 아이디를 입력해 주세요.");
	}
}


function call_ajax_server_id_check() {
	alert('idc')
	
	$("#idcheck").val('good');
	var str = $('#idcheck').val();
	console.log(str);
	
}

$(".btn-signup").click(function(e) {
	document.getElementById('id').disabled = false;
});
</script>

	
	
</body>
</html>