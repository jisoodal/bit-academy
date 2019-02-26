package day4;

import java.util.Scanner;

public class Ch05Test07 {

	public static void main(String[] args) {
		
		Scanner s = new Scanner(System.in);
		
		// 문자열을 숫자로 변환한다. 입력한 값이 숫자가 아닐 경우 예외가 발생한다.
		String tmp = s.nextLine();
		int money = Integer.parseInt(tmp);
		
		System.out.println("money="+money);
		
		int[] coinUnit 	= {500, 100, 50, 10};
		int[] coin		= {5, 5, 5, 5};
		
		for(int i=0;i<coinUnit.length;i++) {
			int coinNum =0;
			
			/*
			 (1) 아래의 로직에 맞게 코드를 작성하시오.
			 	1. 금액(money)을 동전단위로 나눠서 필요한 동전의 개수(coinNum)를 구한다.
			 	2. 배열 coin에서 coinNum만큼의 동전을 뺀다.
			 		(만일 충분한 동전이 없다면 배열 coin에 있는 만큼만 뺀다.)
			 	3. 금액에서 동전의 개수(coinNum)와 동전단위를 곱한 값을 뺀다.
			 */
			coinNum = money/coinUnit[i]; // 동전 개수 = money에서 동전을 나눈 만큼(나머지는 떨어짐)
			if(coinNum<=coin[i]) { // 내야 할 동전 개수가 내가 가진 개수보다 적다면
			coin[i] -= coinNum;  // 내가 가진 개수에서 내야할 만큼 빼기
			money = money-coinUnit[i]*coinNum; // money에서 거슬러 준 돈만큼 뺌
			System.out.println(coinUnit[i]+"원: "+coinNum); // 얼마 냈는지 출력
			}
			else {
				money = money-coinUnit[i]*coin[i]; // 내가 가진 동전 수보다 많으면 전부 내기
				System.out.println(coinUnit[i]+"원: "+coin[i]); // 가진만큼 출력
				coin[i] = 0; // 모든 동전을 내었으므로 0
			}
		}
		
		if(money > 0) {
			System.out.println("거스름돈이 부족합니다."); // 내가 가진 돈보다 많으면
			System.exit(0); // 프로그램을 종료한다.
		}
		
		System.out.println("=남은 동전의 개수=");
		
		for(int i=0;i<coinUnit.length;i++) {
			System.out.println(coinUnit[i]+"원:"+coin[i]);
		}
	}
}
