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
<!-- <div>
	<span style="float:left;" class="custom-control custom-checkbox">
		<input type="checkbox" class="custom-control-input" id="allCheck">
		<label class="custom-control-label" for="allCheck">모두 선택</label>
	</span>
	<span style="float: right;">
		<button class="btn btn-secondary btn-sm" id="selectDeleteBtn">선택삭제</button>
	</span>
</div> -->
<table style="width:100%;" class="table table-hover">
	<thead>
	<tr>
		<td colspan="5">
			<span style="float:left;" class="custom-control custom-checkbox">
				<input type="checkbox" class="custom-control-input" id="allCheck">
				<label class="custom-control-label" for="allCheck">모두 선택</label>
			</span>
			<span style="float: right;">
				<button class="btn btn-secondary btn-sm" id="selectDeleteBtn">선택삭제</button>
			</span>		
		</td>
	</tr>
	<tr style="text-align:center;" class="card-header">
		<th></th>
    	<th scope="col">상품 이미지</th>
	    <th scope="col">상품명/수량/가격</th>
    	<th scope="col">상품별 총가격</th>
    	<th></th>
    </tr>
  	</thead>
	<JSTL:forEach items="${cartList}" var="list" varStatus="status">
	<tr>
		<td style="vertical-align: middle;">
			<div class="custom-control custom-checkbox">
				<input type="checkbox" name="chkBox" class="custom-control-input chkBox" id="check_${status.index}" data-cartNum="${list.cartNum}" data-price="${list.amount * list.productPrice}" data-productListNum="${list.productListNum}">
				<label class="custom-control-label" for="check_${status.index}"></label>
			</div>
		</td>
		<td style="width:200px;">
			<a href="${pageContext.request.contextPath}/Product/Detail?typeNum=${list.typeNum}&productName=${list.productName}"><img src="${list.productImgPath_0}" width="200px" height="150px"></a>
		</td>
		<td style="vertical-align: top; text-align: left;">
			<a href="${pageContext.request.contextPath}/Product/Detail?typeNum=${list.typeNum}&productName=${list.productName}"><h4>${list.productName}</h4></a>
			<div class="form-group" style="max-width:250px;">
				<div class="input-group mb-3">
					<div class="input-group-prepend">
						<span class="input-group-text">구매수량</span>
					</div>
					<input type="number" class="form-control changeAmount_${list.cartNum}" value="${list.amount}">
					<div class="input-group-append">
						<span class="input-group-text changeAmountBtn" data-cartNum="${list.cartNum}">변경</span>
					</div>
				</div>
				<div>
					<div>제품가격 : <fmt:formatNumber value="${list.productPrice}" pattern="#,###"></fmt:formatNumber> ￦</div>
				</div>
			</div>
		</td>
		<td style="text-align:center; vertical-align: middle;">
			<JSTL:set var="amountPrice" value="${list.amount * list.productPrice}"></JSTL:set>
			<fmt:formatNumber value="${amountPrice}" pattern="#,###"></fmt:formatNumber> ￦
		</td>
		<td style="vertical-align: middle;">
			<button class="btn btn-secondary" id="deleteBtn" data-cartNum="${list.cartNum}">삭제</button>
		</td>
	</tr>
	<JSTL:set var="totalPrice" value="${totalPrice + amountPrice}"></JSTL:set>
	</JSTL:forEach>
	<tr class="card-header">
		<td colspan="5">
			<div style="float:left;">
				<h5>총 구매 가격 : <span id="totalPrice"></span>&nbsp;￦</h5>
			</div>
			<div style="float:right;"><button class="btn btn-secondary btn-sm" id="inputOrderBtn">주문정보 입력</button></div>
			<div style="clear:both;" id="inputOrderForm" hidden>
				<form action="addOrder" method="POST" name="orderForm" id="orderForm">
					<div class="form-group">
					  <label class="col-form-label col-form-label-sm" for="recipient">수령인</label>
					  <input class="form-control form-control-sm orderInput" type="text" placeholder="수령인 이름 입력" id="recipient" name="recipient">
					</div>
					<div class="form-group">
					  <label class="col-form-label col-form-label-sm" for="recipientAdrress">주소</label>
					  <input class="form-control form-control-sm orderInput" type="text" placeholder="수령인 주소 입력" id="recipientAdrress" name="recipientAdrress">
					</div>
					<div class="form-group">
					  <label class="col-form-label col-form-label-sm" for="recipientContact">연락처</label>
					  <input class="form-control form-control-sm orderInput" type="text" placeholder="수령인 연락처 입력" id="recipientContact" name="recipientContact">
					</div>
					<input class="form-control form-control-sm orderInput" type="number" value="" id="totalPriceInput" name="totalPrice" hidden>
					<div>
					  <button type="submit" class="btn btn-secondary btn-sm mr-3" id="orderSubmit">주문하기</button>
					  <button type="button" class="btn btn-secondary btn-sm" id="orderCancleBtn">주문취소</button>
					</div>
				</form>
			</div>
		</td>
	</tr>
</table>
</section>
<footer><jsp:include page="/WEB-INF/views/Layout/Footer.jsp" flush="false"></jsp:include></footer>
</body>
<script src="${pageContext.request.contextPath}/resources/js/cart/cartList.js"></script>
</html>