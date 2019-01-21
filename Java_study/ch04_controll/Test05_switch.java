/*
 * Author: Administrator
 * Created: 2016년 1월 18일 월요일 오후 12:27:06
 * Modified: 2016년 1월 18일 월요일 오후 12:27:06
 */

/*어떤수를 입력 받아서, 짝수 홀수를판변 하시오.*/

class Test05_switch
{

 public static void main( String [] args )
	{
	 	int su=Integer.parseInt(args[0]);
			switch(su%2){
			case 0:
				System.out.println(su+" = 짝수 ");
				break;
			case 1:
				System.out.println(su+" = 홀수 ");
				break;
			}//switch end.		
		
	}// end main
}//class end

