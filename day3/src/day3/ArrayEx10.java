package day3;

public class ArrayEx10 {

	public static void main(String[] args) {
		int[] example = {15, 5, 8, 40, 2, 11, 10};
		
		int tmp = example[0];
		
		System.out.println("결과:");
		
		for(int i=1; i<example.length;i++) {
			if(tmp>=example[i]) {
				example[i-1] = tmp;
				tmp = example[i];
				
				System.out.println(example[i]);
			}
			else {
				System.out.println(example[i]);
				continue;
			}
		}

	}

}
