/*
 * Author: Administrator
 * Created: 2016�� 2�� 11�� ����� ���� 2:21:12
 * Modified: 2016�� 2�� 11�� ����� ���� 2:21:12
 */


class Test06_varages
{
   
   //custom
   public void strPrint(String ...names){
      
      for(String s:names)
      {
         System.out.print(s+" ");
      }
      System.out.println();
   }//strPrint()  
   
   //custom
   public void intPrint(int ...nums){
      
      for(int n:nums)
      {
         System.out.print(n+" ");
      }
      System.out.println();
      
      /*�Ϲ� for ��.
      for(int i=0;i<nums;i++)
      {
         System.out.println(nums[i]+ " ");
      }//for
      */
      
   }//intPrint()
   
   
	public static void main( String [] args ) 
   {
      Test06_varages A =new Test06_varages();// ��ü ����.
      
      A.strPrint("kim");
      A.strPrint("lee", "Park");
      A.strPrint("choi","kim", "lee", "koo", "han");
      
      A.intPrint(10);
      A.intPrint(10, 20, 30);
      A.intPrint(40,50,60,70,80,90);
      
      
   }// end main

}//class end
