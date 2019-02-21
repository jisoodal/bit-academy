
public class Star2 {

	public static void main(String[] args) {
		// 2번 예제
		
		/*
		for(int i=0;i<5;i++) {
			
			for(int j=0;j<5;j++) {
				System.out.print("["+i+","+j+"]");
			}
			System.out.println();
		}
		*/
		for(int i=0;i<5;i++) {
			
			for(int j=0;j<5;j++) {
				if(i==j)
				System.out.print("*");
				else
					System.out.print("     ");
			}
			System.out.println();
		}
		
	}

}
