package com.zeroad.spring.model.order;

public class OrderItem {

	long itemSeq; //��ǰ seq;
	long ordNo; //�ֹ� ��ȣ
	String prdName; //��ǰ��
	int cnt; //����
	long price; //����
	
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
		
		sb.append("��ǰ seq : "+itemSeq+"\n");
		sb.append("�ֹ� ��ȣ : "+ordNo+"\n");
		sb.append("��ǰ�� : "+prdName+"\n");
		sb.append("���� : "+cnt+"\n");
		sb.append("�ݾ� : "+price+"\n");
		
		return sb.toString();
		
		
	}//end
	
	
}//class end
