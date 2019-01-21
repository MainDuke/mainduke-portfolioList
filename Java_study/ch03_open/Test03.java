/*
 * Author: Administrator
 * Created: 2016년 1월 15일 금요일 오후 2:17:26
 * Modified: 2016년 1월 15일 금요일 오후 2:17:26
 */


class Test03
{
public static void main( String [] args )
{
	System.out.println(5>3 && 10 >7); //true
	System.out.println(5>3 && 10 <7); //false	
	System.out.println(5>3 || 10 >7); //true
	System.out.println(!(5>3)); //false
	System.out.println(!!(5>3)); //true
	
	//2진 연산(bit연산)
	System.out.println("------------------"); //false
	short a=0xA7;
	short b=0xf0;
		
	System.out.println(Integer.toString(a,2)); //false
	System.out.println(Integer.toString(b,2)); //false
	System.out.println("a&b :"+Integer.toString((a&b),2)); //false
	System.out.println("a|b :"+Integer.toString((a|b),2)); //false
	System.out.println("a^b :"+Integer.toString((a^b),2)); //false
	System.out.println("---shift 연산---------"); //false

	
	//shift 연산.
	short n=9; //1001
	System.out.println(Integer.toString(n,2));
	System.out.println("n<<3 :"+Integer.toString(n<<3,2));
	System.out.println("n<<3 :"+Integer.toString(n>>3,2));
	System.out.println("n<<3 :"+Integer.toString(n>>>3,2));
	
	//10진 출력.
	
	System.out.println("n<<3 :"+(n<<3));
	System.out.println("n>>3 :"+(n>>3));
	System.out.println("n>>>3 :"+(n>>>3));
	
	
	
	
}// end main
}//class end
