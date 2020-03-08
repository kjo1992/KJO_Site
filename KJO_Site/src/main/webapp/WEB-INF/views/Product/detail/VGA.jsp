<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="JSTL" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<div>
<table>
	<tr>
		<td class="specCategory" colspan="4">기본 정보</td>
	</tr>
	<tr>
		<td class="key">제조사</td>
		<td class="value">${productDetail.manufacturer}</td>
		<td class="key">CPU 타입</td>
		<td class="value">${productDetail.cpuType}</td>
	</tr>
	<tr>
		<td class="key">칩셋 시리즈</td>
		<td class="value">${productDetail.vgaSeries}</td>
		<td class="key">기본 클럭</td>
		<td class="value">${productDetail.baseClock}</td>
	</tr>
	<tr>
		<td class="key">부스트 클럭</td>
		<td class="value">${productDetail.boostClock}</td>
		<td class="key">프로세스 갯수</td>
		<td class="value">${productDetail.processAmount}</td>
	</tr>
	<tr>
		<td class="key">PCI 인터페이스</td>
		<td class="value">${productDetail.pciInterface}</td>
		<td class="key"></td>
		<td class="value"></td>
	</tr>
	<tr>
		<td class="specCategory" colspan="4">메모리 정보</td>
	</tr>
	<tr>
		<td class="key">메모리 타입</td>
		<td class="value">${productDetail.memoryType}</td>
		<td class="key">VRAM 크기</td>
		<td class="value">${productDetail.memorySize}</td>
	</tr>
	<tr>
		<td class="key">메모리 버스</td>
		<td class="value">${productDetail.memoryBus}</td>
		<td class="key"></td>
		<td class="value"></td>
	</tr>
	<tr>
		<td class="specCategory" colspan="4">출력 정보</td>
	</tr>
	<tr>
		<td class="key">HDMI 지원 포트수</td>
		<td class="value">${productDetail.hdmiPort}</td>
		<td class="key">DP 지원 포트수</td>
		<td class="value">${productDetail.dpPort}</td>
	</tr>
	<tr>
		<td class="key">지원모니터 수</td>
		<td class="value">${productDetail.supportMonitorAmount}</td>
		<td class="key"></td>
		<td class="value"></td>
	</tr>
	<tr>
		<td class="specCategory" colspan="4">소모전력 정보</td>
	</tr>
	<tr>
		<td class="key">최대 소모 전력</td>
		<td class="value">${productDetail.maxTDP}</td>
		<td class="key">권장 소모 전력</td>
		<td class="value">${productDetail.recommendTDP}</td>
	</tr>
	<tr>
		<td class="key">필요 파워 포트 수</td>
		<td class="value">${productDetail.powerPort}</td>
		<td class="key">파워 페이즈</td>
		<td class="value">${productDetail.powerPhase}</td>
	</tr>
	<tr>
		<td class="specCategory" colspan="4">부가기능</td>
	</tr>
	<tr>
		<td class="key">멀티 VGA 지원 유무</td>
		<td class="value">
			<JSTL:if test="${productDetail.supportMultiVga}">지원</JSTL:if>
		</td>
		<td class="key">4K 지원 유무</td>
		<td class="value">
			<JSTL:if test="${productDetail.support4K}">지원</JSTL:if>
		</td>
	</tr>
	<tr>
		<td class="key">5K 지원 유무</td>
		<td class="value">
			<JSTL:if test="${productDetail.support5K}">지원</JSTL:if>
		</td>
		<td class="key"></td>
		<td class="value"></td>
	</tr>
</table>
</div>
<link href="${pageContext.request.contextPath}/resources/css/productSpec.css" rel="stylesheet">
