package day3;

public class Quiz02 {

	public static void main(String[] args) {
		/*
		int[] arr = {4, 4, 4, 6, 5, 7, 9, 7, 5, 3}
		1. 배열 arr을 오름차순 정렬하여 출력하시오.
		2. 배열 arr에서 중복값을 제거하여 출력하시오. 카운팅 이용
		*/
		
		// 2번
		
		int[] numArr = {4, 4, 4, 6, 5, 7, 9, 7, 5, 3};
		int[] counter = new int[10];
		int index = 0;
		
		for(int i=0;i<numArr.length;i++) { // 숫자 개수를 센다
			counter[numArr[i]]++; // 해당 숫자-> 해당 counter 자리를 1 증가.
		}
		
		for(int i=0;i<numArr.length;i++) { // 작은 수부터 순서대로 counter 개수만큼 나열한다
			if(counter[i]>0) { // 한 번 이상 카운트된 경우
				numArr[index] = i; // numArr 배열에 순차적으로 입력
				System.out.print(numArr[index]+" ");
				index++; // numArr 다음 배열에 입력 시키지위해 증가.
			}
			else
				continue; // 한 번도 카운트되지 않은 경우 반복문 그냥 진행.
		}

	}

}
/*
 결과: 2. {3, 4, 5, 6, 7, 9}
 */
