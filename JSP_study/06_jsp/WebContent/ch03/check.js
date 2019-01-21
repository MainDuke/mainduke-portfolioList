/**
 * check.js
 */

function isNull(obj, msg) {
	if (obj.value=="") {
		if (msg) {
			alert(msg);
		}//if
		obj.focus();
		return true;//입력 안됬으면 true
	}//if end
	return false;// 입력 되었으면 false.
}//function end

function isID(obj) {
	var str=obj.value;
	msg="";
	if (str.length==0) {
		alert("ID를 입력하시오.");
			return false;
	}//if

	str=str.toUpperCase(); //대문자로 변환, A~Z, a~z
	
	if (!('A'<=str.charAt(0)&&'Z'>=str.charAt(0))) {//ID첫글자가 영문자이어야한다.
		alert("ID 첫글자는 영문자이어야한다.");
		return false;
	}//if
	
	for (var i = 1; i <str.length; i++) {
		
		if (!(('A'<=str.charAt(i) && str.charAt(i)<='Z') || ('0' <=str.charAt(i) && str.charAt<='9') || (str.charAt(i)=='_'))){
			alert("ID는 영문,숫자,특수문자( _ )만 사용 가능합니다.");
			return false;
		}//if
	}//for

   if(msg==""){
	   return true;
   }else{
	   return msg;
   }
	
	return true;
}//ID end

function isEmail(obj){
	var str=obj.value;
	if (str=="") {
		return false;
	}//if end
	
	var i=str.indexOf("@");
	if (i<0) {
		alert("@이 입력되지 않았습니다.");
		return false;
	}//if end
	
	i=str.indexOf(".");
	if (i<0) {
		alert("'.' 이 입력되지 않았습니다");
		return false;
	}
	return true;
}//end email


function isCardNumber(obj) {
	var str=obj.value;
	if (str.length != 16) {
		alert("카드 번호 숫자는 16자리 입니다.");
		return false;
	}//if
	for (var i = 0; i < str.length; i++) {
		if (!('0'<=str.charAt(i) && str.charAt(i)<='9')) {
			alert("카드 번호는 숫자로 만 입력해야합니다.");
			return false;
		}//if
	}//for
	return true;
}//function end


function isSSN(front ,back){
	 
	var birthday=front.value;
	var num=back.value;
	
	if (birthday.length != 6) {
		return false;
	}
	if (num.length != 7) {
		return false;
	}
	var hap=0;
	
	for (var i = 0; i <6; i++) {
		var temp=birthday.charAt(i)*(i+2);
	   hap+=temp;
	}//for
	
	var n1=num.charAt(0);
	var n2=num.charAt(1);
	var n3=num.charAt(2);
	var n4=num.charAt(3);
	var n5=num.charAt(4);
	var n6=num.charAt(5);
	var n7=num.charAt(6);

	hap+=(n1*8)+(n2*9)+(n3*2)+(n4*3)+(n5*4)+(n6*5);
	
	hap %= 11;//나머지
	hap = 11-hap;
	hap %= 10;

	if (hap != n7) {
		alert("잘못된 주민번호 입니다.");
		return false;
	}
	return true;
	

}//isSSN end


function isSame(ob1, ob2){
	var str1=ob1.value;
	var str2=ob2.value;
	
	if (str1.length==0 || str2.length==0) {
		alert("암호를 입력 하시오");
	return false;
	}
	if (str1 != str2) {
		alert("암호확인이 정확히 입력 되지 않았습니다.");
		return false;
	}
	return true;
}
