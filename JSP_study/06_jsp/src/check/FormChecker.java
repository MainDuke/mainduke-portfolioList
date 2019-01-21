package check;
//���������� ������ ��ȿ�� üũ
public class FormChecker {

	public static boolean isNull(String m){
		
		if (m==null || m.trim().length()==0) {
			return true;  //������ null �̸�, Ȥ�� �Է� �������� 
		}
		return false;
		
	}//end isNull
//==================================================================================
//==================================================================================
	public static boolean isNumber(String m){
		
		if (isNull(m)) {
			return false;  //�Է����� �ʾ�����
	
		}//if end
	
		m=m.trim();
		int n=m.length();
		
		for (int i = 0; i < n; i++) {
			char c= m.charAt(i);
			if (!('0'<=c && '9'>=c)) {//0~9���̰� �ƴϸ�, ���ڰ� �ƴϸ�~
				return false;
			}
		}//for end
		return true;
	}//isNumber 
	//==================================================================================
	
	public static boolean isSame(String m, String n){
		if (isNull(m) || isNull(n)) {
			return false; //�Է����� �ʾ�����.
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
		
		char c=m.charAt(0); //ù���ڴ� ������ ������ Ȯ��.
		
		if (!(('A')<=c && ('Z')>=c)) {
			return false;
		}//if
		
		for (int i = 1; i < m.length(); i++) {
			c=m.charAt(i);
			if (!(('A'<=c && c<= 'Z') || ('0'<=c && c<='9') || (c=='_'))) {
				System.out.println("���� false : "+c);
				return false;
			}//if
		}//for
		System.out.println("���� true " );
	return true;			
	}//end ID
	//==================================================================================

	public static boolean isCardNumber(String m){
		if (isNull(m)) {
			System.out.println("ī���ȣ �Է��Ͻÿ�.");
			return false;
		}//if
	
		m=m.trim();
		if (m.length() != 16){
			System.out.println("ī���ȣ�� 16�ڸ��� �ƴϴ�.");
			return false;
		}//if
	
		if (!isNumber(m)) {
			System.out.println("ī���ȣ�� ���ڰ� �ƴϴ�.");
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
			System.out.println("�ֹι�ȣ�� ����.");
			return false;
		}
		if(!isNumber(s1)){

			System.out.println("�ֹι�ȣ�� ���ڰ� �ƴϴ�.1");
			return false;
		}
		if(!isNumber(s2)){
			System.out.println("�ֹι�ȣ�� ���ڰ� �ƴϴ�2");
			return false;
		}
		
		s1=s1.trim();
		s2=s2.trim();
		if (!(s1.length()==6))
		{
			System.out.println("�ֹι�ȣ�� ���� ���̰� �� �´´�..");
			return false;
		}
		if (!(s2.length()==7)) {
			return false;
		}
		
		int hap=0;
		for (int i = 0; i < 6; i++) {
			hap+=(s1.charAt(i)-'0')*(i+2);
		}//for
		
		//html ���� �Ѿ�� S2 ���� ���ڴ�. ���ڿ��� �ƽ�Ű�ڵ尪���� ����� �Ͽ� ������ ������ �ϰڴٴ� ���̴�.
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
			System.out.println("�˻��� �ȵȴ�.");
			return false;
		}
		return true;
	}//end isSSN
	
	
}//class end
