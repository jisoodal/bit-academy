package day3;

public class ArrayEx06 {

	public static void main(String[] args) {
		
		int[] arr1 = {79, 88, 91, 33, 1, 55, 95};
		
		int max = arr1[0];
		int	min = arr1[0];
		
		for(int i=1;i<arr1.length;i++) {
			if(arr1[i]>=max) {
				max = arr1[i];
				System.out.println("max:"+max);
			}
			
			else if(arr1[i]<=min){
				min = arr1[i];
				System.out.println("min:"+min);
			}
		}
		System.out.println("max:"+max+", min:"+min);

	}

}
