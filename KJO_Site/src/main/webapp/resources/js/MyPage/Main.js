$(document).ready(function(){	
	$("#UpdatePageBtn, #DeleteBtn").on("click", function(){
		var clickBtn = $(this).attr("id");
		var pwCheck = false;
		$("#pwCheckModal").modal("show");
		
		$("#pwCheckBtn").off("click").on("click", function(){
			var inputPw = $("#inputPw").val();
			$("#pwCheckModal").modal("hide");
			$("#inputPw").val("");
			
			//비밀번호 일치여부 확인 ajax
			$.ajax({
				url:"pwChk",
				data:{
					"inputPw":inputPw
				},
				type:"POST",
				async:false,
				success:function(data){
//					alert("AjaxData : "+data);
					if(data == 1) {
						pwCheck=true;
					} else {
						alert("비밀번호가 틀렸습니다.");
						pwCheck=false;
					}
				},
				error:function(request,status,error) {
					console.log("code:"+request.status+"\n"+"message:"+request.responseText+"\n"+"error:"+error);
				}
			});//ajax
						
			//클릭버튼에 따른 분기처리
			if (pwCheck && clickBtn == "UpdatePageBtn") {
				$("#UpdateForm").attr("onsubmit", "return true");
				$("#UpdatePageBtn").trigger("click");
			} else if(pwCheck && clickBtn == "DeleteBtn") {
				var check=confirm("회원탈퇴시 기존에 작성한 게시글 및 댓글, 상품평, 장바구니, 주문목록은 삭제 됩니다." +
				" 그래도 탈퇴하시겠습니까?");
				if (check) {
					$("#DeleteForm").attr("onsubmit", "return true");
					$("#DeleteBtn").trigger("click");
				}
			}//else if
		}); //pwCheckBtn click end
	}); //UpdatePageBtn, DeleteBtn click end
}); //document end