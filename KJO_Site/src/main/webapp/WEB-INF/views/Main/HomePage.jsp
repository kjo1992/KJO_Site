<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="JSTL" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Welcome</title>
</head>
<body>
<nav id="SiteHeader"><jsp:include page="/WEB-INF/views/Layout/Header.jsp" flush="false"></jsp:include></nav>
<section>
<div class="card mb-3">
	<table class="table table-hover" style="table-layout:fixed; word-break:break-all;">
	<thead>
		<tr class="text-center">
			<th scope="col" style="width:10%;">글번호</th>
			<th scope="col" style="width:10%;">분류</th>
			<th scope="col" style="width:50%;">글제목</th>
			<th scope="col" style="wdith:15%;">작성일자</th>
			<th scope="col" style="width:15%;">조회수</th>
		</tr>
	</thead>
	<tbody>
		<JSTL:forEach items="${FreeBoard}" var="FreeBoard">
			<tr class="text-center">
				<td class="small">${FreeBoard.boardNum}</td>
				<td class="small">${FreeBoard.boardCategory}</td>
				<td class="small">
					<a href="${pageContext.request.contextPath}/FreeBoard/DetailPage?bnum=${FreeBoard.boardNum}">${FreeBoard.boardSubject}</a>
				</td>
				<td class="small"><fmt:formatDate pattern="yyyy-MM-dd HH:mm" value="${FreeBoard.boardWriteDate}"/></td>
				<td class="small">${FreeBoard.boardReadCnt}</td>
			</tr>
		</JSTL:forEach>			
	</tbody>
</table>
</div>

</section>
<footer><jsp:include page="/WEB-INF/views/Layout/Footer.jsp" flush="false"></jsp:include></footer>
</body>
</html>