package day2;

public class Chapter4Test4 {

	public static void main(String[] args) {
		int count	= 0;
		int sum 	= 0;
		
		while(sum <= 100) {
		
			for(int i=1;i<100;i++) {
				if(i%2 == 0) {
					sum -= i;
					count ++;
				}
			
				else {
					sum += i;
					count ++;
				}
				
			}
		}
		System.out.println(count);

	}

}
