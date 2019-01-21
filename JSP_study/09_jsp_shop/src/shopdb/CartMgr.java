package shopdb;
import java.util.*; //HashTable : ��ٱ��Ϸ� ����Ϸ���

public class CartMgr {
	private Hashtable hcart=new Hashtable();
	
	public CartMgr(){} //cons
	
	//��ٱ��Ͽ� �ֱ�, cart �� �ֱ�
	public void addCart(OrderBean order){
		
		int pro_no=order.getPro_no();//��ǰ��ȣ
		String q=order.getQuantity(); //�ֹ� ����
		int quantity=Integer.parseInt(q);//�ֹ�����
		
		if(quantity>0){//�ֹ� ������ ������
			if(hcart.containsKey(pro_no)){//�߰� �ֹ�
				//hcart �� product_no ��ǰ ��ȣ�� ������
				OrderBean tempOrder=(OrderBean)hcart.get(pro_no);
				quantity+=Integer.parseInt(tempOrder.getQuantity());//�����߰�
				tempOrder.setQuantity(quantity+"");//���� setter
				hcart.put(pro_no, tempOrder); //�ؽ� ���̺�(��ٱ���)�� �ִ´�.
			}else{
				//pro_no �� ���� ��� : �� ��ǰ�� ó�� ��� ���
				hcart.put(pro_no,order);
			}//else end
		}//quantity>0 if end
	}//addCart end
	
	
//cart ���� ���� = ��ٱ��Ͽ� �ִ� ���ǵ� ����Ʈ============================================================
	public Hashtable getCartList(){
		return hcart;
	}//getCartList end
	
//cart ���� �߰�============================================================
	public void updateCart(OrderBean order){
		System.out.println("update start");
		int pro_no=order.getPro_no();//��ǰ ��ȣ
		hcart.put(pro_no,order);
	}//updateCart
//cart ���� �߰�============================================================	
	public void deleteCart(OrderBean order){
		System.out.println("delete start");
		int pro_no=order.getPro_no();//��ǰ ��ȣ
		hcart.remove(pro_no);//��ǰ ����� ��ٱ��Ͽ��� ����
	}
	
	
}//class end
