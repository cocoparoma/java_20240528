<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>    
<script type="text/javascript">
var msg = '${msg}';
var url = '${url}';
if (msg != ''){
	alert(msg);
	location.href = '<%=request.getContextPath()%>' + url;
}
</script>