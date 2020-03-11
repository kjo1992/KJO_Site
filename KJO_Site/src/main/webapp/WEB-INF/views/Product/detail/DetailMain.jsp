<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="JSTL" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>${productDetail.productName}</title>
<%-- <link href="${pageContext.request.contextPath}/resources/css/lightslider.css" rel="stylesheet"> --%>
<link href="${pageContext.request.contextPath}/resources/css/bxslider.css" rel="stylesheet">
</head>
<body>
<nav id="SiteHeader"><jsp:include page="/WEB-INF/views/Layout/Header.jsp" flush="false"></jsp:include></nav>
<section>

<div class="card mb-3 border-primary">
	<div class="card-header">
	<h3>${productDetail.productName}</h3>
	</div>
	<div class="card-body">
		<table style="width:100%;">			
		<tr>
			<td style="width:400px;">
			<div class="" style="width:300px; margin:0 auto;">
				<ul id="slider" class="mb-0" style="border:0px solid;">
				<JSTL:forEach items="${productDetail}" var="detail" varStatus="status">
					<JSTL:set var="find" value="${detail.key}"></JSTL:set>
					<JSTL:if test="${fn:contains(find,'productImgPath')}">
						<li>
							<img src="${detail.value}" alt="${productDetail.productName}_${find}" width="100%" height="100%">
						</li>
					</JSTL:if>
				</JSTL:forEach>
				</ul>
				<div id="sliderPager" style="text-align:center;">
				<JSTL:set var="count" value="0" />
				<JSTL:forEach items="${productDetail}" var="detail" varStatus="status">
					<JSTL:set var="find" value="${detail.key}"></JSTL:set>
					<JSTL:if test="${fn:contains(find,'productImgPath')}">
						<a href="" data-slide-index="${count}"><img src="${detail.value}" width="50px;" height="50px;"></a>
						<JSTL:set var="count" value="${count+1}"></JSTL:set>
					</JSTL:if>
				</JSTL:forEach>
				</div>
			</div>
			</td>
			<td rowspan="3" style="vertical-align: top;">
				<div class="ml-4">
				<jsp:include page="${loadPage}" flush="false"></jsp:include>
				</div>
			</td>
		</tr>
		<tr>
			<td style="text-align:center;">
				<div class="mt-4">
					<p>남은수량 : <fmt:formatNumber pattern="#,###" value="${productDetail.amount}"></fmt:formatNumber>&nbsp;개</p> 
					<p>상품가격 : <fmt:formatNumber pattern="#,###" value="${productDetail.productPrice}"></fmt:formatNumber>&nbsp;￦</p>
				</div>
			</td>
		</tr>
		<JSTL:if test="${LoginUser ne null}">
		<tr>
			<td>
				<form style="margin:0 auto;">
				<div class="input-group mb-3">			
					<div class="input-group-prepend">
						<span class="input-group-text">구매수량</span>
					</div>
					<input type="number" value="${productDetail.productListNum}" name="productListNum" id="productListNum" hidden>
					<input style="max-width:100px;" class="form-control" type="number" min="1" max="10" value="1" name="amount" id="amount">
					<div class="input-group-append">
						<span class="input-group-text btn" id="addCartBtn">장바구니 추가</span>
					</div>
				</div>
				</form>
			</td>
		</tr>
		</JSTL:if>
		</table>
	</div>
</div>
<!-- 리뷰 작성 -->
<JSTL:if test="${LoginUser ne null}">
<div class="table-active" style="width:100%;">
	<form action="${pageContext.request.contextPath}/Product/addReply" method="POST">
	<div class="card-body">
	<select class="form-control" style="width:130px;" name="rating">
		<!-- <option selected hidden>평점 선택</option> -->
		<JSTL:forEach items="${ratingOptions}" var="rating" varStatus="status">
		<option value="${rating.key}">${rating.value}</option>
		</JSTL:forEach>
	</select>
	<div class="input-group">
		<div class="input-group-prepend">
			<span class="input-group-text">내용</span>
		</div>
		<input style="" class="form-control" type="text" name="replyText" id="">
		<input type="text" value="${productDetail.productListNum}" name="productListNum" readonly hidden>
		<input type="text" value="${productDetail.typeNum}" name="typeNum" readonly hidden>
		<input type="text" value="${productDetail.productName}" name="productName" readonly hidden>
		<div class="input-group-append">
			<button class="input-group-text btn" id="" type="submit">리뷰 작성</button>
			<!-- <span class="input-group-text btn" id="">리뷰 작성</span> -->
		</div>
	</div>
	</div>
	</form>
