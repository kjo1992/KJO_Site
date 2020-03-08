<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="JSTL" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<div>
<table style="width:100%;">
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
		<td class="key">CPU세대</td>
		<td class="value">${productDetail.generation}</td>
		<td class="key">코어타입</td>
		<td class="value">${productDetail.coreType}</td>
	</tr>
	<tr>
		<td class="key">쓰레드갯수</td>
		<td class="value">${productDetail.threadType}</td>
		<td class="key">기본 클럭</td>
		<td class="value">${productDetail.baseClock}</td>
	</tr>
	<tr>
		<td class="key">L2Cache</td>
		<td class="value">${productDetail.l2Cache}</td>
		<td class="key">L3Cache</td>
		<td class="value">${productDetail.l3Cache}</td>
	</tr>
	<tr>
		<td class="specCategory" colspan="4">소모전력 정보</td>
	</tr>
	<tr>
		<td class="key">TDP</td>
		<td class="value">${productDetail.tdp}</td>
		<td class="key"></td>
		<td class="value"></td>
	</tr>
	<tr>
		<td class="specCategory" colspan="4">메모리 정보</td>
	</tr>
	<tr>
		<td class="key">메모리 타입</td>
		<td class="value">${productDetail.memoryType}</td>
		<td class="key">메모리 버스</td>
		<td class="value">${productDetail.memoryBus}</td>
	</tr>
	<tr>
		<td class="key">메모리 채널</td>
		<td class="value">${productDetail.memoryChannel}</td>
		<td class="key"></td>
		<td class="value"></td>
	</tr>
	<tr>
		<td class="key">내장 그래픽유무</td>
		<td class="value">${productDetail.innerGPU}</td>
		<td class="key">출시일</td>
		<td class="value">${productDetail.releaseDate}</td>
	</tr>
</table>
</div>
<link href="${pageContext.request.contextPath}/resources/css/productSpec.css" rel="stylesheet">