/*
 * Author: Administrator
 * Created: 2016�� 1�� 25�� ������ ���� 9:51:08
 * Modified: 2016�� 1�� 25�� ������ ���� 9:51:08
 */
//static �޼���� static���� ����� ����, �޼��常 ȣ�� ����.
class SinSang2{

	//���� ����: �ڵ����� �ʱ�ȭ �ȴ�.
	String name; //null

	int nai;//0
	String imsi;
	static int sungin=18;
		
		//������:������ ����, Ŭ���� �̸��� ���� �̸�.
		
	public SinSang2(){
		this.name=name;
		this.nai=nai;
		
	
	}//������ end.
		
//�޼���.
		public void setData(String name, int nai)
		{
			
			String imsi;//��������
			if(sungin<nai){
				imsi="����";
			}else{
				imsi="�̼�����";
			}
			System.out.println(name+"---"+nai+"---"+imsi);
		
		
		}
		
		public void disp(){
			System.out.println(name+"---"+nai+"---"+imsi);
		}
		
	
	}//class end


class Test14_method_static
{
	public static void main( String [] args ) 
	{
		SinSang2 s1 = new SinSang2();//��ü ����.
		SinSang2 s2 = new SinSang2();//��ü ����.
		SinSang2 s3 = new SinSang2();//��ü ����.

		s1.setData("ȫ�浿", 17);
		s2.setData("������", 31);
		s3.setData("����ȣ", 25);
		s1.disp();
		s2.disp();
		s3.disp();
	}// end main

}//class end
