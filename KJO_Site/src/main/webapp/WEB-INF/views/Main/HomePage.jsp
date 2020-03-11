<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="JSTL" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Welcome</title>
<link href="${pageContext.request.contextPath}/resources/css/bxslider.css" rel="stylesheet">
</head>
<body>
<nav id="SiteHeader"><jsp:include page="/WEB-INF/views/Layout/Header.jsp" flush="false"></jsp:include></nav>
<section>
<!-- 이미지 -->
<div>
	<div class="card-body mb-3 float-left">
		<div style="width:300px; margin:0 auto;">
			<ul id="slider">
			<JSTL:forEach items="${productList['ProductList']}" var="list" varStatus="status">
				<li><a href="${pageContext.request.contextPath}/Product/Detail?typeNum=${list.typeNum}&productName=${list.productName}&productListNum=${list.productListNum}">
					<img class="productImg" src="${list.productImgPath_0}" title="${list.productName}"></a>
				</li>
			</JSTL:forEach>
			</ul>
		</div>
	</div>
	
	<!-- 댓글 -->
	<div class="card-body mb-3 float-right w-50">
		<table class="table table-hover" style="table-layout:fixed;">
			<thead>
			<tr>
				<td class="text-center" style="width:100px;">평점</td>
				<td class="text-center" style="width:200px;">제품명</td>
				<td class="text-center">상품평</td>
			</tr>
			</thead>
		<JSTL:forEach items="${productReply}" var="list" varStatus="status">
			<tr>
				<td class="text-center"><b>${list.rating}</b></td>
				<td style="overflow:hidden; text-overflow:ellipsis; word-break:break-all; white-space:nowrap;">
					<a href="${pageContext.request.contextPath}/Product/Detail?typeNum=${list.typeNum}&productName=${list.productName}&productListNum=${list.productListNum}">${list.productName}</a>
				</td>
				<td style="overflow:hidden; text-overflow:ellipsis; word-break:break-all; white-space:nowrap;">${list.replyText}</td>
			</tr>
		</JSTL:forEach>
		</table>
	</div>
</div>
<div class="card-body mb-3">
	<table class="table table-hover" style="table-layout:fixed; word-break:break-all;">
	<thead>
		<tr class="text-center">
			<th scope="col" style="width:10%;">글번호</th>
			<th scope="col" style="width:10%;">분류</th>
			<th scope="col" style="width:50%;">글제목</th>
			<th scope="col" style="wdith:15%;">작성일자</th>
			<th scope="col" style="width:15%;">조회수</th>
		</tr>
	</thead>
	<tbody>
	
	</tbody>
	<tbody>
	
	</tbody>
	<tbody>
		<JSTL:forEach items="${FreeBoard}" var="FreeBoard">
			<tr class="text-center">
				<td class="small">${FreeBoard.boardNum}</td>
				<td class="small">${FreeBoard.boardCategory}</td>
				<td class="small">
					<a href="${pageContext.request.contextPath}/FreeBoard/DetailPage?bnum=${FreeBoard.boardNum}">${FreeBoard.boardSubject}</a>
				</td>
				<td class="small"><fmt:formatDate pattern="yyyy-MM-dd HH:mm" value="${FreeBoard.boardWriteDate}"/></td>
				<td class="small">${FreeBoard.boardReadCnt}</td>
			</tr>
		</JSTL:forEach>			
	</tbody>
</table>
</div>

</section>
<footer><jsp:include page="/WEB-INF/views/Layout/Footer.jsp" flush="false"></jsp:include></footer>
</body>
<script src="${pageContext.request.contextPath}/resources/js/bxslider.js"></script>
<script src="${pageContext.request.contextPath}/resources/js/Main/HomePage.js"></script>
<style>
.bx-wrapper {
	border: 0px solid;
	-moz-box-shadow: 0 0 0px #ccc;
  	-webkit-box-shadow: 0 0 0px #ccc;
  	box-shadow: 0 0 0px #ccc;
  	margin-bottom: 0px; /* 60px; */

}

.productImg {
	min-height: 300px;
	min-width: 300 px;
}
</style>
</html>
