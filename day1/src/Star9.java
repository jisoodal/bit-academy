
public class Star9 {

	public static void main(String[] args) {
		 // 1번 예제
		
		for(int i=0; i<5;i++) {
			System.out.println("*****");
		}
		
		// 행이동 alt+up, down
	
		for(int i=0;i<5;i++) {
			
			for(int j=0;j<5;j++) {
				System.out.print("*");
			}
			System.out.println();
		}
		
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
		
		// 3번 예제
		
		/*
		for(int i=0;i<5;i++) {
			
			for(int j=0;j<5;j++) {
				if(i+j==4)
				System.out.print("["+i+","+j+"]");
				else
					System.out.print("     ");
			}
			System.out.println();
		}
		*/
		
			for(int i=0;i<5;i++) {
			
			for(int j=0;j<5;j++) {
				if(i+j==4)
				System.out.print("*");
				else
					System.out.print("     ");
			}
			System.out.println();
		}
			
			// 4번 예제
			
			/*
			for(int i=0;i<5;i++) {
				
				for(int j=0;j<5;j++) {
					if(i+j==4 || i==j)
					System.out.print("["+i+","+j+"]");
					else
						System.out.print("     ");
				}
				System.out.println();
			}
			*/
			
			for(int i=0;i<5;i++) {
				
				for(int j=0;j<5;j++) {
					if(i+j==4 || i==j)
					System.out.print("*");
					else
						System.out.print("     ");
				}
				System.out.println();
			}
			
			for(int i=0;i<5;i++) {
				
				for(int j=0;j<5;j++) {
					if(i+j==4 || i==j)
					System.out.print("["+i+","+j+"]");
					else
						System.out.print("     ");
				}
				System.out.println();
			}
	}

}
