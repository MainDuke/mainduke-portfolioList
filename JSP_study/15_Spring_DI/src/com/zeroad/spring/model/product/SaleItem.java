package com.zeroad.spring.model.product;

public class SaleItem {

	Computer item; //변수
	int cnt;
	long price;
	
	//생성자
	
	public SaleItem(){} //디폴트
	
	
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
		sb.append("상품:"+item.getContents()+"\n");
		sb.append("수량:"+cnt+"\n");
		sb.append("금액:"+price+"\n");
	
		return sb.toString(); //string 리턴
	}
	
}//class 
