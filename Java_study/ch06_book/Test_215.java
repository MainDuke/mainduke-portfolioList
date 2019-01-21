/*
 * Author: Administrator
 * Created: 2016년 1월 22일 금요일 오후 3:22:58
 * Modified: 2016년 1월 22일 금요일 오후 3:22:58
 */


// 같은 패키지? (클래스 파일이 같은 폴더 내에 있는가?)
//

class Test_215
{
	public static void main( String [] args )
		{
			GoodsStock obj;
			obj = new GoodsStock();
			obj.goodsCode = "52135";
			obj.stockNum = 200;
			System.out.println("상품코드: " + obj.goodsCode);
			System.out.println("재고수량: " + obj.stockNum);
			
			obj.addStock(1000);
			System.out.println("상품코드: " + obj.goodsCode);
			System.out.println("재고수량: " + obj.stockNum);
			
			
		}// end main
		
	}//class end
