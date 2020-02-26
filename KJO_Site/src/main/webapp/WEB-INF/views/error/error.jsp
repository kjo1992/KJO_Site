<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href="${pageContext.request.contextPath}/resources/css/Cerulean.css" rel="stylesheet">
<link href="${pageContext.request.contextPath}/resources/css/Tag.css" rel="stylesheet">
</head>
<body>
<section>
<div class="card border-danger mb-3" style="max-width: 25rem;" id="msg">
  <div class="card-header">Error!</div>
  <div class="card-body">
    <h4 class="card-title">페이지 처리중 에러가 발생하였습니다.</h4>
    <div class="card-text" id="confirmBtn">
    	<a href="${pageContext.request.contextPath}/Main/HomePage"><button type="button" class="btn btn-primary btn-sm">메인페이지로 이동</button></a>
    </div>
  </div>
</div>
</section>
</body>
</html>