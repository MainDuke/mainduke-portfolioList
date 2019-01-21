/*
 * Author: Administrator
 * Created: 2016년 1월 22일 금요일 오후 3:14:20
 * Modified: 2016년 1월 22일 금요일 오후 3:14:20
 */


class GoodsStock{
	String goodsCode;
	int stockNum;

	void addStock(int amount){
		stockNum +=amount;
	}//void
	
	int subtrckStock(int amount)
	{
	
		if (stockNum < amount)
			return 0;
		stockNum -= amount;
		return amount;
	}//sub
}
