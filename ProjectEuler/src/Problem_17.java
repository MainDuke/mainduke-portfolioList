//���ڸ� ���ڷ� ǥ����, ���ڿ� ���� ����.
//������ �ذ��ߴ�. �׷��� ����ġ ���̽����� �̿��ؼ� �׶��׶� ó���ϴ°��� �ڵ��� �ߺ����� ���� �ڵ���� �������.
//����, �ڵ��� ���뼺�� �÷���, �� �� ����Ʈ�� �ҽ� �ڵ带 ¥���߰ڴ�.
//�迭�� �����͸� �̿��ؼ�, ���ڿ��� ó���ϸ� �ڵ带 ���̻� ���ϼ� �������̴�.
public class Problem_17 {

	public static void main(String[] args) {
	
		String str="";
		String out="";
		int sum=0;
		
		for(int i=1;i<=1000;i++){ //1~1000���� ���ڸ� �����Ѵ�.
			//�� �ڸ����� ���� ���� �ٸ��� ǥ���ؾ��Ѵ�.
			//1000, 100�� �ڸ����� ���� �Ǻ��� thousand �� hundred�� ���δ�.
			
			str=i+""; //���ڸ� ���ڷ� �ٲ۴�.
			//�Է� ���� ���ڰ� �� �ڸ� �������� �Ǻ��Ѵ�.
			if(str.length()==1){
				switch(i){ //�Էµ� ���� ���� ���� ���ϴ� switch ��
				case 1: out="one";break;
				case 2: out="two";break;
				case 3: out="three";break;
				case 4: out="four";break;
				case 5: out="five";break;
				case 6: out="six";break;
				case 7: out="seven";break;
				case 8: out="eight";break;
				case 9: out="nine";break;
				}
			}else if(str.length()==2){
				
				if(i<20){
					switch(i){ //�Էµ� ���� ���� ���� ���ϴ� switch ��
					case 10: out="ten";break;
					case 11: out="eleven";break;
					case 12: out="twelve";break;
					case 13: out="thirteen";break;
					case 14: out="fourteen";break;
					case 15: out="fifteen";break;
					case 16: out="sixteen";break;
					case 17: out="seventeen";break;
					case 18: out="eighteen";break;
					case 19: out="nineteen";break;
					}//switch end
					
				}else{
					
						switch((str.charAt(0)-48)){ //�Էµ� ���� ���� ���� ���ϴ� switch ��
						case 2: out="twenty";break;
						case 3: out="thirty";break;
						case 4: out="forty";break;
						case 5: out="fifty";break;
						case 6: out="sixty";break;
						case 7: out="seventy";break;
						case 8: out="eighty";break;
						case 9: out="ninety";break;
						}//switch end
						
						switch((str.charAt(1)-48)){ //�Էµ� ���� ���� ���� ���ϴ� switch ��
						case 1: out+=" one";break;
						case 2: out+=" two";break;
						case 3: out+=" three";break;
						case 4: out+=" four";break;
						case 5: out+=" five";break;
						case 6: out+=" six";break;
						case 7: out+=" seven";break;
						case 8: out+=" eight";break;
						case 9: out+=" nine";break;
						}//switch end
					
				}//else
				
			}else if(str.length()==3){
				
				
				switch((str.charAt(0)-48)){ //�Էµ� ���� ���� ���� ���ϴ� switch ��
				case 1: out="one hundred";break;
				case 2: out="two hundred";break;
				case 3: out="three hundred";break;
				case 4: out="four hundred";break;
				case 5: out="five hundred";break;
				case 6: out="six hundred";break;
				case 7: out="seven hundred";break;
				case 8: out="eight hundred";break;
				case 9: out="nine hundred";break;
				}
				
				if((str.charAt(1)-48)==0 ){
				
					switch((str.charAt(2)-48)){ //�Էµ� ���� ���� ���� ���ϴ� switch ��
					
					case 0: out+="";break;
					case 1: out+=" and one";break;
					case 2: out+=" and two";break;
					case 3: out+=" and three";break;
					case 4: out+=" and four";break;
					case 5: out+=" and five";break;
					case 6: out+=" and six";break;
					case 7: out+=" and seven";break;
					case 8: out+=" and eight";break;
					case 9: out+=" and nine";break;
					
					}//switch end
					
				}else if((str.charAt(1)-48)<2 && (str.charAt(1)-48) != 0 ){
					switch((str.charAt(2)-48)){ //�Էµ� ���� ���� ���� ���ϴ� switch ��
					case 0: out+=" and ten";break;
					case 1: out+=" and eleven";break;
					case 2: out+=" and twelve";break;
					case 3: out+=" and thirteen";break;
					case 4: out+=" and fourteen";break;
					case 5: out+=" and fifteen";break;
					case 6: out+=" and sixteen";break;
					case 7: out+=" and seventeen";break;
					case 8: out+=" and eighteen";break;
					case 9: out+=" and nineteen";break;
					}//switch end
					
				}else if((str.charAt(1)-48)>2 || (str.charAt(1)-48)<10){
					
						switch((str.charAt(1)-48)){ //�Էµ� ���� ���� ���� ���ϴ� switch ��
						case 2: out+=" and twenty";break;
						case 3: out+=" and thirty";break;
						case 4: out+=" and forty";break;
						case 5: out+=" and fifty";break;
						case 6: out+=" and sixty";break;
						case 7: out+=" and seventy";break;
						case 8: out+=" and eighty";break;
						case 9: out+=" and ninety";break;
						}//switch end
						
						switch((str.charAt(2)-48)){ //�Էµ� ���� ���� ���� ���ϴ� switch ��
						case 0: out+="";break;
						case 1: out+=" one";break;
						case 2: out+=" two";break;
						case 3: out+=" three";break;
						case 4: out+=" four";break;
						case 5: out+=" five";break;
						case 6: out+=" six";break;
						case 7: out+=" seven";break;
						case 8: out+=" eight";break;
						case 9: out+=" nine";break;
						}//switch end
					
				}
				
			}else if(str.length()==4){
				out="one thousand";
			}else{
				System.out.println("���� ���� �ʰ�?");
			}
			
						
		//1~1000������ ��� ���� ���ڿ��� ǥ���س�����.
			
			//System.out.println(i+"="+out+" ���ڿ��� ��="+(out.replace(" ", "")).length());
			sum += (out.replace(" ", "")).length();
			//trim�� ���ڿ� �յ� ������ �����ϴ°�.
			//replaceAll("\\s", "") ��� ������ �����Ѵ�.
			//�� ���ڿ��� ������ ������ ���ڿ� ���ڸ� sum�� ���Ͽ� �ش�.
			
		}//for end
		
		System.out.println("1~1000������ ��� ���ڿ��� �� = "+sum);
		
		
	}//main
	
	
}//class end
