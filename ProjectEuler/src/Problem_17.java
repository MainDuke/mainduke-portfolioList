//숫자를 문자로 표현후, 문자열 갯수 세기.
//문제는 해결했다. 그러나 스위치 케이스문을 이용해서 그때그때 처리하는것은 코드의 중복으로 인해 코드수가 길어진다.
//따라서, 코드의 재사용성을 늘려서, 좀 더 컴팩트한 소스 코드를 짜봐야겠다.
//배열형 데이터를 이용해서, 문자열을 처리하면 코드를 반이상 줄일수 있을것이다.
public class Problem_17 {

	public static void main(String[] args) {
	
		String str="";
		String out="";
		int sum=0;
		
		for(int i=1;i<=1000;i++){ //1~1000까지 숫자를 대입한다.
			//각 자리수에 따라서 값을 다르게 표현해야한다.
			//1000, 100에 자리수는 숫자 판별후 thousand 나 hundred를 붙인다.
			
			str=i+""; //숫자를 문자로 바꾼다.
			//입력 받은 숫자가 몇 자리 숫자인지 판별한다.
			if(str.length()==1){
				switch(i){ //입력된 값에 따라서 값을 전하는 switch 문
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
					switch(i){ //입력된 값에 따라서 값을 전하는 switch 문
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
					
						switch((str.charAt(0)-48)){ //입력된 값에 따라서 값을 전하는 switch 문
						case 2: out="twenty";break;
						case 3: out="thirty";break;
						case 4: out="forty";break;
						case 5: out="fifty";break;
						case 6: out="sixty";break;
						case 7: out="seventy";break;
						case 8: out="eighty";break;
						case 9: out="ninety";break;
						}//switch end
						
						switch((str.charAt(1)-48)){ //입력된 값에 따라서 값을 전하는 switch 문
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
				
				
				switch((str.charAt(0)-48)){ //입력된 값에 따라서 값을 전하는 switch 문
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
				
					switch((str.charAt(2)-48)){ //입력된 값에 따라서 값을 전하는 switch 문
					
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
					switch((str.charAt(2)-48)){ //입력된 값에 따라서 값을 전하는 switch 문
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
					
						switch((str.charAt(1)-48)){ //입력된 값에 따라서 값을 전하는 switch 문
						case 2: out+=" and twenty";break;
						case 3: out+=" and thirty";break;
						case 4: out+=" and forty";break;
						case 5: out+=" and fifty";break;
						case 6: out+=" and sixty";break;
						case 7: out+=" and seventy";break;
						case 8: out+=" and eighty";break;
						case 9: out+=" and ninety";break;
						}//switch end
						
						switch((str.charAt(2)-48)){ //입력된 값에 따라서 값을 전하는 switch 문
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
				System.out.println("연산 범위 초과?");
			}
			
						
		//1~1000까지의 모든 값을 문자열로 표현해내었다.
			
			//System.out.println(i+"="+out+" 문자열의 수="+(out.replace(" ", "")).length());
			sum += (out.replace(" ", "")).length();
			//trim은 문자열 앞뒤 공백을 제거하는것.
			//replaceAll("\\s", "") 모든 공백을 제거한다.
			//각 문자열의 공백을 제외한 문자열 숫자를 sum에 더하여 준다.
			
		}//for end
		
		System.out.println("1~1000까지의 모든 문자열의 합 = "+sum);
		
		
	}//main
	
	
}//class end
