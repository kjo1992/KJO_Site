$(document).ready(function() {
	$("#slider").bxSlider({
		auto:true,
		autoControls:false,
		adaptiveHeight : true,
		infiniteLoop:true,
		hideControlOnEnd: true,
		pager:false,
		captions:true,
		controls:false,
		/*크롬에서 이미지 클릭시 a태그 사용가능하게 해줌*/
		touchEnabled:(navigator.maxTouchPoints > 0),
	});
})