package controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import logic.Item;
import logic.Shop;

@Controller
public class DetailController {
	private Shop shopService;

	public void setShopService(Shop shopService) {
		this.shopService = shopService;
	}
	
	
	@RequestMapping
	public ModelAndView detailItem(Integer itemId){
		
		//선택된 상품ID에서 상품 정보 를 취득
		Item item= this.shopService.getItemByItemId(itemId);
		
		//모델 생성
		Map<String, Object> model= new HashMap<String, Object>();
		model.put("item", item);
		
		//반환 값인 ModelAndView 인스턴스 생성
		//ModelAndView mv= new ModelAndView();
		//mv.setViewName("detail"); //뷰 네일 정의
		//mv.addObject(model); //뷰 사용 데이터
		
		return new ModelAndView("detail", "item", item );
	}//detailItem();
	
	
}
