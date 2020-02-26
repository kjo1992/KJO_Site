$(document).ready(function() {
	$("input:checkbox").on("change", function(){
		if($("input:checkbox").is(":checked") == true) {
			/* this.value=1; */
			$(this).val("1");
			/*alert($(this).attr("name")+" : "+$(this).val());*/
		} else {
			/* this.value=0; */
			$(this).val("0");
			/*alert($(this).attr("name")+" : "+$(this).val());*/
		}
	});
	
/*	$("#productImg").on("change", function(){
		var fileInput = document.getElementById("productImg");
		var files = fileInput.files;
		var file;
		var inputImg = "";
		for (var i = 0; i < files.length; i++) {
            file = files[i];
            console.log(file);
            var imgName = file.name;
            var imgType = file.type.split("/").pop().toLowerCase();
			var imgSize = file.size;
			var maxSize = 2 * 1024 * 1024;
			
			//파일 형식 검사
			if($.inArray(imgType, ['png','jpeg','jpg','bmp']) != -1) {
				//파일 크기 검사
				if(imgSize < maxSize) {
					inputImg = inputImg+" / "+(i+1)+"."+imgName;
					$("#productImglabel").text(inputImg);
				} else {
					alert(imgName+" 의 파일크기가 너무 큽니다.");
					$("#productImg").val("");
					$("#productImglabel").text("등록된 이미지가 없습니다.");
				}
			} else {
				alert(imgName+" 가 형식에 맞지않은 파일입니다.");
				$("#productImg").val("");
				$("#productImglabel").text("등록된 이미지가 없습니다.");
			}
        }

	});*/
});
