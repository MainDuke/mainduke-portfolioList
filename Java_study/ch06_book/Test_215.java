/*
 * Author: Administrator
 * Created: 2016�� 1�� 22�� �ݿ��� ���� 3:22:58
 * Modified: 2016�� 1�� 22�� �ݿ��� ���� 3:22:58
 */


// ���� ��Ű��? (Ŭ���� ������ ���� ���� ���� �ִ°�?)
//

class Test_215
{
	public static void main( String [] args )
		{
			GoodsStock obj;
			obj = new GoodsStock();
			obj.goodsCode = "52135";
			obj.stockNum = 200;
			System.out.println("��ǰ�ڵ�: " + obj.goodsCode);
			System.out.println("������: " + obj.stockNum);
			
			obj.addStock(1000);
			System.out.println("��ǰ�ڵ�: " + obj.goodsCode);
			System.out.println("������: " + obj.stockNum);
			
			
		}// end main
		
	}//class end
