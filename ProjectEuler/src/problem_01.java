class problem_01
{
   int sum=0;
   
   
   public problem_01(){
   
      
      
      for(int i =1;i<1000;i++)
      {
         
      
         if(i%3 == 0 || i%5 == 0)
         {
            System.out.print(i+" "); 
            sum+=i;
         }//if end
                  
         if(i%10 == 0){
         System.out.println();
         }
         
      }//end
      
     //1000 ���� ���� 3�� 5�� ������� ���� ����Ѵ�.
      //����.
      System.out.println("sum= "+sum);
   
   }//cons end
   
   
	public static void main( String [] args ){
      
      
      
      
   new problem_01();
      
 
   
   
   
   }// end main

}
