<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<nav id="SiteHeader"><jsp:include page="/WEB-INF/views/Layout/Header.jsp" flush="false"></jsp:include></nav>
<body>
<section>
<form action="${pageContext.request.contextPath}/User/AddComp" method="post">
  <div class="card border-info mb-3">
  <fieldset>
    <legend class="card-header">회원가입</legend>
	<div class="card-body">
	    <div class="form-group">
	      <label>ID</label>
	      <div class="input-group">
	      	<input type="text" class="form-control" id="UserInputID" placeholder="Enter your ID(중복불가)" name="userId">
	      	<div class="input-group-append">
		    	<button class="input-group-text btn ChkBtn" id="IDChk" type="button" disabled>중복확인</button>
		    </div>
	      </div>
	      <small id="IDHelp" class="form-text text-muted">5~15 영어 대소문자, 숫자로 구성해주세요.</small>
	    </div>
	    
	    <div class="form-group">
	      <label>Password</label>
	      <div class="input-group">
	      	<input type="password" class="form-control" id="UserInputPW" placeholder="Enter your Password" name="userPw">
	      </div>
	      <small id="PWHelp" class="form-text text-muted">8~15자의 영어 대소문자, 숫자, 특수문자 조합으로  사용 가능합니다.</small>
	    </div>

	    <div class="form-group">
	      <label>NickName</label>
	      <div class="input-group">
	      	<input type="text" class="form-control" id="UserInputName" placeholder="Enter your NickName(중복불가)" name="userName">
	      	<div class="input-group-append">
		    	<button class="input-group-text btn ChkBtn" id="NameChk" type="button" disabled>중복확인</button>
		    </div>
	      </div>
	      <small id="NamelHelp" class="form-text text-muted">2~10자의 대소문자,한글로 조합 가능합니다</small>
	    </div>
	    
	    <div class="form-group">
	      <label>Email</label>
	      <div class="input-group">
	      	<input type="email" class="form-control" id="UserInputEmail" placeholder="Enter your Mail(중복불가)" name="userEmail">
	      	<div class="input-group-append">
		    	<button class="input-group-text btn ChkBtn" id="EmailChk" type="button" disabled>중복확인</button>
		    </div>
	      </div>
	      <small id="emailHelp" class="form-text text-muted">이메일은 아이디를 찾을때 사용합니다.<br/>예제형식)example@email.com</small>
	    </div>
	    
	    <div class="form-group">
	      <label>비밀번호 찾기 질문</label>
	      <select class="form-control" id="questionSelect" name="pwSearchQuestion">
	        <option selected="selected">태어난 고향 도시는?</option>
	        <option>나이많은 사촌의 이름은?</option>
	        <option>본인이 가장 좋아하는 색은?</option>
	        <option>자신의 보물 1호는?</option>
	      </select>
	    </div>
	    
		<div class="form-group">
	      <label>비밀번호 찾기 답</label>
	      <div class="input-group">
	      	<input type="text" class="form-control" id="PWAnswer" placeholder="Enter your Answer" name="PwSearchAnswer">
	      </div>
	      <small id="AnswerHelp" class="form-text text-muted">비밀번호 찾기 질문/대답</small>
	    </div>
	    <button type="submit" class="btn btn-primary" id="submitBtn" disabled>회원가입</button>
  </div>
  </fieldset>
  </div>
</form>
</section>
<footer><jsp:include page="/WEB-INF/views/Layout/Footer.jsp" flush="false"></jsp:include></footer>
</body>
<script src="${pageContext.request.contextPath}/resources/js/User/AddUser.js"></script>
</html>