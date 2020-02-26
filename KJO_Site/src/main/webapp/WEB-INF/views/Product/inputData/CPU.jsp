<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<ul class="list-group list-group-flush">
<!-- 	<li class="list-group-item">
		<label class="mt-3">제품명</label>
	  	<input type="text" class="form-control" name="productName" placeholder="">
	  	<label class="mt-3">판매가격</label>
	  	<input type="number" class="form-control" name="productPrice" placeholder="">
	  	<label class="mt-3">상품이미지</label>
	  	<div class="custom-file">
	   		<label class="custom-file-label" for="productImg" id="productImglabel">상품이미지 등록</label>
			<input type="file" class="custom-file-input form-control" name="productImg" id="productImg" multiple="multiple">
			<small id="" class="form-text text-muted">bmp, png, jpg, jpeg 만 가능, 개별 파일당 2mb 이하, 최대 3장까지</small>
		</div>
	</li> -->
    <li class="list-group-item">
    	<h4>기본 정보</h4>
    	<label class="mt-3">제조사</label>
    	<input type="text" class="form-control" name="manufacturer" placeholder="ex)AMD, 인텔">
    	<label class="mt-3">cpu 타입</label>
    	<input type="text" class="form-control" name="cpuType" placeholder="ex)라이젠3-7, i3-7">
    	<label class="mt-3">cpu 세대</label>
    	<input type="text" class="form-control" name="generation" placeholder="">
    	<label class="mt-3">코어타입</label>
    	<input type="text" class="form-control" name="coreType" placeholder="">
    	<label class="mt-3">쓰레드갯수</label>
    	<input type="text" class="form-control" name="threadType" placeholder="">
    	<label class="mt-3">기본 클럭</label>
    	<input type="text" class="form-control" name="baseClock" placeholder="">
    	<label class="mt-3">부스트 클럭</label>
    	<input type="text" class="form-control" name="boostClock" placeholder="">
    	<label class="mt-3">L2Cache</label>
    	<input type="text" class="form-control" name="l2Cache" placeholder="">
    	<label class="mt-3">L3Cache</label>
    	<input type="text" class="form-control" name="l3Cache" placeholder="">
    </li>
    <li class="list-group-item">
    	<h4>소모전력 정보</h4>
    	<label class="mt-3">TDP</label>
    	<input type="text" class="form-control" name="tdp" placeholder="">
    </li>
    <li class="list-group-item">
    	<h4>메모리 정보</h4>
    	<label class="mt-3">메모리 타입</label>
    	<input type="text" class="form-control" name="memoryType" placeholder="">
    	<label class="mt-3">메모리 버스</label>
    	<input type="text" class="form-control" name="memoryBus" placeholder="">
    	<label class="mt-3">메모리 채널</label>
    	<input type="text" class="form-control" name="memoryChannel" placeholder="">
    </li>
    <li class="list-group-item">
    	<label class="mt-3">내장 그래픽유무</label>
    	<input type="text" class="form-control" name="innerGPU" placeholder="">
    </li>
    <li class="list-group-item">
    	<label class="mt-3">출시일</label>
    	<input type="date" class="form-control" name="releaseDate" placeholder="">
    </li>   
 </ul>
 <script src="${pageContext.request.contextPath}/resources/js/Product/inputSpec.js"></script>