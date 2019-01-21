/*
 * Author: Administrator
 * Created: 2016년 1월 22일 금요일 오전 11:25:02
 * Modified: 2016년 1월 22일 금요일 오전 11:25:02
 */


//패키지- 한 파일
//상속?

class Demo05{
	public void aa(){
		System.out.println("aa()...call");
	}//aa() end
	
	public int bb(){
		//처리내용
		return 123;	
	}//bb() end
	
	public String getName(){
		return "아이유";
	}//getName end
	
} // Demo05 end

class Test05_Method
{
	public static void main(String agrs[]){
		
		Demo05 d5= new Demo05();
		
		d5.aa();
		
		System.out.println(d5.bb());
		System.out.println(d5.getName());
		
	}//main end
	
}// class end
