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
<JSTL:forEach items="${ProductList['ProductList']}" var="list">
<table class="table table-hover">
	<tr class="">
	  <td><img src="${list.productImgPath_0}" width="150px" height="150px"></td>
      <td><a href="Detail?typeNum=${list.typeNum}&productName=${list.productName}"><b>${list.productName}</b></a><br/>
      	<div style="vertical-align:middle;">
      		<JSTL:forEach items="${list}" var="spec" varStatus="status" begin="6">
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
      <td style="width:150px; text-align:center; vertical-align:middle;">남은수량<br/>${list.amount} 개</td>
      <td style="width:150px; text-align:center; vertical-align:middle;">${list.productPrice} 원</td>
    </tr>
</table>
<hr>
</JSTL:forEach>
</section>
<footer><jsp:include page="/WEB-INF/views/Layout/Footer.jsp" flush="false"></jsp:include></footer>
</body>
</html>