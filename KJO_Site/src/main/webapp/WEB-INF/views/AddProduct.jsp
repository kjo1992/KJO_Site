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
<script src="${pageContext.request.contextPath}/resources/js/Product/AddProduct.js"></script>
<section>
<div class="card mb-3">
  <h3 class="card-header">상품 등록</h3>
  <div class="card-body">
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
  <form id="CPU" action="AddProduct/Add" method="post" enctype="multiprat/form-data" name="specInput" hidden>
  <ul class="list-group list-group-flush">
  	<li class="list-group-item">
		<div class="custom-file">
		    <input type="file" class="custom-file-input" name="productImg" multiple="multiple">
		    <label class="custom-file-label" for="inputGroupFile02">상품이미지 등록</label>
		</div>
	</li>
    <li class="list-group-item">
    	<label>CPU 제품명</label>
    	<input type="text" class="form-control" name="productName" placeholder="제품명 입력">
    </li>
    <li class="list-group-item">
    	<label>판매가격</label>
    	<input type="number" class="form-control" name="productPrice" placeholder="">
    </li>
    <li class="list-group-item">
    	<label>제조사</label>
    	<input type="text" class="form-control" name="manufacturer" placeholder="ex)AMD, 인텔">
    </li>
    <li class="list-group-item">
    	<label>cpu 타입</label>
    	<input type="text" class="form-control" name="cpuType" placeholder="ex)라이젠3-7, i3-7">
    </li>
    <li class="list-group-item">
    	<label>cpu 세대</label>
    	<input type="text" class="form-control" name="generation" placeholder="">
    </li>
    <li class="list-group-item">
    	<label>코어타입</label>
    	<input type="text" class="form-control" name="coreType" placeholder="">
    </li>
    <li class="list-group-item">
    	<label>쓰레드갯수</label>
    	<input type="text" class="form-control" name="threadType" placeholder="">
    </li>
    <li class="list-group-item">
    	<label>기본 클럭</label>
    	<input type="text" class="form-control" name="baseClock" placeholder="">
    </li>
    <li class="list-group-item">
    	<label>부스트 클럭</label>
    	<input type="text" class="form-control" name="boostClock" placeholder="">
    </li>
    <li class="list-group-item">
    	<label>L2Cache</label>
    	<input type="text" class="form-control" name="l2Cache" placeholder="">
    </li>
    <li class="list-group-item">
    	<label>L3Cache</label>
    	<input type="text" class="form-control" name="l3Cache" placeholder="">
    </li>
    <li class="list-group-item">
    	<label>TDP</label>
    	<input type="text" class="form-control" name="tdp" placeholder="">
    </li>
    <li class="list-group-item">
    	<label>메모리 타입</label>
    	<input type="text" class="form-control" name="memoryType" placeholder="">
    </li>
    <li class="list-group-item">
    	<label>메모리 버스</label>
    	<input type="text" class="form-control" name="memoryBus" placeholder="">
    </li>
	<li class="list-group-item">
    	<label>메모리 채널</label>
    	<input type="text" class="form-control" name="memoryChannel" placeholder="">
    </li>
    <li class="list-group-item">
    	<label>내장 그래픽유무</label>
    	<input type="text" class="form-control" name="innerGPU" placeholder="">
    </li>
    <li class="list-group-item">
    	<label>출시일</label>
    	<input type="date" class="form-control" name="releaseDate" placeholder="">
    </li>   
  </ul>
  <div class="card-footer text-muted">
	<button type="submit" class="btn btn-primary submitBtn">상품 등록</button>
  </div>
  </form>
  <form id="VGA" action="AddProduct/Add" method="post" enctype="multiprat/form-data" hidden>
  <ul class="list-group list-group-flush" >
	<li class="list-group-item">
		<div class="custom-file">
		    <input type="file" class="custom-file-input" name="productImg" multiple="multiple">
		    <label class="custom-file-label" for="inputGroupFile02">상품이미지 등록</label>
		</div>
	</li>
    <li class="list-group-item">
    	<label>VGA 제품명</label>
    	<input type="text" class="form-control" name="productName" placeholder="">
    </li>
    <li class="list-group-item">
    	<label>판매가격</label>
    	<input type="number" class="form-control" name="productPrice" placeholder="">
    </li>
    <li class="list-group-item">
    	<label>제조 회사</label>
    	<input type="text" class="form-control" name="manufacturer" placeholder="">
    </li>
    <li class="list-group-item">
    	<label>칩셋제조 회사</label>
    	<input type="text" class="form-control" name="chipsetManufacturer" placeholder="">
    </li>
    <li class="list-group-item">
    	<label>칩셋 시리즈</label>
    	<input type="text" class="form-control" name="vgaSeries" placeholder="">
    </li>
    <li class="list-group-item">
    	<label>기본 클럭</label>
    	<input type="text" class="form-control" name="baseClock" placeholder="">
    </li>
    <li class="list-group-item">
    	<label>부스트 클럭</label>
    	<input type="text" class="form-control" name="boostClock" placeholder="">
    </li>
    <li class="list-group-item">
    	<label>프로세스 갯수</label>
    	<input type="text" class="form-control" name="processAmount" placeholder="">
    </li>
    <li class="list-group-item">
    	<label>PCI 인터페이스</label>
    	<input type="text" class="form-control" name="pciInterface" placeholder="">
    </li>
    <li class="list-group-item">
    	<label>메모리 타입</label>
    	<input type="text" class="form-control" name="memoryType" placeholder="">
    </li>
    <li class="list-group-item">
    	<label>VRAM 크기</label>
    	<input type="text" class="form-control" name="memorySize" placeholder="">
    </li>
    <li class="list-group-item">
    	<label>칩셋제조 회사</label>
    	<input type="text" class="form-control" name="chipsetManufacturer" placeholder="">
    </li>
    <li class="list-group-item">
    	<label>메모리 크기</label>
    	<input type="text" class="form-control" name="memoryBus" placeholder="">
    </li>
    <li class="list-group-item">
    	<label>칩셋제조 회사</label>
    	<input type="text" class="form-control" name="chipsetManufacturer" placeholder="">
    </li>
    <li class="list-group-item">
    	<label>HDMI 지원 포트수</label>
    	<input type="number" class="form-control" name="hdmiPort" placeholder="">
    </li>
    <li class="list-group-item">
    	<label>DP 지원 포트수</label>
    	<input type="text" class="form-control" name="dpPort" placeholder="">
    </li>
    <li class="list-group-item">
    	<label>지원모니터 수</label>
    	<input type="text" class="form-control" name="supportMonitorAmount" placeholder="">
    </li>
    <li class="list-group-item">
    	<label>최대 소모 전력</label>
    	<input type="text" class="form-control" name="maxTDP" placeholder="">
    </li>
    <li class="list-group-item">
    	<label>최대 소모 전력</label>
    	<input type="text" class="form-control" name="maxTDP" placeholder="">
    </li>
    <li class="list-group-item">
    	<label>권장 소모 전력</label>
    	<input type="text" class="form-control" name="recommendTDP" placeholder="">
    </li>
    <li class="list-group-item">
    	<label>필요 파워 포트 수</label>
    	<input type="text" class="form-control" name="powerPort" placeholder="">
    </li>
    <li class="list-group-item">
    	<label>파워 페이즈</label>
    	<input type="text" class="form-control" name="powerPhase" placeholder="">
    </li>
    <li class="list-group-item">
    	<label>부가기능</label>
    	<span class="custom-control custom-switch">
    	<!-- <input type="number" value="0" name="supportMultiVga" hidden> -->
    	<input type="checkbox" class="custom-control-input" value="0" name="supportMultiVga" id="vgachk01">
    	<label class="custom-control-label" for="vgachk01">멀티 VGA 지원 유무</label>
    	</span>
    	<span class="custom-control custom-switch">
    	<!-- <input type="number" value="0" name="support4K" hidden> -->
    	<input type="checkbox" class="custom-control-input" value="0" name="support4K" id="vgachk02">
    	<label class="custom-control-label" for="vgachk02">4K 지원 유무</label>
    	</span>
    	<span class="custom-control custom-switch">
    	<!-- <input type="number" value="0" name="support5K" hidden> -->
    	<input type="checkbox" class="custom-control-input" value="0" name="support5K" id="vgachk03">
    	<label class="custom-control-label" for="vgachk03">5K 지원 유무</label>
    	</span>
    </li>
  </ul>
  <div class="card-footer text-muted">
	<button type="submit" class="btn btn-primary submitBtn">상품 등록</button>
  </div>
  </form>
  <form id="MainBoard" action="AddProduct/Add" method="post" enctype="multiprat/form-data" hidden>
  <ul class="list-group list-group-flush">
	<li class="list-group-item">
		<div class="custom-file">
		    <input type="file" class="custom-file-input" name="productImg" multiple="multiple">
		    <label class="custom-file-label" for="inputGroupFile02">상품이미지 등록</label>
		</div>
	</li>
    <li class="list-group-item">
    	<label>메인보드 제품명</label>
    	<input type="text" class="form-control" name="powerPhase" placeholder="">
    </li>
    <li class="list-group-item">
    	<label>판매가격</label>
    	<input type="number" class="form-control" name="productPrice" placeholder="">
    </li>
    <li class="list-group-item">
    	<label>메인보드 제품명</label>
    	<input type="text" class="form-control" name="powerPhase" placeholder="">
    </li>
    <li class="list-group-item">
    	<label>메인보드 제품명</label>
    	<input type="text" class="form-control" name="powerPhase" placeholder="">
    </li>
  </ul>
  <div class="card-footer text-muted">
	<button type="submit" class="btn btn-primary submitBtn">상품 등록</button>
  </div>
  </form>
 </div>
</section>
<footer><jsp:include page="/WEB-INF/views/Layout/Footer.jsp" flush="false"></jsp:include></footer>
</body>

</html>