/*
 * Author: Administrator
 * Created: 2016�� 2�� 11�� ����� ���� 11:46:31
 * Modified: 2016�� 2�� 11�� ����� ���� 11:46:31
 */

import java.util.*;
class Testself
{
   public static void main(String[] args) {
      
      /*
       * RandomŬ����
       * -������
       * Random():������ �ð��� �ʱⰪ���� �ϴ� �����߻�
       * Random(long seed) : seed���� �ʱⰪ�����ϴ� �����߻�
       */
      
      System.out.println("== Random �Լ� ������ seed���� 100���� �������");
      Random random = new Random(100);
      for (int i=0;i<10;i++){
         System.out.print(random.nextInt(3)+" ");
      }
      System.out.println();
      System.out.println("== Random �Լ� ������ seed���� 100���� �������");
      Random random2 = new Random(100);
      for (int i=0;i<10;i++){
         System.out.print(random2.nextInt(3)+" ");
      }
      System.out.println();
      System.out.println("== Random �Լ� ������ seed���� 50���� �������");
      Random random3 = new Random(50); //seed���� �ʱⰪ���� �ϴ� �����߻�
      for (int i=0;i<10;i++){
         System.out.print(random3.nextInt(3)+" ");
      }
      System.out.println();
      System.out.println("== Random �Լ� ������ �⺻�����ڷ� �����������");
      Random random4 = new Random();
      for (int i=0;i<10;i++){
         System.out.print(random4.nextInt(3)+" ");
      }
      System.out.println();
      System.out.println("== Random �Լ� ������ �⺻�����ڷ� �����������");
      Random random5 = new Random(); //������ �ð��� �ʱⰪ���� �ϴ� �����߻�.
      for (int i=0;i<10;i++){
         System.out.print(random5.nextInt(3)+" ");
      }
      
   } 
}