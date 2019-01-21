var ajax = null;// getXMLHttpRequest()함수로 생성한 객체를 넣을 전역변수 
		
function getXMLHttpRequest() {
	if (window.ActiveXObject) {
		try {
			return new ActiveXObject("Msxml2.XMLHTTP");//IE  
		} catch(e) {
			try {
				return new ActiveXObject("Microsoft.XMLHTTP");//IE  
			} catch(e1) {
				return null;
			}
		}
	} else if (window.XMLHttpRequest) {
		return new XMLHttpRequest(); // IE 이외의 브라우저  
	} else {
		return null;
	}
}//--------------------------
 
//function loadNews() {
window.onload = function() {
 	var url = "member_json.jsp"; 
 	 
 	ajax = getXMLHttpRequest();//XMLHttpRequest 객체를 얻는다 
 	ajax.onreadystatechange = viewInfo;// 콜백함수설정
 	ajax.open("GET", url, true); //요청 초기화 , GET/POST선택, 접속 URL입력
 	ajax.send(null); //웹 서버에 요청 전송 
};

function viewInfo() {
	 
	if (ajax.readyState == 4) {
		if (ajax.status == 200) {
			
		 	var json = ajax.responseText ;
			var result = eval('('+ json +')'); // 파싱 contentType="text/plain;
			
	 		 
			if (result.code == 'success') {
				var m = result.data.member;
				alert("m.id="+m.id+ "\n"+"m.name:"+m.name+"\n"+"m.sno="+m.sno);
			} else {
				alert("실패");
			}
		} else {
			alert("에러 발생:"+ajax.status);
		}//else
	}//if

}//function viewInfo()
