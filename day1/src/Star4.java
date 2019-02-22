
public class Star4 {

	public static void main(String[] args) {
			// 4번 예제
			
			for(int i=0;i<5;i++) {
				
				for(int j=0;j<5;j++) {
					if(i+j==4 || i==j)
					System.out.print("["+i+","+j+"]");
					else
						System.out.print("     "); // [i,j]는 총 5글자이므로 5칸을 띄움
				}
				System.out.println();
			}
			
			for(int i=0;i<5;i++) {
				
				for(int j=0;j<5;j++) {
					if(i+j==4 || i==j)
					System.out.print("*");
					else
						System.out.print(" "); // *은 한 글자이므로 한 칸만 띄움
				}
				System.out.println();
			}
		
	}

}
