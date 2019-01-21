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
		
		//���õ� ��ǰID���� ��ǰ ���� �� ���
		Item item= this.shopService.getItemByItemId(itemId);
		
		//�� ����
		Map<String, Object> model= new HashMap<String, Object>();
		model.put("item", item);
		
		//��ȯ ���� ModelAndView �ν��Ͻ� ����
		//ModelAndView mv= new ModelAndView();
		//mv.setViewName("detail"); //�� ���� ����
		//mv.addObject(model); //�� ��� ������
		
		return new ModelAndView("detail", "item", item );
	}//detailItem();
	
	
}
