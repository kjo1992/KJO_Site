$(document).ready(function(){
	function getContextPath() {
		var hostIndex = location.href.indexOf( location.host ) + location.host.length;
		return location.href.substring(hostIndex, location.href.indexOf('/', hostIndex + 1));
	}
	var ContextPath = getContextPath();
	
	$("#LoginBtn").click(function(){
		$("#LoginModal").modal("show");
	});
	
	$("#LogoutBtn").click(function() {
		$(location).attr("href",ContextPath+"/User/Logout");
	});
});