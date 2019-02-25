package day2;

public class Chapter4Test02 {

	public static void main(String[] args) {
		int result = 0;
		for(int i=1;i<21;i++) {
			
			if(i%2 != 0 && i%3 != 0)
				result +=i;
			
			else
				continue;
		}
		System.out.println(result);
	}

}
