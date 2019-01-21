package shopdb;
import java.util.*; //HashTable : 장바구니로 사용하려고

public class CartMgr {
	private Hashtable hcart=new Hashtable();
	
	public CartMgr(){} //cons
	
	//장바구니에 넣기, cart 에 넣기
	public void addCart(OrderBean order){
		
		int pro_no=order.getPro_no();//상품번호
		String q=order.getQuantity(); //주문 수량
		int quantity=Integer.parseInt(q);//주문수량
		
		if(quantity>0){//주문 수량이 있으면
			if(hcart.containsKey(pro_no)){//추가 주문
				//hcart 에 product_no 상품 번호가 있으면
				OrderBean tempOrder=(OrderBean)hcart.get(pro_no);
				quantity+=Integer.parseInt(tempOrder.getQuantity());//수량추가
				tempOrder.setQuantity(quantity+"");//수량 setter
				hcart.put(pro_no, tempOrder); //해쉬 테이블(장바구니)에 넣는다.
			}else{
				//pro_no 가 없을 경우 : 이 상품을 처음 사는 경우
				hcart.put(pro_no,order);
			}//else end
		}//quantity>0 if end
	}//addCart end
	
	
//cart 내용 리턴 = 장바구니에 있는 물건들 리스트============================================================
	public Hashtable getCartList(){
		return hcart;
	}//getCartList end
	
//cart 내용 추가============================================================
	public void updateCart(OrderBean order){
		System.out.println("update start");
		int pro_no=order.getPro_no();//상품 번호
		hcart.put(pro_no,order);
	}//updateCart
//cart 내용 추가============================================================	
	public void deleteCart(OrderBean order){
		System.out.println("delete start");
		int pro_no=order.getPro_no();//상품 번호
		hcart.remove(pro_no);//상품 목록을 장바구니에서 제거
	}
	
	
}//class end
