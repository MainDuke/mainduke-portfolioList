
public class Problem_18_re2 {

	public static void main(String[] args) {
		int pro[][]={
				{75},//00
				{95, 64},
				{17, 47, 82},
				{18, 35, 87, 10},	
				{20, 4, 82, 47, 65},
				{19, 1, 23, 75, 3, 34,},
				{88, 2, 77, 73, 7, 63, 67},
				{99, 65, 4, 28, 6, 16, 70, 92},
				{41, 41, 26, 56, 83, 40, 80, 70, 33},
				{41, 48, 72, 33, 47, 32, 37, 16, 94, 29},
				{53, 71, 44, 65, 25, 43, 91, 52, 97, 51, 14},
				{70, 11, 33, 28, 77, 73, 17, 78, 39, 68, 17, 57},
				{91, 71, 52, 38, 17, 14, 91, 43, 58, 50, 27, 29, 48},
				{63, 66, 4, 68, 89, 53, 67, 30, 73, 16, 69, 87, 40, 31},
				{4, 62, 98, 27, 23, 9, 70, 98, 73, 93, 38, 53, 60, 4, 23}//[14][0]~[14][14]
				};
		
		int sum[][]= new int[15][15];
		
		
		for(int i=0;i<15;i++){
			
			if(i==0){
				sum[0][0]=pro[0][0];
			}else{
				sum[i][0]=sum[i-1][0]+pro[i][0];
				sum[i][i]=sum[i-1][i-1]+pro[i][i];
			}//else
			
			for(int j=1;j<i;j++){
				
			sum[i][j]=pro[i][j]+((sum[i-1][j-1]>sum[i-1][j])?sum[i-1][j-1]:sum[i-1][j]);
				
			}// j for end
			
		}//i for end
		
		int max=0;
		for(int i=0; i<15; i++){
			if(max<sum[14][i]){
				max=sum[14][i];
				//System.out.println("max test="+max+" i="+i);
			}
			//System.out.println(sum[14][i]+"  i="+i);
		}//for
		
		/*
		for(int i=0; i<15; i++){
			for(int j=0;j<i+1;j++){
				System.out.println("i="+i+" j="+j+" sum"+sum[i][j]);
			}//for
		
		}//for
		 */
		
		
		System.out.println("max="+max);
		
	}//main end
	
}//class end
