package logic;

import java.util.List;

public class ShopImpl implements Shop{

	private ItemCatalog itemCatalog;//변수
	//*.servlet.xml 에서 setter 작업
	
	public void setItemCatalog(ItemCatalog itemCatalog){
		this.itemCatalog=itemCatalog;
	}
	
	
	@Override
	public List<Item> getItemList() {
		// TODO Auto-generated method stub
		return this.itemCatalog.getItemList();
	}
	
	
	@Override
	public Item getItemByItemId(Integer itemId) {
		// TODO Auto-generated method stub
		return this.itemCatalog.getItemByItemId(itemId);
	}
}
