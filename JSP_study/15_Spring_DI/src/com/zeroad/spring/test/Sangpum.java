package com.zeroad.spring.test;

public class Sangpum {

	private String pum;
	private int su;
	private int dan;
	
	
	public void setPum(String pum) {
		this.pum = pum;
	}
	public void setSu(int su) {
		this.su = su;
	}
	public void setDan(int dan) {
		this.dan = dan;
	}
	
	public String getContents(){
		
		return "��ǰ�� : "+pum+" ���� : "+su+" �ܰ� :  "+dan;
	}
	
	
}
