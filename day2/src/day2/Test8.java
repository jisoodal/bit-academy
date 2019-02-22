package day2;

public class Test8 {

	public static void main(String[] args) {
		
		for(int i=1;i<=5;i++){
			int tmp = i;
			
			for(int j=1;j<=5;j++) {
				System.out.print(tmp);
				System.out.print("\t");;
				tmp += 5;
			}
			System.out.println();
		}
	}
}
