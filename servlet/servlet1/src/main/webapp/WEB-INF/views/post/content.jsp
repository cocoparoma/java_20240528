<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>${po.po_name} </title>
<jsp:include page="/WEB-INF/views/common/head.jsp"/>
<style type="text/css">




</style>
<script type="text/javascript">

</script>

</head>
<body> <jsp:include page="/WEB-INF/views/common/header.jsp"/>
	<div class="container pt-3">
		<h1>${po.po_name}</h1>
	</div>



</body>
</html>