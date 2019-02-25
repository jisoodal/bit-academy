package day2;

public class Chapter4Test06 {

	public static void main(String[] args) {
		
		for(int i=1;i<=6;i++) {
			for(int k=1;k<=6;k++)
				if((i+k)==6) // 눈이 6개인 두 개의 주사위이므로 중첩for문, 합이 6인걸 뽑아내면 된다.
					System.out.println("경우의 수: "+i+"+"+k+"=6");
			
				else
					continue;
		}

	}

}
