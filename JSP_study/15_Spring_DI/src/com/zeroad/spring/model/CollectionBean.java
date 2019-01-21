package com.zeroad.spring.model;

import com.zeroad.spring.model.product.Computer;
import java.util.*;
//====================================================================
public class CollectionBean {
		
	List<Computer> itemList; //����
	
	public void setItemList(List<Computer> itemList){
		this.itemList=itemList;
	}//end set
	public void printItemList(){
		for(Computer item: itemList){
			System.out.println(item.getContents());
		}
		
	}//end 
	//====================================================================
	Set<Computer> itemSet;//����
	//�ߺ� ��� ���ϴ� set ���.
	public void setItemSet(Set<Computer> itemSet) {
		this.itemSet = itemSet;
	}
	
	public void printItemSet(){
		
		for(Computer item:itemSet){
			System.out.println(item.getContents());
		}
		
	}//end printSet
	
	//====================================================================
	Map<String, Computer> itemMap; //����
	
	public void setItemMap(Map<String, Computer> itemMap){
		this.itemMap = itemMap;
		
	}//end setmap
	
	public void printItemMap(){
		
		for(String key:itemMap.keySet()){
			Computer item= itemMap.get(key);
			System.out.println(key+":"+item.getContents());
		}
		
	}
//====================================================================
}//class
