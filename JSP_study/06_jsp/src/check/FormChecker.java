package check;
//서버측에서 데이터 유효성 체크
public class FormChecker {

	public static boolean isNull(String m){
		
		if (m==null || m.trim().length()==0) {
			return true;  //내용이 null 이면, 혹은 입력 안했으면 
		}
		return false;
		
	}//end isNull
//==================================================================================
//==================================================================================
	public static boolean isNumber(String m){
		
		if (isNull(m)) {
			return false;  //입력하지 않았으면
	
		}//if end
	
		m=m.trim();
		int n=m.length();
		
		for (int i = 0; i < n; i++) {
			char c= m.charAt(i);
			if (!('0'<=c && '9'>=c)) {//0~9사이가 아니면, 숫자가 아니면~
				return false;
			}
		}//for end
		return true;
	}//isNumber 
	//==================================================================================
	
	public static boolean isSame(String m, String n){
		if (isNull(m) || isNull(n)) {
			return false; //입력하지 않았으면.
		}//if end
		m=m.trim();
		n=n.trim();
	
		if (m.equals(n)) {
			return true;
		}
	return false;
	}//isSame end
	//==================================================================================

	public static boolean isID(String m){
		if (isNull(m)) {
			return false;
		}//if
		
		m=m.trim();
		m=m.toUpperCase();
		
		char c=m.charAt(0); //첫글자는 영문자 인지를 확인.
		
		if (!(('A')<=c && ('Z')>=c)) {
			return false;
		}//if
		
		for (int i = 1; i < m.length(); i++) {
			c=m.charAt(i);
			if (!(('A'<=c && c<= 'Z') || ('0'<=c && c<='9') || (c=='_'))) {
				System.out.println("리턴 false : "+c);
				return false;
			}//if
		}//for
		System.out.println("리턴 true " );
	return true;			
	}//end ID
	//==================================================================================

	public static boolean isCardNumber(String m){
		if (isNull(m)) {
			System.out.println("카드번호 입력하시오.");
			return false;
		}//if
	
		m=m.trim();
		if (m.length() != 16){
			System.out.println("카드번호가 16자리가 아니다.");
			return false;
		}//if
	
		if (!isNumber(m)) {
			System.out.println("카드번호가 숫자가 아니다.");
			return false;
		}
		return true;
	}//card end
	//==================================================================================
	
	public static boolean isEmail(String m){
		
		if(isNull(m)){
			return false;
		}
		int n=m.indexOf("@");
		if (n<0) {
			return false;
		}
		
		n=m.indexOf(".");
		if (n<0) {
			return false;
		}
		return true;
		
	}//is Email end
	
	//==================================================================================
	public static boolean isSSN(String s1, String s2){
		if(isNull(s1) || isNull(s2)){
			System.out.println("주민번호가 없다.");
			return false;
		}
		if(!isNumber(s1)){

			System.out.println("주민번호가 숫자가 아니다.1");
			return false;
		}
		if(!isNumber(s2)){
			System.out.println("주민번호가 숫자가 아니다2");
			return false;
		}
		
		s1=s1.trim();
		s2=s2.trim();
		if (!(s1.length()==6))
		{
			System.out.println("주민번호가 숫자 길이가 안 맞는다..");
			return false;
		}
		if (!(s2.length()==7)) {
			return false;
		}
		
		int hap=0;
		for (int i = 0; i < 6; i++) {
			hap+=(s1.charAt(i)-'0')*(i+2);
		}//for
		
		//html 에서 넘어온 S2 값은 문자다. 문자열을 아스키코드값으로 계산을 하여 정수로 저장을 하겠다는 말이다.
		int n0=s2.charAt(0)-'0';
		int n1=s2.charAt(1)-'0';
		int n2=s2.charAt(2)-'0';
		int n3=s2.charAt(3)-'0';
		int n4=s2.charAt(4)-'0';
		int n5=s2.charAt(5)-'0';
		int n6=s2.charAt(6)-'0';
		
		hap+=(n0*8)+(n1*9)+(n2*2)+(n3*3)+(n4*4)+(n5*5);
		
		hap %= 11;
		hap = 11 - hap;
		hap %= 10;
		
		if (hap != n6) {
			System.out.println("검산이 안된다.");
			return false;
		}
		return true;
	}//end isSSN
	
	
}//class end
