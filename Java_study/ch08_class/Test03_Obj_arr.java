/*
 * Author: Administrator
 * Created: 2016�� 1�� 26�� ȭ���� ���� 12:45:20
 * Modified: 2016�� 1�� 26�� ȭ���� ���� 12:45:20
 */

class Sung{
	private String name;//�����ʵ�
	private int kor;
	private int eng;

	public Sung(String name, int kor, int eng){
		this.name=name;
		this.kor=kor;
		this.eng=eng;
	}//������ end
	
	public void disp(){//�޼���
		System.out.println(name+"---"+kor+"---"+eng);
	}
	
	
	
}//class end
class Test03_Obj_arr
{
	public static void main(String args[]){
	
	Sung s[]= new Sung[3];
	s[0] = new Sung("kim", 90,90);
	s[1] = new Sung("lee", 70,66);
	s[2] = new Sung("park", 80,80);
	
	s[0].disp();
	s[1].disp();
	s[2].disp();
	//���� ���� ����ϴ� ���� for ������ �غ��ÿ�.
	
	
	System.out.println();
	for(int i=0;i<=2;i++)
	{
		s[i].disp();
		
	}
	
	
	
}//main end
	
}//class end
