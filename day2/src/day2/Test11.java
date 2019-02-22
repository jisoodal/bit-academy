package day2;

public class Test11 {

	public static void main(String[] args) {
		// Q.두 배열에 같은 숫자가 몇개인지 세어보시오.
		int[] arr1 = {3, 3, 2}; // 배열을 나열한다.
		int[] arr2 = {3, 3, 1};
		int count = 0;

		for(int i = 0; i < arr1.length;i++) { // 배열의 길이만큼 for문 수행
				if(arr1[i] == arr2[i])
					count++;// 배열의 각 위치와 값을 비교하여 숫자가 같은 경우 count를 증가시킴
	
				else // 배열의 각 위치와 값을 비교하여 숫자가 다른 경우
					continue;
			}
		System.out.println("같은 숫자의 개수 : "+count);
	}
}
