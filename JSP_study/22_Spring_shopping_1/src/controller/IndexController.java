package controller;

import java.util.List;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import logic.Item;
import logic.Shop;

public class IndexController implements Controller{

	private Shop shopService;
	
	//
	public void setShopService(Shop shopService){
		this.shopService = shopService;
	}


	@Override
	public ModelAndView handleRequest(HttpServletRequest arg0,
			HttpServletResponse arg1) throws Exception {
		
		List<Item> itemList= this.shopService.getItemList();
		
		ModelAndView mv = new ModelAndView();
		mv.setViewName("/WEB-INF/jsp/index.jsp"); //∫‰¿Ãµø
		mv.addObject("itemList", itemList);
	
		return mv;
	}
	
}//class e
