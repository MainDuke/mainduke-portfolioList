var ajax=null;

function getXMLHttpRequest(){ //ajax 객체 얻기 함수.
	
	if(window.ActiveXObject){//ie 브라우저 사용
		
		try {//최근 ie 버전
			return new ActiveXObject("Msxml2.XMLHTTP");
			
		} catch (e1) {
			try{
			return new ActiveXObject("Microsoft.XMLHTTP"); //객체 생성
			}catch(e2){return null;}
		}//catch
		
		
	}else if(window.XMLHttpRequest){//ie 이외의 브라우져(사파리, 오페라, 파이어 폭스)
		return new XMLHttpRequest();
	}else{
		return null;
	}//end if else
	
}//end getXMLHttpRequest()

function loadNews(){
	//get 방식 요청
	var url="news.jsp"; //get 방식
	ajax = getXMLHttpRequest(); //ajax 객체 얻기
	
	ajax.onreadystatechange=viewNews; //콜백 함수
	ajax.open("GET", url, true);
	ajax.send(null); //get 방식 요청
		
}//helloToServer() end

function viewNews(){
	//alert("helloFromServer");
	if(ajax.readyState==4){//4: 모든 데이터 도착했는가
		if(ajax.status==200){//ok이면
			//alert("서버응답 내용:"+ajax.responseText);
			var newList=document.getElementById("newList");// id 를 얻어서~
			newList.innerHTML=ajax.responseText;
		}
	}//end
}//helloFromServer end

/*
 * XMLHttpRequest객체의 상태 : readyState 속성 
httpRequest.readyState == 0 ( Uninitialised ) => 객체만 생성되고 아직 초기화 되지 않은 상태(open 메서드가 호출되지 않음 )
httpRequest.readyState == 1 ( Loading ) => open 메서드가 호출되고 , 아직 send메서드가 호출되지 않은 상태 
httpRequest.readyState == 2 ( Loader )  => send 메서드가 호출되었지만 , status와 헤더는 도착하지 않은 상태 
httpRequest.readyState == 3 ( Interactive ) => 데이터 일부를 받은 상태 
httpRequest.readyState == 4 ( Complate )  => 데이터 전부를 받은 상태 , 완전한 데이터의 이용 가능 

 * */



