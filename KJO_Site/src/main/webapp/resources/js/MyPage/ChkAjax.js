var MyName = userName;
var MyEmail = userEmail;

$(document).ready(function() {
	//정규표현식
	var IDValueChk = RegExp(/^[a-zA-Z0-9]{5,15}$/);
	var PWValueChk = RegExp(/^(?=.*[a-zA-z))(?=.*[!@#$%^*+=-])(?=.*[0-9]).{8,16}$/);
	var NameValueChk = RegExp(/^[가-힣ㄱ-ㅎㅏ-ㅣa-zA-Z]{2,10}$/);
	var EmailChk = RegExp(/^[0-9a-zA-Z]([-_\.]?[0-9a-zA-Z])*@[0-9a-zA-Z]([-_\.]?[0-9a-zA-Z])*\.[a-zA-Z]{2,3}$/i);
	
	//submit 버튼 활성화,비활성화를 위한 변수
	var userPW = false; var userName = false;
	var userEmail = false; var PWsearchAnswer = false;
	
	function getContextPath() {
		var hostIndex = location.href.indexOf( location.host ) + location.host.length;
		return location.href.substring(hostIndex, location.href.indexOf('/', hostIndex + 1));
	
	}
	var ContextPath = getContextPath()+"/User/";
	
	//userPW 시작
	$("#UserInputPW").on("keyup click", function(){
		if(!(PWValueChk.test($("#UserInputPW").val()))) {
			$("#PWHelp").html("8~15자의 영어 대소문자, 숫자, 특수문자를 입력해주세요.");
			$("#UserInputPW").attr("class","form-control is-invalid");
			userPW = false;
		} else {
			$("#PWHelp").html("사용가능한 PW입니다.");
			$("#UserInputPW").attr("class","form-control is-valid");
			userPW = true;
		};
	}); //userPW 종료
	
	//userName 시작
	$("#UserInputName").on("keyup click", function(){
		if(!(NameValueChk.test($("#UserInputName").val()))) {
			$("#NamelHelp").html("2~10자의 대소문자, 한글을 입력해주세요.");
			$("#UserInputName").attr("class","form-control is-invalid");
			$("#NameChk").attr("disabled",true);
			userName = false;
		} else if(MyName == $("#UserInputName").val()) {
			$("#NamelHelp").html("현재 사용중인 닉네임 입니다.");
			$("#UserInputName").attr("class","form-control is-valid");
			$("#NameChk").attr("disabled",false);
			userName = true;
		} else {
			$("#NamelHelp").html("조건에 부합한 닉네임입니다. 중복확인을 해주세요.");
			$("#UserInputName").attr("class","form-control is-invalid");
			$("#NameChk").attr("disabled",false);
			userName = false;
		};
	}); //userName 종료
	
	//userEmail 시작
	$("#UserInputEmail").on("keyup click", function(){
		if(!(EmailChk.test($("#UserInputEmail").val()))) {
			$("#emailHelp").html("예제형식)example@email.com");
			$("#UserInputEmail").attr("class","form-control is-invalid");
			$("#EmailChk").attr("disabled",true);
			userEmail = false;
		} else if (MyEmail == $("#UserInputEmail").val()) {
			$("#emailHelp").html("현재 사용중인 이메일 입니다.");
			$("#UserInputEmail").attr("class","form-control is-valid");
			$("#EmailChk").attr("disabled",false);
			userEmail = true;
		} else {
			$("#emailHelp").html("조건에 부합한 이메일 입니다. 중복확인을 해주세요.");
			$("#UserInputEmail").attr("class","form-control is-invalid");
			$("#EmailChk").attr("disabled",false);
			userEmail = false;
		};
	}); //userEmail 종료
	
	//비밀번호 찾기 답 시작
	$("#PWAnswer").on("keyup click", function(){
		if ($("#PWAnswer").val() != "") {
			PWsearchAnswer = true;
		} else {
			PWsearchAnswer = false;
		}
	}); //비밀번호 찾기 답 종료
	
	
	//ID, 닉네임, Email 중복확인
	$(".ChkBtn").on("click", function(){
		var ChkBtn = $(this).attr('id');
		var ChkValue; var InputTagID;
		var UrlPath = ContextPath+ChkBtn;
		/*alert(UrlPath);*/
		
		//누른 버튼의 종류가 어떤거인지 확인하고, 해당하는 inputbox 값을 가져오기
		if (ChkBtn == "NameChk") {
			InputTagID = "UserInputName";
			ChkValue = $("#"+InputTagID).val();
		} else if (ChkBtn == "EmailChk") {
			InputTagID = "UserInputEmail"
			ChkValue = $("#"+InputTagID).val();
		}
		
		// 중복값을 찾기 위한 Ajax
		if (ChkValue == "") {
			alert("중복확인할 값을 입력해주세요.")
		} else if(ChkValue != null) {
			$.ajax({
				type:"POST",
				url:UrlPath,
				data:{"ChkValue":ChkValue},
				success:function(data) {
					//alert(data);
					if (data == 0 && ChkBtn == "NameChk") {
						$("#UserInputName").attr("class","form-control is-valid");
						$("#NamelHelp").html("사용가능한 닉네임 입니다.");
						userName = true;
					} else if(data == 0 && ChkBtn == "EmailChk") {
						$("#UserInputEmail").attr("class","form-control is-valid");
						$("#emailHelp").html("사용가능한 이메일 입니다.");
						userEmail = true;
					} else {
						alert("중복되어서 사용이 불가능합니다.");
						$("#"+InputTagID).attr("class","form-control is-invalid");
					}
				},
				error:function(err) {
					alert("정상적인 처리가 아닙니다.");
				}
			})
		}
		
		//변수 초기화
		ChkValue=""; InputTagID="";
	});
	
	//모든값이 올바르게 입력되었을때, submit 버튼 활성화
	$("input").blur(function(){
		if(userPW && userName && userEmail && PWsearchAnswer) {
			$("#submitBtn").attr("disabled",false);
		} else {
			$("#submitBtn").attr("disabled",true);
		}
	});
});