package day2;

public class Chapter4Test09 {

	public static void main(String[] args) {
		String str = "12345";
		int sum = 0;
		
		for(int i=0;i < str.length(); i++) {
			sum += str.charAt(i) - '0';
			// charAt은 i 번째 문자열을 반환해주는데, 이 문자열의 문자를 숫자로 변환하면 된다. 그 방법은
			// - '0'을 해주면 된다.
		}
		
		System.out.println("sum="+sum);
	}

}
