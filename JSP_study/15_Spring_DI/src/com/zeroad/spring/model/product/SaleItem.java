package com.zeroad.spring.model.product;

public class SaleItem {

	Computer item; //����
	int cnt;
	long price;
	
	//������
	
	public SaleItem(){} //����Ʈ
	
	
	public SaleItem(Computer item, int cnt, long price){
		this.item=item;
		this.cnt=cnt;
		this.price=price;
		
		
	}//end cons
	
	public void setItem(Computer item) {
		this.item = item;
	}

	public void setCnt(int cnt) {
		this.cnt = cnt;
	}


	public void setPrice(long price) {
		this.price = price;
	}

	public String display(){
		StringBuffer sb= new StringBuffer();
		sb.append("��ǰ:"+item.getContents()+"\n");
		sb.append("����:"+cnt+"\n");
		sb.append("�ݾ�:"+price+"\n");
	
		return sb.toString(); //string ����
	}
	
}//class 
