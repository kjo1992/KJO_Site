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
<div class="card mb-3">
<JSTL:forEach items="${orderList.list}" var="list" varStatus="status" begin="0" end="0">
<h5 class="card-header">${list.orderNum}
<small>(<fmt:formatDate value="${list.orderDate}" pattern="yyyy-MM-dd HH:mm"/>)</small>
</h5>
</JSTL:forEach>
<div class="card-body">
	<table class="table" style="table-layout:fixed; word-break:break-all;">
		<JSTL:forEach items="${orderList.list}" var="list" varStatus="status">
		<tr>
			<td style="width:250px;">
				<img src="${list.productImgPath_0}" width="200px" height="150px">
			</td>
			<td style="vertical-align: middle;">
				<div>
					<h6>제품명 : <a href="${pageContext.request.contextPath}/Product/Detail?typeNum=${list.typeNum}&productName=${list.productName}&productListNum=${list.productListNum}"><b>${list.productName}</b></a></h6>
					주문수량 : <fmt:formatNumber pattern="#,###" value="${list.amount}"></fmt:formatNumber>개<br/>
					제품가격 : <fmt:formatNumber pattern="#,###" value="${list.productPrice}"></fmt:formatNumber>&nbsp;￦<br/>
					최종가격 : <fmt:formatNumber pattern="#,###" value="${list.amount * list.productPrice}"></fmt:formatNumber>&nbsp;￦
				</div>
			</td>
		</tr>
		</JSTL:forEach>
	</table>
		<JSTL:forEach items="${orderList.list}" var="list" varStatus="status" begin="0" end="0">
		<div class="jumbotron">
			<p class="lead">수령인 : ${list.recipient}</p>
			<p class="lead">배송지 : ${list.recipientAdrress}</p>
			<p class="lead">연락처 : ${list.recipientContact}</p>
			<hr class="my-4">
			<h5>총 가격 : <fmt:formatNumber pattern="#,###" value="${list.totalPrice}"></fmt:formatNumber>&nbsp;￦</h5>
		</div>
		</JSTL:forEach>
</div>
</div>
</section>
<footer><jsp:include page="/WEB-INF/views/Layout/Footer.jsp" flush="false"></jsp:include></footer>
</body>
</html>