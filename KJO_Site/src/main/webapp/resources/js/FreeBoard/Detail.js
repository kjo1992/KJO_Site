$(document).ready(function(){
	function getContextPath() {
		var hostIndex = location.href.indexOf( location.host ) + location.host.length;
		return location.href.substring(hostIndex, location.href.indexOf('/', hostIndex + 1));
	
	}
	var ContextPath = getContextPath();
	
	$(function(){
		CKEDITOR.replace('replytext',{
			width:'90%',
			height:'100px',
			toolbar : 'Custom',
			//removePlugins : 'elementspath',
			toolbarStartupExpanded : false,
			toolbarCanCollapse : false,
			toolbar_Custom: [],
		});
	})
});