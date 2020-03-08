$(document).ready(function() {
	alert("detail Spec");
	
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
})