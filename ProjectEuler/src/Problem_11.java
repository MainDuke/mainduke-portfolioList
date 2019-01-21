import java.util.*;

public class Problem_11 {

	//20 X 20 배열을 만들어보자.
	//StringTokenizer 를 이용하든 spilt() 메서드를 이용하든!
	//문자열을 파싱 하여, 이중배열에 하나씩 넣어서 계산 을 해보자.
	public Problem_11(){
			
		int gop=1;
		int result=0;
			// 					    0   1  2  3  4   5   6   7  8  9  0  1   2   3  4  5  6  7  8  9
					String str="08 02 22 97 38 15 00 40 00 75 04 05 07 78 52 12 50 77 91 08 "
							+ "49 49 99 40 17 81 18 57 60 87 17 40 98 43 69 48 04 56 62 00 "
							+ "81 49 31 73 55 79 14 29 93 71 40 67 53 88 30 03 49 13 36 65 "
							+ "52 70 95 23 04 60 11 42 69 24 68 56 01 32 56 71 37 02 36 91 "
							+ "22 31 16 71 51 67 63 89 41 92 36 54 22 40 40 28 66 33 13 80 "
							+ "24 47 32 60 99 03 45 02 44 75 33 53 78 36 84 20 35 17 12 50 "
							+ "32 98 81 28 64 23 67 10 26 38 40 67 59 54 70 66 18 38 64 70 "
							+ "67 26 20 68 02 62 12 20 95 63 94 39 63 08 40 91 66 49 94 21 "
							+ "24 55 58 05 66 73 99 26 97 17 78 78 96 83 14 88 34 89 63 72 "
							+ "21 36 23 09 75 00 76 44 20 45 35 14 00 61 33 97 34 31 33 95 "
							+ "78 17 53 28 22 75 31 67 15 94 03 80 04 62 16 14 09 53 56 92 "
							+ "16 39 05 42 96 35 31 47 55 58 88 24 00 17 54 24 36 29 85 57 "
							+ "86 56 00 48 35 71 89 07 05 44 44 37 44 60 21 58 51 54 17 58 "
							+ "19 80 81 68 05 94 47 69 28 73 92 13 86 52 17 77 04 89 55 40 "
							+ "04 52 08 83 97 35 99 16 07 97 57 32 16 26 26 79 33 27 98 66 "
							+ "88 36 68 87 57 62 20 72 03 46 33 67 46 55 12 32 63 93 53 69 "
							+ "04 42 16 73 38 25 39 11 24 94 72 18 08 46 29 32 40 62 76 36 "
							+ "20 69 36 41 72 30 23 88 34 62 99 69 82 67 59 85 74 04 36 16 "
							+ "20 73 35 29 78 31 90 01 74 31 49 71 48 86 81 16 23 57 05 54 "
							+ "01 70 54 71 83 51 54 69 16 92 33 48 61 43 52 01 89 19 67 48 ";
						

						StringTokenizer st= new StringTokenizer(str); //띄어쓰기 한 부분을 잘라서 
						//System.out.println(st.countTokens()); //갯수 확인해보니 400개 나온다. 20X20 배열
						
						String arr[][]=new String[20][20]; //배열 생성
						
						for(int i=0;i<20;i++){ //i행 20개
							for(int j=0;j<20;j++){ //j 열 20개
								arr[i][j]=st.nextToken(); //각각의 토큰을 차례차례 넣어준다.
							}//jfor end
						}//ifor end
						
						//System.out.println(arr[19][19]); // 위치 확인 
						
						//값 비교를 위해 3가지 형태의 반복문을 써보겠다.
						//첫번째 가로 4개수의 곱을 계산해보겠다.
						
						for(int i=0;i<20;i++){ //i행 20개
							for(int j=0;j<17;j++){ // i행의 가로 4개의 첫번째 숫자의 위치를 정해준다.
							
								gop=1;//곱해서 누적된 값을 초기화 하고 다시 가로곱을 구한다.
								for(int k=j; k<j+4; k++){ //i행의 j열부터 가로 4개의 수를 곱하는 부분
									
									gop*=Integer.parseInt(arr[k][i]);//특정 위치의 값을 곱해서 누적시킨다.
									
								}//k for end
								if(result < gop){result=gop;} //더 큰값을 저장한다.
								
							}//j for end
						}//i for end
						System.out.println("가로행 최고값"+result); //가로행 최고값
						
						
						//두번째, 세로 4개의 곱을 계산해서 제일 큰 값을 넣는다.
						
						for(int i=0;i<20;i++){ //i행 20개
							for(int j=0;j<17;j++){ // i행의 가로 4개의 첫번째 숫자의 위치를 정해준다.
							
								gop=1;//곱해서 누적된 값을 초기화 하고 다시 가로곱을 구한다.
								for(int k=j; k<j+4; k++){ //i행의 j열부터 가로 4개의 수를 곱하는 부분
									
									gop*=Integer.parseInt(arr[i][k]);//특정 위치의 값을 곱해서 누적시킨다.
									
								}//k for end
								if(result < gop){result=gop;} //더 큰값을 저장한다.
								
							}//j for end
						}//i for end
						
						System.out.println("세로행 최고값"+result); //세로행 최고값
						
						
						//세번째, 대각선 4개의 곱을 계산해서 제일 큰 값을 넣는다.
						//
						
						for(int i=0;i<17;i++){ //i행 20개
							for(int j=3;j<20;j++){// i행의 가로 4개의 첫번째 숫자의 위치를 정해준다.
								gop=1;//곱해서 누적된 값을 초기화 하고 다시 가로곱을 구한다.
								for(int k=0; k<4; k++){ //i행의 j열부터 가로 4개의 수를 곱하는 부분
									
									//System.out.println("sum"+sum+" "+i+" "+j);
									gop*=Integer.parseInt(arr[i+k][j-k]);//특정 위치의 값을 곱해서 누적시킨다.
									
								}//k for end
							if(result < gop){result=gop;} //더 큰값을 저장한다.
							}//j for end
						}//i for end
						
						
						System.out.println("/ 대각선 최고값"+ result); // /대각선 최고값
						
						//네번째, \ 대각선 4개의 곱을 계산해서 제일 큰 값을 넣는다.
						//
						
						for(int i=0;i<17;i++){ //i행 20개
							for(int j=0;j<17;j++){// i행의 가로 4개의 첫번째 숫자의 위치를 정해준다.
								gop=1;//곱해서 누적된 값을 초기화 하고 다시 가로곱을 구한다.
								for(int k=0; k<4; k++){ //i행의 j열부터 가로 4개의 수를 곱하는 부분
									
									//System.out.println("sum"+sum+" "+i+" "+j);
									gop*=Integer.parseInt(arr[i+k][j+k]);//특정 위치의 값을 곱해서 누적시킨다.
									
								}//k for end
							if(result < gop){result=gop;} //더 큰값을 저장한다.
							}//j for end
						}//i for end
						
						
						System.out.println("최종"+result); // /대각선 최고값
						
						
						/* 풀기는 했는데 정답자들 중에 더 깔끔한 코딩이 있어서 주석을 단다.
						 
			for (int i = 0; i < array.length - 3; i++) {
            	for (int j = 0; j < array.length - 3; j++) {
               
                int[] test = new int[7];

                test[0] = array[i][j] * array[i][j + 1] * array[i][j + 2] * array[i][j + 3]; //가로열 곱셈
                test[1] = array[i][j] * array[i + 1][j] * array[i + 2][j] * array[i + 3][j]; //세로열 곱셈
                test[2] = array[i][j + 1] * array[i + 1][j + 1] * array[i + 2][j + 1] * array[i + 3][j + 1]; //
                test[3] = array[i][j + 2] * array[i + 1][j + 2] * array[i + 2][j + 2] * array[i + 3][j + 2];
                test[4] = array[i][j + 3] * array[i + 1][j + 3] * array[i + 2][j + 3] * array[i + 3][j + 3];
                
                test[5] = array[i][j] * array[i + 1][j + 1] * array[i + 2][j + 2] * array[i + 3][j + 3];
                test[6] = array[i][j + 3] * array[i + 1][j + 2] * array[i + 2][j + 1] * array[i + 3][j];

                for (int d : test) {
                    if (result < d)
                        result = d;
                }//최종값 비교 end
            }
        }//for end
						 * 
						 * */
						
						}//cons 
						
						public static void main(String[] args) {
							new Problem_11();
						}
}//class end