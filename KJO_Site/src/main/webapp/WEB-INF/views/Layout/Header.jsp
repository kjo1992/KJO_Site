<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="JSTL" %>

<link href="${pageContext.request.contextPath}/resources/css/Cerulean.css" rel="stylesheet">
<link href="${pageContext.request.contextPath}/resources/css/Tag.css" rel="stylesheet">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js"></script>
<script src="${pageContext.request.contextPath}/resources/js/Layout/Header.js"></script>
<script src="${pageContext.request.contextPath}/resources/ckeditor/ckeditor.js"></script>

<nav class="navbar navbar-expand-lg navbar-light bg-light fixed-top">
  <!-- <a class="navbar-brand" href="redirect:MainPage">KJO Home</a> -->
  <a class="navbar-brand" href="${pageContext.request.contextPath}/Main/HomePage">KJO Home</a>
  <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarColor03" aria-controls="navbarColor03" aria-expanded="false" aria-label="Toggle navigation">
    <span class="navbar-toggler-icon"></span>
  </button>

  <div class="collapse navbar-collapse" id="navbarColor03">
    <ul class="navbar-nav mr-auto">
<!--       <li class="LinkBtn nav-item" id="BenchMark">
        <a class="nav-link" href="#">BechMark<span class="sr-only">(current)</span></a>
      </li> -->
      <li class="LinkBtn nav-item dropdown" id="ProductList">
        <a class="nav-link dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">ProductList</a>
        <div class="dropdown-menu" style="">
	      <a class="dropdown-item" href="${pageContext.request.contextPath}/Product/Main?typeNum=COM100">CPU</a>
	      <a class="dropdown-item" href="${pageContext.request.contextPath}/Product/Main?typeNum=COM101">VGA</a>
	      <a class="dropdown-item" href="${pageContext.request.contextPath}/Product/Main?typeNum=COM102">MainBoard</a>
	      <JSTL:if test="${LoginUser.authority eq 'master'}">
	      <div class="dropdown-divider"></div>
   		  <a class="dropdown-item" href="${pageContext.request.contextPath}/Product/AddProduct">제품 등록</a>
		  </JSTL:if>
    	</div>
      </li>
      <li class="LinkBtn nav-item" id="FreeBoard">
        <a class="nav-link" href="${pageContext.request.contextPath}/FreeBoard/List">자유게시판</a>
      </li>
	  <JSTL:if test="${LoginUser ne null}">
      <li class="LinkBtn nav-item" id="MyPage">
        <a class="nav-link" href="${pageContext.request.contextPath}/MyPage/Main">마이페이지</a>
      </li>
      </JSTL:if>
    </ul>
    <JSTL:choose>
		<JSTL:when test="${LoginUser ne null}">
			<img class="img-thumbnail"src="${LoginUser.getProfileImg()}" id="thumnail">&emsp;
			<small class="small"><b>${LoginUser.getUserName()}</b> 님 환영합니다.</small>
			<button class="btn btn-secondary btn-sm my-2 my-sm-0 ml-3" type="submit" id="LogoutBtn">로그아웃</button>
		</JSTL:when>
		<JSTL:otherwise>
			<button class="btn btn-secondary btn-sm my-2 my-sm-0" type="submit" id="LoginBtn">로그인</button>
		</JSTL:otherwise>
	</JSTL:choose>
  </div>
</nav>
<div class="modal mt-5" id="LoginModal">
  <div class="modal-dialog" role="document">
    <div class="modal-content">
      <div class="modal-header">
        <h5 class="modal-title">로그인</h5>
        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
          <span aria-hidden="true">&times;</span>
        </button>
      </div>
      <div class="modal-body">
      	<form action="${pageContext.request.contextPath}/User/Login" method="POST">
      		<div class="from-group"><input type="text" class="form-control" placeholder="ID" name="UserId"></div>
      		<div class="from-group"><input type="password" class="form-control my-sm-2" placeholder="PW" name="UserPw"></div>
      		<small class="form-text text-muted my-sm-2">ID/PW가 기억나지 않으십니까?</small>
      		<div class="from-group my-sm-2">
      		<input type="submit" value="로그인" class="btn btn-primary btn-sm my-2 my-sm-0">
      		<a href="${pageContext.request.contextPath}/User/AddUser"><input type="button" value="회원가입" class="btn btn-secondary btn-sm my-2 my-sm-0"></a>
      		</div>
      	</form>
      </div>
    </div>
  </div>
</div>