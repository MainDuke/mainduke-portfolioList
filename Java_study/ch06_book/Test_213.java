/*
 * Author: Administrator
 * Created: 2016�� 1�� 22�� �ݿ��� ���� 3:14:20
 * Modified: 2016�� 1�� 22�� �ݿ��� ���� 3:14:20
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
