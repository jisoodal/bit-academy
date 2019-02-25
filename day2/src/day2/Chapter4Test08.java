package day2;

public class Chapter4Test08 {

	public static void main(String[] args) {
		
		for(int i=0;i<=10;i++) {
			
			for(int j=0;j<=10;j++) { // 범위가 0부터 10까지이므로 두 개의 중첩문!
				if((2*i)+(4*j)==10) // 문제 그대로 해석하여 합이 10이면 된다.
					System.out.println("x="+i+", y="+j);
				
				else
					continue;
			}
		}
	}
}
