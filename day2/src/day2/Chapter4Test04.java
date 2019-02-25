package day2;

public class Chapter4Test04 {

	public static void main(String[] args) {
		int count = 0;
		int sum = 0;
		int n = 1;
			
			for(int i=1; sum<100;i++,n=-n) { // 짝수마다 음수를 곱한다
				sum += i*n; // 1+(-2)+3+(-4) ...
				count++; // 카운트를 증가시켜 몇까지 더해야 총합이 100 이상이 나오는지 구한다.
			}
			System.out.println(count);
		}

}
