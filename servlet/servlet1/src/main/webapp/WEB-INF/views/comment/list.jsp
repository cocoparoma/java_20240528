<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>${co.co_name} 커뮤니티</title>
<jsp:include page="/WEB-INF/views/common/head.jsp"/>
<style type="text/css">




</style>
<script type="text/javascript">

</script>

</head>
<body>
	<jsp:include page="/WEB-INF/views/common/header.jsp"/>
	

	
	<div class="container">
          
	<form class="input-group mb-3" action="<c:url value="/post/list"/>">
	  
		  <div class="input-group-prepend">
			  	<select class="form-control" name="type">
			  		<c:if test="${pm.cri.type=='all'}">selected</c:if>
			  		<option value="all" <c:if test="${pm.cri.type=='all'}">selected</c:if>>전체</option>
			  		<option value="name" <c:if test="${pm.cri.type=='name'}">selected</c:if>>제목</option>
			  		<option value="id" <c:if test="${pm.cri.type=='id'}">selected</c:if>>작성자</option>
			  	</select>
		  </div>
		  
		  <input type="text" class="form-control" placeholder="검색어를 입력하세요." name="search" value="${pm.cri.search }">
  		  <div class="input-group-append">
		   	 <button class="btn btn-primary" type="submit">검색</button>
	 	   </div>
	 	   <input type="hidden" name="co_id" value = "${pm.cri.co_id}">
	</form>
          
  <table class="table table-hover">
    <thead>
      <tr>
        <th>번호</th>
        <th>제목</th>
       	<th>작성자</th>  
        <th>작성일</th>
        <th style="text-align: center;">추천/비추천</th>
        <th>조회수</th>
      </tr>
    </thead>
    <tbody>
      <c:forEach items="${list}" var="po">
     
      <tr>
         <td>${po.po_id}</td> <!--: 실제 게시글 번호  -->
        <!--<td>${pm.totalCount - vs.index - pm.cri.pageStart}</td> --> <!-- :현제 게시글번호 -->
        <td><a style="color: black;" class="nav" href="<c:url value="/post/detail?po_id=${po.po_id}"/>">${po.po_name}</a></td>
        <td>${po.po_me_id}</td>
        <td>${po.po_date}</td>
        
        <c:choose>
        	<c:when test="${po.po_up eq 0 && po.po_down eq 0}"><td style="text-align: center;">0</td></c:when>
        	<c:when test="${po.po_down eq 0}"><td style="text-align: center;">+${po.po_up}/${po.po_down}</td></c:when>
        	<c:when test="${po.po_up eq 0}"><td style="text-align: center;">${po.po_up}/-${po.po_down}</td></c:when>
        	<c:otherwise><td style="text-align: center;">+${po.po_up}/-${po.po_down}</td></c:otherwise>
        </c:choose>
       	
       	<td>${po.po_view}</td>
      </tr>
      </c:forEach>


      <c:if test="${list.size() == 0}">
          <tr>
   	     	<th colspan="6" class="text-center">등록된 계시글이 없습니다.</th>
          </tr>
      </c:if>

    </tbody>
  </table>
  
  <div class="container">
	  <ul class="pagination justify-content-center">
	  	<c:if test="${pm.prev}">
		    <li class="page-item">
		    	<c:url var="url" value="/post/list">
		    		<c:param name="co_id" value="${pm.cri.co_id}"/>
		    		<c:param name="page" value="${pm.startPage - 1}"/>
		    	</c:url>
		    	<a class="page-link" href="${url}">이전</a>
	    	</li>
	    </c:if>
	    <c:forEach begin="${pm.startPage}" end="${pm.endPage}" var="i">
	   	
	   	<c:choose>
	   		<c:when test="${pm.cri.page==i}">
	   			    <c:set var="active" value="active"/>
	   		</c:when>
	   		<c:otherwise>
	  		 		 <c:set var="active" value=""/>
	   		</c:otherwise>
	   	</c:choose>
	    
		    <li class="page-item ${active}">
		    	<c:url var="url" value="/post/list">
		    		<c:param name="co_id" value="${pm.cri.co_id}"/>
		    		<c:param name="page" value="${i}"/>
		    	</c:url>
		    
		    
		    	<a class="page-link" href="${url}">${i}</a>
	    	</li>
	    </c:forEach>	
	  	<c:if test="${pm.next}">
		    <li class="page-item">
		    	<c:url var="url" value="/post/list">
		    		<c:param name="co_id" value="${pm.cri.co_id}"/>
		    		<c:param name="page" value="${pm.endPage +1}"/>
		    	</c:url>
		    	<a class="page-link" href="${url}">다음</a>
		    </li>
	    </c:if>
	  </ul>
	  
	  <a href="<c:url value="/post/insert?co_id=${pm.cri.co_id}"/>" class="btn btn-outline-danger">게시글 등록</a>
  </div>
</div>
</body>
</html>