/*
 * Author: Administrator
 * Created: 2016�� 2�� 5�� �ݿ��� ���� 9:36:02
 * Modified: 2016�� 2�� 5�� �ݿ��� ���� 9:36:02
 */

import java.util.*;

class Test03_Calendar
{
   
	public static void main(String args[]){
      
      Calendar cal = Calendar.getInstance(); //��ü ����.
      
      int year =cal.get(Calendar.YEAR); //�⵵.
      int month = cal.get(Calendar.MONTH)+1; //��. 1��(0)~12��(11) �̹Ƿ� +1 ������Ѵ�.
      int day = cal.get(Calendar.DATE); //��.
      
      int h=cal.get(Calendar.HOUR); //�ð�.
      int m=cal.get(Calendar.MINUTE); //��
      int s= cal. get(Calendar.SECOND); //��
      
      System.out.println(year+"�� "+month+"�� "+day+"�� ");
      System.out.println(h+"�� "+m+"�� "+s+"�� ");
      
      
   }//main end

}//class end
