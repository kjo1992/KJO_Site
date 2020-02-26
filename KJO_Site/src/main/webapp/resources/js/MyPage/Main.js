$(document).ready(function(){
	$("#UpdatePageBtn").on("click", function(){		
		var checkPw = prompt('보안을 위해 비밀번호를 한번 더 입력해주세요');
		
		if (checkPw == null || checkPw == "") {
			alert("비밀번호가 입력되지 않았습니다.");
		} else {
			$.ajax({
				url:"pwChk",
				data:{
					"inputPw":checkPw
				},
				type:"POST",
				async:false,
				success:function(data){
//					alert("AjaxData : "+data);
					if(data == 1) {
						$("#UpdateForm").attr("onsubmit", "return true");
//						$.post(getContextPath()+"/MyPage/UpdatePage"
//								, {"inputPw":checkPw});
					} else {
						alert("비밀번호가 틀렸습니다.");
					}
				},
				error:function(request,status,error) {
					console.log("code:"+request.status+"\n"+"message:"+request.responseText+"\n"+"error:"+error);
				}
			});
		}
	});
	
	$("#DeleteBtn").on("click", function(){
		var check=confirm("회원탈퇴시 기존에 작성한 게시글 및 댓글은 삭제, 수정이 불가능합니다." +
				" 그래도 탈퇴하시겠습니까?");
		
		if (check) {
			$("#DeleteForm").attr("onsubmit", "return true");
		}
	});
});