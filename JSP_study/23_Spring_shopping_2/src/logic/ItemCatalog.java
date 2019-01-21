package logic;

import java.util.*;

public interface ItemCatalog {
	public List<Item> getItemList();
	public Item getItemByItemId(Integer itemId);
}
