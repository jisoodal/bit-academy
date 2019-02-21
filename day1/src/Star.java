
public class Star {

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
			
			// 5번 예제
			
			for(int i=0;i<5;i++) {
				
				for(int j=0;j<5;j++) {
					if(j<=i || i==j) {
					System.out.print("["+i+","+j+"]");
					}
				}
				System.out.println();
			}
			
			
			for(int i=0;i<5;i++) {
				
				for(int j=0;j<5;j++) {
					if(j<=i || i==j) {
					System.out.print("*");
					}
				}
				System.out.println();
			}
			
			System.out.println("다음");
			
			// 6번 예제
			
			for(int i=0;i<5;i++) {
				
				for(int j=0;j<5;j++) {
					if(j>=i || i==j) {
					System.out.print("*");
					}
				}
				System.out.println();
			}
			
			System.out.println("다음");
			
			// 7번 예제
			
			for(int i=1;i<=5;i++) {
				
				for(int j=1;j<=i+4;j++) {
					if(true) {
					System.out.print("*");
					}
					else
						System.out.println("     ");
				}
				System.out.println();
			}
			
			// 8번 예제
			
			// ||(or)합집합, &&(and)교집합
			
			for(int i=1;i<=5;i++) {
				
				for(int j=1;j<=5;j++) {
					if((i+j<=6 && i<=j)||(i>=j && i+j>=6)) {
					System.out.print("*");
					}
					else
						System.out.println("     ");
				}
				
				System.out.println();
			}
			
			// if(!((i+j<6 && i<j)||(i<j && i+j>6)))
		
	}

}
