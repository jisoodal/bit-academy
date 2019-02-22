package day2;

public class Chapter4Test6 {

	public static void main(String[] args) {
		
		for(int i=1;i<=6;i++) {
			for(int k=1;k<=6;k++)
				if((i+k)==6)
					System.out.println("경우의 수: "+i+"+"+k+"=6");
			
				else
					continue;
		}

	}

}
