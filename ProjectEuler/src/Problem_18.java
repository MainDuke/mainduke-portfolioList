import java.util.StringTokenizer;
import java.util.Vector;


public class Problem_18 {

	
	
	//�Ű������� ���� ���� �̿��ؼ�
	//��������� ����� �ֱ� ���� �޼����̴�.
	public int[][] getAdjM(int n, int n2){ //n��, �ﰢ ����� ���, n2�� �� ����� ��

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
		
		return adjM;
		
	}//end getAdjM
		
	//���� �켱 Ž��?
	public void DFS(int start, int max , int[][] adjM){
		
		int visit[]=new int[max];
		
		visit[start]=1;
		for(int i=0;i<max;i++){
			
			if(adjM[start][i]==1 && visit[i]==0){
				System.out.printf("%d ���� %d �� �̵�\n",start,i);
				DFS(i, max, adjM);
			}//if end
		
		}//for end
	}//DFS end
	
	//������
	public Problem_18(){
		
		
		int a[][]=getAdjM(3,6);
		
		System.out.println("�׽�Ʈ");
		for(int i=0;i<6;i++){
			System.out.print((i+1)+"�� ");
			for(int j=0;j<6;j++){
				System.out.print(a[i][j]+" ");
			}//in end
			System.out.println();
		}//out end
		
		//DFS(0, 6 ,getAdjM(3,6));
		
		
		/*
		Vector vec= new Vector();
		String str="75 95 64 17 47 82 18 35 87 10 20 04 82 47 65 19 01 23 75 03 34"
				+ " 88 02 77 73 07 63 67 99 65 04 28 06 16 70 92 41 41 26 56 83 40 80 70 33"
				+ " 41 48 72 33 47 32 37 16 94 29 53 71 44 65 25 43 91 52 97 51 14"
				+ " 70 11 33 28 77 73 17 78 39 68 17 57 91 71 52 38 17 14 91 43 58 50 27 29 48"
				+ " 63 66 04 68 89 53 67 30 73 16 69 87 40 31 04 62 98 27 23 09 70 98 73 93 38 53 60 04 23";
		
		StringTokenizer st=new StringTokenizer(str);
		
		//System.out.println(st.countTokens());
		//for ���ǿ� countTokens�� �ϴϱ�, ���� ����� �ȵ���. ��??...
		
		for(int i=1;i<=120;i++){
				vec.add(st.nextToken());	
		}//for
		
		//System.out.println(vec.size());
		//��������... for ���ǹ����� �������� ���� ���� �ʴ´�...?
		for(int i=0;i<120;i++){
			
			System.out.println(i+"�� vec="+vec.get(i));	
					
		}//for
		*/
		
		
		
	}//cons end
	
	
	public static void main(String[] args) {
	
		
		new Problem_18();
	}//main
	
	
}//class end
