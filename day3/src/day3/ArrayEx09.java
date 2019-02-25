package day3;

public class ArrayEx09 {

	public static void main(String[] args) {
		// 임의의 값으로 배열 채우기
		int[] example = {-4, -1, 3, 6, 11}; // 임의의 값
		
		int[] arr1 = new int[10];
		
		for(int i=0;i<arr1.length;i++) { // arr1 배열 길이만큼 반복(arr1의 배열이 다 채워질 때까지)
			int n = (int)(Math.random()*example.length); // example 배열의 임의의 자리수를 가져오기 위함
			arr1[i] = example[n]; // 순서대로 arr1 배열에 임의의 example 수를 넣는다.
			System.out.print(arr1[i]+" ");
		}

	}

}
