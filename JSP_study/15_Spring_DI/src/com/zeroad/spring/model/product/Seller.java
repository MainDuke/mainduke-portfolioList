package com.zeroad.spring.model.product;

public abstract class Seller {

		private String name;
		
		public abstract Computer getComputer(); //�߻� �޼���

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

		//etc
		
		public void sell(){
			System.out.println(name+" �ǸŻ�ǰ : "+getComputer().getContents());
			//									Computer(�Ǵ� Bean��ü, Ŭ����).getContents();
		}
		

}//class
