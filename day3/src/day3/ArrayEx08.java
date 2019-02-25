package day3;

public class ArrayEx08 {

	public static void main(String[] args) {
		// 로또 번호 섞기
		int[] lotto = new int[6]; // 로또 6자리의 배열
		
		System.out.print("로또 번호는:");
		
		for(int i=0;i<6;i++) { // 1~45의 랜덤한 번호를 6번 반복하여 각 배열 자리에 넣는다.
			int n = (int)(Math.random()*45); // 1~45사이의 번호를 랜덤으로 뽑아낸다.
			
			// 랜덤으로 생성된 번호가 전 배열과 겹치지 않는지 확인한다. 
			lotto[i] = n; 
			System.out.print(lotto[i]+" ");
		}
		

	}

}