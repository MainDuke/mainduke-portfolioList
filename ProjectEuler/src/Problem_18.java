import java.util.StringTokenizer;
import java.util.Vector;


public class Problem_18 {

	
	
	//매개변수로 받은 값을 이용해서
	//인접행렬을 만들어 주기 위한 메서드이다.
	public int[][] getAdjM(int n, int n2){ //n은, 삼각 행렬의 행수, n2는 총 노드의 수

		int adjM[][]=new int[n2][n2];
		
		int sum=0;//수열 공차값 보정 값.
		for(int i=1;i<n;i++){ //삼각 행렬의 각 층을 나타내는 값 n층에는 n 개의 노드가 있다.
			
				for(int a=sum;a<sum+i;a++){ //각층의 첫 위치에 오는 값은, 수열에 영향을 받는다. 수열 값을 sum 으로 구해준다.
					for(int b=0;b<n2;b++){
						if(b==(a+i) || b==(a+i+1)){
							adjM[a][b]=adjM[b][a]=1;
						}//if end
					}//b for end
				}//a for end
			sum+=i; //수열 공차 값 보정.
		}//i for end
		System.out.print(" / ");
		for(int t=1;t<=n2;t++){
			System.out.print(t+" ");
		}
		System.out.println();
		for(int i=0;i<n2;i++){
			System.out.print((i+1)+"번 ");
			for(int j=0;j<n2;j++){
				System.out.print(adjM[i][j]+" ");
			}//in end
			System.out.println();
		}//out end
		
		return adjM;
		
	}//end getAdjM
		
	//깊이 우선 탐색?
	public void DFS(int start, int max , int[][] adjM){
		
		int visit[]=new int[max];
		
		visit[start]=1;
		for(int i=0;i<max;i++){
			
			if(adjM[start][i]==1 && visit[i]==0){
				System.out.printf("%d 에서 %d 로 이동\n",start,i);
				DFS(i, max, adjM);
			}//if end
		
		}//for end
	}//DFS end
	
	//생성자
	public Problem_18(){
		
		
		int a[][]=getAdjM(3,6);
		
		System.out.println("테스트");
		for(int i=0;i<6;i++){
			System.out.print((i+1)+"번 ");
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
		//for 조건에 countTokens를 하니깐, 값이 제대로 안들어간다. 왜??...
		
		for(int i=1;i<=120;i++){
				vec.add(st.nextToken());	
		}//for
		
		//System.out.println(vec.size());
		//마찬가지... for 조건문에는 정상적인 값이 들어가지 않는다...?
		for(int i=0;i<120;i++){
			
			System.out.println(i+"번 vec="+vec.get(i));	
					
		}//for
		*/
		
		
		
	}//cons end
	
	
	public static void main(String[] args) {
	
		
		new Problem_18();
	}//main
	
	
}//class end
