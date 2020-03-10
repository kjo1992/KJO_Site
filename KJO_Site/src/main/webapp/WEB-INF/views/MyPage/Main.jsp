<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
<div class="card mb-3 border-primary">
  <h4 class="card-header">회원정보</h4>
  <ul class="list-group list-group-flush">
  	<li class="list-group-item">
  		<div class="mr-5 card-body" style="max-width:30%; float:left;">
  			<h5 class="card-title text-center">프로필 사진</h5>
  			<img class="img-thumbnail" style="height: 150px; width: 150px; display: block;"
  			src="${UserInfoGet.profileImg}" alt="Card image">
  		</div>
  		<div style="float:left;">
  			<div class="card-body">
	  			<h5 class="card-title">ID</h5>
	    		${UserInfoGet.userId}
    		</div>
    		<div class="card-body">
	  			<h5 class="card-title">닉네임</h5>
	    		${UserInfoGet.userName}
    		</div>
  		</div>
  	</li>
    <li class="list-group-item">
    	<h6 class="card-title">Email</h6>
    	${UserInfoGet.userEmail}
    </li>
    <li class="list-group-item">
    	<h6 class="card-title">비밀번호 찾기 질문</h6>
    	${UserInfoGet.pwSearchQuestion}
    </li>
    <li class="list-group-item">
    	<h6 class="card-title">비밀번호 찾기 대답</h6>
    	${UserInfoGet.pwSearchAnswer}
    </li>
    <li class="list-group-item">
    	<h6 class="card-title">회원가입일</h6>
    	<fmt:formatDate pattern="yyyy-MM-dd HH:mm" value="${UserInfoGet.userRegDate}"/>
    </li>
    <li class="list-group-item">
    	<h6 class="card-title">최종로그인 일자</h6>
    	<fmt:formatDate pattern="yyyy-MM-dd HH:mm" value="${UserInfoGet.lastLoginDate}"/>
    </li>
  </ul>
  <div class="card-footer text-muted hidden">
  	<div class="float-right">
  	<%-- <a href="${pageContext.request.contextPath}/MyPage/UpdatePage" class="card-link" id="UpdatePageBtn">회원정보 수정</a>&emsp; --%>
  	<form class="float-left"action="${pageContext.request.contextPath}/MyPage/UpdatePage" name="Update" method="post" id="UpdateForm" onsubmit="return false">
  		<button type="submit" class="btn btn-link" id="UpdatePageBtn">회원정보 수정</button>
  	</form>
  	&emsp;
    <form class="float-right" action="${pageContext.request.contextPath}/MyPage/Delete" name="Delete" method="post" id="DeleteForm" onsubmit="return false">
    	<button type="submit" class="btn btn-link" style="color:red;" id="DeleteBtn">회원탈퇴</button>
    	<!-- <a href="javascript:Delete.submit();" class="card-link" style="color:red;">회원탈퇴</a> -->
    </form>
    </div>
  </div>
</div>

<div class="card mb-3">
	<h5 class="card-header">내가 작성한 게시글<small>(최근5개)</small>
	<small class="text-right float-right">전체보기</small>
	</h5>
	<div class="card-body">
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
				<JSTL:forEach items="${FreeBoard.FreeBoardList}" var="MyBoard">
					<tr class="text-center">
						<td class="small">${MyBoard.boardNum}</td>
						<td class="small">${MyBoard.boardCategory}</td>
						<td class="small">
							<a href="${pageContext.request.contextPath}/FreeBoard/DetailPage?bnum=${MyBoard.boardNum}">${MyBoard.boardSubject}</a>
						</td>
						<td class="small"><fmt:formatDate pattern="yyyy-MM-dd HH:mm" value="${MyBoard.boardWriteDate}"/></td>
						<td class="small">${MyBoard.boardReadCnt}</td>
					</tr>
				</JSTL:forEach>			
			</tbody>
		</table>
		
	</div>
	<h5 class="card-header">내가 작성한 댓글<small>(최근5개)</small>
	</h5>
	<div class="card-body">
		<table class="table table-hover" style="table-layout:fixed; word-break:break-all;">
			<thead>
				<tr class="text-center">
					<th scope="col" style="width:80%;">댓글 내용</th>
					<th scope="col" style="width:20%;">댓글 작성일자</th>
				</tr>
			</thead>
			<tbody>
				<JSTL:forEach items="${FreeBoard.FreeBoardReply}" var="MyReply">
					<tr class="text-center">
						<td class="small text-left">
							<a href="${pageContext.request.contextPath}/FreeBoard/DetailPage?bnum=${MyReply.boardNum}">${MyReply.replyText}</a>
						</td>
						<td class="small"><fmt:formatDate pattern="yyyy-MM-dd HH:mm" value="${MyReply.replyWriteDate}"/></td>
					</tr>
				</JSTL:forEach>			
			</tbody>
		</table>
	
	</div>
</div>

<div class="card mb-3">
	<h5 class="card-header">주문목록<small></small></h5>
	<div class="card-body">
		<table class="table table-hover" style="table-layout:fixed; word-break:break-all;">
			<tr>
				<th scope="col">주문번호</th>
				<th>주문일자</th>
				<th>배송상태</th>
			</tr>
		<JSTL:forEach items="${orderList}" var="list" varStatus="status">
			<tr>
				<td><h5>${list.orderNum}</h5></td>
				<td><fmt:formatDate value="${list.orderDate}" pattern="yyyy-MM-dd HH:mm"/></td>
				<td>${list.totalPrice}</td>
			</tr>
		</JSTL:forEach>
		</table>
	</div>
</div>
</section>
<footer><jsp:include page="/WEB-INF/views/Layout/Footer.jsp" flush="false"></jsp:include></footer>
<script src="${pageContext.request.contextPath}/resources/js/MyPage/Main.js"></script>
</body>
</html>