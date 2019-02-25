package day3;

public class FlowEx24 {

	public static void main(String[] args) {
		int[] arr1 = {1,2,3};
		int[] arr2 = {1,5,3};
		
		int cnt = 0; // 같은 숫자의 개수를 세기 위한 변수
		
//		if(arr1[0]==arr2[0]) cnt++;
//		if(arr1[0]==arr2[1]) cnt++;
//		if(arr1[0]==arr2[2]) cnt++;
//		if(arr1[1]==arr2[0]) cnt++;
//		if(arr1[1]==arr2[1]) cnt++;
//		if(arr1[1]==arr2[2]) cnt++;
//		if(arr1[2]==arr2[0]) cnt++;
//		if(arr1[2]==arr2[1]) cnt++;
//		if(arr1[2]==arr2[2]) cnt++;
		
//		for(int i=0;i<3;i++) { // i=0~2
//			for(int j=0;j<3;j++)
//				if(arr1[i]==arr2[j]) cnt++;
			
			//두 배열이 같은지 비교하려면?
			for(int i=0;i<3;i++)
				if(arr1[i]==arr2[i]) // 같으면 cnt++
					cnt++;
				else
					break; // 다르면 반복문을 빠져나온다.
			
			System.out.println("cnt="+cnt);
			
			// 조건식을 어떻게 해야하지?
			// 배열의 길이만큼 cnt값이 나와야 한다!
			if(cnt==arr1.length) {
				System.out.println("같습니다.");
			}
			else
				System.out.println("다릅니다.");
		}

}
