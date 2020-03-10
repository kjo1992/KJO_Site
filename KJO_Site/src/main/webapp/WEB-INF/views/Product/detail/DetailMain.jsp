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

<div class="card mb-3">
<div class="card-header">
<h3>${productDetail.productName}</h3>
</div>
<div class="card-body">
	<table style="border:1px solid; width:100%;">			
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
			<jsp:include page="${loadPage}" flush="false"></jsp:include>
		</td>
	</tr>
	<tr>
		<td style="text-align:center;">
			남은수량 : ${productDetail.amount} 개<br/> 
			상품가격 : ${productDetail.productPrice}
		</td>
	</tr>
	<tr>
		<td style="text-align:center;">
			<form>
				<input type="number" value="${productDetail.productListNum}" name="productListNum" id="productListNum" hidden>
				<%-- <input type="text" value="${LoginUser.userNum}" name="userNum" id="userNum" hidden> --%>
				수량 : <input type="number" min="1" max="10" value="1" name="amount" id="amount"><br/>
				<input type="button" value="장바구니 추가" id="addCartBtn">
			</form>
		</td>
	</tr>
	</table>
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
