<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href="${pageContext.request.contextPath}/resources/css/Cerulean.css" rel="stylesheet">
<style type="text/css">
	#msg {margin:0 auto;}
	#confirmBtn {margin:0 auto;}
</style>
</head>
<body>
<div class="card border-secondary mb-3" style="max-width: 25rem;" id="msg">
  <div class="card-header">축하합니다!</div>
  <div class="card-body">
    <h4 class="card-title">회원가입에 성공 하였습니다.</h4>
    <div class="card-text" id="confirmBtn">
    	<a href="${pageContext.request.contextPath}/Main/HomePage"><button type="button" class="btn btn-primary btn-sm">메인페이지로 이동</button></a>
    </div>
  </div>
</div>
</body>
</html>