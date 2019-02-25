package day3;

public class ArrayEx05 {

	public static void main(String[] args) {
		int sum = 0;
		float avg = 0f;
		
		int[] arr1 = {100,88,100,100,90};
		
		for(int i=0;i<5;i++) {
			sum+= arr1[i];
		}
		avg = (float)sum/arr1.length;
		
		System.out.println("sum:"+sum+", avg:"+avg);
	}

}
