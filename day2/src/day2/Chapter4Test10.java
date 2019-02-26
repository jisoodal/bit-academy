package day2;

public class Chapter4Test10 {

	public static void main(String[] args) {
		int num = 12345;
		int sum = 0;
		
		while(num>0) { 
			sum += num%10; // 10으로 나누어 가장 마지막 자리의 수를 떼어내어 더한다.
			num /=10; // 마지막 자리의 수룰 떼어내야 하므로 num도 10씩 나누어 준다.
		}
		
		System.out.println("sum="+sum);

	}

}
