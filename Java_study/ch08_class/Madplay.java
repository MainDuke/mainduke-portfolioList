/*
 * Author: Administrator
 * Created: 2016년 1월 27일 수요일 오후 5:39:14
 * Modified: 2016년 1월 27일 수요일 오후 5:39:14
 */
public class 해장국{
	public void 간맞추기(){
		System.out.println("소금치기");
}
}
class 뼈다귀해장국 extends 해장국{
	public void 간맞추기(){
		System.out.println("뼈다귀해장국에는 들깨가루");
	}
	public void 뼈추가하기(){
	System.out.println("뼈추가!");
	}
}
class 콩나물해장국 extends 해장국{
	public void 간맞추기(){
		System.out.println("콩나물해장국에는 고추가루");
	}
	public void 콩나물넣기(){
		System.out.println("콩나물");
	}
}//class

class 취객{
	public void 해장국먹기(해장국 무슨해장국){
		무슨해장국.간맞추기();
	}
}

class Madplay{
	public static void main( String [] args ) 
	{
		취객 취객한사람 = new 취객();
		해장국 해장국한그릇 = new 뼈다귀해장국();
		취객한사람.해장국먹기(해장국한그릇);
	}// end main

}//class end
