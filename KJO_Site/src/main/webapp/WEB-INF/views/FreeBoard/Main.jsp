<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%-- <%@ include file="/WEB-INF/views/Layout/SiteHeader.jsp" %> --%>
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
<div>
	<table class="table table-hover" style="table-layout:fixed; word-break:break-all;">
		<thead>
			<tr class="text-center">
				<th scope="col" style="width:10%;">글번호</th>
				<th scope="col" style="width:10%;">분류</th>
				<th scope="col" style="width:40%;">글제목</th>
				<th scope="col" style="wdith:20%;">작성자</th>
				<th scope="col" style="wdith:10%;">작성일자</th>
				<th scope="col" style="width:10%;">조회수</th>
			</tr>
		</thead>
  		<JSTL:forEach items="${ BoardList }" var="ListPaging">
			<tr class="text-center">
				<td class="small">${ ListPaging.boardNum }</td>
				<td class="small">${ ListPaging.boardCategory }</td>
				<td>
					<a href="${pageContext.request.contextPath}/FreeBoard/DetailPage?bnum=${ListPaging.boardNum}">${ ListPaging.boardSubject }</a>
					<span class="badge badge-primary badge-pill">${ ListPaging.replyCount }</span>
				</td>
				<td class="small">${ ListPaging.writerName }</td>
				<td class="small"><fmt:formatDate pattern="yyyy-MM-dd HH:mm" value="${ ListPaging.boardWriteDate }"/></td>
				<td class="small">${ ListPaging.boardReadCnt }</td>
			</tr>
		</JSTL:forEach>
		<tr>
			<td colspan="6"></td>
		</tr>
	</table>
	<div class="">
		<ul class="pagination pagination-sm float-left">
			<JSTL:choose>
				<JSTL:when test="${Page.prev}">
					<li class="page-item">
						<a class="page-link" href="${pageContext.request.contextPath}/FreeBoard/List?pageNum=${Page.startPage-1}&amouont=${Page.cri.amount}&keyword=${Page.cri.keyword}">&laquo;</a>
					</li>
				</JSTL:when>
				<JSTL:otherwise>
					<li class="page-item disabled">
						<a class="page-link" href="${pageContext.request.contextPath}/FreeBoard/List?pageNum=${Page.startPage-1}&amouont=${Page.cri.amount}&keyword=${Page.cri.keyword}">&laquo;</a>
					</li>
				</JSTL:otherwise>
			</JSTL:choose>
			<JSTL:forEach var="num" begin="${Page.startPage}" end="${Page.endPage}">
				<li class="page-item">
					<a class="page-link" href="${pageContext.request.contextPath}/FreeBoard/List?pageNum=${num}&amount=${Page.cri.amount}&keyword=${Page.cri.keyword}">${num}</a>
				</li>
			</JSTL:forEach>
			<JSTL:choose>
				<JSTL:when test="${Page.next}">
					<li class="page-item">
						<a class="page-link" href="${pageContext.request.contextPath}/FreeBoard/List?pageNum=${Page.endPage+1}&amouont=${Page.cri.amount}&keyword=${Page.cri.keyword}">&raquo;</a>
					</li>			
				</JSTL:when>
				<JSTL:otherwise>
					<li class="page-item disabled">
						<a class="page-link" href="${pageContext.request.contextPath}/FreeBoard/List?pageNum=${Page.endPage+1}&amouont=${Page.cri.amount}&keyword=${Page.cri.keyword}">&raquo;</a>
					</li>			
				</JSTL:otherwise>
			</JSTL:choose>
		</ul>
		<JSTL:if test="${LoginUser ne null}">
			<a href="${pageContext.request.contextPath}/FreeBoard/WritePage">
			<button type="button" class="btn btn-secondary float-right">글쓰기</button></a>
		</JSTL:if>
	</div>
	<form action="${pageContext.request.contextPath}/FreeBoard/List" method="get">
	<div class="input-group"  style="max-width:40%; margin:0 auto; clear:both;">
		<select class="custom-select" style="max-width:20%;" name="searchOption">
	      <option value="searchSubject">제목</option>
	      <option value="searchContent">내용</option>
	      <option value="searchSubCon">제목+내용</option>
	      <option value="searchWriter">작성자</option>
	    </select>
		<input type="text" name="pageNum" value="1" hidden>
		<input type="text" name="amount" value="${Page.cri.amount}" hidden>
	 	<input type="text" class="form-control sm-2" id="FB_Search" placeholder="Search" name="keyword">
	 	<div class="input-group-append">
			<button class="input-group-text btn" id="searchBtn" type="submit">검색</button>
		</div>
	</div>
</form>
</div>
</section>
<footer><jsp:include page="/WEB-INF/views/Layout/Footer.jsp" flush="false"></jsp:include></footer>
</body>
</html>