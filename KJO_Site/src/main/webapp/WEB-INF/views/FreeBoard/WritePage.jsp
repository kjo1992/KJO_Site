<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%-- <%@ include file="/WEB-INF/views/Layout/SiteHeader.jsp" %> --%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<nav id="SiteHeader"><jsp:include page="/WEB-INF/views/Layout/Header.jsp" flush="false"></jsp:include></nav>
<section>
<div class="form-group card bg-light mb-3">
<form action="${pageContext.request.contextPath}/FreeBoard/Write" method="POST">
	<div class="input-group card-header">
	<select class="custom-select" style="max-width:10%;" name="boardCategory">
      <option value="잡담">잡담</option>
      <option value="질문">질문</option>
      <option value="자랑">자랑</option>
    </select>
	<input type="text" class="form-control" name="boardSubject" placeholder="게시글 제목 입력"><br/>
	<input type="text" value="${LoginUser.getUserNum()}" name="writerNum" hidden>
	</div>
	<div class="card-body">
	<textarea class="form-control" id="contentArea" rows="3" name="boardContent" placeholder="본문 내용 작성" style="resize: none;"></textarea>
	<input type="submit" value="작성">
	</div>
</form>
</div>
</section>
<footer><jsp:include page="/WEB-INF/views/Layout/Footer.jsp" flush="false"></jsp:include></footer>
</body>
<script src="${pageContext.request.contextPath}/resources/js/FreeBoard/Write.js"></script>
</html>