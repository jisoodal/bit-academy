package day2;

public class Chapter4Test03 {

	public static void main(String[] args) {
		
		int result = 0;
		
		for(int i=1;i<=10;i++) { // j부터 시작해서 i까지 더하는 과정을 10번 반복했다.
			
			for(int j=1;j<i;j++) {
				result += j;
			}
		}
		System.out.println(result);

	}

}
/*
  for(int i=1;i<=10;i++){
  	sum += i;
  	totalSum += sum;
  	} 
  	으로 하는 방식도 있었다.
  	1 
  	3 = 1+2
  	5 = 1+2+3
	6 = 1+2+3+4
	10 = 1+2+3+4
	....etc를 활용하였으며, for문을 한 번만 쓰므로 보다 효율적. 풀어쓰는 것이 도움이 된다.
*/