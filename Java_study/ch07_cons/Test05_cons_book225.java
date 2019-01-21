/*
 * Author: Administrator
 * Created: 2016년 1월 25일 월요일 오후 4:14:45
 * Modified: 2016년 1월 25일 월요일 오후 4:14:45
 */


//book 224~228 : 생성자
//변수 첫글자 소문자, 두번째 음절부터는 대문자.
//메서드 첫글자 소문자, 두번째 음ㅈ거부터는 대문자.

class SubInfor2{

	//전역변수
	String name;
	String id;
	String password;
	String phoneNo;
	String address;	

	//1. 디폴트
	public SubInfor2()
	{
	System.out.println("디폴트");	
	}
	
	//2. 인자 있음.
	public SubInfor2(String name, String id, String password){
		this.name=name; 
		this.id=id;
		this.password=password;
	}//cons end
	//3. 인자 있음.
	public SubInfor2(String name, String id, String password, String phoneNo, 
		String address){
		this.name=name; //227 생성자 연습.
		this.id=id;
		this.password=password;
		this.phoneNo= phoneNo;
		this.address=address;
	}//cons end
	//메서드
	public void changepassword(String password)
	{
		this.password=password;
	}
	public void setAddress(String address)
	{
		this.address= address;
	}
	public void setphoneNo(String phoneNo)
	{
		this.phoneNo=phoneNo;
	}
	
}//class end

class Test05_cons_book225{
	public static void main( String [] args ){
	
		SubInfor2 ob1,ob2;
		ob1=new SubInfor2(); 
		ob2 = new SubInfor2("홍길동","Food","12345","02-2323-5656","서울 마포구 신촌로 176 중앙 빌딩 5F");
		
		
		Test05_cons_book225 test= new Test05_cons_book225();//밑에 void disp() 쪽 객체 생성.
				
		test.disp(ob1);
		test.disp(ob2);
		
	}// end main
	void disp(SubInfor2 ob){
	System.out.println("이름:"+ob.name);
	System.out.println("ID :"+ob.id);
	System.out.println("Password :"+ob.id);
	System.out.println("전화번호 :"+ob.phoneNo);
	System.out.println("Address :"+ob.address+"\n");
}//disp end

	
	
}//class end.
