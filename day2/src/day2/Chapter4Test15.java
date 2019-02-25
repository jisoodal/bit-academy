package day2;

public class Chapter4Test15 {

	public static void main(String[] args) {
		int number = 13531;
		int tmp = number; // 이래야 10씩 나눌 수가 있다. 100, 1000씩 나누면 나머지는 31, 531이 된다.
		
		int result = 0;
		
		while(tmp !=0) { // 계속해서 나누다보면 0이 된다
			result = result*10 + tmp%10; // 곱하기 10을 해줘야 자리수가 하나씩 밀려서 역순으로 배열할 수 있게 된다.
			tmp /=10;
		}
		
		if(number == result)
			System.out.println(number+"는 회문수 입니다.");
		else
			System.out.println(number+"는 회문수가 아닙니다.");

	}

}
