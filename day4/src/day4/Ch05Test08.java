package day4;

public class Ch05Test08 {

	public static void main(String[] args) {
		int[] answer = {1,4,4,3,1,4,4,2,1,3,2};
		int[] counter = new int[4];
		
		for(int i=0;i< answer.length;i++) { // 겹치는 숫자많큼 더하기
			counter[(answer[i])-1]++; // 0부터 시작하므로 answer의 해당 배열 수-1의 counter 
									  // 자리를 1 더하기
		}
		
		for(int i=0;i<counter.length;i++) {
			System.out.print(counter[i]); // 카운트된 수 만큼 출력
			for(int j=0;j<counter[i];j++)
				System.out.print("*"); // 카운트된 만큼 별 출력
			System.out.println();
		}
	}

}
