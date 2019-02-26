package day4;

public class Ch05Test06 {

	public static void main(String[] args) {
		// 큰 금액의 동전을 우선적으로 거슬러 줘야한다. -> 0부터 돌리면 된다
		int[] coinUnit = {500, 100, 50, 10};
		
		int money = 2680;
		System.out.println("money="+money);
		
		for(int i=0;i<coinUnit.length;i++) {
			int res = 0; // 거슬러 준 동전 개수
			res = money/coinUnit[i];  // 동전 개수 = money에서 동전을 나눈 만큼(나머지는 떨어짐)
			System.out.println(coinUnit[i]+"원:"+res); 
			money = money-coinUnit[i]*res; // money에서 거슬러 준 돈만큼 뺌
		}

	}

}
