/*
 * Author: Administrator
 * Created: 2016년 1월 21일 목요일 오전 10:37:44
 * Modified: 2016년 1월 21일 목요일 오전 10:37:44
 */


//System.arraycopy 예제

class Test05_array_copy
{
	public static void main( String [] args )
	{
		int a[] = {1,3,5,7,9,11};
		int b[] = new int[a.length]; //배열은 지역일지라도 자동 초기화 된다.
		System.arraycopy(a,1,b,2,3); // a[1]부터 3를 b[2]로 복사.
		//System.arraycopy(배열, 시작지점, 복사받으려는 배열, 복사 받으려는 배열의 시작지점, 복사 범위)
		
		for(int i =0;i<a.length;i++)
		{
			System.out.println(a[i]+"=="+b[i]);
		}
		
	}// end main

}//claas end
