/*
 * Author: Administrator
 * Created: 2016년 1월 25일 월요일 오후 12:32:12
 * Modified: 2016년 1월 25일 월요일 오후 12:32:12
 */

//book 222 실습.

class SubInfor{
	String name, id, password;
	String phoneNo, address;
	
	
	//생성자는 기본적으로 public을 써준다.
	public SubInfor(){}
		
	
	public SubInfor(String name, String id, String password){
		this.name=name;
		this.id=id;
		this.password=password;
		
	}
	
	
	public SubInfor(String name, String id, String password, String phoneNo, String address){
		this.name=name;
		this.id=id;
		this.password=password;
		this.phoneNo=phoneNo;
		this.address=address;
	}
	
	void changepassword(String password){
		this.password=password;
	}
	void setphoneNo(String phoneNo){
		this.phoneNo=phoneNo;
	}
	void setaddress(String setaddress){
		this.address=setaddress;
	}
	
	
}// SubInfor end




class ConstrExample222
{
	public static void main( String [] args ) 
	{
		
		//현재, SubInof 에는 디폴트 생성자가 없다.
		//그래서 SubInfor()로 선언 하면 에러가 생긴다.
		//인자가 있는 생성자가 있을때는 , 디폴트생성자는 자동으로 생성 되지 않는다.
		
		ConstrExample222 cc= new ConstrExample222();
		
		SubInfor obj1, obj2, obj3;
		obj1 = new SubInfor("연흥부", "poorman", "zebi");
		obj2 = new SubInfor("연놀부", "richman", "money", "02-000-0000", "타워팰리스");
		obj3 = new SubInfor();
		
		printSubInfor(obj1);
		printSubInfor(obj2);
		
		cc.printSubInfor2(obj1);
		cc.printSubInfor2(obj2);
	
		obj2.changepassword("789");
		obj2.setphoneNo("010-7766-8877");
		obj2.setaddress("서울 마포구 신촌로 176 중앙빌딩 5f");
		printSubInfor(obj2);
		cc.printSubInfor2(obj2);
		
	}// end main

	//static을 빼고서 필드에 메서드를 사용했다면...?
	//아래 부분 printSubInfor를 따로 객체를 생성해야 아래 메서드를 정상 실행할수 있따.
	
	static void printSubInfor(SubInfor obj){
		System.out.println("이건 P1");
		System.out.println("이름: " + obj.name);
		System.out.println("ID: " + obj.id);
		System.out.println("패스워드: " + obj.password);
		System.out.println("전화번호: " + obj.phoneNo);
		System.out.println("주소: " + obj.address);
		System.out.println();
	}
	
		void printSubInfor2(SubInfor obj){
			System.out.println("이건 P2");
			System.out.println("이름: " + obj.name);
			System.out.println("ID: " + obj.id);
			System.out.println("패스워드: " + obj.password);
			System.out.println("전화번호: " + obj.phoneNo);
			System.out.println("주소: " + obj.address);
			System.out.println();
		}
	
	
	
	
		
		
	
}//class end
