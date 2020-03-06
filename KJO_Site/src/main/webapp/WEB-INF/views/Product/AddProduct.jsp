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
  <h3 class="card-header">상품 등록</h3>
  <div class="card-body mb-0">
    <h5 class="card-title">제품 분류 선택</h5>
      <div class="form-group">
	  	<select class="custom-select" id="productType" name="typeNum">
	  	 <JSTL:forEach items="${ProductTypeList}" var="ProductTypeList">
	  	 	<option value="${ProductTypeList.typeNum}">${ProductTypeList.typeName}</option>
	  	 </JSTL:forEach>
	  	</select>
	  	<small id="" class="form-text text-muted">작성중 카테고리를 변경하면 입력값이 초기화됩니다.</small>
  	  </div>
  </div>
  <form action="AddProduct/Add" method="post" enctype="multipart/form-data" id="inputSpec">
  	  <div class="list-group list-group-flush">
		<li class="list-group-item">
			<label class="mt-3">제품명</label>
		  	<input type="text" class="form-control" name="productName" placeholder="">
		  	<label class="mt-3">판매가격</label>
		  	<input type="number" class="form-control" name="productPrice" placeholder="">
		  	<label class="mt-3">남은수량</label>
		  	<input type="number" class="form-control" name="amount" placeholder="">
		  	<label class="mt-3">상품이미지</label>
		  	<div class="custom-file">
		   		<label class="custom-file-label" for="productImg" id="productImglabel">등록된 이미지가 없습니다.</label>
				<input type="file" class="custom-file-input form-control" name="productImg" id="productImg" multiple="multiple" accept="image/jpg, image/jpeg, image/png, image/bmp">
				<small id="" class="form-text text-muted">bmp, png, jpg, jpeg 만 가능, 개별 파일당 2mb 이하, 최대 4장까지</small>
			</div>
			<label class="mt-3">이미지 미리보기</label>
			<div class="jumbotron" style="height:200px; padding:5px;" id="loadImg_wrap"></div>
		</li>
	  </div>
	  <div id="inputData">
	    <%-- <jsp:include page="/WEB-INF/views/Product/inputData/CPU.jsp" flush="false"></jsp:include> --%>
	  </div>  	
	  <div class="card-footer text-muted">
		<button type="submit" class="btn btn-primary" id="submitBtn">상품 등록</button>
	  </div>
  </form>
</div>
</section>
<footer><jsp:include page="/WEB-INF/views/Layout/Footer.jsp" flush="false"></jsp:include></footer>
</body>
<script src="${pageContext.request.contextPath}/resources/js/Product/AddProduct.js"></script>
<%-- <script src="${pageContext.request.contextPath}/resources/js/Product/inputSpec.js"></script> --%>
</html>