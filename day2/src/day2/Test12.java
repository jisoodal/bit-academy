package day2;

public class Test12 {

	public static void main(String[] args) {
		// Q.두 배열이 같은지 확인하고, 같으면 "같습니다", 다르면 "다릅니다"를 출력하세요.
		int[] arr1 = {3, 3, 2}; // 배열을 나열한다.
		int[] arr2 = {3, 3, 2};
		
		if(arr1.length == arr2.length){ // 두 배열의 길이가 같은가? True의 경우 for문 수행
			Loop1 : for(int i = 0; i <= (arr1.length)-1; i++) { // 배열의 길이만큼 for문 수행
				if(arr1[i] != arr2[i]) {
					System.out.println("다릅니다. ");// 배열의 각 위치와 값을 비교하여 다른 경우
					break Loop1;
				}
				
				else
					System.out.println("같습니다.");
			}
		}
		else // 두 배열의 길이가 다른 경우
			System.out.println("다릅니다.");


	}

}
