package com.zeroad.spring.model.order;

public class OrderItem {

	long itemSeq; //상품 seq;
	long ordNo; //주문 번호
	String prdName; //상품명
	int cnt; //수량
	long price; //가격
	
	public long getItemSeq() {
		return itemSeq;
	}
	public void setItemSeq(long itemSeq) {
		this.itemSeq = itemSeq;
	}
	public long getOrdNo() {
		return ordNo;
	}
	public void setOrdNo(long ordNo) {
		this.ordNo = ordNo;
	}
	public String getPrdName() {
		return prdName;
	}
	public void setPrdName(String prdName) {
		this.prdName = prdName;
	}
	public int getCnt() {
		return cnt;
	}
	public void setCnt(int cnt) {
		this.cnt = cnt;
	}
	public long getPrice() {
		return price;
	}
	public void setPrice(long price) {
		this.price = price;
	}

	public String toString(){
		StringBuffer sb=new StringBuffer();
		
		sb.append("상품 seq : "+itemSeq+"\n");
		sb.append("주문 번호 : "+ordNo+"\n");
		sb.append("상품명 : "+prdName+"\n");
		sb.append("수량 : "+cnt+"\n");
		sb.append("금액 : "+price+"\n");
		
		return sb.toString();
		
		
	}//end
	
	
}//class end