</div>
</JSTL:if>
<!-- 댓글목록 -->
<div class="card mb-3">
	<div class="card-body">
		<table class="table">
			<thead>
				<tr class="text-center">
					<th scope="col" style="width:200px;">닉네임</th>
					<th scope="col" style="width:100px;">평점</th>
					<th scope="col">내용</th>
					<th scope="col" style="width:200px;">작성일자</th>
					<th style="width:50px;"></th>
				</tr>
			</thead>
			<JSTL:forEach items="${productReply}" var="reply" varStatus="status">
			<tr class="table-primary text-center">
				<td>${reply.userName}</td>
				<td><b>${reply.rating}</b></td>
				<td>${reply.replyText}</td>
				<td>
					<fmt:formatDate value="${reply.regDate}" pattern="yyyy.MM.dd hh:mm"/>
				</td>
				<td>
					<JSTL:if test="${reply.userNum eq LoginUser.getUserNum()}">
					<form class="" action="${pageContext.request.contextPath}/Product/deleteReply?productListNum=${reply.productListNum}&userNum=${reply.userNum}&typeNum=${productDetail.typeNum}&productName=${productDetail.productName}" method="post" id="">
		    			<button type="submit" class="btn btn-link p-0 m-0">&times;</button>
		    		</form>
		    		</JSTL:if>
				</td>
			</tr>
			</JSTL:forEach>
		</table>
		<div class="">
		<ul class="pagination pagination-sm">
			<JSTL:choose>
				<JSTL:when test="${Page.prev}">
					<li class="page-item">
						<a class="page-link" href="${pageContext.request.contextPath}/Product/Detail?pageNum=${Page.startPage-1}&amouont=${Page.cri.amount}&keyword=${Page.cri.keyword}&typeNum=${productDetail.typeNum}&productName=${productDetail.productName}&productListNum=${productDetail.productListNum}"">&laquo;</a>
					</li>
				</JSTL:when>
				<JSTL:otherwise>
					<li class="page-item disabled">
						<a class="page-link" href="${pageContext.request.contextPath}/Product/Detail?pageNum=${Page.startPage-1}&amouont=${Page.cri.amount}&keyword=${Page.cri.keyword}&typeNum=${productDetail.typeNum}&productName=${productDetail.productName}&productListNum=${productDetail.productListNum}"">&laquo;</a>
					</li>
				</JSTL:otherwise>
			</JSTL:choose>
			<JSTL:forEach var="num" begin="${Page.startPage}" end="${Page.endPage}">
				<li class="page-item">
					<a class="page-link" href="${pageContext.request.contextPath}/Product/Detail?pageNum=${num}&amount=${Page.cri.amount}&keyword=${Page.cri.keyword}&typeNum=${productDetail.typeNum}&productName=${productDetail.productName}&productListNum=${productDetail.productListNum}">${num}</a>
				</li>
			</JSTL:forEach>
			<JSTL:choose>
				<JSTL:when test="${Page.next}">
					<li class="page-item">
						<a class="page-link" href="${pageContext.request.contextPath}/Product/Detail?pageNum=${Page.endPage+1}&amouont=${Page.cri.amount}&keyword=${Page.cri.keyword}&typeNum=${productDetail.typeNum}&productName=${productDetail.productName}&productListNum=${productDetail.productListNum}">&raquo;</a>
					</li>			
				</JSTL:when>
				<JSTL:otherwise>
					<li class="page-item disabled">
						<a class="page-link" href="${pageContext.request.contextPath}/Product/Detail?pageNum=${Page.endPage+1}&amouont=${Page.cri.amount}&keyword=${Page.cri.keyword}&typeNum=${productDetail.typeNum}&productName=${productDetail.productName}&productListNum=${productDetail.productListNum}">&raquo;</a>
					</li>			
				</JSTL:otherwise>
			</JSTL:choose>
		</ul>
	</div>
	</div>
</div>
</section>
<footer><jsp:include page="/WEB-INF/views/Layout/Footer.jsp" flush="false"></jsp:include></footer>
</body>

<%-- <script src="${pageContext.request.contextPath}/resources/js/lightslider.js"></script> --%>
<script src="${pageContext.request.contextPath}/resources/js/bxslider.js"></script>
<script src="${pageContext.request.contextPath}/resources/js/Product/DetailProduct.js"></script>
<style>
.bx-wrapper {
	border: 0px solid;
	-moz-box-shadow: 0 0 0px #ccc;
  	-webkit-box-shadow: 0 0 0px #ccc;
  	box-shadow: 0 0 0px #ccc;
  	margin-bottom: 0px; /* 60px; */
}
</style>

</html>
