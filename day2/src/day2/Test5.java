package day2;

public class Test5 {

	public static void main(String[] args) {
		
		for(int i=1;i<6;i++) {
			
			for(int j=1;j<=i;j++) {
					System.out.print(j);
			}
			System.out.println();		
		}
		
//		int num = 1;
//		for(int i=1;i<=5;i++) {
//			for(int j=1;j<=5;j++) {
//				System.out.printf("%2d ", num++); 이렇게 해도 되고
//				System.out.printf("%2d ", (i-1*5+j)); 이렇게 해도 되고
//			}
//		}
	}
}
