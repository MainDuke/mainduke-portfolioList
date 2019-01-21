/*
 * Author: Administrator
 * Created: 2016년 2월 12일 금요일 오전 9:30:10
 * Modified: 2016년 2월 12일 금요일 오전 9:30:10
 */

/*Stack은 배열처럼 한 개 이상의 데이터를 저장할 수 있는 기억 공간 이지만 
데이터 저장하고 꺼내는 순서가 정해져 있다는 면에서 배열과 차이점이 있다 

스택은 LIFO ( Last-In , First-out) 입출력 방식이다 

Stack 메서드들
push(E item) : 스택 맨위에다 객체를 추가한다 
empty() : 현재 스텍이 비어있는가를 확인 ( isEmpty() 와 동일)
pop()  : 스택 맨 위의 객체를 꺼낸다 ( 객체 제거 )
peek() :  스택 맨 위의 객체를 꺼낸다 ( 객체 제거 되지 않는다  
*/


import java.util.*;

class Test14_stack
{
	public static void main( String [] args ) 
   {
      Stack<String> stack = new Stack<String>();
      stack.push("사과");
      stack.push("배");
      stack.push("수박");
      stack.push("참외");
      stack.push("오렌지");
      
      while(!stack.isEmpty())//현재 스택이비어 있지 않다면, 반복수행.
      {
         System.out.println(stack.pop());
      }//while
      
      
      }// end main

}//class end
