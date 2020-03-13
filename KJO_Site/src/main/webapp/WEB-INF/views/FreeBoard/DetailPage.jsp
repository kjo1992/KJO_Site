<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="JSTL" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<nav id="SiteHeader"><jsp:include page="/WEB-INF/views/Layout/Header.jsp" flush="false"></jsp:include></nav>
<section>
<article>
<div id="detailBody" style="margin:0 auto;">
	<div class="card border-secondary mb-3" id="detailbody">
	  <div class="card-header">
	  	<table style="margin:0 auto; width:100%; table-layout:fixed; word-break:break-all;">
	  		<tr>
	  			<td class="text-left">${FBDetail.writerName}</td>
	  			<td class="text-center"><b><fmt:formatDate pattern="yyyy-MM-dd HH:mm" value="${FBDetail.boardWriteDate}"></fmt:formatDate></b></td>
	  			<td class="text-right">조회수 : ${FBDetail.boardReadCnt}</td>
	  		</tr>
	  	</table>
	  </div>
	  <div class="card-body">
	  	<p><b>[${FBDetail.boardCategory}]</b></p>
	    <h4 class="card-title">${FBDetail.boardSubject}</h4>
	    <p class="card-text">${FBDetail.boardContent}</p>
	    <JSTL:if test="${FBDetail.writerNum eq LoginUser.getUserNum()}">
	    	<div class="card-body">
		    	<div class="float-right">
			    <form class="float-left" action="${pageContext.request.contextPath}/FreeBoard/UpdatePage?bnum=${FBDetail.boardNum}&unum=${FBDetail.writerNum}" method="post" id="UpdateForm">
			    	<button type="submit" class="btn btn-link" id="UpdateBtn">수정</button>
				</form>
				<form class="float-right" action="${pageContext.request.contextPath}/FreeBoard/Delete?bnum=${FBDetail.boardNum}&unum=${FBDetail.writerNum}" method="post" id="DeleteForm">
					<button type="submit" class="btn btn-link" id="DeleteBtn">삭제</button>
				</form>
				</div>
			</div>
	    </JSTL:if>
	    <div class="card-body">
		    <p class="card-text text-right float-none">최종수정일 : 
		    <fmt:formatDate pattern="yyyy-MM-dd HH:mm" value="${FBDetail.boardUpdateDate}"/></p>
	    </div>
	  </div>
	</div>
</div>
<JSTL:choose>
	<JSTL:when test="${LoginUser ne null}">
		<div class="card-header">
			<form action="${pageContext.request.contextPath}/FreeBoard/WriteReply">
			<div class="input-group" style="margin:0 auto; max-width:90%">
				<input type="text" value="${FBDetail.boardNum}" name="boardNum" hidden>
				<input type="text" value="${LoginUser.getUserNum()}" name="replyerNum" hidden>
				<textarea class="form-control" rows="4" style="resize: none;" placeholder="댓글을입력해주세요" name="replyText" id="ReplyText"></textarea>
				<div class="input-group-append">
					<button class="input-group-text btn" id="replyBtn" type="submit">작성</button>
				</div>
			</div>
			</form>
		</div>
	</JSTL:when>
	<JSTL:otherwise>
		<div class="card-header">
			<input type="text" class="form-control-plaintext" placeholder="댓글을 작성하려면 로그인이 필요합니다.">
		</div>
	</JSTL:otherwise>
</JSTL:choose>
<JSTL:forEach items="${FBReply}" var="reply">
	<div class="card border-light mb-0">
		<div class="card-body">
	    	<p class="lead">${reply.replyerName}
	    	<small class="small">(<fmt:formatDate pattern="yyyy-MM-dd HH:mm" value="${reply.replyWriteDate}"></fmt:formatDate>)
	    	<JSTL:if test="${reply.replyerNum eq LoginUser.getUserNum()}">
	    		<a href="${pageContext.request.contextPath}/FreeBoard/DeleteReply?rnum=${reply.replyNum}&bnum=${FBDetail.boardNum}&unum=${reply.replyerNum}">&times;</a>
	    	</JSTL:if>
	    	</small></p>
	    	<p class="card-text">${reply.replyText}</p>
	  	</div>
	</div>
</JSTL:forEach>
</article>
</section>
<footer><jsp:include page="/WEB-INF/views/Layout/Footer.jsp" flush="false"></jsp:include></footer>
</body>
<script src="${pageContext.request.contextPath}/resources/js/FreeBoard/Detail.js"></script>
</html>