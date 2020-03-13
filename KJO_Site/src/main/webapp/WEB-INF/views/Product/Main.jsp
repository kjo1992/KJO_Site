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
<table class="table table-hover">
	<thead>
		<tr style="text-align:center;">
			<th>이미지</th>
			<th>상품명</th>
			<th>수량,평점</th>
			<th>가격</th>
		</tr>
	</thead>
	<JSTL:forEach items="${ProductList['ProductList']}" var="list">
	<tr class="text-center;">
	  <td><img src="${list.productImgPath_0}" width="150px" height="150px"></td>
      <td><a href="${pageContext.request.contextPath}/Product/Detail?typeNum=${list.typeNum}&productName=${list.productName}&productListNum=${list.productListNum}"><b>${list.productName}</b></a><br/>
      	<div style="vertical-align:middle;">
      		<JSTL:forEach items="${list}" var="spec" varStatus="status" begin="7">
      			<JSTL:choose>
      				<JSTL:when test="${status.last}">
      					${spec.value}
      				</JSTL:when>
      				<JSTL:otherwise>
      					${spec.value} /		
      				</JSTL:otherwise>
      			</JSTL:choose>
			</JSTL:forEach>
		</div>
      </td>
      <td style="width:150px; text-align:center; vertical-align:middle;">
      	<p><fmt:formatNumber pattern="#,###" value="${list.amount}"></fmt:formatNumber> 개</p>
      	<p><fmt:formatNumber pattern="#.00" value="${list.rating}"></fmt:formatNumber> / 5.00</p>
      </td>
      <td style="width:150px; text-align:center; vertical-align:middle;">
      	<p><fmt:formatNumber pattern="#,###" value="${list.productPrice}"></fmt:formatNumber>&nbsp;￦</p>
      </td>
    </tr>
    </JSTL:forEach>
</table>
<hr>
<div class="">
	<ul class="pagination pagination-sm">
		<JSTL:choose>
			<JSTL:when test="${Page.prev}">
				<li class="page-item">
					<a class="page-link" href="${pageContext.request.contextPath}/Product/Main?pageNum=${Page.startPage-1}&amouont=${Page.cri.amount}&typeNum=${typeNum}&keyword=${Page.cri.keyword}">&laquo;</a>
				</li>
			</JSTL:when>
			<JSTL:otherwise>
				<li class="page-item disabled">
					<a class="page-link" href="${pageContext.request.contextPath}/Product/Main?pageNum=${Page.startPage-1}&amouont=${Page.cri.amount}&typeNum=${typeNum}&keyword=${Page.cri.keyword}">&laquo;</a>
				</li>
			</JSTL:otherwise>
		</JSTL:choose>
		<JSTL:forEach var="num" begin="${Page.startPage}" end="${Page.endPage}">
			<li class="page-item">
				<a class="page-link" href="${pageContext.request.contextPath}/Product/Main?pageNum=${num}&amount=${Page.cri.amount}&typeNum=${typeNum}&keyword=${Page.cri.keyword}">${num}</a>
			</li>
		</JSTL:forEach>
		<JSTL:choose>
			<JSTL:when test="${Page.next}">
				<li class="page-item">
					<a class="page-link" href="${pageContext.request.contextPath}/Product/Main?pageNum=${Page.endPage+1}&amouont=${Page.cri.amount}&typeNum=${typeNum}&keyword=${Page.cri.keyword}">&raquo;</a>
				</li>			
			</JSTL:when>
			<JSTL:otherwise>
				<li class="page-item disabled">
					<a class="page-link" href="${pageContext.request.contextPath}/Product/Main?pageNum=${Page.endPage+1}&amouont=${Page.cri.amount}&typeNum=${typeNum}&keyword=${Page.cri.keyword}">&raquo;</a>
				</li>			
			</JSTL:otherwise>
		</JSTL:choose>
	</ul>
</div>
</section>
<footer><jsp:include page="/WEB-INF/views/Layout/Footer.jsp" flush="false"></jsp:include></footer>
</body>
</html>