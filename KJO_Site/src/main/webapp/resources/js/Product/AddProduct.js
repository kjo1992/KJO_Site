$(document).ready(function(){
	function getContextPath() {
		var hostIndex = location.href.indexOf( location.host ) + location.host.length;
		return location.href.substring(hostIndex, location.href.indexOf('/', hostIndex + 1));
	}
	var ContextPath = getContextPath();
	
	//초기에 선택된 체크박스 text값 가져오기
	var selectbox = $("#productType option:checked").text();
	
	//모듈화된 input창을 Ajax로 호출
	var actionPage = ContextPath+"/Product/inputData/"+selectbox;
	$("#inputData").load(actionPage);
	
	//제품타입 선택시
	$("#productType").on("change", function(){
		selectbox = $(this).children("option:selected").text();
		actionPage = ContextPath+"/Product/inputData/"+selectbox;
		
		$("#inputData").load(actionPage);
		$("li>input").val("");
		inputClear();
	});
	
	
	$("#submitBtn").on("click", function(){
		var selectVal = $("#productType").val();
//		alert(selectVal);
		$("input:checkbox:not(checked)").attr("checked", true);
		//typeNum 전달하게 하는 스크립트
		$("#inputSpec").attr("action", "AddProduct/Add?typeNum="+selectVal);
//		$("#"+selectbox).attr("action", "AddProduct/Add?typeNum="+selectVal);
		
	});
	
	$("#productImg").on({
		click: function() {
			inputClear();
//			alert("click clear");
		}, change: function() {
			var fileInput = document.getElementById("productImg");
			var files = fileInput.files;
			var file;
			var inputImg = " ";
//			var view_files = [];
			var complete = false;
			
			//파일 갯수 검사
			if(files.length > 4) {
				alert("파일의 첨부갯수는 4개를 넘을수 없습니다.");
				inputClear();
				complete=false;
			} else {
//				alert("file amount check");
				for (var i = 0; i < files.length; i++) {
		            file = files[i];
		            var imgName = file.name;
		            var imgType = file.type.split("/").pop().toLowerCase();
					var imgSize = file.size;
					var maxSize = 2 * 1024 * 1024;
					
					//파일 형식 검사
					if($.inArray(imgType, ['png','jpeg','jpg','bmp']) == -1) {
						alert(imgName+" 가 형식에 맞지않은 파일입니다.");
						inputClear();
						complete=false;
						break;
					} else {
//						alert("file type check");
						//파일 크기 검사
						if(imgSize > maxSize) {
							alert(imgName+" 의 파일크기가 너무 큽니다.");
							inputClear();
							complete=false;
							break;
						} else {
//							alert("file size check");
							complete=true;
						}//파일 크기 검사
					}//파일 형식 검사
				}//for 
			}//else
			if(complete==true) {
				for (var i = 0; i < files.length; i++) {
					file = files[i];
					var imgName = file.name;
					
		            inputImg = inputImg+" / "+(i+1)+"."+imgName;
					$("#productImglabel").text(inputImg);
//					view_files.push(file);
					
					var viewer = new FileReader();
					viewer.onload = function(e) {
						console.log(e);
						var appendImg = "<a class='card-link'><img src='"+e.target.result+"' data-file='"+imgName+"' style='width:150px; height:150px; display:inline; margin:0 auto;'></a>";
						$("#loadImg_wrap").append(appendImg);
					}
					viewer.readAsDataURL(file);
				}//for
			}//if
		}// on change
		
	});
	
	function inputClear(){
		$("#productImg").val("");
		$("#loadImg_wrap").empty();
		$("#productImglabel").text("등록된 이미지가 없습니다.");
	}
});