package day2;

public class Chapter4Test8 {

	public static void main(String[] args) {
		
		for(int i=0;i<=10;i++) {
			
			for(int j=0;j<=10;j++) {
				if((2*i)+(4*j)==10)
					System.out.println("x="+i+", y="+j);
				
				else
					continue;
			}
		}
	}
}
