package day2;

public class Chapter4Test05 {

	public static void main(String[] args) {
		
		int i = 0;
		
		while(i<=10) { // while문은 for문의 전제를 위로, 조건문을 조건문으로, 증감식을 맨 아래로 내보낸다.
			int j = 0;
			
			while(j<=i) {
				System.out.print("*");
				j++;
			}
			System.out.println();
			i++;
		}

	}

}
