package ch06;

public class Exercise6_20 {

	public static void main(String[] args) {
	
		int[] original = {1,2,3,4,5,6,7,8,9};
		System.out.println(java.util.Arrays.toString(original));
		
		int [] result = shuffle(original);
		System.out.println(java.util.Arrays.toString(result));
	}
	
	public static int[] shuffle(int[] origin) {
		
		int tmp = 0;
		
		for(int i=0;i<origin.length;i++) {
			
			int ran = (int)(Math.random()* origin.length);
			
			tmp = origin[0];
			origin[0] = origin[ran];
			origin[ran] = tmp;
		}
		
		return origin;
	}
}