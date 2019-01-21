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

function helloToServer(){
	//alert("helloToServer");
	var name=document.getElementById("name");
	var params="name="+encodeURIComponent(name.value);
	
	//get 방식 요청
	var url="helloApp.jsp?"+params; //get 방식
	ajax = getXMLHttpRequest(); //ajax 객체 얻기
	
	ajax.onreadystatechange=helloFromServer; //콜백 함수
	ajax.open("GET", url, true);
	ajax.send(null); //get 방식 요청
	
	/*
	 * open() 함수는 세개의 인자를 입력 받는데 , 그 의미는 다음과 같다
첫번째 인자  : HTTP메서드를 지정한다 , HTML의 form을 보면 method 속성에 get/post 값을 주는데 ,
              첫번째 인자도 같은 값이 사용된다.
두번째 인자  : 접속할 URL(서버주소) 을 입력한다, 웹 브라우저 보안상 이유로 접속할 url은 현재 페이지와 같은 도메인에 있어야 한다.
세번째 인자  : 동기/비동기 방식을 지정한다.

	 * */
	
	
	/*
	//post  방식
	var url="helloApp.jsp"//post 방식
	ajax = getXMLHttpRequest(); //ajax 객체 얻기
	
	ajax.onreadystatechange=helloFromServer; //콜백 함수
	ajax.open("post", url, true);
	ajax.send(params); //post 방식 요청
	*/
	
}//helloToServer() end

function helloFromServer(){
	//alert("helloFromServer");
	if(ajax.readyState==4){//4: 모든 데이터 도착했는가
		if(ajax.status==200){//ok이면
			//alert("서버응답 내용:"+ajax.responseText);
			var result=document.getElementById("result");// id 를 얻어서~
			result.value=ajax.responseText;
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


ajax.status==200
200 요청 성공
403 접근 거부
404 페이지 없음
500 서버 오류

 * */



