$(document).ready(function() {
	function getContextPath() {
		var hostIndex = location.href.indexOf( location.host ) + location.host.length;
		return location.href.substring(hostIndex, location.href.indexOf('/', hostIndex + 1));
	
	}
	var ContextPath = getContextPath();
	
	$("#slider").bxSlider({
		/*mode: 'fade',*/
		auto:false,
		autoControls:false,
		/*adaptiveHeight : true,*/
		infiniteLoop:false,
		hideControlOnEnd: true,
		pager:true,
		pagerCustom:"#sliderPager",
	});
	
	$("#addCartBtn").on("click", function(){
		var productListNum = $("#productListNum").val();
//		var userNum = $("#userNum").val();
		var amount = $("#amount").val();
		/*alert("productListNum : "+productListNum+"/ amount : "+amount);*/
		var data = {
			productListNum : productListNum,
			/*userNum : userNum,*/
			amount : amount
		};
		
		if (amount < 1) {
			alert("장바구니에 담을 최소 수량은 1개 입니다.");
			$("#amount").val("1");
		} else {
			$.ajax({
				url : ContextPath+"/cart/addCart",
				type : "post",
				data : data,
				success : function(result){
					if(result == 1) {
						alert("장바구니에 성공적으로 추가되었습니다.");
						console.log(result);
						$("#amount").val("1");
					} else {
						alert("회원만 사용 가능합니다.");
						console.log(result);
						$("#amount").val("1");
					}
				},
				error : function(){
					alert("카트 담기 실패");
				}
			}); // ajax
		} // if else
	});// onclick
	
}); // document