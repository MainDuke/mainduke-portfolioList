public class Problem_18_re {

	public Problem_18_re(){
		
	}//cons
	
	//int[][] ���� ����� ���ϴ� �޼���
	public static void getAdjM(int n, int n2){ //n��, �ﰢ ����� ���, n2�� �� ����� ��

		int adjM[][]=new int[n2][n2];
		
		int sum=0;//���� ������ ���� ��.
		for(int i=1;i<n;i++){ //�ﰢ ����� �� ���� ��Ÿ���� �� n������ n ���� ��尡 �ִ�.
			
				for(int a=sum;a<sum+i;a++){ //������ ù ��ġ�� ���� ����, ������ ������ �޴´�. ���� ���� sum ���� �����ش�.
					for(int b=0;b<n2;b++){
						if(b==(a+i) || b==(a+i+1)){
							adjM[a][b]=adjM[b][a]=1;
						}//if end
					}//b for end
				}//a for end
			sum+=i; //���� ���� �� ����.
		}//i for end
		
		/*
		System.out.print(" / ");
		for(int t=1;t<=n2;t++){
			System.out.print(t+" ");
		}
		System.out.println();
		for(int i=0;i<n2;i++){
			System.out.print((i+1)+"�� ");
			for(int j=0;j<n2;j++){
				System.out.print(adjM[i][j]+" ");
			}//in end
			System.out.println();
		}//out end
		*/
		
		//return adjM;
		
	}//end getAdjM
	
	public static void main(String[] args) {
		int pro[][]={
				{75},
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
				{4, 62, 98, 27, 23, 9, 70, 98, 73, 93, 38, 53, 60, 4, 23}
				};
	
		int adjM[][]=new int[15][15];
		int sum=0;//���� ������ ���� ��.
		for(int i=1;i<15;i++){ //�ﰢ ����� �� ���� ��Ÿ���� �� n������ n ���� ��尡 �ִ�.
			
				for(int a=sum;a<sum+i;a++){ //������ ù ��ġ�� ���� ����, ������ ������ �޴´�. ���� ���� sum ���� �����ش�.
					for(int b=0;b<15;b++){
						if(b==(a+i) || b==(a+i+1)){
							adjM[a][b]=adjM[b][a]=1;
						}//if end
					}//b for end
				}//a for end
			sum+=i; //���� ���� �� ����.
		}//i for end
		
		for(int i=0;i<15;i++){
			for(int j=0;j<15;j++){
				
			
				if(pro[i][j]==1 || pro[j][i]==1){
					
				}
				
			}//j for end
		}//i for end
		
		
			System.out.println(pro[0][0]);
			int num=0;
			for(int i=1;i<=15;i++){num+=i;}
			
			getAdjM(15,num);
			
	}//main
	
}//class end
