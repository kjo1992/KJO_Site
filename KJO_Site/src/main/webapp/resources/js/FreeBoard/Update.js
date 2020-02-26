$(document).ready(function(){
	function getContextPath() {
		var hostIndex = location.href.indexOf( location.host ) + location.host.length;
		return location.href.substring(hostIndex, location.href.indexOf('/', hostIndex + 1));
	
	}
	var ContextPath = getContextPath();
	
	$(function(){
		CKEDITOR.replace('contentArea',{
			width:'100%',
			height:'500px',
			filebrowserImageUploadUrl: ContextPath+'/FreeBoard/ImgUpload',
		});
		
		CKEDITOR.on('dialogDefinition', function( ev ){
			var dialogName = ev.data.name;
            var dialogDefinition = ev.data.definition;
            
            switch (dialogName) {
            	case 'image': //Image Properties dialog
	       			//dialogDefinition.removeContents('info');
	           		dialogDefinition.removeContents('Link');
	               	dialogDefinition.removeContents('advanced');
	               	break;
            }
		});
	});
});