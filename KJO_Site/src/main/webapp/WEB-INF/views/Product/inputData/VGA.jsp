<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<ul class="list-group list-group-flush" >
	<!-- <li class="list-group-item">
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
    	<input type="text" class="form-control" name="manufacturer" placeholder="">
    	<label class="mt-3">칩셋제조 회사</label>
    	<input type="text" class="form-control" name="chipsetManufacturer" placeholder="">
    	<label class="mt-3">칩셋 시리즈</label>
    	<input type="text" class="form-control" name="vgaSeries" placeholder="">
    	<label class="mt-3">기본 클럭</label>
    	<input type="text" class="form-control" name="baseClock" placeholder="">
    	<label class="mt-3">부스트 클럭</label>
    	<input type="text" class="form-control" name="boostClock" placeholder="">
    	<label class="mt-3">프로세스 갯수</label>
    	<input type="text" class="form-control" name="processAmount" placeholder="">
    	<label class="mt-3">PCI 인터페이스</label>
    	<input type="text" class="form-control" name="pciInterface" placeholder="">
    </li>
    <li class="list-group-item">
    	<h4>메모리 정보</h4>
    	<label class="mt-3">메모리 타입</label>
    	<input type="text" class="form-control" name="memoryType" placeholder="">
    	<label class="mt-3">VRAM 크기</label>
    	<input type="text" class="form-control" name="memorySize" placeholder="">
    	<label class="mt-3">메모리 버스</label>
    	<input type="text" class="form-control" name="memoryBus" placeholder="">
    </li>
    <li class="list-group-item">
    	<h4>출력 정보</h4>
    	<label class="mt-3">HDMI 지원 포트수</label>
    	<input type="number" class="form-control" name="hdmiPort" placeholder="">
    	<label class="mt-3">DP 지원 포트수</label>
    	<input type="number" class="form-control" name="dpPort" placeholder="">
    	<label class="mt-3">지원모니터 수</label>
    	<input type="number" class="form-control" name="supportMonitorAmount" placeholder="">
    </li>
    <li class="list-group-item">
    	<h4>소모전력 정보</h4>
    	<label class="mt-3">최대 소모 전력</label>
    	<input type="text" class="form-control" name="maxTDP" placeholder="">
    	<label class="mt-3">권장 소모 전력</label>
    	<input type="text" class="form-control" name="recommendTDP" placeholder="">
    	<label class="mt-3">필요 파워 포트 수</label>
    	<input type="text" class="form-control" name="powerPort" placeholder="">
    	<label class="mt-3">파워 페이즈</label>
    	<input type="text" class="form-control" name="powerPhase" placeholder="">
    </li>
    <li class="list-group-item">
    	<label class="mt-3">부가기능</label>
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
    	<label class="custom-control-label inputChk" for="vgachk03">5K 지원 유무</label>
    	</span>
    </li>
 </ul>
<script src="${pageContext.request.contextPath}/resources/js/Product/inputSpec.js"></script>