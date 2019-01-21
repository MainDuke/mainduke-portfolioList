package com.zeroad.spring.model.product;

public abstract class Seller {

		private String name;
		
		public abstract Computer getComputer(); //추상 메서드

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

		//etc
		
		public void sell(){
			System.out.println(name+" 판매상품 : "+getComputer().getContents());
			//									Computer(또는 Bean객체, 클래스).getContents();
		}
		

}//class
