function writeSave(){
	
	//script.js
	if($("#writer").val()==''){
		alert("이름을 입력하시오.");
		$("#writer").focus();
		return false;
	}
	
	if($("#subject").val()==''){
		alert("글제목을 입력하시오.");
		$("#subject").focus();
		return false;
	}
	
	if($("#content").val()==''){
		alert("글내용을 입력하시오.");
		$("#content").focus();
		return false;
	}
	
	if($("#passwd").val()==''){
		alert("암호를 입력하시오.");
		$("#passwd").focus();
		return false;
	}
	
	
}//writeSave