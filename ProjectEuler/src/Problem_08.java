import java.util.*;

public class Problem_08 { //1000�ڸ��� ���ڿ���, 5���� ���ڸ� �߶� ����� �ִ� ���� ū ���� ã���ÿ�.
	
	

	
	
	
	public Problem_08(){
		
		//���� 1000�ڸ�.
		String str="731671765313306249192251196744265747423553491949349698352031277450632623957831801698480186947885184385861560789112949495459501737958331952853208805511"
				+ "1254069874715852386305071569329096329522744304355766896648950445244523161731856403098711121722383113"
				+ "6222989342338030813533627661428280644448664523874930358907296290491560440772390713810515859307960866"
				+ "7017242712188399879790879227492190169972088809377665727333001053367881220235421809751254540594752243"
				+ "5258490771167055601360483958644670632441572215539753697817977846174064955149290862569321978468622482"
				+ "83972241375657056057490261407972968652414535100474"
				+ "8216637048440319989000889524345065854122758866688116427171479924442928230863465674813919123162824586"
				+ "1786645835912456652947654568284891288314260769004224219022671055626321111109370544217506941658960408"
				+ "0719840385096245544436298123098787992724428490918884580156166097919133875499200524063689912560717606"
				+ "0588611646710940507754100225698315520005593572972571636269561882670428252483600823257530420752963450";
		
		int gop=0; //���� ū ���� ���Ͽ� ���⿡ ������ ���̴�.
		int strGop=1; //�� ���ڿ����� ���ϴ� ���� ���⿡ �����Ͽ�, gop�� ���� ���̴�.
		
		for(int i=0;i<996;i++){ //1~995 ������ �Է��� �Ǵµ�, ������ 5�ڸ��� 995~1000 �ڸ� ����.
			strGop=1;		//for�� �ݺ��Ҷ����� �����ڸ��� �ʱ�ȭ ���ش�.
			String spilt=str.substring(i, i+5 ); //i~i+5 ���ش�. 
			
			for(int j=0;j<5;j++){ //0~4 ���� 5���� ���ڸ� �����ش�.
				System.out.print(spilt.charAt(j)+" ");
				
				strGop *= ((int)spilt.charAt(j)-48); //charAt �� char Ÿ���̹Ƿ� int�� ĳ�����ϸ� �ƽ�Ű���� �Ǿ������. �׷��Ƿ� 0���� -48�� ����� �������� �ȴ�.
				//�׷��� �̷��� ����� 1�ڸ� ���ڸ� �����ϹǷ� ���� ��������.
				
			}//j for end
			System.out.println();
			
			if(gop<strGop){ //J for �ݺ����� 5�ڸ� ������ ���� ���Ѵ���,  ������ 5�ڸ� ���� ���� ���Ѵ�. ���� ���� ���� �� ũ�ٸ� gop �μ��� �����Ѵ�.
				gop=strGop;
			}//if end
			
		}//i for end
		
		System.out.println(gop); //1000�ڸ� ���� �� ���� ����� ��, ���������� �����ִ� gop ���� ���� ū ���� ���̴�.
		
	}//end cons
	
	public static void main(String[] args) {
		new Problem_08();
	}
	
}//class end