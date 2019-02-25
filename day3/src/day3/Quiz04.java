package day3;

import java.util.Scanner;

public class Quiz04 {

	public static void main(String[] args) {
// 		   1. 5x5 배열 int 배열 만들고
//		   2. 1~25로 초기화
//		   3. shuffle() - 배열의 요소를 섞는다
		Scanner scanner = new Scanner(System.in);
		int[][] puzzle = new int[5][5]; // 5x5배열 만들기
		int[][] cntArr = new int[5][5];
		int index = 1; // 1~25로 초기화하기
		
		for(int i=0;i<5;i++) { // 각 행과 열에 1~25의 숫자 입력
			for(int j=0;j<5;j++) {
				puzzle[i][j] = index; // puzzle[0][0]~puzzle[4][4]까지 1~25 숫자로 초기화
				index ++;
				}
			}
		for(int i=1;i<=25;i++) { // puzzle[0][0] ~ puzzle[4][4]까지 숫자 25번 섞기
			int n = (int)(Math.random()*4); // 0~4까지 랜덤 숫자 발생
			int m = (int)(Math.random()*4);
			int tmp = puzzle[0][0]; // 0행0열에 있는 값을 tmp에 저장
			puzzle[0][0] = puzzle[n][m]; // 0행 0열의 값을 puzzle[n][m]의 값과 교환
			puzzle[n][m] = tmp; // puzzle[n][m]의 값을 tmp에 저장하여 반복
			} // 계속해서 새로운 puzzle[n][m]의 값을 puzzle[0][0]과 교환하여 숫자 섞기
		
		do {
			
		for(int i=0;i<5;i++) {
			for(int j=0;j<5;j++) {
				if(j!=4)
					System.out.printf("%3d",puzzle[i][j]); // 5x5 퍼즐모양으로 맞추기 위함.
				
				else {
					System.out.printf("%3d", puzzle[i][j]);
					System.out.println();
				}
			}
		}
		
		System.out.print("빙고게임 시작! 1~25 사이의 숫자를 입력해주세요:");
		String input = scanner.nextLine();
		int num = Integer.parseInt(input);
		
		Outer: 
			if(num>=1 && num<=25) {
				for(int i=0;i<5;i++) {
					for(int j=0;j<5;j++) {
						if(num == puzzle[i][j]) {
							cntArr[i][j]++;	// 동일한 위치의 cntArr에 1을 증가
							puzzle[i][j] = 0; // 해당 위치를 0으로 변경
						}
						else if
						
						else
							continue;
					}
				}
			}
		
		} while(index==0);
	}

}
