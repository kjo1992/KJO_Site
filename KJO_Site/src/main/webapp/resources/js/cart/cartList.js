$(document).ready(function(){
	var totalPrice = 0;
	
	function comma(str) {
		str = String(str);
		return str.replace(/(\d)(?=(?:\d{3})+(?!\d))/g, '$1,');
	}
	
	//모두선택 체크박스
	$("#allCheck").on("click", function() {
		var allChk = $("#allCheck").prop("checked");
		if(allChk) {
			$(".chkBox").prop("checked", true);
			//총 금액 총합계
			totalPrice = 0;
			$("input[name='productListNum']").remove();
			$("input[name='cartNum']").remove();
			
			$("input:checkbox[name='chkBox']:checked").each(function(){
				totalPrice = totalPrice + parseInt($(this).attr("data-price"));
				$("#orderForm").append("<input type='text' name='productListNum' value='"+$(this).attr("data-productListNum")+"' id='listNum_"+$(this).attr("data-productListNum")+"' hidden>");
				$("#orderForm").append("<input type='text' name='cartNum' value='"+$(this).attr("data-cartNum")+"' id='cartNum_"+$(this).attr("data-cartNum")+"' hidden>");
			});
			$("#totalPrice").html(comma(totalPrice));
			$("#totalPriceInput").val(totalPrice);
		} else {
			$(".chkBox").prop("checked", false);
			//총 금액 초기화
			totalPrice = 0;
			$("#totalPrice").html(comma(totalPrice));
			$("#totalPriceInput").val(totalPrice);
			$("input[name='productListNum']").remove();
			$("input[name='cartNum']").remove();
		}//if
	});//on click
	
	//개별상품 선택 체크박스
	$(".chkBox").on("click", function() {
		$("#allCheck").prop("checked", false);
		
		//개별 금액, 총금액에서+-
		if($(this).prop("checked")) {
			totalPrice = totalPrice + parseInt($(this).attr("data-price"));
			$("#orderForm").append("<input type='text' name='productListNum' value='"+$(this).attr("data-productListNum")+"' id='listNum_"+$(this).attr("data-productListNum")+"' hidden>");
			$("#orderForm").append("<input type='text' name='cartNum' value='"+$(this).attr("data-cartNum")+"' id='cartNum_"+$(this).attr("data-cartNum")+"' hidden>");
		} else {
			totalPrice = totalPrice - parseInt($(this).attr("data-price"));
			$("#listNum_"+$(this).attr("data-productListNum")).remove();
			$("#cartNum_"+$(this).attr("data-cartNum")).remove();
		}
		
		$("#totalPrice").html(comma(totalPrice));
		$("#totalPriceInput").val(totalPrice);
		
	});
	
	$("#selectDeleteBtn").on("click", function() {
		var confirmChk = confirm("선택한 제품들을 장바구니에서 삭제하시겠습니까?");
		
		if(confirmChk) {
			var checkArr = new Array();
			
			$("input:checkbox[name='chkBox']:checked").each(function(){
				/*alert($(this).attr("data-cartNum"));*/
				checkArr.push($(this).attr("data-cartNum"));
			});
			
			console.log(checkArr);
			
			$.ajax({
				url:"delete",
				type:"post",
				data:{
					chkBox:checkArr
				},
				success:function(result){
					if (result == 1) {
						location.href = "list";
					} else {
						alert("삭제에 실패하였습니다.");
					}
				}
			});// ajax
		}// if
	})// on click
	
	$(".deleteBtn").on("click", function() {
		var confirmChk = confirm("선택한 제품을 장바구니에서 삭제하시겠습니까?");
		
		if(confirmChk) {
			var checkArr = new Array();
			
			checkArr.push($(this).attr("data-cartNum"));
			
			console.log(checkArr);
			
			$.ajax({
				url:"delete",
				type:"post",
				data:{
					chkBox:checkArr
				},
				success:function(result){
					if (result == 1) {
						location.href = "list";
					} else {
						alert("삭제에 실패하였습니다.");
					}
				}
			});// ajax
		}// if
	})// on click
	
	$(".changeAmountBtn").on("click", function(){
		var confirmChk = confirm("수량을 변경하시겠습니까?");
		
		if(confirmChk) {
			var SCV={};
			SCV["cartNum"] = $(this).attr("data-cartNum");
			SCV["amount"] = $(".changeAmount_"+$(this).attr("data-cartNum")).val();
			/*alert(SCV.amount);*/
			console.log(SCV);
			
			$.ajax({
				url:"changeAmount",
				type:"post",
				contentType:"application/json",
				dataType:"json",
				data:JSON.stringify(SCV),
				success:function(result){
					if (result == 1) {
						location.href="list";
					} else {
						alert("변경에 실패하였습니다.");
					}
				}
			});//ajax
		}//if
	})//onclick
	
	//주문정보 입력 클릭 이벤트
	$("#inputOrderBtn").on("click", function(){
		$(this).fadeOut();
		$("#inputOrderForm").attr("hidden",false);
	});
	
	//주문취소 클릭 이벤트
	$("#orderCancleBtn").on("click", function(){
		$("#inputOrderForm").attr("hidden",true);
		$(".orderInput").val("");
		$("#inputOrderBtn").fadeIn();
	});
})