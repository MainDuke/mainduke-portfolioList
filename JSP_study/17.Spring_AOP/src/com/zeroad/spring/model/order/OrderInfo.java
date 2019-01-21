package com.zeroad.spring.model.order;
//주문 정보 모델 클래스


public class OrderInfo {

	long ordNo;//변수
	String orderDate;
	String orderName;
	String delvAddr;
	String revName;
	String rcvName;
	String delvTel;
	
	
	public String getDelvTel() {
		return delvTel;
	}


	public void setDelvTel(String delvTel) {
		this.delvTel = delvTel;
	}


	public long getOrdNo() {
		return ordNo;
	}


	public void setOrdNo(long ordNo) {
		this.ordNo = ordNo;
	}


	public String getOrderDate() {
		return orderDate;
	}


	public void setOrderDate(String orderDate) {
		this.orderDate = orderDate;
	}


	public String getOrderName() {
		return orderName;
	}


	public void setOrderName(String orderName) {
		this.orderName = orderName;
	}


	public String getDelvAddr() {
		return delvAddr;
	}


	public void setDelvAddr(String delvAddr) {
		this.delvAddr = delvAddr;
	}


	public String getRevName() {
		return revName;
	}


	public void setRevName(String revName) {
		this.revName = revName;
	}


	public String getRcvName() {
		return rcvName;
	}


	public void setRcvName(String rcvName) {
		this.rcvName = rcvName;
	}


	public String toString(){
		StringBuffer sb=new StringBuffer();
		sb.append("주문번호 : "+ordNo+"\n");
		sb.append("주문일 : "+orderDate+"\n");
		sb.append("주문자 : "+orderName+"\n");
		sb.append("배송지 : "+delvAddr+"\n");
		sb.append("수신자 : "+revName+"\n");
		sb.append("연락처 : "+rcvName+"\n");
		
		return sb.toString();
	}//end
	
}//class end
