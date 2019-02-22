package day2;

public class Chapter4Test3 {

	public static void main(String[] args) {
		
		int result = 0;
		
		for(int i=1;i<=10;i++) {
			
			for(int j=1;j<i;j++) {
				result += j;
			}
		}
		System.out.println(result);

	}

}
