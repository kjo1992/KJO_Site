$(document).ready(function() {
	$('#imgUpload').on("change", function(){
		//파일 이름
		var imgName = $('#imgUpload')[0].files[0].name;
		
		// image/** 에서 확장자만 추출
		var imgType = $('#imgUpload')[0].files[0].type.split('/').pop().toLowerCase();
		
		// 파일사이즈, 최대업로드(2MB) 사이즈
		var imgSize = $('#imgUpload')[0].files[0].size;
		var maxSize = 2 * 1024 * 1024;
		console.log("imgName="+imgName);
		console.log("imgType="+imgType);
		console.log("imgSize="+imgSize);
		console.log("maxSize="+maxSize);
		
		var formData = new FormData();
		formData.append("upload", $("#imgUpload")[0].files[0]);
		console.log($("#imgUpload")[0].files[0]);
		
//		alert('imgName : '+imgName+' // imgType : '+imgType+' // imgSize : '+imgSize);
//		alert(formData);
//		console.log(formData);
		
		// 확장자가 배열안에 포함되어있는지 체크
		if ($.inArray(imgType, ['png','jpeg','jpg','bmp']) != -1) {
			// 선택된 이미지가 최대업로드 사이즈보다 작으면
			if(imgSize < maxSize) {
				alert("업로드 가능");
				$.ajax({
					url:"imgChange",
					data:formData,
					dataType:'text',
					processData:false,
					contentType:false,
					type:'POST',
					success:function(data) {
						alert('업로드 성공');
						$("#profileImg").attr("src", data);
						$("#thumnail").attr("src", data);
						console.log("return : "+data);
					},
					error:function(request,status,error){
						console	.log("code:"+request.status+"\n"+"message:"+request.responseText+"\n"+"error:"+error);
					}

				})
			} else { // 최대용량을 넘기면
				alert("파일의 크기는 2MB를 넘길수 없습니다.");
				$("#imgUpload").val("");
			}
		} else {// 확장자가 배열안에 없으면
			alert('png, jpeg, jpg, bmp 파일만 업로드 가능합니다.');
			$("#imgUpload").val("");
		}
	});
});